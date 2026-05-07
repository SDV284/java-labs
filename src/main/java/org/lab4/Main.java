package org.lab4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Phone> devices = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== ГОЛОВНЕ МЕНЮ (v1) ===");
            System.out.println("1. Створити новий об'єкт");
            System.out.println("2. Вивести всі об'єкти");
            System.out.println("3. Вихід");
            System.out.print("Вибір: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> createBasicPhone(); // Тимчасовий метод
                case "2" -> showAllDevices();
                case "3" -> exit = true;
                default -> System.out.println("Невірний вибір.");
            }
        }
    }

    private static void createBasicPhone() {
        try {
            System.out.print("Бренд: "); String b = scanner.nextLine();
            System.out.print("Модель: "); String m = scanner.nextLine();
            System.out.print("Ціна: "); double p = Double.parseDouble(scanner.nextLine());

            devices.add(new Phone(b, m, p));
            System.out.println("Базовий телефон додано.");
        } catch (Exception e) {
            System.out.println("Помилка введення.");
        }
    }

    private static void showAllDevices() {
        if (devices.isEmpty()) {
            System.out.println("Список порожній.");
        } else {
            for (Phone d : devices) System.out.println(d.toString());
        }
    }
}