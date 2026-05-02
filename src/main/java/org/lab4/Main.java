package org.lab4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Phone> phones = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Меню ---");
            System.out.println("1. Додати новий телефон");
            System.out.println("2. Вивести всі телефони");
            System.out.println("3. Вийти");
            System.out.print("Оберіть дію: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> addPhone();
                    case 2 -> showPhones();
                    case 3 -> running = false;
                    default -> System.out.println("Невірний вибір.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Помилка: введіть числове значення для меню.");
            }
        }
    }

    private static void addPhone() {
        try {
            System.out.print("Бренд: ");
            String brand = scanner.nextLine();
            System.out.print("Модель: ");
            String model = scanner.nextLine();
            System.out.print("Ціна: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Ємність батареї: ");
            int battery = Integer.parseInt(scanner.nextLine());

            phones.add(new Phone(brand, model, price, battery));
            System.out.println("Телефон успішно додано!");
        } catch (NumberFormatException e) {
            System.out.println("Помилка: Ціна та батарея мають бути числами.");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка валідації: " + e.getMessage());
        }
    }

    private static void showPhones() {
        if (phones.isEmpty()) {
            System.out.println("Список порожній.");
        } else {
            phones.forEach(System.out::println);
        }
    }
}