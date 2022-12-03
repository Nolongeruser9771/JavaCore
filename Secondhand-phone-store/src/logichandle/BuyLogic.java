package logichandle;

import entities.*;

import view.UserMainHomeView;

import java.util.ArrayList;
import java.util.Scanner;

public class BuyLogic implements ProductService, MenuService {

    public void BuyInfoInput(Scanner scanner, ArrayList<Product> prods, ArrayList<User> users, ArrayList<Order> orders, User thisUser,ArrayList<Product> sortLists) {
        String idInput, prodNumInput;
        Product choosedProd = null;
        int quantity = 0;
        boolean flag1, flag2;
        //Tìm và check id
        do {
            System.out.println("Bạn muốn mua sản phẩm nào?");
            System.out.println("Mời nhập id sản phẩm");
            idInput = scanner.nextLine();
            if (isValidNumber(idInput) && findById(idInput, sortLists) != null) {
                choosedProd = findById(idInput, sortLists);
                productShow(choosedProd);
                flag1 = true;
            } else {
                System.out.println("Dữ liệu không hợp lệ! Mời nhập lại.");
                flag1 = false;
            }
        } while (!flag1);
        //Check stock
        do {
            System.out.println("Mời chọn số lượng muốn mua:");
            prodNumInput = scanner.nextLine();
            if (isValidNumber(prodNumInput)) {
                quantity = Integer.parseInt(prodNumInput);
                flag2 = stockCheck(choosedProd,quantity);
            } else {
                flag2 = false;
            }
        }while (!flag2);

        String choiceInput;
        do {
            System.out.println("Bạn xác nhận muốn mua sản phẩm này?" + "\n" + choosedProd.getProductName() + "\nSố lượng: " + quantity);
            System.out.println("1. Có. Tôi muốn mua         2. Không, tôi muốn chọn lại sản phẩm");
            choiceInput=scanner.nextLine();
        }while (!isChoiceOfTwoFunctionValid(choiceInput));

        switch (Integer.parseInt(choiceInput)) {
            case 1:
                System.out.println("Thông tin đơn hàng:");
                Order order = new Order(thisUser,choosedProd,quantity);
                orderShow(order);
                //Check điểm thưởng
                if (thisUser.getRewardPoint()>0) {
                    int usedPoint = rewardPointUse(scanner,thisUser);
                    order.setRewardPoint(usedPoint);
                    order.setTotal(order.getTotal() - usedPoint);
                    thisUser.setRewardPoint(thisUser.getRewardPoint() - usedPoint + (int) (order.getTotal() * 0.01));
                    orderShow(order);
                } else {
                    thisUser.setRewardPoint((int)(order.getTotal()*0.01));
                }
                orders.add(order);
                thisUser.getOrders().add(order);
                System.out.println("Đặt hàng thành công!");
                break;
            case 2:
                //Quay về HomeView
                UserMainHomeView mainHomeView = new UserMainHomeView();
                mainHomeView.displayBuyMenu(scanner,prods,users,orders, thisUser);
                break;
        }
    }

    private int rewardPointUse(Scanner scanner, User thisUser) {
        boolean flag = true;
        String usedPointInput;
        do {
            do {
                System.out.println("Bạn đang có " + thisUser.getRewardPoint() + ". Bạn muốn sử dụng bao nhiêu điểm cho đơn hàng này");
                usedPointInput = scanner.nextLine();
            } while (!isValidNumber(usedPointInput));

            if (Integer.parseInt(usedPointInput) > thisUser.getRewardPoint()) {
                System.out.println("Số lượng điểm không hợp lệ!");
                flag = false;
            }
        }while (!flag);
        return Integer.parseInt(usedPointInput);
    }
    private void productShow(Product choosedProd) {
        System.out.println("==============================================================================");
        System.out.println("ID\t\t\tPRODUCT-NAME\t\tDESCRIPTION\t\tPRICE\t\tSTATUS");
        System.out.println("==============================================================================");
        System.out.println(choosedProd.getId()+"\t\t\t"+choosedProd.getProductName()+"\t\t\t"+choosedProd.getDescription()+"\t\t\t"+choosedProd.getPrice()+"\t\t\t"+choosedProd.getStockStatus());
    }

    private void orderShow(Order order) {
        System.out.println("======================================================================================================================");
        System.out.println("ORDER-ID\tORDER-DATE\t\tCUSTOMER-NAME\t\tPRODUCT-NAME\tQUANTITY\t\tPRICE\t\tREWARD-POINT\t\t\tTOTAL\t\t\tADDRESS");
        System.out.println("======================================================================================================================");
        System.out.println(order);
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
            return Integer.parseInt(numberInput) > 0;
        } catch (Exception e) {
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
            return choosedProd;
        }
    }

    @Override
    public boolean isChoiceOfFiveFunctionValid(String choiceInput) {
        return false;
    }

    @Override
    public boolean isChoiceOfThreeFunctionValid(String choiceInput) {
        return false;
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
