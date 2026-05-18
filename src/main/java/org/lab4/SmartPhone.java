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

    public void setScreenSize(double screenSize) {
        if (screenSize <= 0) throw new IllegalArgumentException("Розмір екрану має бути додатним");
        this.screenSize = screenSize;
    }

    public void setOs(String os) {
        if (os == null || os.trim().isEmpty()) throw new IllegalArgumentException("ОС не може бути порожньою");
        this.os = os;
    }

    @Override
    public String toString() {
        // Поліморфне розширення методу toString
        return super.toString() + String.format(" | Смартфон [Екран: %.1f\", ОС: %s]", screenSize, os);
    }
}