package org.lab4;

import java.util.ArrayList;

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
}