package src;

import javax.swing.JOptionPane;

public class Main {
    public void registernewuser(String fname, String sname, String mail, String acctype, String gender, String celnum,
            String birthdate) {
        User user = new User(fname, sname, mail, acctype, gender, celnum, birthdate);
        user.writetoFile("src\\Userdb.txt");

        JOptionPane.showMessageDialog(null, "Details registered", "Account Successful", 0);
        JOptionPane.showMessageDialog(null, "Username: " + user.getUsername() + "\nPassword: " + user.getPassword(),
                "Account Successful", 0);
    }
}
