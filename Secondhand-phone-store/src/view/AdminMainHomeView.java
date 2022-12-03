package view;

import entities.*;
import iService.MenuService;
import iService.ProductService;
import logichandle.ProductLogic;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminMainHomeView implements MenuService, ProductService {
    LoginHomeView loginHomeView = new LoginHomeView();
    public void displayAdminHomeView(Scanner scanner, ArrayList<Product> prods, ArrayList<User> users, User thisUser, ArrayList<Order> orders, ArrayList<PreOrder> preOrders) {
        String choiceInput;
        do {
            System.out.println("WELCOME " + thisUser.getUsername().toUpperCase() + " to ADMIN PAGE, bạn có thể\n" +
                    "1 - Thay đổi thông tin cá nhân\n" +
                    "2 - Xem và chỉnh sửa sản phẩm\n" +
                    "3 - Xem và duyệt đơn hàng\n" +
                    "4 - Đăng xuất\n" +
                    "5 - Thoát chương trình");
            System.out.println("Mời bạn chọn: ");
            choiceInput = scanner.nextLine();
        } while (!isChoiceOfFiveFunctionValid(choiceInput));
        switch (Integer.parseInt(choiceInput)) {
            case 1:
                loginHomeView.loginActionView(scanner, users, prods, orders, thisUser, preOrders);
                break;
            case 2:
                System.out.println("=====================================================================================");
                System.out.println(("ID\t\tPRODUCT-NAME\t\tPRODUCT-TYPE\t\tDESCRIPTION\t\tPRICE\t\tSTOCK\t\tSTATUS"));
                System.out.println("=====================================================================================");
                System.out.println(prods);
                //show lại cho đẹp
                productUpdateMenu(scanner,prods,users,thisUser,orders,preOrders);
                break;
            case 3:
                orderUpdateMenu(scanner,prods,users,thisUser,orders,preOrders);
                break;
            case 4:
                loginHomeView.displayLoginHomeView(scanner,prods,users,orders,preOrders);
                break;
            case 0:
                System.exit(0);
                break;
        }
        displayAdminHomeView(scanner, prods, users, thisUser, orders,  preOrders);
    }
    private void orderUpdateMenu(Scanner scanner, ArrayList<Product> prods, ArrayList<User> users, User thisUser, ArrayList<Order> orders, ArrayList<PreOrder> preOrders) {
        String choiceInput;

        boolean flag;
        while (true) {
            do {
                flag = true;
                System.out.println("Bạn muốn thực hiện:\n" +
                        "1. Xem order và pre-order\n" +
                        "2. Duyệt pre-order\n" +
                        "3. Trở lại Admin Menu");
                choiceInput = scanner.nextLine();
                if (!isChoiceOfThreeFunctionValid(choiceInput)||(isChoiceOfThreeFunctionValid(choiceInput)&&preOrders.size()==0 && Integer.parseInt(choiceInput)==2)){
                    System.out.println("Lựa chọn không hợp lệ");
                    flag = false;
                }
            } while (!flag);

            switch (Integer.parseInt(choiceInput)) {
                case 1:
                    System.out.println("======================================================================================================================");
                    System.out.println("ORDER-ID\tORDER-DATE\t\tCUSTOMER-NAME\t\tPRODUCT-NAME\tQUANTITY\t\tPRICE\t\tREWARD-POINT\t\t\tTOTAL\t\t\tADDRESS");
                    System.out.println("======================================================================================================================");
                    System.out.println(orders);

                    System.out.println("======================================================================================================================");
                    System.out.println("PREORDER-ID\tPREORDER-DATE\tCUSTOMER-NAME\tOLD-PRODUCT\t\tNEW-PRODUCT\t\tQUANTITY\tPRICE\t\tTOTAL\t\tNOTE");
                    System.out.println("======================================================================================================================");
                    System.out.println(preOrders);
                    break;
                case 2:
                    preorderConfirm(scanner, prods, users, thisUser, orders, preOrders);
                    break;
                case 3:
                    displayAdminHomeView(scanner, prods, users, thisUser, orders, preOrders);
                    break;
            }
        }
    }
    private void productUpdateMenu(Scanner scanner, ArrayList<Product> products, ArrayList<User> users, User thisUser, ArrayList<Order> orders, ArrayList<PreOrder> preOrders) {
        String choiceInput;
        while (true) {
            do {
                System.out.println("Bạn muốn thực hiện:\n" +
                        "1. Thêm sản phẩm\n" +
                        "2. Xoá sản phẩm\n" +
                        "3. Trở lại Admin Menu");
                choiceInput = scanner.nextLine();
            } while (!isChoiceOfThreeFunctionValid(choiceInput));
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
                    } while (findById(idInput, products) == null);
                    Product pro = findById(idInput, products);
                    products.remove(pro);
                    System.out.println("Đã xoá sản phẩm thành công!");
                    break;
                case 3:
                    displayAdminHomeView(scanner, products, users, thisUser, orders, preOrders);
                    break;
            }
        }
    }

    private void PreOrderUpdate(Scanner scanner, ArrayList<Product> products, ArrayList<User> users, User thisUser, ArrayList<Order> orders, ArrayList<PreOrder> preOrders, PreOrder preOrder) {
        String choiceInput;
        while (true) {
            do {
                System.out.println("Bạn có muốn chỉnh sửa giá và thêm ghi chú cho sản phẩm thu đổi không?\n" +
                        "1. Có          2. Không");
                choiceInput = scanner.nextLine();
            } while (!isChoiceOfTwoFunctionValid(choiceInput));
            int choice = Integer.parseInt(choiceInput);
            switch (choice) {
                case 1:
                    int purchasePrice;
                    String note;
                    while (true) {
                        try {
                            System.out.println("Mời nhập giá thực tế thu mua: ");
                            purchasePrice = Integer.parseInt(scanner.nextLine());
                            System.out.println("Mời nhập ghi chú");
                            note = scanner.nextLine();

                            preOrder.setPurchasePrice(purchasePrice);
                            preOrder.setNote(note);
                            preOrder.getUser().setRewardPoint((int) (preOrder.getUser().getRewardPoint() + preOrder.getTotal() * 0.01));
                            break;
                        } catch (Exception e) {
                            System.out.println("Nhập liệu không hợp lệ");
                        }
                    }
                case 2:
                    displayAdminHomeView(scanner, products, users, thisUser, orders, preOrders);
                    break;
            }
        }
    }

    private void preorderConfirm(Scanner scanner, ArrayList<Product> products, ArrayList<User> users, User thisUser, ArrayList<Order> orders, ArrayList<PreOrder> preOrders) {
        preOrders.forEach(p -> {
            if (p.getStatus()==0) {System.out.println(p);}
        });
        String idInput;
        while (true) {
            do {
                System.out.println("Mời nhập id của pre-order cần duyệt: ");
                idInput = scanner.nextLine();
            } while (findPreorderById(idInput, preOrders) == null);
            PreOrder choosedPreOrder = findPreorderById(idInput, preOrders);

            String choiceInput;
            do {
                System.out.println("Bạn muốn duyệt đơn này?\n" +
                        "1. Duyệt đơn           2.Xoá đơn       3. Chọn đơn khác     4. Trở lại Admin Menu");
                choiceInput = scanner.nextLine();
            } while (!isChoiceOfFourFunctionValid(choiceInput));
            switch (Integer.parseInt(choiceInput)) {
                case 1:
                    PreOrderUpdate(scanner, products, users, thisUser, orders, preOrders, choosedPreOrder);
                    choosedPreOrder.setStatus(1);
                    break;
                case 2:
                    preOrders.remove(choosedPreOrder);
                    choosedPreOrder.getNewProduct().setStock(choosedPreOrder.getNewProduct().getStock() + 1);
                    break;
                case 3:
                    preorderConfirm(scanner, products, users, thisUser, orders, preOrders);
                    break;
                case 4:
                    displayAdminHomeView(scanner, products, users, thisUser, orders, preOrders);
                    break;
            }
        }
    }

    private boolean isChoiceOfFourFunctionValid(String choiceInput) {
        try {
            int choice = Integer.parseInt(choiceInput);
            if (choice >= 1 && choice <= 4) {
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

    @Override
    public Product findById(String id, ArrayList<Product> products) {
        Product choosedProd = null;
        try {
            for (Product prod : products) {
                if (prod.getId() == Integer.parseInt(id)) {
                    choosedProd = prod;
                    break;
                }
            }
            return choosedProd;
        } catch (Exception e) {
            System.out.println("Định dạng không hợp lệ!");
        }
        return choosedProd;
    }

    public PreOrder findPreorderById(String id, ArrayList<PreOrder> preOrders) {
        PreOrder choosedpreOrder = null;
        try {
            for (PreOrder preOrder : preOrders) {
                if (preOrder.getId() == Integer.parseInt(id)) {
                    choosedpreOrder = preOrder;
                    break;
                }
            }
            return choosedpreOrder;
        } catch (Exception e) {
            System.out.println("Định dạng không hợp lệ");
        }
        return choosedpreOrder;
    }
    //Có thể dùng generic chỗ này
}
