package LogicHandle;

import Entity.Sales;

import java.util.Scanner;

import static MainRun.MainRun.products;
import static MainRun.MainRun.sales;

public class SalesLogic {

    public static void addNewSales() {
        System.out.println("Thêm bao nhiêu nhân viên: ");
        int salesNum = new Scanner(System.in).nextInt();
        for (int i = 0; i < salesNum; i++) {
            Sales sale = new Sales();
            sale.inputInfo();
            saveSalesInfo(sale);
        }
    }

    private static void saveSalesInfo(Sales sale) {
        for (int i = 0; i < sales.length; i++) {
            if(sales[i]==null) {
                sales[i]= sale;
                break;
            }
        }
    }

    public static void showSalesInfo() {
        for (int i = 0; i <sales.length; i++) {
            if(sales[i]!=null) {
                System.out.println(sales[i]);
            }
        }
    }

    public static Sales findSalesById(int salesID) {
        Sales sale =null;
        for (int i = 0; i < sales.length; i++) {
            if (sales[i]!=null && sales[i].getId() == salesID) {
                sale = sales[i];
            }
        }
        return sale;
    }
}
