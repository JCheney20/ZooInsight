package src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class User {
    private String firstname, surname, email, usertype, gender, cellnumber, dob, username, password, IDnumber;
    private long RadNum = Math.round(Math.random() * 10000);

    public User(String fname, String sname, String mail, String acctype, String gender, String celnum,
            String birthdate) {
        this.IDnumber = String.valueOf(RadNum);
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

    public User(String[] user) {
        this.IDnumber = String.valueOf(RadNum);
        this.firstname = user[0];
        this.surname = user[1];
        this.email = user[2];
        this.usertype = user[3];
        this.gender = user[4];
        this.cellnumber = user[5];
        this.dob = user[6];
        this.username = createUsername();
        this.password = createPass();
    }

    // Setter Methods

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCellnumber(String cellnumber) {
        this.cellnumber = cellnumber;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIDnumber(String iDnumber) {
        IDnumber = iDnumber;
    }

    // Getter Methods
    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getUsertype() {
        return usertype;
    }

    public String getGender() {
        return gender;
    }

    public String getCellnumber() {
        return cellnumber;
    }

    public String getDob() {
        return dob;
    }

    public String getIDnumber() {
        return IDnumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Output info
    public void printInfo() {
        System.out.printf(//
                "Name: %s\nSurname: %s\nEmail: %s\nAccount Type: %s\nGender: %s\nCell Number: %s\nDate of Birth: %s\n\n",
                firstname, surname, email, usertype, gender, cellnumber, dob);
    }

    @Override
    public String toString() {
        return firstname + "," + surname + "," + email + "," + usertype + "," + gender + ","
                + cellnumber
                + "," + dob;
    }

    public String toString2() {
        return IDnumber + "," + firstname + "," + surname + "," + email + "," + usertype + "," + gender + ","
                + cellnumber
                + "," + dob + "," + username + "," + password;
    }

    public void writetoFile(String filename, int type) {
        try {
            FileWriter fw = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            if (type == 1) {
                out.println(this.toString());
                out.close();
            } else {
                out.println(this.toString2());
                out.close();
            }
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
