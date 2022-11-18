package LogicHandle;

import Entity.Product;
import Main.Main;

import java.util.Scanner;

import static LogicHandle.sortLogicById.sortByIdMenu;

public class ProductLogic {
    public static void addProduct() {
        System.out.println("Thêm bao nhiêu sản phẩm");
        int productNum;
        do {
            productNum = new Scanner(System.in).nextInt();
            if (productNum > 0) {
                break;
            }
            System.out.println("Số luợng sản phẩm không được là số âm");
        } while (true);

        for (int i = 0; i < productNum; i++) {
            Product product = new Product();
            product.inputInfo();
            Main.products.add(product);
        }
    };

    public static void showProductInfo() {
        for (Product product: Main.products) {
            System.out.println(product);
        }
    }

    public static void findByName() {
        System.out.println("Mời nhập tên sản phẩm cần tìm");
        String productName = new Scanner(System.in).nextLine();
        Product prod = null;
        for (int i = 0; i < Main.products.size(); i++) {
            if ((Main.products.get(i).getName().equals(productName))) {
                prod = Main.products.get(i);
                System.out.println(prod);
                break;
            }
        }
        if (prod==null) {
            System.out.println("Không có sản phẩm tên " + productName);
        }
    }

    public static void findById() {
        System.out.println("Mời nhập id cần tìm");
        int productId = new Scanner(System.in).nextInt();
        Product prod = null;
        for (int i = 0; i < Main.products.size(); i++) {
            if (Main.products.get(i).getId() == productId) {
                prod = Main.products.get(i);
                System.out.println(prod);
                sortByIdMenu(i);
                break;
            }
        }
        if (prod==null) {
            System.out.println("Không có sản phẩm id " + productId);
        }
    }

    public static void findByUnderQuantity() {
        Product prod = null;
        for (Product product: Main.products) {
            if(product.getQuantity() < 5) {
                prod = product;
                System.out.println(prod);
            }
        }
        if(prod==null) {
            System.out.println("Không có sản phẩm nào có số lượng dưới 5");
        }
    }

    public static void findUnder50() {
        Product prod = null;
        for (int i = 0; i < Main.products.size(); i++) {
            if(Main.products.get(i).getPrice() < 50000) {
                prod = Main.products.get(i);
                System.out.println(prod);
            }
        }
        if(prod==null) {
            System.out.println("Không có sản phẩm có giá dưới 50.000 VNĐ");
        }
    }

    public static void findFrom50To100() {
        Product prod = null;
        for (int i = 0; i < Main.products.size(); i++) {
            if(Main.products.get(i).getPrice() >= 50000 && Main.products.get(i).getPrice() < 100000) {
                prod = Main.products.get(i);
                System.out.println(prod);
            }
        }
        if(prod==null) {
            System.out.println("Không có sản phẩm có giá từ 50.000VNĐ đến dưới 100.000VND");
        }

    }

    public static void findOver100() {
        Product prod = null;
        for (int i = 0; i < Main.products.size(); i++) {
            if(Main.products.get(i).getPrice() >= 100000) {
                prod = Main.products.get(i);
                System.out.println(prod);
            }
        }
        if(prod==null) {
            System.out.println("Không có sản phẩm có giá trên 100.000 VNĐ");
        }
    }
}
