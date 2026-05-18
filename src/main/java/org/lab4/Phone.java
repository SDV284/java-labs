package org.lab4;

import java.util.Objects;

public abstract class Phone implements Comparable<Phone>  {
    protected String type; // Поле для ідентифікації класу в JSON
    private String brand;
    private String model;
    private double price;

    public Phone(String brand, String model, double price) {
        setBrand(brand);
        setModel(model);
        setPrice(price);
    }

    // РЕАЛІЗАЦІЯ COMPARABLE (за брендом)
    @Override
    public int compareTo(Phone other) {
        return this.brand.compareToIgnoreCase(other.brand);
    }

    // ГЕТЕРИ
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getPrice() { return price; }
    public String getType() { return type; }

    // СЕТЕРИ З ВАЛІДАЦІЄЮ (з ПР №5)
    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Бренд не може бути порожнім");
        }
        this.brand = brand;
    }

    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Модель не може бути порожньою");
        }
        this.model = model;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Ціна має бути додатною");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Телефон [Бренд: %s, Модель: %s, Ціна: %.2f]", brand, model, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone)) return false;
        Phone phone = (Phone) o;
        return Double.compare(phone.price, price) == 0 &&
                Objects.equals(brand, phone.brand) &&
                Objects.equals(model, phone.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, price);
    }
}