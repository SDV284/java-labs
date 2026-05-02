package org.lab4;

/**
 * Клас Phone з валідацією даних та обробкою винятків.
 */
public class Phone {
    private String brand;
    private String model;
    private double price;
    private int batteryCapacity; // Нове поле

    /**
     * Конструктор з валідацією.
     */
    public Phone(String brand, String model, double price, int batteryCapacity) {
        setBrand(brand);
        setModel(model);
        setPrice(price);
        setBatteryCapacity(batteryCapacity);
    }

    public String getBrand() { return brand; }
    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Бренд не може бути порожнім");
        }
        this.brand = brand;
    }

    public String getModel() { return model; }
    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Модель не може бути порожньою");
        }
        this.model = model;
    }

    public double getPrice() { return price; }
    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Ціна повинна бути більшою за 0");
        }
        this.price = price;
    }

    public int getBatteryCapacity() { return batteryCapacity; }
    public void setBatteryCapacity(int batteryCapacity) {
        if (batteryCapacity <= 0) {
            throw new IllegalArgumentException("Ємність батареї має бути додатною");
        }
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public String toString() {
        return String.format("Phone[Brand: %s, Model: %s, Price: %.2f, Battery: %d mAh]",
                brand, model, price, batteryCapacity);
    }
}