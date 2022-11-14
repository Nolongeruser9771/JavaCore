package LogicHandle;

import Constant.ProductGroupConstant;

import java.util.Scanner;

import static LogicHandle.SalesManagementLogic.*;

public class sortLogic {
    public static void sortMenu() {
        System.out.println("Chọn cách sắp xếp: ");
        System.out.println("1. Theo tên nhân viên");
        System.out.println("2. Theo nhóm mặt hàng");
        int choice;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 2) {
                break;
            }
            System.out.println("Sai cách sắp xếp. Mời nhập lại");
        } while (true);
        switch (choice) {
            case 1:
                showSalesManagementAfterSortByName(sortByName());
                break;
            case 2:
              showSalesManagementAfterSortBProductGroup(sortByProductGroup());
                break;
        }
    }
}
