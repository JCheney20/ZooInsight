package src;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class User {
    private String firstname, surname, email, usertype, gender, cellnumber, dob;
    private int userID;

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
    }

    // Setter Methods
    private int setUserID() {
        int IDnum = 0;

        return IDnum;
    }

    public void setfname(String fname) {
        this.firstname = fname;
    }

    public void setsname(String sname) {
        this.surname = sname;
    }

    public void setmail(String mail) {
        this.email = mail;
    }

    public void settype(String type) {
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

    // Output info
    public void printInfo() {
        System.out.printf(
                "UserID: %f\nName: %s\nSurname: %s\nEmail: %s\nAccount Type: %s\nGender: %s\nCell Number: %s\nDate of Birth: %s\n\n",
                userID, firstname,
                surname, email, usertype, gender, cellnumber, dob);
    }

    @Override
    public String toString() {
        return firstname + "," + surname + "," + email + "," + usertype + "," + gender + "," + cellnumber + "," + dob;
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

}
