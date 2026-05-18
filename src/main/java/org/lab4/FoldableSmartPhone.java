package org.lab4;

public class FoldableSmartPhone extends SmartPhone {
    private int foldingCycles; // Гарантована кількість циклів складання

    public FoldableSmartPhone(String brand, String model, double price, double screenSize, String os, int foldingCycles) {
        super(brand, model, price, screenSize, os);
        this.type = "FoldableSmartPhone";
        this.foldingCycles = foldingCycles;
    }

    public void setFoldingCycles(int foldingCycles) {
        if (foldingCycles < 0) throw new IllegalArgumentException("Кількість циклів не може бути від'ємною");
        this.foldingCycles = foldingCycles;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Складаний [Ресурс згинання: %d циклів]", foldingCycles);
    }
}