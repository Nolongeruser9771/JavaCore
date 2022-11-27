package view;

import entities.User;
import logic.LogInLogic;
import logic.SignUpLogic;

import java.util.ArrayList;
import java.util.Scanner;

public class LogInMenu {
    SignUpLogic signInLogic = new SignUpLogic();
    public void displayMenu(Scanner scanner, ArrayList<User> users) {
        while (true) {
            String choiceInput;
            do {
                System.out.println("===== What do you want to do =====");
                System.out.println("1. Log in");
                System.out.println("2. Sign up");
                choiceInput = scanner.nextLine();
            } while (!functionChoiceCheck(choiceInput));
            int choice = Integer.parseInt(choiceInput);

            switch (choice) {
                case 1:
                    LogInLogic.inputInfoToLogin(scanner, users);
                    break;
                case 2:
                    User user = signInLogic.inputInfoToSignUp(scanner, users);
                    users.add(user);
                    break;
            }
        }
    }

    public static boolean functionChoiceCheck(String choiceInput) {
        try {
            int functionChoice = Integer.parseInt(choiceInput);
            if (functionChoice == 1 || functionChoice == 2) {
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
