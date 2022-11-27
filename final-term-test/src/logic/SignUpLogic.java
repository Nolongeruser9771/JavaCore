package logic;

import entities.User;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SignUpLogic {
    public User inputInfoToSignUp(Scanner scanner,ArrayList<User> users) {
        System.out.println("===== SIGN UP DISPLAY MENU =====");
        String userName;
        do {
            System.out.println("Input user name");
            userName = scanner.nextLine();
        } while (!isAvailableUserName(userName,users));

        String email;
        do {
            System.out.println("Input your email");
            email = scanner.nextLine();
        } while (!emailCheck(email) || !isAvailableEmail(email, users));

        String passWord;
        do {
            System.out.println("Input your pass word");
            passWord = scanner.nextLine();
        } while (!passWordCheck(passWord));

        System.out.println("Sign in successfully");
        return new User(userName,email,passWord);
    }

    public static boolean emailCheck(String email) {
        if(Pattern.matches("\\S+@([a-zA-Z0-9_.+-]+)\\.[a-zA-Z0-9_.+-]+", email)) {
            return true;
        }
        System.out.println("Invalid email");
        return false;
    }

    public static boolean passWordCheck(String passWord) {
        if(Pattern.matches("^(?=.*[.,;_-])(?=.*[A-Z]).{7,15}$", passWord)) {
            return true;
        }
        System.out.println("Invalid passWord");
        return false;
    }

    public static boolean isAvailableUserName(String userName, ArrayList<User> users) {
        for (User user: users) {
            if (user.getUserName().equals(userName)) {
                System.out.println("Exist Username");
                return false;
            }
        }
        return true;
    }

    public static boolean isAvailableEmail(String email, ArrayList<User> users) {
        for (User user:users) {
            if (user.getEmail().equals(email)) {
                System.out.println("Exist Email");
                return false;
            }
        }
        return true;
    }
}
