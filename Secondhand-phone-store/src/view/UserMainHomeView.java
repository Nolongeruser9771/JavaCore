package view;

import constant.PhoneTypeConstant;
import entities.*;
import logichandle.BuyLogic;
import logichandle.ExchangeAndSaleLogic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class UserMainHomeView implements MenuService {

    public void displayHomeMenu(Scanner scanner, ArrayList<Product> prods, ArrayList<User> users, User thisUser, ArrayList<Order> orders, ArrayList<PreOrder> preOrders) {

        String choiceInput;
        do {
            System.out.println("===== WELCOME TO NGUYÊN SECOND-SMART =====\n" +
                "Bạn muốn làm gì?\n" +
                "1. Mua điện thoại      2. Bán điện thoại       3. Đổi cũ lấy mới      4.Thay đổi thông tin cá nhân    0. Thoát\n" +
                "Mời bạn chọn");
            choiceInput = scanner.nextLine();
        } while (!isChoiceOfFiveFunctionValid(choiceInput));
        //Id sản phẩm
        ExchangeAndSaleLogic exchangeAndSaleLogic = new ExchangeAndSaleLogic();
        switch (Integer.parseInt(choiceInput)) {
            case 1:
                displayBuyMenu(scanner,prods,users,orders,thisUser);
                break;
            case 2:
                exchangeAndSaleLogic.saleInfoInput(scanner,prods);
                break;
            case 3:
                exchangeAndSaleLogic.exchangeInfoInput(scanner,prods,thisUser,preOrders);
                break;
            case 4:
                LoginHomeView loginHomeView = new LoginHomeView();
                loginHomeView.loginActionView(scanner, users, prods, orders, thisUser,preOrders);
            case 5:
                System.exit(0);
        }
        displayHomeMenu(scanner, prods, users,thisUser, orders, preOrders);
    }

    public void displayBuyMenu(Scanner scanner, ArrayList<Product> products, ArrayList<User> users, ArrayList<Order> orders, User thisUser) {
        String choiceInput;
        do {
            System.out.println("Bạn muốn hiển thị sản phẩm theo:\n" +
                    "1. Theo giá        2. Theo loại");
            choiceInput = scanner.nextLine();
        } while (!isChoiceOfTwoFunctionValid(choiceInput));
        BuyLogic buyLogic = new BuyLogic();
        switch (Integer.parseInt(choiceInput)) {
            case 1:
                displayPriceMenu(scanner,products);
                buyLogic.BuyInfo(scanner,products,users,orders,thisUser);
                break;
            case 2:
                String type = phoneTypeChoose(scanner);
                productShowByType(products,type);
                buyLogic.BuyInfo(scanner,products,users,orders,thisUser);
                break;
        }
    }

    private void displayPriceMenu(Scanner scanner, ArrayList<Product> products) {
        String choiceInput;
        do {
            System.out.println("Bạn muốn sắp xếp sản phẩm theo thứ tự:\n" +
                    "1. Từ thấp tới cao     2. Từ cao tới thấp");
            choiceInput = scanner.nextLine();
        } while (!isChoiceOfTwoFunctionValid(choiceInput));
        switch (Integer.parseInt(choiceInput)) {
            case 1:
                products.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o1.getPrice()- o2.getPrice();
                    }
                });
                productShow(products);
                break;
            case 2:
                products.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o2.getPrice()- o1.getPrice();
                    }
                });
                productShow(products);
                break;
        }
    }
    private void productShowByType(ArrayList<Product> products, String type) {
        System.out.println("================================================================");
        System.out.println("ID\t\t\tPRODUCT-NAME\t\tDESCRIPTION\t\tPRICE\t\tSTATUS");
        System.out.println("================================================================");
        products.forEach(prod -> {
            if (prod.getProductType().equals(type)) {
                System.out.println(prod.getId()+"\t\t\t"+prod.getProductName()+"\t\t\t"+prod.getDescription()+"\t\t\t"+prod.getPrice()+"\t\t\t"+prod.getStockStatus());
            }
        });
    }

    private void productShow(ArrayList<Product> products) {
        System.out.println("================================================================");
        System.out.println("ID\t\t\tPRODUCT-NAME\t\tDESCRIPTION\t\tPRICE\t\tSTATUS");
        System.out.println("================================================================");
        products.forEach(prod -> {
            System.out.println(prod.getId()+"\t\t\t"+prod.getProductName()+"\t\t\t"+prod.getDescription()+"\t\t\t"+prod.getPrice()+"\t\t\t"+prod.getStockStatus());
        });
    }

    public String phoneTypeChoose(Scanner scanner) {
        String type = null;
        String typeChoiceInput;
        do {
            System.out.println("Mời chọn loại điện thoại:\n" +
                    "1. Apple   2. SamSung  3.Oppo\n" +
                    "Mời bạn chọn");
            typeChoiceInput = scanner.nextLine();
        } while (!isChoiceOfThreeFunctionValid(typeChoiceInput));
        switch (Integer.parseInt(typeChoiceInput)) {
            case 1:
                type = PhoneTypeConstant.A.value;
                break;
            case 2:
                type = PhoneTypeConstant.S.value;
                break;
            case 3:
                type = PhoneTypeConstant.O.value;
                break;
        }
        return type;
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
        try {
            int choice = Integer.parseInt(choiceInput);
            if (choice>=1 && choice <=3) {
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
