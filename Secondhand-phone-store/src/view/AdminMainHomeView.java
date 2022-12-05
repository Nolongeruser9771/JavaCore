package view;

import entities.*;
import iService.MenuService;
import iService.ProductService;
import iService.DataService;
import logichandle.ProductLogic;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminMainHomeView extends DataService implements MenuService, ProductService {
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
                if (!isChoiceOfThreeFunctionValid(choiceInput)) {
                    flag = false;
                } else if (preOrders.size()==0 && Integer.parseInt(choiceInput)==2) {
                    //Kiểm tra nếu ko có preorder thì không cho duyệt, quay lại menu
                    System.out.println("Hiện tại không có đơn hàng cần phải duyệt!");
                    flag = false;
                }
            } while (!flag);

            switch (Integer.parseInt(choiceInput)) {
                case 1:
                    System.out.println("===========================================================================================================");
                    System.out.println("ORDER-ID\tORDER-DATE\tCUSTOMER-NAME\tPRODUCT-NAME\tQUANTITY\tPRICE\t\tREWARD-POINT\tTOTAL\t\tADDRESS");
                    System.out.println("===========================================================================================================");
                    listShow(orders);
                    System.out.println();
                    System.out.println("=======================================================================================================================");
                    System.out.println("PREORDER-ID\tPREORDER-DATE\tCUSTOMER-NAME\tOLD-PRODUCT\t\tNEW-PRODUCT\tQUANTITY\tPRICE\t\tTOTAL\t\tNOTE");
                    System.out.println("=======================================================================================================================");
                    listShow(preOrders);
                    break;
                case 2:
                    boolean flag1 = false;
                    //Tạo sortLists gồm các preorder có trạng thái 0 (chưa duyệt) -> hiển thị sortLists
                    do {
                        ArrayList<PreOrder> sortLists = preOrdersSortListshow(preOrders);
                        if (sortLists.size() == 0) {
                            System.out.println("Không có preOrder cần duyệt!");
                            return;
                        }
                        preorderConfirm(scanner, prods, users, thisUser, orders, sortLists, preOrders);
                        String choiceIn;
                        do {
                            System.out.println("Bạn muốn tiếp tục duyệt pre-order không?\n" +
                                    "1. Có       2. Không");
                            choiceIn = scanner.nextLine();
                        } while (!isChoiceOfTwoFunctionValid(choiceIn));
                        if (Integer.parseInt(choiceIn)==1) {
                            flag1 = true;
                        }
                    }while (flag1);
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
                        "1. Xem sản phẩm\n" +
                        "2. Thêm sản phẩm\n" +
                        "3. Xoá sản phẩm\n" +
                        "4. Trở lại Admin Menu");
                choiceInput = scanner.nextLine();
            } while (!isChoiceOfFourFunctionValid(choiceInput));
            switch (Integer.parseInt(choiceInput)) {
                case 1:
                    System.out.println("=====================================================================================");
                    System.out.println("ID\tPRODUCT-NAME\tPRODUCT-TYPE\tDESCRIPTION\tPRICE\tSTOCK\tSTATUS");
                    System.out.println("=====================================================================================");
                    listShow(products);
                    break;
                case 2:
                    ProductLogic productLogic = new ProductLogic();
                    Product newPro = productLogic.productInputInfo(scanner);
                    products.add(newPro);
                    elementShow(newPro);
                    System.out.println("Đã thêm sản phẩm thành công!");
                    break;
                case 3:
                    String idInput;
                    do {
                        System.out.println("Nhập id sản phẩm muốn xoá: ");
                        idInput = scanner.nextLine();
                    } while (findById(idInput, products) == null);
                    Product pro = findById(idInput, products);
                    elementShow(pro);

                    String choiceIn;
                    do {
                        System.out.println("Bạn có chắc muốn xóa sản phẩm này?\n" +
                                "1.  Có          2. Không");
                        choiceIn = scanner.nextLine();
                    } while (!isChoiceOfTwoFunctionValid(choiceIn));
                    if (Integer.parseInt(choiceIn)==1) {
                        products.remove(pro);
                        System.out.println("Đã xoá sản phẩm thành công!");
                    }
                    break;
                case 4:
                    displayAdminHomeView(scanner, products, users, thisUser, orders, preOrders);
                    break;
            }
        }
    }

    private void PreOrderUpdate(Scanner scanner, ArrayList<Product> products, ArrayList<User> users, User thisUser, ArrayList<Order> orders, ArrayList<PreOrder> preOrders, PreOrder preOrder) {
        String choiceInput;
        do {
            System.out.println("Bạn có muốn chỉnh sửa giá và thêm ghi chú cho sản phẩm thu đổi không?\n" +
                    "1. Có          2. Không");
            choiceInput = scanner.nextLine();
        } while (!isChoiceOfTwoFunctionValid(choiceInput));
        int choice = Integer.parseInt(choiceInput);
        switch (choice) {
        case 1:
            int purchasePrice, total, plusReward;
            String note;
            while (true) {
                try {
                    System.out.println("Mời nhập giá thu mua thực tế: ");
                    purchasePrice = Integer.parseInt(scanner.nextLine());
                    System.out.println("Mời nhập ghi chú");
                    note = scanner.nextLine();

                    //Thay đổi tình trạng preOrder/total/note
                    preOrder.setStatus(1);
                    if (preOrder.getNewProduct().getPrice()>purchasePrice){
                        total  = preOrder.getNewProduct().getPrice()-purchasePrice;
                    } else total =0;
                    preOrder.setTotal(total);
                    preOrder.setNote(note);

                    //Set điểm reward
                    plusReward = rewardPointCal(purchasePrice,preOrder);
                    preOrder.getUser().setRewardPoint(preOrder.getUser().getRewardPoint() + plusReward);
                    System.out.println("Đã duyệt đơn thành công!");
                    elementShow(preOrder);


                    break;
                } catch (Exception e) {
                    System.out.println("Nhập liệu không hợp lệ");
                }
            }
                break;
            case 2:
                //Chỉnh sửa trạng thái
                preOrder.setStatus(1);
                //set điểm reward cho user
                plusReward =rewardPointCal(preOrder.getPurchasePrice(),preOrder);
                preOrder.getUser().setRewardPoint(preOrder.getUser().getRewardPoint() + plusReward);

                elementShow(preOrder);
                System.out.println("Đã duyệt đơn thành công!");
                break;
            }
        }
    private int rewardPointCal(int purchasePrice, PreOrder preOrder) {
        int rewardPointPlus;
        //nếu giá mua cao hơn giá bán thì total = 0; reward bằng số chênh lệch;
        //Nếu giá mua nhỏ hơn giá bán thì total bằng chêch lệch;
        if (purchasePrice > preOrder.getNewProduct().getPrice()) {
            rewardPointPlus = purchasePrice - preOrder.getNewProduct().getPrice();
        } else {
            rewardPointPlus = (int) (preOrder.getTotal() * 0.01);
        }
        return rewardPointPlus;
    }
    private ArrayList<PreOrder> preOrdersSortListshow(ArrayList<PreOrder> preOrders){
        ArrayList<PreOrder> sortLists = new ArrayList<>();
        //Hiển thị các đơn có status = 0 ;
        preOrders.forEach(p -> {
            if (p.getStatus()==0) {
                System.out.println(p);
                sortLists.add(p);}});
        return sortLists;
    }
    private void preorderConfirm(Scanner scanner, ArrayList<Product> products, ArrayList<User> users, User thisUser, ArrayList<Order> orders,ArrayList<PreOrder> sortLists, ArrayList<PreOrder> preOrders) {
        String idInput;
        do {
            System.out.println("Mời nhập id của pre-order cần duyệt: ");
            idInput = scanner.nextLine();
        } while (findPreorderById(idInput, sortLists) == null);
        PreOrder choosedPreOrder = findPreorderById(idInput, sortLists);

        String choiceInput;
        do {
            System.out.println("Bạn muốn duyệt đơn này?\n" +
                    "1. Duyệt đơn           2.Xoá đơn       3. Chọn đơn khác     4. Trở lại Admin Menu");
            choiceInput = scanner.nextLine();
        } while (!isChoiceOfFourFunctionValid(choiceInput));
        switch (Integer.parseInt(choiceInput)) {
            case 1:
                PreOrderUpdate(scanner, products, users, thisUser, orders, preOrders, choosedPreOrder);
                break;
            case 2:
                preOrders.remove(choosedPreOrder);
                choosedPreOrder.getNewProduct().setStock(choosedPreOrder.getNewProduct().getStock() + 1);
                System.out.println("Đã xóa đơn thành công!");
                break;
            case 3:
                preorderConfirm(scanner, products, users, thisUser, orders,preOrders,sortLists);
                break;
            case 4:
                displayAdminHomeView(scanner, products, users, thisUser, orders, preOrders);
                break;
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
            if (choosedProd==null) {
                System.out.println("Không tìm thấy id này");
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
            if (choosedpreOrder==null) {
                System.out.println("Không tìm thấy id này");
            }
            return choosedpreOrder;
        } catch (Exception e) {
            System.out.println("Định dạng không hợp lệ");
        }
        return choosedpreOrder;
    }
}
