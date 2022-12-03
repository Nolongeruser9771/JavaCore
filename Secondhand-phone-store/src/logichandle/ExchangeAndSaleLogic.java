package logichandle;

import constant.PhoneTypeConstant;
import entities.*;
import view.UserMainHomeView;

import java.util.ArrayList;
import java.util.Scanner;

public class ExchangeAndSaleLogic implements MenuService, ProductService {
    UserMainHomeView userMainHomeView = new UserMainHomeView();
    public void saleInfoInput(Scanner scanner,ArrayList<Product> products) {
        System.out.println("Bạn muốn bán điện thoại?");
        Product choosedProduct = choosePhone(scanner, products);
        double rate =phoneStatusChoose(scanner);

        System.out.println("Giá thu mua của chúng tôi cho sản phẩm này là: " + choosedProduct.getPrice()*rate);
        System.out.println("Hiện tại, chúng tôi không hỗ trợ thu mua online.\n" +
                "Nếu bạn đồng ý với gía thu mua trên, xin vui lòng mang điện thoại đến cửa hàng của chúng tôi");
    }
    public void exchangeInfoInput(Scanner scanner,ArrayList<Product> products, User thisUser, ArrayList<PreOrder> exchangePreOrders) {
        System.out.println("Bạn muốn đổi điện thoại?");
        Product oldPro = choosePhone(scanner, products);
        int purchasePrice = (int)(oldPro.getPrice() * phoneStatusChoose(scanner));
        Product newPro;
        boolean flag = true;
        do {
            System.out.println("Chọn hiệu điện thoại bạn muốn đổi");
            newPro = choosePhone(scanner, products);
            if (newPro.getStock()==0) {
                System.out.println("Sản phẩm này đã hết hàng! Vui lòng chọn loại điện thoại khác");
                flag = false;
            }
        } while (!flag);
        //Check xem stock còn không
        int payment = newPro.getPrice() - purchasePrice;
        int rewardPoint = Math.abs(payment);
        int total;
        String note;
        System.out.println("Giá thu mua của sản phẩm là: "+ purchasePrice);
        if (payment>=0) {
            System.out.println("Bạn có thể đổi điện thoại "+ newPro.getProductName() + ", số tiền cần bù vào là:" + payment + "VNĐ");
            total = payment;
            note = "--";
        } else {
            System.out.println("Bạn có thể đổi miễn phí điện thoại " + newPro.getProductName()+", và được tặng thêm "+ rewardPoint +
                    " điểm trong tài khoản, có thể sử dụng cho các đơn hàng tiếp theo");
            total=0;
            note=String.valueOf(payment);
        }
        String choiceInput;
        do {
            System.out.println("Bạn có muốn pre-order để chúng tôi giữ sản phẩm lại cho bạn không?\n" +
                    "1. Có. Tôi muốn            2. Không. Tôi cần xem xét lại");
            choiceInput = scanner.nextLine();
        } while (!isChoiceOfTwoFunctionValid(choiceInput));
        switch (Integer.parseInt(choiceInput)) {
            case 1:
                PreOrder preOrder = new PreOrder(thisUser,oldPro,newPro,1,note);
                preOrder.setTotal(total);
                preOrderShow(preOrder);

                exchangePreOrders.add(preOrder);
                newPro.setStock(newPro.getStock()-1);
                //chỉ đặt đơn hàng để giữ sp, stock tạm thời trừ đi 1, điểm reward chưa được cộng
                System.out.println("Bạn đã pre-order để thu cũ đổi mới thành công!");
                System.out.println("Chúng tôi sẽ liên lạc lại qua điên thoại với bạn sau!");
                break;
            case 2:
                break;
        }
    }
    private void preOrderShow(PreOrder preOrder) {
        System.out.println("======================================================================================================================");
        System.out.println("PREORDER-ID\tPREORDER-DATE\tCUSTOMER-NAME\tOLD-PRODUCT\t\tNEW-PRODUCT\t\tQUANTITY\tPRICE\t\tTOTAL\t\tNOTE");
        System.out.println("======================================================================================================================");
        System.out.println(preOrder);
    }
    private Product choosePhone(Scanner scanner, ArrayList<Product> products) {
        System.out.println("Bạn cần chọn loại và tình trạng điện thoại để biêt giá thu mua hiện tại của chúng tôi");
        String type = userMainHomeView.phoneTypeChoose(scanner);
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
                rate = 0.75;
                break;
            case 2:
                rate = 0.65;
                break;
            case 3:
                rate = 0.55;
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
