package logichandle;

import entities.Member;
import entities.Order;
import entities.Product;

import view.MainHomeView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class BuyLogic {
    public void BuyInfo(Scanner scanner, ArrayList<Product> products, ArrayList<Member> members, ArrayList<Order> orders) {
        System.out.println("Bạn muốn mua sản phẩm nào?");
        String idInput, prodNumInput;
        do {
            System.out.println("Mời nhập id sản phẩm");
            idInput = scanner.nextLine();
            System.out.println("Mời chọn số lượng muốn mua:");
            prodNumInput = scanner.nextLine();
        } while (!isValidNumber(idInput) && !isValidNumber(prodNumInput) && findProductById(idInput,products)==null);
        Product choosedProd = findProductById(idInput,products);
        int quantity = Integer.parseInt(prodNumInput);
        System.out.println("Bạn xác nhận muốn mua sản phẩm này?" + "\n" + choosedProd.getProductName() + "\nSố lượng: " + quantity);
        System.out.println("1. Có. Tôi muốn mua         2. Không, tôi muốn chọn lại sản phẩm");
        //check
        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                System.out.println("Thông tin đơn hàng:");
                Order order = new Order(LocalDate.now(),choosedProd,quantity);
                orders.add(order);
                System.out.println(order + "\nĐặt hàng thành công");
                break;
            case 2:
                MainHomeView mainHomeView = new MainHomeView();
                mainHomeView.displayBuyMenu(scanner,products);
                break;
        }
    }

    private Product findProductById (String id, ArrayList<Product> products) {
        Product choosedProd = null;
        for (Product prod : products) {
            if (prod.getId() == Integer.parseInt(id)) {
                choosedProd = prod;
                break;
            }
        }
        return choosedProd;
    }

    private boolean isValidNumber(String numberInput) {
        try {
            if (Integer.parseInt(numberInput)>0) {
                return true;
            }
            System.out.println("Định dạng không hợp lệ!");
            return false;
        } catch (Exception e) {
            System.out.println("Định dạng không hợp lệ!");
            return false;
        }
    }
}
