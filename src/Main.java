package src;

public class Main {
    public void registernewuser(String fname, String sname, String mail, String acctype, String gender, String celnum,
            String birthdate) {
        User user = new User(fname, sname, mail, acctype, gender, celnum, birthdate);
        user.writetoFile("Userdb.txt");
    }
}
