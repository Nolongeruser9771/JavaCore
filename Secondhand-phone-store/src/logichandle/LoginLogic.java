package logichandle;

import constant.EmailAndPasswordConstant;
import entities.Member;
import entities.Order;
import entities.Product;
import view.LoginHomeView;
import view.MainHomeView;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LoginLogic {
    public Member logIn(Scanner scanner, ArrayList<Product> products, ArrayList<Member> members, ArrayList<Order> orders) {
        System.out.println("Nhập thông tin đăng nhập");
        System.out.println("Mời nhập username:");
        String username = scanner.nextLine();
        System.out.println("Mời nhập password:");
        String password = scanner.nextLine();
        System.out.println(members);

        Member checkedMember = null;
        for (Member Member:members) {
            if (Member.getUsername().equals(username) && Member.getPassword().equals(password)) {
                System.out.println("Đăng nhâp thành công!");
                checkedMember = Member;
                MainHomeView mainHomeView = new MainHomeView();
                mainHomeView.displayHomeMenu(scanner,products,members,checkedMember, orders);
                return checkedMember;
            }
        }
        System.out.println("Đăng nhập thất bại!");
        return checkedMember;
    }

    public void SignUp(Scanner scanner, ArrayList<Product> products, ArrayList<Member> members, ArrayList<Order> orders) {
        String name, phone, address, username = null, password = null, email = null;
        boolean flag = true;

        while (flag) {
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
            Member thisMember;
            if (checkValidPassword(password) && checkValidEmail(email)) {
                if (!checkExistedUsername(username,members) && !checkExistedEmail(email, members)) {
                    System.out.println("Bạn đã đăng kí thành công");
                    thisMember = new Member(name,phone,address,email,username,password);
                    members.add(thisMember);

                    System.out.println(members);
                    logIn(scanner,products,members,orders);
                    flag = false;
                }
            }
        }
    }

    public void forgetPassword(Scanner scanner, ArrayList<Product> products, ArrayList<Member> members, ArrayList<Order> orders) {
        Member thisMember = null;
        System.out.println("Nhập email của bạn: ");
        String email = scanner.nextLine();
        for (Member Member : members) {
            if (Member.getEmail().equals(email)) {
                thisMember = Member;
                break;
            }
        }
        if (thisMember==null) {
            System.out.println("Không tồn tại tài khoản này");
            LoginHomeView loginHomeView = new LoginHomeView();
            loginHomeView.displayLoginHomeView(scanner,products, members, orders);
            return;
        }
        String newPass;
        do {
            System.out.println("Nhập password mới: ");
            newPass = scanner.nextLine();
        } while (!checkValidPassword(newPass));
        thisMember.setPassword(newPass);
        System.out.println("Thay đổi password thành công");
    }
    public boolean checkExistedUsername(String username, ArrayList<Member> members){
        for (Member Member:members){
            if(Member.getUsername().equals(username)){
                System.out.println("Username này đã tồn tại vui lòng nhập lại");
                return true;
            }
        }
        return false;
    }

    public boolean checkExistedEmail(String email, ArrayList<Member> members){
        for (Member Member:members){
            if(Member.getEmail().equals(email)){
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
