package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class utils_FileManager {

    public static void clearFile(String filename) {
        try {
            FileWriter fw = new FileWriter(filename, false);
            PrintWriter pw = new PrintWriter(fw, false);
            pw.flush();
            pw.close();
            fw.close();
        } catch (Exception exception) {
            System.out.println("Exception have been caught");
        }
    }

    public void reassign() {
        ArrayList<obj_User> records = new ArrayList<obj_User>();
        String[] attributes = new String[10];
        Scanner in;
        int count = 0;
        try {
            // 1.1
            in = new Scanner(new File("src\\Userdb.txt"));
            do {
                attributes = in.nextLine().split(",");
                records.add(new obj_User(attributes));
                records.get(count).setIDnumber(String.valueOf(count + 1));
                count++;
            } while (in.hasNextLine());
            Arrays.fill(attributes, null);
        } catch (IOException e) {
            System.out.println("Error: " + String.valueOf(e));
            System.out.println("Unable to update");
            return;
        }
        clearFile("src\\Caretakerdb.txt");
        clearFile("src\\Ownerdb.txt");
        clearFile("src\\Admindb.txt");
        for (obj_User user : records) {
            if (user.getUsertype().equals("Caretaker")) {
                user.setIDnumber("C" + user.getIDnumber());
                user.writetoFile("src\\Caretakerdb.txt", 2);
            } else if (user.getUsertype().equals("Owner")) {
                user.setIDnumber("O" + user.getIDnumber());
                user.writetoFile("src\\Ownerdb.txt", 2);
            } else {
                user.setIDnumber("A" + user.getIDnumber());
                user.writetoFile("src\\Admindb.txt", 2);
            }
        }
        in.close();
    }

    public void registerNewUser(String[] userinput) {
        obj_User user = new obj_User(userinput);
        user.writetoFile("src\\Userdb.txt", 1);
        reassign();
        JOptionPane.showMessageDialog(null, "Account successfully registered!", "Success!", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, "Username: " + user.getUsername() + "\nPassword: " + user.getPassword(),
                "User Details", JOptionPane.INFORMATION_MESSAGE);
    }
}
