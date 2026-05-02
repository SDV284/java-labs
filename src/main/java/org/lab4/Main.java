package org.lab4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Інформаційна шапка
        System.out.println("========================================");
        System.out.println("Програма керування магазином телефонів");
        System.out.println("Виконав: Святішенко Дмитро, Варіант 3");
        System.out.println("========================================");

        Store myStore = new Store("TechZone");
        Scanner sc = new Scanner(System.in);

        // Демонстрація статичного поля
        System.out.println("Початкова кількість телефонів: " + Phone.getTotalPhonesCreated());

        // Тестовий об'єкт
        Phone p1 = new Phone("Apple", "iPhone 15", 45000, OsType.IOS);
        myStore.addPhone(p1);

        // Демонстрація конструктора копіювання через додавання в магазин
        System.out.println("Створено об'єктів після додавання: " + Phone.getTotalPhonesCreated());

        myStore.displayInventory();
    }
}