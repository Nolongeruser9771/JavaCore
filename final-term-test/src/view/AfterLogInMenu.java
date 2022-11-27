package view;

import entities.User;

import java.util.ArrayList;
import java.util.Scanner;

import static logic.AfterLoginLogic.*;

public class AfterLogInMenu {
    public static void afterLoginDisplayMenu(Scanner scanner, User thisUser, ArrayList<User> users) {
        String choiceInput;
        while (true) {
            do {
                System.out.println("===== WELCOME =====");
                System.out.println("You can do:");
                System.out.println("1. Change username");
                System.out.println("2. Change email");
                System.out.println("3. Change password");
                System.out.println("4. Log out");
                System.out.println("0. Exit");
                choiceInput = scanner.nextLine();
            } while (!functionChoiceCheck(choiceInput));

            int choice = Integer.parseInt(choiceInput);

            switch (choice) {
                case 1:
                    userNameChange(thisUser, scanner, users);
                    break;
                case 2:
                    emailChange(thisUser, scanner, users);
                    break;
                case 3:
                    passWordChange(thisUser, scanner);
                    break;
                case 4:
                    LogInMenu menu = new LogInMenu();
                    menu.displayMenu(scanner, users);
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }

    private static boolean functionChoiceCheck(String choiceInput) {
        try {
            int functionChoice = Integer.parseInt(choiceInput);
            if (functionChoice >=0 && functionChoice <=4) {
                return true;
            }
            System.out.println("Wrong functionChoice. Please choose again");
            return false;
        }catch (Exception e) {
            System.out.println("Invalid type of input");
            return false;
        }
    }
}
