package org.lab4;

import java.util.ArrayList;

/**
 * Драйвер-клас для демонстрації роботи з класом Phone та ArrayList.
 */
public class Main {
    public static void main(String[] args) {
        // Створення ArrayList для зберігання об'єктів Phone
        ArrayList<Phone> phoneList = new ArrayList<>();

        // Заповнення списку 5-ма об'єктами
        phoneList.add(new Phone("Apple", "iPhone 15", 42000.0));
        phoneList.add(new Phone("Samsung", "Galaxy S23", 35000.0));
        phoneList.add(new Phone("Google", "Pixel 8", 31000.5));
        phoneList.add(new Phone("Xiaomi", "13T Pro", 28000.0));
        phoneList.add(new Phone("Motorola", "Edge 40", 18500.0));

        // Виведення інформації про кожний об'єкт через toString()
        System.out.println("Список телефонів (кількість: " + phoneList.size() + "):");
        for (Phone phone : phoneList) {
            System.out.println(phone.toString());
        }
    }
}