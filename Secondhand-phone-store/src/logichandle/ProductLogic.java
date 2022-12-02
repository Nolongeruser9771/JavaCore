package logichandle;

import entities.Product;
import view.UserMainHomeView;

import java.util.Scanner;

public class ProductLogic {
    UserMainHomeView userMainHomeView = new UserMainHomeView();
    public Product productInputInfo(Scanner scanner) {
        String proName, proType, proDescrip, proPriceInput, proStockInput;
        do {
            System.out.println("Mời nhập tên sản phẩm");
            proName = scanner.nextLine();
            System.out.println("Mời nhập loại sản phẩm");
            proType = userMainHomeView.phoneTypeChoose(scanner);
            System.out.println("Mời nhập mô tả sản phẩm");
            proDescrip = scanner.nextLine();
            System.out.println("Mời nhập giá sản phẩm");
            proPriceInput = scanner.nextLine();
            System.out.println("Mời nhập số lượng tồn kho sản phẩm");
            proStockInput = scanner.nextLine();
        } while (!isNumberValid(proPriceInput) && !isNumberValid(proStockInput));
        int proStock = Integer.parseInt(proStockInput);
        int proPrice = Integer.parseInt(proPriceInput);
        return new Product(proName,proType,proDescrip,proPrice,proStock);
    }

    private boolean isNumberValid(String number) {
        try {
            if (Integer.parseInt(number)>=0) {
                return true;
            }
            System.out.println("Giá hoặc số lượng không được bé hơn 0");
            return false;
        }catch (Exception e) {
            System.out.println("Dữ liệu không hợp lệ!");
            return false;
        }
    }
}
