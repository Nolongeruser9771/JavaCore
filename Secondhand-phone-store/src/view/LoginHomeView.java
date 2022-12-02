package view;

import entities.Member;
import entities.Order;
import entities.Product;
import logichandle.LoginLogic;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginHomeView {
    public void displayLoginHomeView(Scanner scanner, ArrayList<Product> products, ArrayList<Member> members, ArrayList<Order> orders) {
        System.out.println("WELCOME TO NGUYÊN SECOND-SMART");
        String choiceInput;
        do {
            System.out.println("Bạn đã có tài khoản chưa?\n" +
                    "1. Tôi đã có\n" +
                    "2. Tôi chưa có");
            choiceInput = scanner.nextLine();
        } while (!isChoiceOfloginValid(choiceInput));
        LoginLogic loginLogic = new LoginLogic();
        switch (Integer.parseInt(choiceInput)) {
            case 1:
                Member checkLogIn = loginLogic.logIn(scanner,products,members,orders);
                System.out.println(checkLogIn);
                while (checkLogIn==null) {
                    loginWrongView(scanner,products,members,orders);
                }
                break;
            case 2:
                loginLogic.SignUp(scanner,products,members,orders);
                break;
        }
    }
    private void loginWrongView(Scanner scanner, ArrayList<Product> products, ArrayList<Member> members, ArrayList<Order> orders) {
        System.out.println("Username hoặc password đang sai!");
        String choiceInput;
        do {
            System.out.println("Mời chọn:");
            System.out.println("1. Đăng nhập lại");
            System.out.println("2. Quên password");
            choiceInput = scanner.nextLine();
        } while (!isChoiceOfloginValid(choiceInput));
        LoginLogic loginLogic = new LoginLogic();
        switch (Integer.parseInt(choiceInput)){
            case 1:
                loginLogic.logIn(scanner,products,members,orders);
                break;
            case 2:
                loginLogic.forgetPassword(scanner,products,members,orders);
                break;
        }
    }

    private void loginActionView() {

    }

    private boolean isChoiceOfloginValid(String choiceInput) {
        try {
            int choice = Integer.parseInt(choiceInput);
            if (choice==1 || choice == 2) {
                return true;
            }
            System.out.println("Lựa chọn không hợp lệ!");
            return false;
        } catch (Exception e) {
            System.out.println("Lựa chọn không hợp lệ!");
            return false;
        }
    }
}
