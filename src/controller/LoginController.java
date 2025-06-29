package controller;

import dbkoneksi.konfig;
import utils.CryptoUtil;

import java.sql.*;

public class LoginController {

    public static boolean registerUser(String username, String password) {
        String hashed = CryptoUtil.hashPassword(password);
        String sql = "INSERT INTO users (username, password_hash) VALUES (?, ?)";

        try (Connection conn = konfig.sambung();  
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, hashed);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Gagal registrasi: " + e.getMessage());
            return false;
        }
    }

    public static boolean loginUser(String username, String password) {
        String sql = "SELECT password_hash FROM users WHERE username = ?";

        try (Connection conn = konfig.sambung();  
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedHash = rs.getString("password_hash");
                return CryptoUtil.verifyPassword(password, storedHash);
            }

        } catch (SQLException e) {
            System.err.println("Gagal login: " + e.getMessage());
        }

        return false;
    }
}
