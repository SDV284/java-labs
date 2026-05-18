package org.lab4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Store {
    private ArrayList<StoreItem> inventory;

    public Store() {
        this.inventory = new ArrayList<>();
    }

    public void addNewPhone(Phone ph, int quantity) {
        boolean found = false;
        for (StoreItem item : inventory) {
            // Використовуємо метод equals(), реалізований у попередніх лабах
            if (item.getPhone().equals(ph)) {
                item.setQuantity(item.getQuantity() + quantity);
                found = true;
                break;
            }
        }
        if (!found) {
            inventory.add(new StoreItem(ph, quantity));
        }
    }

    public ArrayList<StoreItem> getInventory() { return inventory; }
    public void setInventory(ArrayList<StoreItem> list) { this.inventory = list; }

    public ArrayList<StoreItem> getSortedInventory(Comparator<StoreItem> comparator) {
        ArrayList<StoreItem> sortedList = new ArrayList<>(this.inventory);
        Collections.sort(sortedList, comparator);
        return sortedList;
    }

    public ArrayList<StoreItem> findByBrand(String brand) {
        ArrayList<StoreItem> results = new ArrayList<>();
        for (StoreItem item : inventory) {
            if (item.getPhone().getBrand().toLowerCase().contains(brand.toLowerCase())) {
                results.add(item);
            }
        }
        return results;
    }

    public ArrayList<StoreItem> findByPriceRange(double min, double max) {
        ArrayList<StoreItem> results = new ArrayList<>();
        for (StoreItem item : inventory) {
            double price = item.getPhone().getPrice();
            if (price >= min && price <= max) {
                results.add(item);
            }
        }
        return results;
    }
}