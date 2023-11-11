package src;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class utils_CreateNew {
    utils_DBManager DB = new utils_DBManager();

    public void registerNewUser() {
        String[] userinput = new String[8];
        String[] gender = { "Male", "Female", "Other" };
        String[] usetype = { "Admin", "Caretaker", "Owner" };
        Arrays.fill(userinput, null);
        userinput[0] = JOptionPane.showInputDialog(null, "Please enter new user\'s firstname:", "New User",
                JOptionPane.QUESTION_MESSAGE);
        userinput[1] = JOptionPane.showInputDialog(null, "Please enter new user\'s surname:", "New User",
                JOptionPane.QUESTION_MESSAGE);
        userinput[2] = JOptionPane.showInputDialog(null, "Please enter new user\'s email:", "New User",
                JOptionPane.QUESTION_MESSAGE);
        userinput[3] = (String) JOptionPane.showInputDialog(null, "Please enter new user\'s account type:", "New User",
                JOptionPane.QUESTION_MESSAGE,
                null, usetype, usetype[0]);
        userinput[4] = (String) JOptionPane.showInputDialog(null, "Please enter new user\'s gender:", "New User",
                JOptionPane.QUESTION_MESSAGE,
                null, gender, gender[0]);
        userinput[5] = JOptionPane.showInputDialog(null, "Please enter new user\'s cellnumber:", "New User",
                JOptionPane.QUESTION_MESSAGE);
        userinput[6] = JOptionPane.showInputDialog(null, "Please enter new user\'s Date of Birth:", "New User",
                JOptionPane.QUESTION_MESSAGE);

        obj_User user = new obj_User(userinput, 1);
        DB.populateDB(user);
        JOptionPane.showMessageDialog(null, user.getFirstname() + " has been successfully added to the database.",
                "Success!", JOptionPane.PLAIN_MESSAGE);
    }

    public void registerNewAnimal() {
        String[] userinput = new String[8];
        String[] gender = { "Male", "Female", "Unknown" };
        Arrays.fill(userinput, null);
        userinput[0] = JOptionPane.showInputDialog(null, "Please enter animal\'s name:", "New Animal",
                JOptionPane.QUESTION_MESSAGE);
        userinput[1] = JOptionPane.showInputDialog(null, "Please enter animal\'s age:", "New Animal",
                JOptionPane.QUESTION_MESSAGE);
        userinput[2] = (String) JOptionPane.showInputDialog(null, "Please enter animal\'s gender:", "New Animal",
                JOptionPane.QUESTION_MESSAGE,
                null, gender, gender[0]); // ? Dropdown
        userinput[3] = JOptionPane.showInputDialog(null, "Please enter animal\'s Class:", "New Animal",
                JOptionPane.QUESTION_MESSAGE);
        userinput[4] = JOptionPane.showInputDialog(null, "Please enter animal\'s Family:", "New Animal",
                JOptionPane.QUESTION_MESSAGE);
        userinput[5] = JOptionPane.showInputDialog(null, "Please enter animal\'s Species:", "New Animal",
                JOptionPane.QUESTION_MESSAGE);
        userinput[6] = JOptionPane.showInputDialog(null, "Please enter animal\'s Favourite Food:", "New Animal",
                JOptionPane.QUESTION_MESSAGE);
        obj_Animal animal = new obj_Animal(userinput);
        DB.populateDB(animal);
        JOptionPane.showMessageDialog(null, animal.getName() + " has been successfully added to the database.",
                "Success!", JOptionPane.PLAIN_MESSAGE);

    }

}
