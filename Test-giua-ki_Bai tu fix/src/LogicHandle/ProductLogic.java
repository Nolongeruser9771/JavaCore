package LogicHandle;

import Entity.Product;
import Entity.Sales;
import MainRun.MainRun;

import java.util.Scanner;

import static MainRun.MainRun.products;
import static MainRun.MainRun.sales;

public class ProductLogic {

    public static void addNewProduct() {
        System.out.println("Thêm bao nhiêu mã hàng: ");
        int productNum = new Scanner(System.in).nextInt();
        for (int i = 0; i < productNum; i++) {
            Product product = new Product();
            product.inputInfo();
            saveProductInfo(product);
            }
        }

    private static void saveProductInfo(Product product) {
        for (int i = 0; i < products.length; i++) {
            if(products[i]==null) {
                products[i]= product;
                break;
            }
        }
    }

    public static void showProductInfo() {
        for (int i = 0; i < products.length; i++) {
            if(products[i]!=null) {
                System.out.println(products[i]);
            }
        }
    }

    public static Product findProductById(int productID) {
         Product product =null;
        for (int i = 0; i < products.length; i++) {
            if (products[i]!=null && products[i].getId() == productID) {
                product = products[i];
            }
        }
        return product;
    }
}