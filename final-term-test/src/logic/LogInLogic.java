package logic;

import entities.User;

import view.LogInMenu;

import java.util.ArrayList;
import java.util.Scanner;

import static logic.AfterLoginLogic.passWordChange;
import static logic.SignUpLogic.emailCheck;
import static view.AfterLogInMenu.afterLoginDisplayMenu;

public class LogInLogic {
    public static void inputInfoToLogin(Scanner scanner, ArrayList<User> users) {
        String userName;
        String passWord;
        do {
            System.out.println("===== LOG IN MENU =====");
            System.out.println("Input user name");
            userName = scanner.nextLine();

            System.out.println("Input your pass word");
            passWord = scanner.nextLine();

        } while (findUser(userName,passWord,users,scanner));
    }

    private static boolean findUser(String userName, String passWord, ArrayList<User> users,Scanner scanner) {
        boolean isLoopInputLogin = false;
        User checkedUser = null;

        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                checkedUser = user;
                break;
            }
        }
        if (checkedUser == null) {
            System.out.println("Wrong username. Please check your username again");
            isLoopInputLogin = wrongUserNameMenu(scanner);
        } else if (checkedUser.getPassWord().equals(passWord)) {
                System.out.println("Welcome " + checkedUser.getUserName());
                afterLoginDisplayMenu(scanner, checkedUser, users);
            } else {
                isLoopInputLogin = wrongPassWordMenu(scanner, checkedUser);
            }

        return isLoopInputLogin;
    }

    private static boolean wrongUserNameMenu(Scanner scanner) {
        String choiceInput;
        do {
            System.out.println("Do you want to login again?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            choiceInput = scanner.nextLine();
        } while (!LogInMenu.functionChoiceCheck(choiceInput));
        int choice = Integer.parseInt(choiceInput);
        return choice == 1;
    }

    private static boolean wrongPassWordMenu(Scanner scanner, User checkedUser) {
        String choiceInput;
        do {
            System.out.println("====== WRONG PASSWORD =====");
            System.out.println("What do you want to do?");
            System.out.println("1. Login again");
            System.out.println("2. Forgot password");
            choiceInput = scanner.nextLine();
        } while (!LogInMenu.functionChoiceCheck(choiceInput));

        int choice = Integer.parseInt(choiceInput);

        if (choice == 1) {
            return true;
        } else {
            String email;
            do {
                System.out.println("===== FORGOT PASSWORD GUIDE =====");
                System.out.println("Input your registered email");
                email = scanner.nextLine();
            } while (!emailCheck(email));

            if (checkedUser.getEmail().equals(email)) {
                    System.out.println("===== CHANGE PASSWORD GUIDE =====");
                    passWordChange(checkedUser,scanner);
                    return true;
                }
                System.out.println("Not existed account");
            }
        return false;
    }
}
