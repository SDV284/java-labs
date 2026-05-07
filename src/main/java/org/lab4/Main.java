package org.lab4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Phone> devices = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        devices = FileService.loadFromFile();

        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== ГОЛОВНЕ МЕНЮ ===");
            System.out.println("1. Пошук об'єкта");
            System.out.println("2. Створити новий об'єкт");
            System.out.println("3. Вивести всі об'єкти");
            System.out.println("4. Завершити роботу");
            System.out.print("Вибір: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> searchMenu(); // Виклик підменю
                case "2" -> createDeviceMenu();
                case "3" -> showAllDevices();
                case "4" -> {
                    FileService.saveToFile(devices);
                    exit = true;
                }
            }
        }
    }

    private static void createDeviceMenu() {
        System.out.println("\n--- Оберіть тип пристрою ---");
        System.out.println("1. Смартфон | 2. Кнопковий | 3. Захищений | 4. Складаний");
        String type = scanner.nextLine();

        try {
            System.out.print("Бренд: "); String b = scanner.nextLine();
            System.out.print("Модель: "); String m = scanner.nextLine();
            System.out.print("Ціна: "); double p = Double.parseDouble(scanner.nextLine());

            switch (type) {
                case "1" -> {
                    System.out.print("Екран: "); double s = Double.parseDouble(scanner.nextLine());
                    System.out.print("ОС: "); String os = scanner.nextLine();
                    devices.add(new SmartPhone(b, m, p, s, os));
                }
                case "2" -> {
                    System.out.print("Ліхтарик (true/false): "); boolean f = Boolean.parseBoolean(scanner.nextLine());
                    devices.add(new KeypadPhone(b, m, p, f));
                }
                case "3" -> {
                    System.out.print("IP Рейтинг (число): "); int ip = Integer.parseInt(scanner.nextLine());
                    devices.add(new RuggedPhone(b, m, p, ip));
                }
                case "4" -> {
                    System.out.print("Екран: "); double s = Double.parseDouble(scanner.nextLine());
                    System.out.print("ОС: "); String os = scanner.nextLine();
                    System.out.print("Цикли згинання: "); int c = Integer.parseInt(scanner.nextLine());
                    devices.add(new FoldableSmartPhone(b, m, p, s, os, c));
                }
                default -> System.out.println("Скасовано: невідомий тип.");
            }
            System.out.println("Об'єкт успішно додано!");
        } catch (Exception e) {
            System.out.println("Помилка: невірний формат даних.");
        }
    }

    private static void showAllDevices() {
        if (devices.isEmpty()) {
            System.out.println("\nКолекція порожня.");
        } else {
            System.out.println("\n--- Список пристроїв ---");
            for (Phone d : devices) System.out.println(d.toString());
        }
    }

    private static void searchMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- КРИТЕРІЇ ПОШУКУ ---");
            System.out.println("1. За брендом | 2. За моделлю | 3. За ціною | 4. Назад");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Бренд: ");
                    displayResults(findByBrand(scanner.nextLine()));
                }
                case "2" -> {
                    System.out.print("Модель: ");
                    displayResults(findByModel(scanner.nextLine()));
                }
                case "3" -> {
                    try {
                        System.out.print("Мін. ціна: ");
                        double min = Double.parseDouble(scanner.nextLine());
                        System.out.print("Макс. ціна: ");
                        double max = Double.parseDouble(scanner.nextLine());
                        displayResults(findByPriceRange(min, max));
                    } catch (Exception e) {
                        System.out.println("Помилка: введіть числа.");
                    }
                }
                case "4" -> back = true;
                default -> System.out.println("Невірний вибір.");
            }
        }
    }

    private static ArrayList<Phone> findByBrand(String brand) {
        ArrayList<Phone> found = new ArrayList<>();
        for (Phone p : devices) {
            // Пошук без урахування регістру (Stream API заборонено)
            if (p.getBrand().toLowerCase().contains(brand.toLowerCase())) {
                found.add(p);
            }
        }
        return found;
    }

    private static void displayResults(ArrayList<Phone> results) {
        if (results.isEmpty()) {
            System.out.println("Об'єктів не знайдено.");
        } else {
            for (Phone p : results) System.out.println(p);
        }
    }

    private static ArrayList<Phone> findByModel(String model) {
        ArrayList<Phone> found = new ArrayList<>();
        for (Phone p : devices) {
            if (p.getModel().toLowerCase().contains(model.toLowerCase())) {
                found.add(p);
            }
        }
        return found;
    }

    private static ArrayList<Phone> findByPriceRange(double min, double max) {
        ArrayList<Phone> found = new ArrayList<>();
        for (Phone p : devices) {
            if (p.getPrice() >= min && p.getPrice() <= max) {
                found.add(p);
            }
        }
        return found;
    }
}