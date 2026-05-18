package org.lab4;

public class StoreItem implements Comparable<StoreItem> {
    private Phone phone;
    private int quantity;

    public StoreItem(Phone phone, int quantity) {
        this.phone = phone;
        this.quantity = quantity;
    }

    @Override
    public int compareTo(StoreItem other) {
        return this.phone.compareTo(other.getPhone());
    }

    public Phone getPhone() { return phone; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) {
        if (quantity < 0) throw new IllegalArgumentException("Кількість не може бути від'ємною");
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return phone.toString() + " | Кількість: " + quantity;
    }
}