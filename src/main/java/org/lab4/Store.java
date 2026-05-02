package org.lab4;

import java.util.ArrayList;

/**
 * Клас Store демонструє принцип агрегації (містить список телефонів).
 */
public class Store {
    private String storeName;
    private ArrayList<Phone> inventory; // Агрегація

    public Store(String storeName) {
        this.storeName = storeName;
        this.inventory = new ArrayList<>();
    }

    public void addPhone(Phone phone) {
        // Додаємо копію об'єкта, демонструючи використання конструктора копіювання
        this.inventory.add(new Phone(phone));
    }

    public void displayInventory() {
        System.out.println("--- Магазин: " + storeName + " ---");
        if (inventory.isEmpty()) {
            System.out.println("Склад порожній.");
        } else {
            for (Phone p : inventory) {
                System.out.println(p);
            }
        }
    }
}