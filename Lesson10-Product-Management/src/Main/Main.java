package Main;

import Entity.Product;
import LogicHandle.ProductLogic;

import java.util.ArrayList;
import java.util.Scanner;

import static LogicHandle.ProductLogic.*;
import static LogicHandle.sortLogic.sortByPriceMenu;

public class Main {

    public static ArrayList<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            functionChoice();
        }
    }

    private static void functionChoice() {
        int choice;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice < 1 || choice >6) {
                System.out.println("Không có lựa chọn trên. Mời chọn lại");
            }
            if(Main.products.isEmpty() && choice>=2 && choice <=5) {
                System.out.println("Kho dữ liệu của bạn đang rỗng. Bạn cần thêm dữ liệu trước khi thao tác");
                return;
            }
            break;
        } while (true);

        switch (choice) {
            case 1:
                addProduct();
                showProductInfo();
                break;
            case 2:
                findByName();
                break;
            case 3:
                findById();
                break;
            case 4:
                findByUnderQuantity();
                break;
            case 5:
                sortByPriceMenu();
                break;
            case 6:
                System.exit(0);
        }
    }
    private static void showMenu() {
        System.out.println("---CHƯƠNG TRÌNH QUẢN LÍ SẢN PHẨM---");
        System.out.println("Mời chọn 1 trong các lựa chọn dưới đây: ");
        System.out.println("1. Xem danh sách sản phẩm");
        System.out.println("2. Tìm sản phẩm theo tên");
        System.out.println("3. Tìm sản phẩm theo id");
        System.out.println("4. Tìm các sản phẩm theo số lượng dưới 5");
        System.out.println("5. Tìm sản phẩm theo mức giá");
        System.out.println("6. Thoát");
    }

}
