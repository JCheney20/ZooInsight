package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

import javafx.collections.ObservableList;

public class utils_FileManager {
    private static void clearFile(String filename) {
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

    private void reassignUser() {
        ArrayList<obj_User> records = new ArrayList<obj_User>();
        String[] attributes = new String[10];
        Scanner in;
        int count = 0;
        try {

            in = new Scanner(new File("src\\db_User.txt"));
            do {
                attributes = in.nextLine().split(",");
                records.add(new obj_User(attributes, 1));
                records.get(count).setIDnumber(String.valueOf(count + 1));
                count++;
            } while (in.hasNextLine());
            Arrays.fill(attributes, null);
        } catch (IOException e) {
            System.out.println("Error: " + String.valueOf(e));
            System.out.println("Unable to update");
            return;
        }
        clearFile("src\\db_Caretaker.txt");
        clearFile("src\\db_Owner.txt");
        clearFile("src\\db_Admin.txt");
        for (obj_User user : records) {
            if (user.getUsertype().equals("Caretaker")) {
                user.setIDnumber("C" + user.getIDnumber());
                user.writetoFile("src\\db_Caretaker.txt", 2);
            } else if (user.getUsertype().equals("Owner")) {
                user.setIDnumber("O" + user.getIDnumber());
                user.writetoFile("src\\db_Owner.txt", 2);
            } else {
                user.setIDnumber("A" + user.getIDnumber());
                user.writetoFile("src\\db_Admin.txt", 2);
            }
        }
        in.close();
    }

    public <T extends utils_ObjectGen> void updateFile(ObservableList<T> userlist, String filename) {
        clearFile("src\\db_" + filename + ".txt");
        for (T user : userlist) {
            user.writetoFile("src\\db_" + filename + ".txt", 1);
        }
        reassignUser();
    }

    public void registerNewUser(String[] userinput) {
        obj_User user = new obj_User(userinput, 1);
        user.writetoFile("src\\db_User.txt", 1);
        reassignUser();
        JOptionPane.showMessageDialog(null, "Account successfully registered!", "Success!", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, "Username: " + user.getUsername() + "\nPassword: " + user.getPassword(),
                "User Details", JOptionPane.INFORMATION_MESSAGE);
    }
}
