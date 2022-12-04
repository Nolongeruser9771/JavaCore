package view;

import entities.*;
import iService.MenuService;
import logichandle.LoginLogic;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginHomeView implements MenuService {
    LoginLogic loginLogic = new LoginLogic();
    public void displayLoginHomeView(Scanner scanner, ArrayList<Product> products, ArrayList<User> users, ArrayList<Order> orders, ArrayList<PreOrder> preOrders) {
        System.out.println("===== WELCOME TO NGUYÊN SECOND-SMART =====");
        String choiceInput;
        do {
            System.out.println("Bạn đã có tài khoản chưa?\n" +
                    "1. Tôi đã có\n" +
                    "2. Tôi chưa có");
            choiceInput = scanner.nextLine();
        } while (!isChoiceOfTwoFunctionValid(choiceInput));
        switch (Integer.parseInt(choiceInput)) {
            case 1:
                User checkLogIn = loginLogic.logIn(scanner,products,users,orders, preOrders);
                while (checkLogIn==null) {
                    loginWrongView(scanner,products,users,orders,preOrders);
                }
                break;
            case 2:
                User thisUser = loginLogic.SignUp(scanner,products,users,orders, preOrders);
                if (thisUser!=null) {
                    loginLogic.logIn(scanner,products,users,orders,preOrders);
                }
                break;
        }
    }
    private void loginWrongView(Scanner scanner, ArrayList<Product> products, ArrayList<User> user, ArrayList<Order> orders, ArrayList<PreOrder> preOrders) {
        System.out.println("Username hoặc password đang sai!");
        String choiceInput;
        do {
            System.out.println("Mời chọn:");
            System.out.println("1. Đăng nhập lại");
            System.out.println("2. Quên password");
            choiceInput = scanner.nextLine();
        } while (!isChoiceOfTwoFunctionValid(choiceInput));
        switch (Integer.parseInt(choiceInput)){
            case 1:
                loginLogic.logIn(scanner,products,user,orders,preOrders);
                break;
            case 2:
                loginLogic.forgetPassword(scanner,products,user,orders,preOrders);
                break;
        }
    }

    public void loginActionView(Scanner scanner, ArrayList<User> users,ArrayList<Product> products,ArrayList<Order> orders,User thisUser,ArrayList<PreOrder> preOrders) {
        String choiceInput;
        do {
            System.out.println("WELCOME "+ thisUser.getUsername().toUpperCase()+ ", bạn muốn thay đổi thông tin gì?\n" +
                    "1 - Thay đổi username\n" +
                    "2 - Thay đổi email\n" +
                    "3 - Thay đổi mật khẩu\n" +
                    "4 - Trở lại trang cá nhân\n" +
                    "0 - Đăng xuất");
            System.out.println("Mời bạn chọn: ");
            choiceInput = scanner.nextLine();
        } while (!isChoiceOfFiveFunctionValid(choiceInput));
        switch (Integer.parseInt(choiceInput)){
            case 1:
                boolean flag = true;
                while (flag){
                    System.out.println("Mời nhập username mới: ");
                    String username = scanner.nextLine();
                    if(!loginLogic.checkExistedUsername(username, users)){
                        flag=false;
                        thisUser.setUsername(username);
                        System.out.println("Đổi username thành công!");
                    }
                }
                break;
            case 2:
                boolean flag2 = true;
                while (flag2){
                    System.out.println("Mời nhập email mới: ");
                    String email = scanner.nextLine();
                    if(!loginLogic.checkExistedEmail(email, users)){
                        flag2=false;
                        thisUser.setEmail(email);
                        System.out.println("Đổi email thành công!");
                    }
                }
                break;
            case 3:
                System.out.println("Mời nhập password mới: ");
                String password = scanner.nextLine();
                thisUser.setPassword(password);
                System.out.println("Đổi password thành công");
                break;
            case 4:
                if (thisUser.getRole().equals("ADMIN")) {
                    AdminMainHomeView adminMainHomeView = new AdminMainHomeView();
                    adminMainHomeView.displayAdminHomeView(scanner,products,users,thisUser,orders,preOrders);
                } else {
                    UserMainHomeView userMainHomeView = new UserMainHomeView();
                    userMainHomeView.userInfoAccessMenu(scanner,products,users,thisUser,orders,preOrders);
                }
                break;
            case 0:
                displayLoginHomeView(scanner,products,users,orders,preOrders);
                break;
        }
        loginActionView(scanner, users, products, orders, thisUser,preOrders);
    }

    @Override
    public boolean isChoiceOfFiveFunctionValid(String choiceInput) {
        try {
            int choice = Integer.parseInt(choiceInput);
            if (choice>=0 && choice <=4) {
                return true;
            }
            System.out.println("Lựa chọn không hợp lệ!");
            return false;
        } catch (Exception e) {
            System.out.println("Lựa chọn không hợp lệ!");
            return false;
        }
    }

    @Override
    public boolean isChoiceOfThreeFunctionValid(String choiceInput) {
        return false;
    }

    @Override
    public boolean isChoiceOfTwoFunctionValid(String choiceInput) {
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
