package MainRun;

import Constant.ProductGroupConstant;
import Entity.Product;
import Entity.Sales;
import Entity.SalesManagement;

import java.util.Scanner;

import static LogicHandle.ProductLogic.addNewProduct;
import static LogicHandle.ProductLogic.showProductInfo;
import static LogicHandle.SalesLogic.addNewSales;
import static LogicHandle.SalesLogic.showSalesInfo;
import static LogicHandle.SalesManagementLogic.*;
import static LogicHandle.sortLogic.sortMenu;

public class MainRun {

    public static Sales[] sales = new Sales[100];
    public static Product[] products = new Product[100];

    public static SalesManagement[] salesManagements = new SalesManagement[100];

    public static void main(String[] args) {
        while(true) {
            showMenu();
            functionChoice();
        }
    }

    private static void functionChoice() {
        int choice;
        do {
            choice = new Scanner(System.in).nextInt();
            if(choice>=1 && choice<=6) {
                break;
            }
            System.out.println("Sai lựa chọn. Mời nhập lại");
        } while (true);
        switch (choice) {
            case 1:
                addNewProduct();
                showProductInfo();
                break;
            case 2:
                addNewSales();
                showSalesInfo();
                break;
            case 3:
                addNewSalesManagement();
                showSalesManagementInfo();
                break;
            case 4:
                sortMenu();
                break;
            case 5:
                earningCount();
                break;
            case 6:
                System.exit(0);
        }
    }

    private static void showMenu() {
        System.out.println("---CHƯƠNG TRÌNH QUẢN LÍ NHÂN VIÊN BÁN HÀNG---");
        System.out.println("1. Nhập mặt hàng và in ra DS");
        System.out.println("2. Nhập nhân viên và in ra DS");
        System.out.println("3. Lập bàng DS bán hàng");
        System.out.println("4. Sắp xếp DS bán hàng");
        System.out.println("5. Lập bảng kê doanh thu");
        System.out.println("6. Exit");
    }
}