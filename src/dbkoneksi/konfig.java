package dbkoneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class konfig {

    public static Connection sambung() {
        try {
            String url = "jdbc:mysql://localhost:3306/secure_notes_db";
            String user = "root";
            String password = "";

            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Koneksi Berhasil");

            return con;
        } catch (SQLException e) {
             System.out.println("koneksi error:" + e.getMessage());
        }
        return null;
    }

}
