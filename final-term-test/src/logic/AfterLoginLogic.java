package logic;

import entities.User;

import java.util.ArrayList;
import java.util.Scanner;

import static logic.SignUpLogic.*;

public class AfterLoginLogic {
    public static void userNameChange(User thisUser, Scanner scanner, ArrayList<User> users) {
        String newUserName;
        do {
            System.out.println("Input new username");
            newUserName = scanner.nextLine();
        } while (!isAvailableUserName(newUserName,users));
        thisUser.setUserName(newUserName);
        System.out.println("Change username successfully!");
    }

    public static void emailChange(User thisUser, Scanner scanner, ArrayList<User> users) {
        String newEmail;
        do {
            System.out.println("Input new email");
            newEmail = scanner.nextLine();
        } while (!isAvailableEmail(newEmail,users) || !emailCheck(newEmail));
        thisUser.setEmail(newEmail);
        System.out.println("Change email successfully!");
    }

    public static void passWordChange(User thisUser, Scanner scanner) {
        String newPassWord;
        do {
            System.out.println("Input new password");
            newPassWord = scanner.nextLine();
        } while (!passWordCheck(newPassWord));
        thisUser.setPassWord(newPassWord);
        System.out.println("Change password successfully!");
    }
}
