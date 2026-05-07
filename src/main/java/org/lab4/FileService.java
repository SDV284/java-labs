package org.lab4;

import com.google.gson.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileService {
    private static final String FILE_NAME = "inventory.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Тепер приймаємо список StoreItem
    public static void saveToFile(ArrayList<StoreItem> items) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(items, writer);
        } catch (IOException e) {
            System.out.println("Помилка збереження: " + e.getMessage());
        }
    }

    // Тепер повертаємо список StoreItem
    public static ArrayList<StoreItem> loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new ArrayList<>();

        try (FileReader reader = new FileReader(FILE_NAME)) {
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
            ArrayList<StoreItem> list = new ArrayList<>();

            for (JsonElement element : jsonArray) {
                JsonObject itemObj = element.getAsJsonObject();
                int quantity = itemObj.get("quantity").getAsInt();

                // Дістаємо вкладений об'єкт телефону для визначення його типу
                JsonObject phoneObj = itemObj.get("phone").getAsJsonObject();
                String type = phoneObj.get("type").getAsString();

                Phone phone;
                switch (type) {
                    case "SmartPhone" -> phone = gson.fromJson(phoneObj, SmartPhone.class);
                    case "KeypadPhone" -> phone = gson.fromJson(phoneObj, KeypadPhone.class);
                    case "RuggedPhone" -> phone = gson.fromJson(phoneObj, RuggedPhone.class);
                    case "FoldableSmartphone" -> phone = gson.fromJson(phoneObj, FoldableSmartPhone.class);
                    default -> phone = gson.fromJson(phoneObj, Phone.class);
                }
                list.add(new StoreItem(phone, quantity));
            }
            return list;
        } catch (Exception e) {
            System.out.println("Помилка завантаження: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}