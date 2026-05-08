package org.lab4;

/**
 * Клас Смартфон, що успадковує Phone.
 */
public class SmartPhone extends Phone {
    private double screenSize;
    private String os;

    public SmartPhone(String brand, String model, double price, double screenSize, String os) {
        super(brand, model, price); // Виклик конструктора базового класу
        this.type = "SmartPhone";
        this.screenSize = screenSize;
        this.os = os;
    }

    @Override
    public String toString() {
        // Поліморфне розширення методу toString
        return super.toString() + String.format(" | Смартфон [Екран: %.1f\", ОС: %s]", screenSize, os);
    }

    public double getScreenSize() { return screenSize; }
    public String getOs() { return os; }
}