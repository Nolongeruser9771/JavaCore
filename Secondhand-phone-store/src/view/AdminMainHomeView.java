package view;

import entities.*;
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
                    "4 - Thêm quyền admin\n" +
                    "5 - Thoát chương trình\n");
            //Thêm options thêm đơn hàng
            System.out.println("Mời bạn chọn: ");
            choiceInput = scanner.nextLine();
        } while (!isChoiceOfFiveFunctionValid(choiceInput));
        switch (Integer.parseInt(choiceInput)) {
            case 1:
                loginHomeView.loginActionView(scanner, users, prods, orders, thisUser, preOrders);
                break;
            case 2:
                System.out.println("=====================================================================================");
                System.out.println(("ID\tPRODUCT-NAME\t\tPRODUCT-TYPE\t\tDESCRIPTION\t\tPRICE\t\tSTOCK\t\tSTATUS"));
                System.out.println("=====================================================================================");
                System.out.println(prods);
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
                    "1. Xem order và pre-order\n" +
                    "2. Duyệt pre-order");
            choiceInput = scanner.nextLine();
        } while (!isChoiceOfTwoFunctionValid(choiceInput));
        switch (Integer.parseInt(choiceInput)) {
            case 1:
                System.out.println("======================================================================================================================");
                System.out.println("ORDER-ID\tORDER-DATE\t\tCUSTOMER-NAME\t\tPRODUCT-NAME\tQUANTITY\t\tPRICE\t\tREWARD-POINT\t\t\tTOTAL");
                System.out.println("======================================================================================================================");
                System.out.println(orders);

                System.out.println("======================================================================================================================");
                System.out.println("PREORDER-ID\tPREORDER-DATE\tCUSTOMER-NAME\tOLD-PRODUCT\t\tNEW-PRODUCT\t\tQUANTITY\tPRICE\t\tTOTAL\t\tNOTE");
                System.out.println("======================================================================================================================");
                System.out.println(preOrders);
                break;
            case 2:
                //trước khi duyệt cần hiển thị các preorder có status = 0
                preorderConfirm(scanner,preOrders);
                break;
                //Có thể thêm chức năng thêm order
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

    private void PreOrderUpdate(Scanner scanner, PreOrder preOrder) {
        String choiceInput;
        do {
            System.out.println("Bạn có muốn chỉnh sửa giá và thêm ghi chú cho sản phẩm thu đổi không?\n" +
                    "1. Có          2. Không");
            choiceInput = scanner.nextLine();
        }while (!isChoiceOfTwoFunctionValid(choiceInput));
        int choice = Integer.parseInt(choiceInput);
        switch (choice){
            case 1:
                int total;
                String note;
                while (true) {
                    try {
                        System.out.println("Mời nhập số tiền cần thanh toán: ");
                        total = Integer.parseInt(scanner.nextLine());
                        System.out.println("Mời nhập ghi chú");
                        note = scanner.nextLine();
                        preOrder.setTotal(total);
                        preOrder.setNote(note);
                        preOrder.getUser().setRewardPoint((int)(total*0.01));
                    } catch (Exception e) {
                        System.out.println("Nhập liệu không hợp lệ");
                    }
                }
            case 2:
                break;
        }

    }

    private void preorderConfirm(Scanner scanner,ArrayList<PreOrder> preOrders) {
        preOrders.forEach(p -> {
            if (p.getStatus()==0) {System.out.println(p);}
        });
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
                PreOrderUpdate(scanner,choosedPreOrder);
                choosedPreOrder.setStatus(1);
                break;
            case 2:
                preOrders.remove(choosedPreOrder);
                choosedPreOrder.getNewProduct().setStock(choosedPreOrder.getNewProduct().getStock()+1);
                break;
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
