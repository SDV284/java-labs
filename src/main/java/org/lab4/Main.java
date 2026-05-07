package org.lab4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Phone> devices = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== ГОЛОВНЕ МЕНЮ ===");
            System.out.println("1. Створити новий об'єкт");
            System.out.println("2. Вивести всі об'єкти");
            System.out.println("3. Завершити роботу");
            System.out.print("Оберіть дію: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> createDeviceMenu(); // Оновлений метод з підменю
                case "2" -> showAllDevices();
                case "3" -> exit = true;
                default -> System.out.println("Невірний вибір.");
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
}