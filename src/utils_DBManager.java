package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class utils_DBManager {
    static final String DB_URL = "jdbc:mysql://localhost:3306/zooinsight";
    static final String USER = "AAdmin";
    static final String PASS = "admin123";

    public void getData() {
        String QUERY = "SELECT * FROM users";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                System.out.println("Account Number: " + rs.getString("accnum"));
                System.out.println("Name: " + rs.getString("firstname"));
                System.out.println("Surname: " + rs.getString("surname"));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public <T> void populateDB(obj_User user) {
        String[] userstr = user.toString().split(",");
        String QUERY = "INSERT INTO users (firstname,surname,email,usertype,gender,cellnumber,dob)VALUES(?,?,?,?,?,?,?)";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement(QUERY);
            for (int i = 1; i <= userstr.length; i++) {
                stmt.setString(i, userstr[i - 1]);
            }
            stmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
