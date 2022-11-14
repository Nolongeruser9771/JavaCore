package LogicHandle;

import Entity.Driver;
import Entity.RouteManagement;

import java.util.Scanner;

import static LogicHandle.RouteManagementLogic.*;
import static MainRun.Main.drivers;
import static MainRun.Main.routeManagements;

public class sortLogic {
    public static void sortMenu() {
        System.out.println("Mời chọn loại sắp xếp: ");
        System.out.println("1. Sắp xếp theo hộ tên");
        System.out.println("2. Sắp xếp theo số lượng tuyến đảm nhận");
        int choice;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice <= 2 && choice >= 1) {
                break;
            }
            System.out.println("Sai loại. Mời nhập lại");
        } while (true);
        switch (choice) {
            case 1:
                showRouteManagementAfterSortByName(sortByName());
                break;
            case 2:
                showRouteManagementAfterSortByQuantity(sortByRouteQuantity());
                break;
        }
    }

}
