package org.lab4;

import java.util.Objects;

/**
 * Клас Phone з підтримкою статичних членів та конструктора копіювання.
 */
public class Phone {
    private String brand;
    private String model;
    private double price;

    /**
     * Основний конструктор.
     */
    public Phone(String brand, String model, double price) {
        setBrand(brand);
        setModel(model);
        setPrice(price);
    }

    /**
     * Конструктор копіювання.
     * @param other об'єкт, з якого копіюються дані
     */
    public Phone(Phone other) {
        this(other.brand, other.model, other.price);
    }

    // Гетери та сетери
    public String getBrand() { return brand; }
    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) throw new IllegalArgumentException("Brand empty");
        this.brand = brand;
    }

    public double getPrice() { return price; }
    public void setPrice(double price) {
        if (price <= 0) throw new IllegalArgumentException("Price must be > 0");
        this.price = price;
    }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    @Override
    public String toString() {
        return String.format("Phone[Brand: %s, Model: %s, Price: %.2f]",
                brand, model, price);
    }
}