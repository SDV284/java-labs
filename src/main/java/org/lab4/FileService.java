package org.lab4;

import com.google.gson.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileService {
    private static final String FILE_NAME = "input.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveToFile(ArrayList<Phone> devices) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(devices, writer);
            System.out.println("Дані успішно збережено у " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Помилка запису: " + e.getMessage());
        }
    }

    public static ArrayList<Phone> loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new ArrayList<>();

        try (FileReader reader = new FileReader(FILE_NAME)) {
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
            ArrayList<Phone> list = new ArrayList<>();

            for (JsonElement element : jsonArray) {
                JsonObject obj = element.getAsJsonObject();
                String type = obj.get("type").getAsString();

                // Вручну визначаємо, в який клас перетворити JSON
                switch (type) {
                    case "SmartPhone" -> list.add(gson.fromJson(obj, SmartPhone.class));
                    case "KeypadPhone" -> list.add(gson.fromJson(obj, KeypadPhone.class));
                    case "RuggedPhone" -> list.add(gson.fromJson(obj, RuggedPhone.class));
                    case "FoldableSmartphone" -> list.add(gson.fromJson(obj, FoldableSmartPhone.class));
                    default -> list.add(gson.fromJson(obj, Phone.class));
                }
            }
            return list;
        } catch (Exception e) {
            System.out.println("Помилка читання: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}