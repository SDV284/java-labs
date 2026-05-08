package org.lab4;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseManager {
    private Properties props = new Properties();

    public DatabaseManager(String configPath) {
        try (FileInputStream fis = new FileInputStream(configPath)) {
            props.load(fis);
        } catch (Exception e) {
            System.err.println("Config error: " + e.getMessage());
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(props.getProperty("db.url"),
                props.getProperty("db.user"), props.getProperty("db.password"));
    }

    public void savePhone(Phone p, int quantity) {
        String sql = "INSERT INTO phones (type, brand, model, price, quantity, screen_size, os, has_flashlight, ip_rating, folding_cycles) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getType());
            ps.setString(2, p.getBrand());
            ps.setString(3, p.getModel());
            ps.setDouble(4, p.getPrice());
            ps.setInt(5, quantity);

            // Встановлюємо значення за замовчуванням NULL
            for (int i = 6; i <= 10; i++) ps.setNull(i, Types.NULL);

            // Логіка для підтипів (використовуємо гетери з попереднього коміту)
            if (p instanceof SmartPhone) {
                ps.setDouble(6, ((SmartPhone) p).getScreenSize());
                ps.setString(7, ((SmartPhone) p).getOs());
            }
            if (p instanceof KeypadPhone) ps.setBoolean(8, ((KeypadPhone) p).isHasFlashlight());
            if (p instanceof RuggedPhone) ps.setInt(9, ((RuggedPhone) p).getIpRating());
            if (p instanceof FoldableSmartPhone) ps.setInt(10, ((FoldableSmartPhone) p).getFoldingCycles());

            ps.executeUpdate();
        } catch (SQLException e) { System.err.println("DB Error: " + e.getMessage()); }
    }
}