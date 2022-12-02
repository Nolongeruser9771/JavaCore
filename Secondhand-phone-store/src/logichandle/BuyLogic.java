package logichandle;

import entities.*;

import view.UserMainHomeView;

import java.util.ArrayList;
import java.util.Scanner;

public class BuyLogic implements ProductService {

    public void BuyInfo(Scanner scanner, ArrayList<Product> prods, ArrayList<User> users, ArrayList<Order> orders, User thisUser) {
        String idInput, prodNumInput;
        Product choosedProd;
        int quantity;
        do {
            System.out.println("Bạn muốn mua sản phẩm nào?");
            do {
                System.out.println("Mời nhập id sản phẩm");
                idInput = scanner.nextLine();
                System.out.println("Mời chọn số lượng muốn mua:");
                prodNumInput = scanner.nextLine();
            } while (!isValidNumber(idInput) && !isValidNumber(prodNumInput) && findById(idInput, prods) == null);
            choosedProd = findById(idInput, prods);
            quantity = Integer.parseInt(prodNumInput);
        } while (!stockCheck(choosedProd,quantity));
        System.out.println("Bạn xác nhận muốn mua sản phẩm này?" + "\n" + choosedProd.getProductName() + "\nSố lượng: " + quantity);
        System.out.println("1. Có. Tôi muốn mua         2. Không, tôi muốn chọn lại sản phẩm");
        //check
        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                System.out.println("Thông tin đơn hàng:");
                Order order = new Order(thisUser,choosedProd,quantity);
                //show đơn hàng
                String usedPointInput;
                boolean flag = true;
                if (thisUser.getRewardPoint()>0) {
                    do {
                        System.out.println("Bạn đang có " + thisUser.getRewardPoint() + ". Bạn muốn sử dụng bao nhiêu điểm cho đơn hàng này");
                        usedPointInput = scanner.nextLine();
                    }while (!isValidNumber(usedPointInput));
                    int usedPoint = Integer.parseInt(usedPointInput);
                    if (usedPoint>thisUser.getRewardPoint()) {
                        System.out.println("Số lượng điểm không hợp lệ!");
                        flag = false;
                        //lặp lại
                    } else {
                        order.setRewardPoint(usedPoint);
                        order.setTotal(order.getTotal()-usedPoint);
                        thisUser.setRewardPoint(thisUser.getRewardPoint()-usedPoint+(int)(order.getTotal()*0.01));
                    }
                } else {
                    thisUser.setRewardPoint((int)(order.getTotal()*0.01));
                }
                //show đơn hàng
                orders.add(order);
                System.out.println(order + "\nĐặt hàng thành công!");
                break;
            case 2:
                UserMainHomeView mainHomeView = new UserMainHomeView();
                mainHomeView.displayBuyMenu(scanner,prods,users,orders, thisUser);
                break;
                //chưa ổn
        }
    }
    private boolean stockCheck(Product choosedProd, int quantity) {
        if (choosedProd.getStock()>quantity) {
            return true;
        }
        System.out.println("Số lượng tồn kho không đủ! Xin xem lại số lượng hoặc chọn dòng điện thoại khác");
        return false;
    }
    private boolean isValidNumber(String numberInput) {
        try {
            if (Integer.parseInt(numberInput)>0) {
                return true;
            }
            System.out.println("Dữ liệu không hợp lệ!");
            return false;
        } catch (Exception e) {
            System.out.println("Dữ liệu không hợp lệ!");
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
