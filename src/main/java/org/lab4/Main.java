package org.lab4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Store myStore = new Store();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        myStore.setInventory(FileService.loadFromFile());
        System.out.println("Базу даних завантажено. Товарів у списку: " + myStore.getInventory().size());

        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== МЕНЮ (ПР13) ===");
            System.out.println("1. Пошук | 2. Додати | 3. Весь склад | 4. Відсортований список | 5. Вихід");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> searchMenu();
                case "2" -> createDeviceMenu();
                case "3" -> showInventory(myStore.getInventory());
                case "4" -> showInventory(myStore.getSortedInventory()); // Новий пункт
                case "5" -> {
                    FileService.saveToFile(myStore.getInventory());
                    exit = true;
                }
                default -> System.out.println("Невірний вибір.");
            }
        }
    }

    private static void createDeviceMenu() {
        System.out.println("\n--- Оберіть тип пристрою ---");
        System.out.println("1. SmartPhone | 2. KeypadPhone | 3. RuggedPhone | 4. FoldableSmartphone");
        String typeChoice = scanner.nextLine();

        try {
            System.out.print("Бренд: "); String b = scanner.nextLine();
            System.out.print("Модель: "); String m = scanner.nextLine();
            System.out.print("Ціна: "); double p = Double.parseDouble(scanner.nextLine());

            System.out.print("Кількість одиниць: ");
            int q = Integer.parseInt(scanner.nextLine());

            Phone phone = null;
            switch (typeChoice) {
                case "1" -> {
                    System.out.print("Екран: "); double s = Double.parseDouble(scanner.nextLine());
                    System.out.print("ОС: "); String os = scanner.nextLine();
                    phone = new SmartPhone(b, m, p, s, os);
                }
                case "2" -> {
                    System.out.print("Ліхтарик (true/false): "); boolean f = Boolean.parseBoolean(scanner.nextLine());
                    phone = new KeypadPhone(b, m, p, f);
                }
                case "3" -> {
                    System.out.print("IP Рейтинг (число): "); int ip = Integer.parseInt(scanner.nextLine());
                    phone = new RuggedPhone(b, m, p, ip);
                }
                case "4" -> {
                    System.out.print("Екран: "); double s = Double.parseDouble(scanner.nextLine());
                    System.out.print("ОС: "); String os = scanner.nextLine();
                    System.out.print("Цикли згинання: "); int c = Integer.parseInt(scanner.nextLine());
                    phone = new FoldableSmartPhone(b, m, p, s, os, c);
                }
                default -> System.out.println("Невірний тип пристрою.");
            }

            if (phone != null) {
                myStore.addNewPhone(phone, q);
                System.out.println("Товар успішно додано/оновлено на складі.");
            }
        } catch (Exception e) {
            System.out.println("Помилка: Некоректний формат даних. Спробуйте ще раз.");
        }
    }

    private static void showInventory(ArrayList<StoreItem> items) {
        if (items.isEmpty()) {
            System.out.println("Список об'єктів порожній.");
        } else {
            System.out.println("\n--- Вміст списку ---");
            for (StoreItem item : items) {
                System.out.println(item);
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