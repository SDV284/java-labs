package org.lab4;

import java.util.Objects;

/**
 * Клас Phone з підтримкою статичних членів та конструктора копіювання.
 */
public class Phone {
    // Статичне поле для підрахунку кількості об'єктів
    private static int totalPhonesCreated = 0;

    private String brand;
    private String model;
    private double price;
    private OsType os; // Використання enum

    /**
     * Основний конструктор.
     */
    public Phone(String brand, String model, double price, OsType os) {
        setBrand(brand);
        setModel(model);
        setPrice(price);
        this.os = os;
        totalPhonesCreated++; // Збільшуємо лічильник
    }

    /**
     * Конструктор копіювання.
     * @param other об'єкт, з якого копіюються дані
     */
    public Phone(Phone other) {
        this(other.brand, other.model, other.price, other.os);
    }

    /**
     * Статичний метод для отримання загальної кількості створених об'єктів.
     */
    public static int getTotalPhonesCreated() {
        return totalPhonesCreated;
    }

    // Гетери та сетери (з валідацією з ПР5)
    public String getBrand() { return brand; }
    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) throw new IllegalArgumentException("Brand empty");
        this.brand = brand;
    }

    public OsType getOs() { return os; }
    public void setOs(OsType os) { this.os = os; }

    public double getPrice() { return price; }
    public void setPrice(double price) {
        if (price <= 0) throw new IllegalArgumentException("Price must be > 0");
        this.price = price;
    }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    @Override
    public String toString() {
        return String.format("Phone[Brand: %s, Model: %s, Price: %.2f, OS: %s]",
                brand, model, price, os);
    }
}