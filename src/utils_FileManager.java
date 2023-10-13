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
            // 1.1
            in = new Scanner(new File("src\\db_User.txt"));
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

    public void registerNewUser(String[] userinput) {
        obj_User user = new obj_User(userinput);
        user.writetoFile("src\\db_User.txt", 1);
        reassignUser();
        JOptionPane.showMessageDialog(null, "Account successfully registered!", "Success!", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, "Username: " + user.getUsername() + "\nPassword: " + user.getPassword(),
                "User Details", JOptionPane.INFORMATION_MESSAGE);
    }

    public void registerNewAnimal() {
        String[] userinput = new String[8];
        String[] gender = { "Male", "Female", "Unknown" };
        Arrays.fill(userinput, null);
        userinput[0] = JOptionPane.showInputDialog(null, "Please enter animal\'s name:", "New Animal", 0);
        userinput[1] = JOptionPane.showInputDialog(null, "Please enter animal\'s age:", "New Animal", 0);
        userinput[2] = (String) JOptionPane.showInputDialog(null, "Please enter animal\'s gender:", "New Animal", 0,
                null, gender, gender[0]); // ? Dropdown
        userinput[3] = JOptionPane.showInputDialog(null, "Please enter animal\'s Class:", "New Animal", 0);
        userinput[4] = JOptionPane.showInputDialog(null, "Please enter animal\'s Family:", "New Animal", 0);
        userinput[5] = JOptionPane.showInputDialog(null, "Please enter animal\'s Species:", "New Animal", 0);
        userinput[6] = JOptionPane.showInputDialog(null, "Please enter animal\'s Favourite Food:", "New Animal", 0);
        obj_Animal animal = new obj_Animal(userinput);
        animal.writetoFile("src\\db_Animals.txt");
        JOptionPane.showMessageDialog(null, animal.getName() + " has been successfully added to the database.",
                "Success!", JOptionPane.PLAIN_MESSAGE);

    }
}
