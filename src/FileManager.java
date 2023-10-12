package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileManager {
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
        ArrayList<User> records = new ArrayList<User>();
        String[] attributes = new String[10];
        Scanner in;
        int count = 0;
        try {
            // 1.1
            in = new Scanner(new File("src\\Userdb.txt"));
            do {
                attributes = in.nextLine().split(",");
                records.add(new User(attributes));
                records.get(count).setUserID(String.valueOf(count + 1));
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
        for (User user : records) {
            if (user.getAcctype().equals("Caretaker")) {
                user.setUserID("C" + user.getUserID());
                user.writetoFile("src\\Caretakerdb.txt", 2);
            } else if (user.getAcctype().equals("Owner")) {
                user.setUserID("O" + user.getUserID());
                user.writetoFile("src\\Ownerdb.txt", 2);
            } else {
                user.setUserID("A" + user.getUserID());
                user.writetoFile("src\\Admindb.txt", 2);
            }
        }
        in.close();
    }

    public void registerNewUser(String[] userinput) {
        User user = new User(userinput);
        user.writetoFile("src\\Userdb.txt", 1);
        reassign();
        JOptionPane.showMessageDialog(null, "Account successfully registered!", "Success!", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, "Username: " + user.getUsername() + "\nPassword: " + user.getPassword(),
                "User Details", JOptionPane.INFORMATION_MESSAGE);
    }
}
