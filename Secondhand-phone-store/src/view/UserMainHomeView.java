package view;

import constant.PhoneTypeConstant;
import entities.*;
import logichandle.BuyLogic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class UserMainHomeView implements idFindable, choiceCheckable {

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
        switch (Integer.parseInt(choiceInput)) {
            case 1:
                displayBuyMenu(scanner,prods,users,orders,thisUser);
                break;
            case 2:
                displaySaleMenu(scanner,prods);
                break;
            case 3:
                displayExhangeMenu(scanner,prods,thisUser,preOrders);
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
                products.forEach(prod -> {
                    if (prod.getProductType().equals(type)) {
                        System.out.println(prod);
                    }
                });
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
                products.forEach(System.out::println);
                break;
            case 2:
                products.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o2.getPrice()- o1.getPrice();
                    }
                });
                products.forEach(System.out::println);
                break;
        }
    }
    private void displaySaleMenu(Scanner scanner,ArrayList<Product> products) {
        System.out.println("Bạn muốn bán điện thoại?");
        Product choosedProduct = choosePhone(scanner, products);
        double rate =phoneStatusChoose(scanner);

        System.out.println("Giá thu mua của chúng tôi cho sản phẩm này là: " + choosedProduct.getPrice()*rate);
        System.out.println("Hiện tại, chúng tôi không hỗ trợ thu mua online.\n" +
                "Nếu bạn đồng ý với gía thu mua trên, xin vui lòng mang điện thoại đến cửa hàng của chúng tôi");
    }
    private void displayExhangeMenu(Scanner scanner,ArrayList<Product> products, User thisUser, ArrayList<PreOrder> exchangePreOrders) {
        System.out.println("Bạn muốn đổi điện thoại?");
        Product oldPro = choosePhone(scanner, products);
        double purchasePrice = oldPro.getPrice() * phoneStatusChoose(scanner);
        System.out.println("Chọn hiệu điện thoại bạn muốn đổi");
        Product newPro = choosePhone(scanner,products);
        double payment = newPro.getPrice() - purchasePrice;
        long rewardPoint = (long) Math.abs(payment);
        if (payment>=0) {
            System.out.println("Bạn có thể đổi điện thoại "+ newPro.getProductName() + ", số tiền cần bù vào là:" + payment + "VNĐ");
        } else {

            System.out.println("Bạn có thể đổi miễn phí điện thoại " + newPro.getProductName()+", và được tặng thêm "+ rewardPoint +
                    " điểm trong tài khoản, có thể sử dụng cho các đơn hàng tiếp theo");
        }
        String choiceInput;
        do {
            System.out.println("Bạn có muốn pre-order để chúng tôi giữ sản phẩm lại cho bạn không?\n" +
                    "1. Có. Tôi muốn            2. Không. Tôi cần xem xét lại");
            choiceInput = scanner.nextLine();
        } while (!isChoiceOfTwoFunctionValid(choiceInput));
        switch (Integer.parseInt(choiceInput)) {
            case 1:
                PreOrder exchangePreOrder = new PreOrder(thisUser,oldPro,newPro,1);
                exchangePreOrders.add(exchangePreOrder);
                newPro.setStock(newPro.getStock()-1);
                thisUser.setRewardPoint(thisUser.getRewardPoint()+rewardPoint);
                System.out.println("Bạn đã pre-order để thu cũ đổi mới thành công");
                break;
            case 2:
                break;
        }
    }
    private Product choosePhone(Scanner scanner, ArrayList<Product> products) {
        System.out.println("Bạn cần chọn loại và tình trạng điện thoại để biêt giá thu mua hiện tại của chúng tôi");
        String type = phoneTypeChoose(scanner);
        products.forEach(prod -> {
            if (prod.getProductType().equals(type)) {
                System.out.println(prod.getId() + "\t\t" + prod.getProductName());
            }});
        String idInput;
        do {
            System.out.println("Nhập loại điện thoại bạn muốn bán bằng cách nhập id tương ứng");
            idInput = scanner.nextLine();
        } while (findById(idInput, products) == null);
        return findById(idInput, products);
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

    public double phoneStatusChoose(Scanner scanner) {
        double rate = 0;
        String statusChoiceInput;
        do {
            System.out.println("Mời chọn tình trạng điện thoại:\n" +
                    "1. Thân máy, màn hình không bị trầy xước & chức năng hoạt động tốt\n" +
                    "2. Màn hình đẹp, thân máy trầy xước 3 vết và chức năng hoạt động tốt\n" +
                    "3. Trầy xước nặng và có lỗi chức năng máy\n" +
                    "4. Màn hình âm ảnh nhẹ, không dính iCloud, KNOX\n" +
                    "5. Màn hình âm ảnh nặng, máy dính iCloud, KNOX\n" +
                    "Mời bạn chọn");
            statusChoiceInput = scanner.nextLine();
        } while (!isChoiceOfFiveFunctionValid(statusChoiceInput));
        switch (Integer.parseInt(statusChoiceInput)) {
            case 1:
                rate = 0.85;
                break;
            case 2:
                rate = 0.75;
                break;
            case 3:
                rate = 0.65;
                break;
            case 4:
                rate = 0.45;
                break;
            case 5:
                rate = 0.35;
                break;
        }
        return rate;
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
    public boolean isChoiceOfFiveFunctionValid(String choiceInput) {
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
}
