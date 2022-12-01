package view;

import Data.ProductData;
import constant.PhoneStatusConstant;
import constant.PhoneTypeConstant;
import entities.Member;
import entities.Order;
import entities.Product;
import logichandle.BuyLogic;

import java.util.ArrayList;
import java.util.Scanner;

public class MainHomeView {
    public void displayHomeMenu(Scanner scanner, ArrayList<Product> products, ArrayList<Member> members, Member thisMember, ArrayList<Order> orders) {
        String choiceInput;
        do {
            System.out.println("Chào mừng bạn đến cửa hàng NGUYÊN SECOND-SMART\n" +
                "Bạn muốn làm gì?\n" +
                "1. Mua điện thoại      2. Bán điện thoại       3. Đổi cũ lấy mới\n" +
                "Mời bạn chọn");
            choiceInput = scanner.nextLine();
        } while (!isChoiceOfFunctionValid(choiceInput));
        switch (Integer.parseInt(choiceInput)) {
            case 1:
                ProductData productData = new ProductData();
                ArrayList<Product> prods = productData.productData(products);
                displayBuyMenu(scanner, prods);
                BuyLogic buyLogic = new BuyLogic();
                buyLogic.BuyInfo(scanner,prods,members,orders);
                break;
            case 2:
                displaySaleMenu(scanner);
                break;
            case 3:
                displayExhangeMenu(scanner);
                break;
        }
    }

    public void displayBuyMenu(Scanner scanner, ArrayList<Product> products) {
        String choiceInput;
        do {
            System.out.println("Bạn muốn hiển thị sản phẩm theo:\n" +
                    "1. Theo giá        2. Theo loại");
            choiceInput = scanner.nextLine();
        } while (!isChoiceOfPhoneSaleValid(choiceInput));
        switch (Integer.parseInt(choiceInput)) {
            case 1:
                displayPriceMenu(scanner);
                break;
            case 2:
                String type = phoneTypeChoose(scanner);
                System.out.println(type);
                for (Product prod : products) {
                    if (prod.getProductType().equals(type)) {
                        System.out.println(prod);
                    }
                }
                break;
        }
    }

    private void displayPriceMenu(Scanner scanner) {
        String choiceInput;
        do {
            System.out.println("Bạn muốn sắp xếp sản phẩm theo thứ tự:\n" +
                    "1. Từ thấp tới cao     2. Từ cao tới thấp");
            choiceInput = scanner.nextLine();
        } while (!isChoiceOfPhoneSaleValid(choiceInput));
        switch (Integer.parseInt(choiceInput)) {
            case 1:

                break;
            case 2:
                //Hiển thị giá từ cao tới thấp
                break;
        }
    }
    private void displaySaleMenu(Scanner scanner) {
        System.out.println("Bạn muốn bán điện thoại?\n" +
                "Bạn cần chọn loại và tình trạng điện thoại để biêt giá thu mua hiện tại của chúng tôi");
        phoneTypeChoose(scanner);
        phoneStatusChoose(scanner);
        //Cần bổ sung thêm menu các dòng điện thoại
    }
    public void displayExhangeMenu(Scanner scanner) {
        System.out.println("Bạn muốn đổi điện thoại?\n" +
                "Bạn cần cung cấp các thông tin bên dưới để biết giá tham khảo của sản phẩm muốn mua\n" +
                "Mời nhập thông tin về điện thoại");
        phoneTypeChoose(scanner);
        phoneStatusChoose(scanner);
        System.out.println();
    }

    public String phoneTypeChoose(Scanner scanner) {
        String type = null;
        String typeChoiceInput;
        do {
            System.out.println("Mời chọn loại điện thoại:\n" +
                    "1. Apple   2. SamSung  3.Oppo\n" +
                    "Mời bạn chọn");
            typeChoiceInput = scanner.nextLine();
        } while (!isChoiceOfFunctionValid(typeChoiceInput));
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


    public String phoneStatusChoose(Scanner scanner) {
        String status = null;
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
        } while (!isChoiceOfPhoneTypeAndStatusValid(statusChoiceInput));
        switch (Integer.parseInt(statusChoiceInput)) {
            case 1:
                status = PhoneStatusConstant.TYPE1.value;
                break;
            case 2:
                status = PhoneStatusConstant.TYPE2.value;
                break;
            case 3:
                status = PhoneStatusConstant.TYPE3.value;
                break;
            case 4:
                status = PhoneStatusConstant.TYPE4.value;
                break;
            case 5:
                status = PhoneStatusConstant.TYPE5.value;
                break;
        }
        return status;
    }

    private boolean isChoiceOfFunctionValid(String choiceInput) {
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

    private boolean isChoiceOfPhoneTypeAndStatusValid(String choiceInput) {
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

    private boolean isChoiceOfPhoneSaleValid(String choiceInput) {
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
