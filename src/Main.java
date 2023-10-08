package src;

public class Main {

    public void registernewuser(String[] userinput) {

        User user = new User(userinput[0], userinput[1], userinput[2], userinput[3], userinput[4], userinput[5],
                userinput[6]);
        user.writetoFile("src\\Userdb.txt");

        System.out.println("Done");
    }
}
