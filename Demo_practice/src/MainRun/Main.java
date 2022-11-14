package MainRun;

import Entity.Driver;
import Entity.Route;
import Entity.RouteManagement;

import java.util.Scanner;

import static LogicHandle.DriverLogic.addNewDriver;
import static LogicHandle.DriverLogic.showDriverInfo;
import static LogicHandle.RouteLogic.addNewRoute;
import static LogicHandle.RouteLogic.showRouteInfo;
import static LogicHandle.RouteManagementLogic.*;
import static LogicHandle.sortLogic.sortMenu;

public class Main {

    public static Driver[] drivers = new Driver[1000];
    public static Route[] routes = new Route[1000];
    public static RouteManagement[] routeManagements = new RouteManagement[1000];

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
            if(choice<=6 && choice>=1) {
                break;
            }
            System.out.println("Sai loại. Mời nhập lại");
        } while (true);
        switch (choice) {
            case 1:
                addNewDriver();
                showDriverInfo();
                break;
            case 2:
                addNewRoute();
                showRouteInfo();
                break;
            case 3:
                addNewRouteManagement();
                showRouteManagement();
                break;
            case 4:
                sortMenu();
                break;
            case 5:
                routeDistanceCal();
                break;
            case 6:
                System.exit(0);
                break;
        }
    }

    private static void showMenu() {
        System.out.println("---CHƯƠNG TRÌNH QUẢN LÍ XE BUÝT---");
        System.out.println("1. Nhập và in DS lái xe");
        System.out.println("2. Nhập và in DS tuyến");
        System.out.println("3. Phân công lái xe và in DS ra màn hình");
        System.out.println("4. Sắp xếp DS phân công");
        System.out.println("5. Lập bảng kê tng khoảng cách chạy");
        System.out.println("6. Thoát chương trình");
        System.out.println("Mời chọn chức năng");
    }
}