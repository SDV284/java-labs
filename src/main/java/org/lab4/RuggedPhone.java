package org.lab4;

public class RuggedPhone extends Phone {
    private int ipRating;

    public RuggedPhone(String brand, String model, double price, int ipRating) {
        super(brand, model, price);
        this.type = "RuggedPhone";
        this.ipRating = ipRating;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Захищений [IP Рейтинг: IP%d]", ipRating);
    }

    public int getIpRating() { return ipRating; }
}