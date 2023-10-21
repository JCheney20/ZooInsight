package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class utils_DBManager {
    static final String DB_URL = "jdbc:mysql//localhost://3306/DBConnect";
    static final String USER = "AAdmin";
    static final String PASS = "admin123";

    public void getData() {
        String QUERY = "SELECT * FROM zooinsight";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                System.out.println("Account Number: " + rs.getString("accnum"));
                System.out.println("Name: " + rs.getString("firstname"));
                System.out.println("Name: " + rs.getString("surname"));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
