package src;

import java.util.Scanner;

/* 
* Name & Surname: Justin Cheney
 * Student Number: 4323819
 * Project Name: ZooInsight
*/
public class ZooManagementSystem_Main {

    public static String[] Registration(String name, String surname, String DOB, String email, char accountType) {
        String passname = name.substring(0, 3);
        String passSurname = surname.substring(surname.length() - 3, surname.length());
        String[] dob = DOB.split("/");
        String accType = "";
        switch (accountType) {
            case 'A':
                accType = "Administrator";
                break;
            case 'O':
                accType = "Owner";
            case 'C':
                accType = "Caretakers";
            default:
                break;
        }
        long RadNum = Math.round(Math.random() * 99);
        String password = RadNum + passname + passSurname + dob[2].substring(2);
        String[] registrationDetails = { name, surname, accType, email, password };
        return registrationDetails;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(// Description Message
                "This project's function is to provide Zoo caretakers & owners a means of organising and keeping track of the animals within the zoo.\n\nThis will be done by storing animals information on a database that is organised by various categories. Users will be able to login and look through these various details with the owners getting a more broad overview than the caretakers.");

        // initialise need variables
        String fName, sName, dateOfBirth, emailAddress;
        String[] User;
        char accType;

        System.out.println("Please enter your name:"); // Getting users first name
        fName = keyboard.nextLine();

        System.out.println("Please enter your surname:"); // Getting users surname
        sName = keyboard.nextLine();

        System.out.println("Please enter your date of birth (DD/MM/YYYY):"); // Getting users date of birth
        dateOfBirth = keyboard.nextLine();

        System.out.println("Please enter your email adresss (1234@example.com):"); // Getting users email address
        emailAddress = keyboard.nextLine();

        System.out.println("Are you creating an Admin, Caretaker or Owner account (A, C or O):"); // Account type
        accType = (keyboard.nextLine()).charAt(0);

        User = Registration(fName, sName, dateOfBirth, emailAddress, accType); // pass in variable to registration
                                                                               // method
        System.out.printf(
                "%nHi %s %s, you have been successfully registered your %s account using the email: %s.%nYour generated password is:%n%s",
                User[0], User[1], User[2], User[3], User[4]);

        keyboard.close();
    }
}
