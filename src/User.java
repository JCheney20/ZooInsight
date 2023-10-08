package src;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class User {
    private String firstname, surname, email, usertype, gender, cellnumber, dob, username, password, userID;

    public User(String fname, String sname, String mail, String acctype, String gender, String celnum,
            String birthdate) {
        this.userID = setUserID();
        this.firstname = fname;
        this.surname = sname;
        this.email = mail;
        this.usertype = acctype;
        this.gender = gender;
        this.cellnumber = celnum;
        this.dob = birthdate;
        this.username = createUsername();
        this.password = createPass();
    }

    // Setter Methods
    private String setUserID() {
        int IDnum = 1;
        Scanner in;
        File file = new File("Userdb.txt");
        try {
            in = new Scanner(file);
            while (in.hasNextLine()) {
                IDnum++;
            }
        } catch (Exception e) {
            System.out.println("Error: " + String.valueOf(e));
            return String.valueOf(0);
        }
        in.close();
        return String.valueOf(IDnum);
    }

    public void setFname(String fname) {
        this.firstname = fname;
    }

    public void setSname(String sname) {
        this.surname = sname;
    }

    public void setMail(String mail) {
        this.email = mail;
    }

    public void setAcctype(String type) {
        this.usertype = type;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setcelnum(String celnum) {
        this.cellnumber = celnum;
    }

    public void setBirthdate(String birthdate) {
        this.dob = birthdate;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    // Getter Methods
    public String getfname() {
        return firstname;
    }

    public String getsname() {
        return surname;
    }

    public String getmail() {
        return email;
    }

    public String getAcctype() {
        return usertype;
    }

    public String getGender() {
        return gender;
    }

    public String getcelnum() {
        return cellnumber;
    }

    public String getBirthdate() {
        return dob;
    }

    public String getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Output info
    public void printInfo() {
        System.out.printf(
                "UserID: %f\nUsername: %s\\n" + //
                        "Name: %s\nSurname: %s\nEmail: %s\nAccount Type: %s\nGender: %s\nCell Number: %s\nDate of Birth: %s\n\n",
                userID, username, firstname,
                surname, email, usertype, gender, cellnumber, dob);
    }

    @Override
    public String toString() {
        return userID + "," + firstname + "," + surname + "," + email + "," + usertype + "," + gender + "," + cellnumber
                + "," + dob + "," + username + "," + password;
    }

    public void writetoFile(String filename) {
        try {
            FileWriter fw = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            out.println(this.toString());
            out.close();
        } catch (IOException e) {
            System.out.println("Error: " + String.valueOf(e));
            return;
        }
    }

    private String createPass() {
        String passname = firstname.substring(0, 3);
        String passSurname = surname.substring(surname.length() - 3, surname.length());
        long RadNum = Math.round(Math.random() * 99);
        String password = RadNum + passname + passSurname;
        return password;
    }

    private String createUsername() {
        char intial = firstname.charAt(0);
        username = intial + surname;
        return username;
    }
}
