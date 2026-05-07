package org.lab4;

/**
 * Клас Кнопковий телефон, що успадковує Phone.
 */
public class KeypadPhone extends Phone {
    private boolean hasFlashlight;

    public KeypadPhone(String brand, String model, double price, boolean hasFlashlight) {
        super(brand, model, price);
        this.type = "KeyboardPhone";
        this.hasFlashlight = hasFlashlight;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Кнопковий [Ліхтарик: %s]", hasFlashlight ? "Так" : "Ні");
    }
}