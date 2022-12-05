package view;

import constant.PhoneTypeConstant;
import entities.*;
import iService.MenuService;
import logichandle.BuyLogic;
import logichandle.ExchangeAndSaleLogic;
import logichandle.UserLogic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class UserMainHomeView implements MenuService {
    UserLogic userLogic = new UserLogic();
    LoginHomeView loginHomeView = new LoginHomeView();
    public void displayHomeMenu(Scanner scanner, ArrayList<Product> prods, ArrayList<User> users, User thisUser, ArrayList<Order> orders, ArrayList<PreOrder> preOrders) {
        String choiceInput;
        do {
            System.out.println("===== WELCOME TO NGUYÊN SECOND-SMART =====\n" +
                "Bạn muốn làm gì?\n" +
                "1. Mua điện thoại      2. Bán điện thoại       3. Đổi cũ lấy mới      4.Truy cập thông tin cá nhân    0. Thoát\n" +
                "Mời bạn chọn");
            choiceInput = scanner.nextLine();
        } while (!isChoiceOfFiveFunctionValid(choiceInput));
        ExchangeAndSaleLogic exchangeAndSaleLogic = new ExchangeAndSaleLogic();
        switch (Integer.parseInt(choiceInput)) {
            case 1:
                displayBuyMenu(scanner,prods,users,orders,thisUser,preOrders);
                break;
            case 2:
                exchangeAndSaleLogic.saleInfoInput(scanner,prods);
                break;
            case 3:
                exchangeAndSaleLogic.exchangeInfoInput(scanner,prods,thisUser,preOrders);
                break;
            case 4:
                userInfoAccessMenu(scanner,prods,users,thisUser,orders,preOrders);
                break;
            case 0:
                System.exit(0);
        }
        displayHomeMenu(scanner, prods, users,thisUser, orders, preOrders);
    }

    public void userInfoAccessMenu(Scanner scanner, ArrayList<Product> prods, ArrayList<User> users, User thisUser, ArrayList<Order> orders, ArrayList<PreOrder> preOrders) {
        String choiceInput;
        while (true) {
            do {
                System.out.println("Bạn có thể:\n" +
                        "1. Thông tin đăng nhập    2. Thông tin cá nhân   3. Thông tin đơn hàng     4. Xem điểm thưởng    0. Trở lại Main Menu");
                choiceInput = scanner.nextLine();
            } while (!isChoiceOfFiveFunctionValid(choiceInput));
            switch (Integer.parseInt(choiceInput)) {
                case 1:
                    loginHomeView.loginActionView(scanner, users, prods, orders, thisUser, preOrders);
                    break;
                case 2:
                    userLogic.userInfoChange(scanner,prods,users,thisUser,orders,preOrders);
                    break;
                case 3:
                    userLogic.showOrderInfo(thisUser);
                    break;
                case 4:
                    System.out.println("==========================");
                    System.out.println("ĐIỂM THƯỞNG CỦA BẠN LÀ");
                    System.out.println("==========================");
                    System.out.println(thisUser.getRewardPoint());
                    break;
                case 0:
                    displayHomeMenu(scanner, prods, users, thisUser, orders, preOrders);
                    break;
            }
        }
    }

    public void displayBuyMenu(Scanner scanner, ArrayList<Product> products, ArrayList<User> users, ArrayList<Order> orders, User thisUser, ArrayList<PreOrder> preOrders) {
        String choiceInput;
        do {
            System.out.println("Bạn muốn hiển thị sản phẩm theo:\n" +
                    "1. Theo giá        2. Theo loại");
            choiceInput = scanner.nextLine();
        } while (!isChoiceOfTwoFunctionValid(choiceInput));
        BuyLogic buyLogic = new BuyLogic();
        ArrayList<Product> sortLists;
        switch (Integer.parseInt(choiceInput)) {
            case 1:
                //Tạo ra sortList để khi findID chỉ tìm trong sortLists hiển thị
                sortLists = displayPriceMenu(scanner,products);
                buyLogic.BuyInfoInput(scanner,products,users,orders,thisUser,sortLists,preOrders);
                break;
            case 2:
                String type = phoneTypeChoose(scanner);
                sortLists = productShowByType(products,type);
                buyLogic.BuyInfoInput(scanner,products,users,orders,thisUser,sortLists, preOrders);
                break;
        }
    }

    private ArrayList<Product> displayPriceMenu(Scanner scanner, ArrayList<Product> products) {
        String choiceInput;
        do {
            System.out.println("Bạn muốn sắp xếp sản phẩm theo thứ tự:\n" +
                    "1. Từ thấp tới cao     2. Từ cao tới thấp       3. Theo khoảng giá");
            choiceInput = scanner.nextLine();
        } while (!isChoiceOfThreeFunctionValid(choiceInput));
        ArrayList<Product> sortLists = new ArrayList<>();
        switch (Integer.parseInt(choiceInput)) {
            case 1:
                products.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o1.getPrice() - o2.getPrice();
                    }
                });
                productShow(products);
                sortLists = products;
                break;
            case 2:
                products.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o2.getPrice() - o1.getPrice();
                    }
                });
                productShow(products);
                sortLists = products;
                break;
            case 3:
                //hiển thị theo khoảng giá
                String choiceIn;
                do {
                    sortLists = productShowByPrice(scanner,products);
                    System.out.println("Bạn có muốn tìm tiếp không?\n" +
                            "1. Có     2. Không");
                    choiceIn = scanner.nextLine();
                } while (!isChoiceOfTwoFunctionValid(choiceIn) || Integer.parseInt(choiceIn) == 1);
                break;
        }
        return sortLists;
    }
    private ArrayList<Product> productShowByPrice(Scanner scanner, ArrayList<Product> products) {
        ArrayList<Product> sortLists = new ArrayList<>();
        try {
            System.out.println("Mời bạn nhập khoảng giá muốn tìm\n" + "" +
                    "Từ: ");
            int fromPrice = Integer.parseInt(scanner.nextLine());
            System.out.println("Đến: ");
            int toPrice = Integer.parseInt(scanner.nextLine());
            //Kiểm tra khoảng giá có phù hợp không
            if(toPrice>fromPrice) {
                for (Product prod : products) {
                    if (prod.getPrice() < toPrice && prod.getPrice() > fromPrice) {
                        sortLists.add(prod);
                    }
                }
            } else {
                System.out.println("Khoảng giá không phù hợp!");
                return sortLists;
            }

            if (sortLists.size()==0) {
                System.out.println("Không tìm được sản phẩm trong khoảng giá trên!");
                return sortLists;
            } else {
                productShow(sortLists);
            }
        } catch (Exception e) {
            System.out.println("Dữ liệu không hợp lệ");
        }
        return sortLists;
    }
    private ArrayList<Product> productShowByType(ArrayList<Product> products, String type) {
        ArrayList <Product> sortLists = new ArrayList<>();
        System.out.println("================================================================");
        System.out.println("ID\t\t\tPRODUCT-NAME\t\tDESCRIPTION\t\tPRICE\t\tSTATUS");
        System.out.println("================================================================");
        products.forEach(prod -> {
            if (prod.getProductType().equals(type)) {
                System.out.println(prod.getId()+"\t\t\t"+prod.getProductName()+"\t\t\t"+prod.getDescription()+"\t\t\t"+prod.getPrice()+"\t\t\t"+prod.getStockStatus());
                sortLists.add(prod);
            }
        });
        return sortLists;
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
