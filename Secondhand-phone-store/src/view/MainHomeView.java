package view;

import data.ProductData;
import constant.PhoneStatusConstant;
import constant.PhoneTypeConstant;
import entities.Member;
import entities.Order;
import entities.Product;
import entities.idFindable;
import logichandle.BuyLogic;

import javax.swing.text.TabSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class MainHomeView implements idFindable {
    private ArrayList<Product> products;

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
                displayBuyMenu(scanner,prods,members,orders,thisMember);
                break;
            case 2:
                displaySaleMenu(scanner,products);
                break;
            case 3:
                displayExhangeMenu(scanner,products);
                break;
        }
    }

    public void displayBuyMenu(Scanner scanner, ArrayList<Product> products, ArrayList<Member> members, ArrayList<Order> orders, Member thisMember) {
        String choiceInput;
        do {
            System.out.println("Bạn muốn hiển thị sản phẩm theo:\n" +
                    "1. Theo giá        2. Theo loại");
            choiceInput = scanner.nextLine();
        } while (!isChoiceOfPhoneSaleValid(choiceInput));
        BuyLogic buyLogic = new BuyLogic();
        switch (Integer.parseInt(choiceInput)) {
            case 1:
                displayPriceMenu(scanner,products);
                buyLogic.BuyInfo(scanner,products,members,orders,thisMember);
                break;
            case 2:
                String type = phoneTypeChoose(scanner);
                products.forEach(prod -> {
                    if (prod.getProductType().equals(type)) {
                        System.out.println(prod);
                    }
                });
                buyLogic.BuyInfo(scanner,products,members,orders,thisMember);
                break;
        }
    }

    private void displayPriceMenu(Scanner scanner, ArrayList<Product> products) {
        String choiceInput;
        do {
            System.out.println("Bạn muốn sắp xếp sản phẩm theo thứ tự:\n" +
                    "1. Từ thấp tới cao     2. Từ cao tới thấp");
            choiceInput = scanner.nextLine();
        } while (!isChoiceOfPhoneSaleValid(choiceInput));
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
        phoneInfoInput(scanner,products);
        System.out.println("Hiện tại, chúng tôi không hỗ trợ thu mua online.\n" +
                "Nếu bạn đồng ý với gía thu mua trên, xin vui lòng mang điện thoại đến cửa hàng của chúng tôi");
    }
    public void displayExhangeMenu(Scanner scanner,ArrayList<Product> products) {
        System.out.println("Bạn muốn đổi điện thoại?");
        double refPrice = phoneInfoInput(scanner,products);
        System.out.println("Mời chọn hiệu điện thoại muốn đổi");
        String newType = phoneTypeChoose(scanner);
        products.forEach(product -> {if (product.getProductType().equals(newType)) {
            System.out.println(product.getId() + "\t\t\t" + product.getProductName());
        }});
        String idInput;
        do {
            System.out.println("Mời nhập id để chọn dòng điện thoại muốn đổi:");
            idInput = scanner.nextLine();
        }while (findById(idInput,products)==null);
        Product choosedProd = findById(idInput,products);
        double payment = choosedProd.getPrice() - refPrice;
        if (payment>=0) {
            System.out.println("Số tiền bạn cần phải bù thêm là: " + payment);
        } else {
            System.out.println("Bạn được đổi sản phẩm với trị giá 0đ và "+ Math.abs(payment) + " điểm, có thể quy đổi thành tiền cho đơn hàng tới");
        }
    }
    public double phoneInfoInput(Scanner scanner, ArrayList<Product> products) {
        System.out.println("Bạn cần chọn loại và tình trạng điện thoại để biêt giá thu mua hiện tại của chúng tôi");
        String type = phoneTypeChoose(scanner);
        products.forEach(prod -> {
            if (prod.getProductType().equals(type)) {
                System.out.println(prod.getId() + "\t\t\t" + prod.getProductName());
            }});
        String idInput;
        do {
            System.out.println("Nhập loại điện thoại bạn muốn bán bằng cách nhập id tương ứng");
            idInput = scanner.nextLine();
        } while (findById(idInput, products) == null);
        Product product = findById(idInput, products);
        double rate = phoneStatusChoose(scanner);
        System.out.println("Gía chúng tôi thu mua đối với điện thoại này là: " + product.getPrice() * rate);
        return product.getPrice() * rate;
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


    public double phoneStatusChoose(Scanner scanner) {
        String status = null;
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
        } while (!isChoiceOfPhoneTypeAndStatusValid(statusChoiceInput));
        switch (Integer.parseInt(statusChoiceInput)) {
            case 1:
                status = PhoneStatusConstant.TYPE1.value;
                rate = 0.85;
                break;
            case 2:
                status = PhoneStatusConstant.TYPE2.value;
                rate = 0.75;
                break;
            case 3:
                status = PhoneStatusConstant.TYPE3.value;
                rate = 0.65;
                break;
            case 4:
                status = PhoneStatusConstant.TYPE4.value;
                rate = 0.45;
                break;
            case 5:
                status = PhoneStatusConstant.TYPE5.value;
                rate = 0.35;
                break;
        }
        return rate;
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
