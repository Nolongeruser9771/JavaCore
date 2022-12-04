package logichandle;

import entities.Product;
import view.UserMainHomeView;

import java.util.Scanner;

public class ProductLogic {
    UserMainHomeView userMainHomeView = new UserMainHomeView();
    public Product productInputInfo(Scanner scanner) {
        String proName, proType, proDescrip, proPriceInput, proStockInput;
            System.out.println("Mời nhập tên sản phẩm");
            proName = scanner.nextLine();
            //Chọn loại điện thoại
            proType = userMainHomeView.phoneTypeChoose(scanner);
            System.out.println("Mời nhập mô tả sản phẩm");
            proDescrip = scanner.nextLine();
        do {
            System.out.println("Mời nhập giá sản phẩm");
            proPriceInput = scanner.nextLine();
        } while (!isNumberValid(proPriceInput));
        int proPrice = Integer.parseInt(proPriceInput);

        do{
            System.out.println("Mời nhập số lượng tồn kho sản phẩm");
            proStockInput = scanner.nextLine();
        } while (!isNumberValid(proStockInput));
        int proStock = Integer.parseInt(proStockInput);

        return new Product(proName,proType,proDescrip,proPrice,proStock);
    }

    private boolean isNumberValid(String number) {
        try {
            if (Integer.parseInt(number)>=0) {
                return true;
            }
            System.out.println("Giá và số lượng không được bé hơn 0");
            return false;
        }catch (Exception e) {
            System.out.println("Dữ liệu không hợp lệ!");
            return false;
        }
    }
}
