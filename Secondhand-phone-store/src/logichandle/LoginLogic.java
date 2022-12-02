package logichandle;

import constant.EmailAndPasswordConstant;
import entities.*;
import view.AdminMainHomeView;
import view.LoginHomeView;
import view.UserMainHomeView;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LoginLogic {
    public User logIn(Scanner scanner, ArrayList<Product> products, ArrayList<User> users, ArrayList<Order> orders, ArrayList<PreOrder> preOrders) {
        System.out.println("Nhập thông tin đăng nhập");
        System.out.println("Mời nhập username:");
        String username = scanner.nextLine();
        System.out.println("Mời nhập password:");
        String password = scanner.nextLine();

        User checkedUser = null;
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Đăng nhâp thành công!");
                checkedUser = user;
                if (user.getRole().equals("ADMIN")) {
                    AdminMainHomeView adminMainHomeView = new AdminMainHomeView();
                    adminMainHomeView.displayAdminHomeView(scanner, products, users,user, orders, preOrders);
                    return checkedUser;
                } else {
                    UserMainHomeView mainHomeView = new UserMainHomeView();
                    mainHomeView.displayHomeMenu(scanner, products, users, checkedUser, orders, preOrders);
                    return checkedUser;
                }
            }
        }
        System.out.println("Đăng nhập thất bại!");
        return checkedUser;

    }
    //Check lại

    public User SignUp(Scanner scanner, ArrayList<Product> products, ArrayList<User> users, ArrayList<Order> orders, ArrayList<PreOrder> preOrders) {
        String name, phone, address, username = null, password = null, email = null;
        User thisUser = null;
        do {
            System.out.println("Mời nhập thông tin cá nhân:\n" +
                    "Mời nhập họ và tên: ");
            name = scanner.nextLine();
            System.out.println("Mời nhập số điện thoại:");
            phone = scanner.nextLine();
            System.out.println("Mời nhập địa chỉ:");
            address = scanner.nextLine();
            System.out.println("Mời nhập thông tin tài khoản:\n" +
                    "Mời nhập username:");
            username = scanner.nextLine();
            System.out.println("Mời nhập password:");
            password = scanner.nextLine();
            System.out.println("Mời nhập email:");
            email = scanner.nextLine();
            if (checkValidPassword(password) && checkValidEmail(email)) {
                if (!checkExistedUsername(username,users) && !checkExistedEmail(email, users)) {
                    System.out.println("Bạn đã đăng kí thành công");
                    thisUser = new User(name,phone,address,email,username,password,"MEMBER");
                    users.add(thisUser);
                    return thisUser;
                }
            }
        } while (thisUser==null);

        return thisUser;
    }

    public void forgetPassword(Scanner scanner, ArrayList<Product> products, ArrayList<User> users, ArrayList<Order> orders, ArrayList<PreOrder> preOrders) {
        User thisUser = null;
        System.out.println("Nhập email của bạn: ");
        String email = scanner.nextLine();
        for (User User : users) {
            if (User.getEmail().equals(email)) {
                thisUser = User;
                break;
            }
        }
        if (thisUser==null) {
            System.out.println("Không tồn tại tài khoản này");
            LoginHomeView loginHomeView = new LoginHomeView();
            loginHomeView.displayLoginHomeView(scanner,products, users, orders,preOrders);
            return;
        }
        String newPass;
        do {
            System.out.println("Nhập password mới: ");
            newPass = scanner.nextLine();
        } while (!checkValidPassword(newPass));
        thisUser.setPassword(newPass);
        System.out.println("Thay đổi password thành công");
    }
    public boolean checkExistedUsername(String username, ArrayList<User> users){
        for (User User:users){
            if(User.getUsername().equals(username)){
                System.out.println("Username này đã tồn tại vui lòng nhập lại");
                return true;
            }
        }
        return false;
    }

    public boolean checkExistedEmail(String email, ArrayList<User> users){
        for (User User:users){
            if(User.getEmail().equals(email)){
                System.out.println("Email này đã tồn tại vui lòng nhập lại");
                return true;
            }
        }
        return false;
    }

    public boolean checkValidPassword(String password){
        if(!Pattern.matches(EmailAndPasswordConstant.REGEX_PASSWORD,password)){
            System.out.println("Password phải có ít nhất 1 kí tự In hoa, 1 kí tự thườngm 1 kí tự số và 1 kí t đặc biệt, vui lòng thử lại");
            return false;
        }
        return true;
    }

    public boolean checkValidEmail(String email){
        if(!Pattern.matches(EmailAndPasswordConstant.REGEX_EMAIL,email)){
            System.out.println("Email không hợp lệ, vui lòng thử lại");
            return false;
        }
        return true;
    }
}
