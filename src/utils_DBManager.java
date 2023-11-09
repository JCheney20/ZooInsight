package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class utils_DBManager {
    private String fname, usertype;
    static final String DB_URL = "jdbc:mysql://localhost:3306/zooinsight";
    static final String USER = "AAdmin";
    static final String PASS = "admin123";

    /*
     * private void moveData() {
     * ArrayList<obj_User> records = new ArrayList<>();
     * String[] attributes = new String[10];
     * Scanner in;
     * int count = 0;
     * try {
     * in = new Scanner(new File("src\\db_User.txt"));
     * do {
     * attributes = in.nextLine().split(",");
     * records.add(new obj_User(attributes, 1));
     * populateDB(records.get(count));
     * System.out.println("User added");
     * count++;
     * } while (in.hasNextLine());
     * Arrays.fill(attributes, null);
     * } catch (IOException e) {
     * System.out.println("Error: " + String.valueOf(e));
     * System.out.println("Unable to update");
     * return;
     * }
     * }
     */
    public String getFname() {
        return fname;
    }

    public String getusertype() {
        return usertype;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setusertype(String usertype) {
        this.usertype = usertype;
    }

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

    public void getAnimalData() {
        String QUERY = "SELECT * FROM animals";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                System.out.println("Account Number: " + rs.getString("animalsid"));
                System.out.println("Name: " + rs.getString("fname"));
                System.out.println("Age: " + rs.getString("age"));
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

    public <T> void populateDB(obj_Animal animal) {
        String[] animalstr = animal.toString().split(",");
        String QUERY = "INSERT INTO animals (fname, age, gender, class, family,species, fav_food, mood)VALUES(?,?,?,?,?,?,?,?)";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement(QUERY);
            for (int i = 1; i <= animalstr.length; i++) {
                stmt.setString(i, animalstr[i - 1]);
            }
            stmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean Login(String username, String password) {
        boolean flag = false;
        String QUERY = "CALL LOGIN(?,?)";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement(QUERY);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            flag = (rs != null) ? true : false;
            if (rs.next()) {
                setFname(rs.getString("firstname"));
                setusertype(rs.getString("usertype"));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

}
