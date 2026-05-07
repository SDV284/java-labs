package org.lab4;

public class StoreItem {
    private Phone phone;
    private int quantity;

    public StoreItem(Phone phone, int quantity) {
        this.phone = phone;
        this.quantity = quantity;
    }

    public Phone getPhone() { return phone; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return phone.toString() + " | Кількість: " + quantity;
    }
}