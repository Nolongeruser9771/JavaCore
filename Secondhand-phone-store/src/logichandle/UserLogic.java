package logichandle;

import entities.*;
import iService.DataService;
import view.UserMainHomeView;

import java.util.ArrayList;
import java.util.Scanner;

public class UserLogic extends DataService {
    public void showOrderInfo(User thisUser) {
        if (thisUser.getOrders().size()!=0) {
            System.out.println("==========================================================================");
            System.out.println("ĐƠN HÀNG ORDER");
            System.out.println("==========================================================================");
            listShow(thisUser.getOrders());
            return;
        }
        if (thisUser.getPreOrders().size()!=0) {
            System.out.println("==========================================================================");
            System.out.println("ĐƠN HÀNG PRE-ORDER");
            System.out.println("==========================================================================");
            listShow(thisUser.getPreOrders());
            return;
        }
        System.out.println("Bạn không có đơn hàng nào");
    }

    public void userInfoChange(Scanner scanner, ArrayList<Product> prods, ArrayList<User> users, User thisUser, ArrayList<Order> orders, ArrayList<PreOrder> preOrders) {
        String choiceInput;
        while (true) {
            do {
                System.out.println("Bạn muốn thay đổi thông tin nào\n" +
                        "1. Thay đổi Họ và Tên    2. Thay đổi số điện thoại    3. Thay đổi địa chỉ    4. Trở lại User Menu");
                choiceInput = scanner.nextLine();
            } while (!isChoiceOfFunctionValid(choiceInput));
            switch (Integer.parseInt(choiceInput)) {
                case 1:
                    System.out.println("Nhập Họ và Tên mới");
                    thisUser.setName(scanner.nextLine());
                    System.out.println("Thay đổi Họ và tên thành công!");
                    break;
                case 2:
                    System.out.println("Nhập số điện thoại mới");
                    thisUser.setPhone(scanner.nextLine());
                    System.out.println("Thay đổi số điện thoại thành công!");
                    break;
                case 3:
                    System.out.println("Nhập địa chỉ mới");
                    thisUser.setAddress(scanner.nextLine());
                    System.out.println("Thay đổi địa chỉ thành công!");
                    break;
                case 4:
                    UserMainHomeView userMainHomeView = new UserMainHomeView();
                    userMainHomeView.userInfoAccessMenu(scanner, prods, users, thisUser, orders, preOrders);
                    break;
            }
        }
    }

    public boolean isChoiceOfFunctionValid(String choiceInput) {
        try {
            int choice = Integer.parseInt(choiceInput);
            if (choice>=1 && choice <=4) {
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
