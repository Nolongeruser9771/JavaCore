package view;

import data.ProductData;
import entities.*;
import logichandle.ProductLogic;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminMainHomeView implements choiceCheckable, idFindable {
    LoginHomeView loginHomeView = new LoginHomeView();
    public void displayAdminHomeView(Scanner scanner, ArrayList<Product> prods, ArrayList<User> users, User thisUser, ArrayList<Order> orders, ArrayList<PreOrder> preOrders) {
        String choiceInput;
        do {
            System.out.println("WELCOME " + thisUser.getUsername().toUpperCase() + " to ADMIN PAGE, bạn có thể\n" +
                    "1 - Thay đổi thông tin cá nhân\n" +
                    "2 - Xem và chỉnh sửa sản phẩm\n" +
                    "3 - Xem và duyệt đơn hàng\n" +
                    "4 - Thêm quyền admin\n" +
                    "5 - Thoát chương trình\n");
            System.out.println("Mời bạn chọn: ");
            choiceInput = scanner.nextLine();
        } while (!isChoiceOfFiveFunctionValid(choiceInput));
        switch (Integer.parseInt(choiceInput)) {
            case 1:
                loginHomeView.loginActionView(scanner, users, prods, orders, thisUser, preOrders);
                break;
            case 2:
                productShow(prods);
                productUpdateMenu(scanner,prods);
                break;
            case 3:
                orderUpdateMenu(scanner, orders,preOrders);
                break;
            case 4:
                User admin = loginHomeView.loginLogic.SignUp(scanner,prods,users,orders,preOrders);
                admin.setRole("ADMIN");
                break;
            case 0:
                System.exit(0);
                break;
        }
        displayAdminHomeView(scanner, prods, users, thisUser, orders,  preOrders);
    }
    private void orderUpdateMenu(Scanner scanner, ArrayList<Order> orders,ArrayList<PreOrder> preOrders) {
        String choiceInput;
        do {
            System.out.println("Bạn muốn thực hiện:\n" +
                    "1. Xem order\n" +
                    "2. Xem và duyệt pre-order");
            choiceInput = scanner.nextLine();
        } while (!isChoiceOfTwoFunctionValid(choiceInput));
        switch (Integer.parseInt(choiceInput)) {
            case 1:
                orderShow(orders);
                break;
            case 2:
                preorderShow(preOrders);
                preorderConfirm(scanner,preOrders);
                break;
        }
    }
    private void productUpdateMenu(Scanner scanner, ArrayList<Product> products) {
        String choiceInput;
        do {
            System.out.println("Bạn muốn thực hiện:\n" +
                    "1. Thêm sản phẩm\n" +
                    "2. Xoá sản phẩm");
            choiceInput = scanner.nextLine();
        } while (!isChoiceOfTwoFunctionValid(choiceInput));
        ProductLogic productLogic = new ProductLogic();
        switch (Integer.parseInt(choiceInput)) {
            case 1:
                Product newPro = productLogic.productInputInfo(scanner);
                products.add(newPro);
                System.out.println("Đã thêm sản phẩm thành công!");
                break;
            case 2:
                String idInput;
                do {
                    System.out.println("Nhập id sản phẩm muốn xoá: ");
                    idInput = scanner.nextLine();
                } while (findById(idInput,products)==null);
                Product pro = findById(idInput,products);
                products.remove(pro);
                System.out.println("Đã xoá sản phẩm thành công!");
                break;
                //Có thể thêm phần chỉnh sửa sản phẩm
        }
    }

    private void preorderConfirm(Scanner scanner,ArrayList<PreOrder> preOrders) {
        String idInput;
        do {
            System.out.println("Mời nhập id của pre-order cần duyệt: ");
            idInput = scanner.nextLine();
        } while (findPreorderById(idInput,preOrders)==null);
        PreOrder choosedPreOrder = findPreorderById(idInput,preOrders);

        String choiceInput;
        do {
            System.out.println("Bạn muốn duyệt đơn này?\n" +
                    "1. Duyệt đơn           2.Xoá đơn");
            choiceInput = scanner.nextLine();
        } while (!isChoiceOfTwoFunctionValid(choiceInput));
        switch (Integer.parseInt(choiceInput)) {
            case 1:
                choosedPreOrder.setOrderStatus(1);
                break;
            case 2:
                preOrders.remove(choosedPreOrder);
                choosedPreOrder.getNewProduct().setStock(choosedPreOrder.getNewProduct().getStock()+1);
                break;
        }

    }
    private void orderShow(ArrayList<Order> orders) {
        System.out.println("ORDER-ID\tORDER-DATE\t\t\t\t\tPRODUCT-NAME\t\t\t\tQUANTITY\t\t\tPRICE\t\t\t\tTOTAL");
        for (Order order:orders) {
            System.out.printf("%d %25s %20s %20d %20d %20f",order.getId(),order.getOrderDate(),order.getProduct().getProductName(),order.getQuantity(),order.getProduct().getPrice(),order.getTotal());
            System.out.println();
        }
    }
    private void preorderShow(ArrayList<PreOrder> preOrders) {
        System.out.println("ORDER-ID\tORDER-DATE\t\t\t\t\tEXCHANGED-PRODUCT\t\t\t\tNEW-PRODUCT\t\t\tQUANTITY\t\t\tPRICE\t\t\t\tTOTAL");
        for (PreOrder preOrder:preOrders) {
            System.out.printf("%d %25s %20s %20s %20d %20d %20s",preOrder.getId(),preOrder.getOrderDate(),preOrder.getProduct().getProductName(),preOrder.getNewProduct().getProductName(),preOrder.getQuantity(),preOrder.getNewProduct().getPrice(),preOrder.getTotal());
            System.out.println();
        }
    }
    private void productShow(ArrayList<Product> products) {
        System.out.println("ID\tPRODUCT-NAME\t\t\t\t\tPRODUCT-TYPE\t\t\t\tDESCRIPTION\t\t\tPRICE\t\t\t\tSTOCK\t\t\t\tSTATUS");
        for (Product prod:products) {
            System.out.printf("%d %25s %20s %20s %20d %20d %20s",prod.getId(),prod.getProductName(),prod.getProductType(),prod.getDescription(),prod.getPrice(),prod.getStock(),prod.getStockStatus());
            System.out.println();
        }
    }
    @Override
    public boolean isChoiceOfFiveFunctionValid(String choiceInput) {
        try {
            int choice = Integer.parseInt(choiceInput);
            if (choice >= 0 && choice <= 4) {
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
            if (choice>=1 && choice <=5) {
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

    @Override
    public Product findById(String id, ArrayList<Product> products) {
        Product choosedProd = null;
        for (Product prod : products) {
            if (prod.getId() == Integer.parseInt(id)) {
                choosedProd = prod;
                break;
            }
        }
        return choosedProd;
    }

    public PreOrder findPreorderById(String id, ArrayList<PreOrder> preOrders) {
        PreOrder choosedpreOrder = null;
        for (PreOrder preOrder:preOrders) {
            if (preOrder.getId() == Integer.parseInt(id)) {
                choosedpreOrder = preOrder;
                break;
            }
        }
        return choosedpreOrder;
    }
    //Có thể dùng generic chỗ này
}
