package org.lab4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // ЗАМІНА: Замість ArrayList<Phone> тепер об'єкт нашого контейнера
    private static Store myStore = new Store();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        myStore.setInventory(FileService.loadFromFile());
        System.out.println("Базу даних завантажено. Товарів у списку: " + myStore.getInventory().size());

        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== СКЛАД МАГАЗИНУ (ПР11) ===");
            System.out.println("1. Пошук | 2. Додати товар | 3. Весь склад | 4. Вихід");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> searchMenu();
                case "2" -> createDeviceMenu();
                case "3" -> showInventory();
                case "4" -> {
                    FileService.saveToFile(myStore.getInventory());
                    exit = true;
                }
            }
        }
    }

    private static void createDeviceMenu() {
        System.out.println("\n--- Оберіть тип: 1.Смартфон 2.Кнопковий 3.Захищений 4.Складаний ---");
        String typeChoice = scanner.nextLine();
        try {
            System.out.print("Бренд: "); String b = scanner.nextLine();
            System.out.print("Модель: "); String m = scanner.nextLine();
            System.out.print("Ціна: "); double p = Double.parseDouble(scanner.nextLine());

            // НОВЕ: Запит кількості
            System.out.print("Кількість одиниць на склад: ");
            int q = Integer.parseInt(scanner.nextLine());

            Phone phone = null;
            switch (typeChoice) {
                case "1" -> phone = new SmartPhone(b, m, p, 6.1, "Android");
                case "2" -> phone = new KeypadPhone(b, m, p, true);
                case "3" -> phone = new RuggedPhone(b, m, p, 68);
                case "4" -> phone = new FoldableSmartPhone(b, m, p, 7.6, "Android", 200000);
            }

            if (phone != null) {
                myStore.addNewPhone(phone, q);
                System.out.println("Дані оновлено!");
            }
        } catch (Exception e) {
            System.out.println("Помилка вводу.");
        }
    }

    private static void showInventory() {
        ArrayList<StoreItem> items = myStore.getInventory();
        if (items.isEmpty()) {
            System.out.println("Склад порожній.");
        } else {
            for (StoreItem item : items) {
                System.out.println(item.toString());
            }
        }
    }

    private static void searchMenu() {
        System.out.println("1. За брендом | 2. За ціною");
        String choice = scanner.nextLine();
        if (choice.equals("1")) {
            System.out.print("Бренд: ");
            String brand = scanner.nextLine();
            ArrayList<StoreItem> results = myStore.findByBrand(brand);
            for (StoreItem res : results) System.out.println(res);
        }
        if (choice.equals("2")) {
            System.out.print("Мінімальна ціна: ");
            double min = Double.parseDouble(scanner.nextLine());
            System.out.print("Максимальна ціна: ");
            double max = Double.parseDouble(scanner.nextLine());
            ArrayList<StoreItem> results = myStore.findByPriceRange(min, max);
            for (StoreItem res : results) System.out.println(res);
        }
    }
}