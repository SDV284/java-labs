package org.lab4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Єдина колекція для всіх типів об'єктів
        ArrayList<Phone> devices = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Додати Смартфон | 2. Додати Кнопковий | 3. Показати всі | 4. Вихід");
            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Бренд: "); String b = sc.nextLine();
                    System.out.print("Модель: "); String m = sc.nextLine();
                    System.out.print("Ціна: "); double p = Double.parseDouble(sc.nextLine());
                    System.out.print("Діагональ: "); double s = Double.parseDouble(sc.nextLine());
                    System.out.print("ОС: "); String os = sc.nextLine();
                    devices.add(new SmartPhone(b, m, p, s, os));
                }
                case "2" -> {
                    System.out.print("Бренд: "); String b = sc.nextLine();
                    System.out.print("Модель: "); String m = sc.nextLine();
                    System.out.print("Ціна: "); double p = Double.parseDouble(sc.nextLine());
                    System.out.print("Є ліхтарик? (true/false): "); boolean f = Boolean.parseBoolean(sc.nextLine());
                    devices.add(new KeypadPhone(b, m, p, f));
                }
                case "3" -> {
                    System.out.println("\n--- Список пристроїв (Поліморфний вивід) ---");
                    for (Phone device : devices) {
                        // Викликається відповідний toString() залежно від реального типу об'єкта
                        System.out.println(device.toString());
                    }
                }
                case "4" -> running = false;
            }
        }
    }
}