import Entity.Driver;
import Entity.Route;
import Service.RouteManagement;
import Service.RouteManagementDetail;

import java.util.Scanner;

public class MainRun {
    public static Driver[] drivers = new Driver[100];
    public static Route[] routes = new Route[100];
    public static RouteManagement[] routeManagements = new RouteManagement[1000];

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int functionChoice = functionChoice();
            logicHandle(functionChoice);
        }
    }

    public static void logicHandle(int choice) {
        switch (choice) {
            case 1:
                addNewDriver();
                break;
            case 2:
                printDriverList();
                break;
            case 3:
                addNewRoute();
                break;
            case 4:
                printRouteList();
                break;
            case 5:
                RouteManagement(drivers, routes);
                break;
            case 6:
                break;
            case 7:

                break;
            case 8:
                System.exit(0);
        }
    }

    private static void RouteManagement(Driver[] drivers, Route[] routes) {
        if (isNullOfEmpty(drivers, routes)) {
            //Phân công tài xế
            System.out.println("Nhập số tài xế muốn phân công");
            int driverNum = new Scanner(System.in).nextInt();
            Driver driver = null;
            for (int i = 0; i < driverNum; i++) {
                System.out.println("Phân công tài xế thứ " + (i + 1));
                System.out.println("Nhập mã tài xế muốn phân công: ");
                int driverID = new Scanner(System.in).nextInt();
                driver = null;
                do {
                    for (int j = 0; j < drivers.length; j++) {
                        if (drivers[j].getId() == driverID) {
                            driver = drivers[i];
                            break;
                        }
                    }
                    if (driver != null) {
                        break;
                    }
                    System.out.println("Không tìm thấy tài xế ID " + driverID + ". Vui lòng nhập lại");
                } while (true);

            //Phân công tuyến
            System.out.println("Nhập số tuyến muốn phân công cho tài xế này");
            int routeNum = new Scanner(System.in).nextInt();
            RouteManagementDetail[] routeDetail = new RouteManagementDetail[routeNum];
            int routeCount = 0;
            int count = 0;
            for (int k = 0; k < routeNum; k++) {
            System.out.println("Nhập thông tin tuyến thứ " + (k + 1));
            System.out.println("Nhập ID tuyến: ");
            int routeID = new Scanner(System.in).nextInt();
            Route route = null;
                do {
                    for (int j = 0; j < routes.length; j++) {
                        if (routes[j].getId() == routeID) {
                            route = routes[i];
                            break;
                        }
                    }
                    if (route != null) {
                        break;
                    }
                    System.out.println("Không tìm thấy tài xế ID " + routeID + ". Vui lòng nhập lại");
                } while (true);

                System.out.println("Bạn muốn phân công bao nhiêu chuyến này?");
                int routeQuantity = new Scanner(System.in).nextInt();
                routeDetail[count] = new RouteManagementDetail(route, routeQuantity);
                routeCount += route.getRouteQuantity * routeNum;
                if (routeCount > 15) {
                    System.out.println("Số lượt chuyến vượt quá 15. Không thể nhận chuyến thêm");
                    break;
                }
                count++;
            }
            RouteManagement routeManagement = new RouteManagement(driver, routeDetail);
            saveRouteInfo(routeManagement);
            }
            showRoutManagementInfo();
        }
    }

    private static boolean isNullOfEmpty(Driver[] drivers, Route[] routes) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < drivers.length; i++) {
            if (drivers[i] != null) {
                count1++;
            }
        }
        for (int i = 0; i < routes.length; i++) {
            if (routes[i] != null) {
                count2++;
            }
        }
        if (count1 == 0 || count2 == 0) {
            System.out.println("Bạn cần có dữ liệu để phân công");
        }
        return count1!=0&&count2!=0;
    }


    private static void showRoutManagementInfo() {
        for (int i = 0; i < routeManagements.length; i++) {
            if(routeManagements[i]!=null) {
                System.out.println(routeManagements[i]);
            }
        }
    }

    private static void saveRouteInfo(RouteManagement routeManagement) {
        for (int i = 0; i < routeManagements.length; i++) {
            if (routeManagements[i]==null) {
                routeManagements[i]=routeManagement;
                break;
            }
        }
    }

    private static void printRouteList() {
        for (int i = 0; i < routes.length; i++) {
            if (routes[i]!=null) {
                System.out.println(routes[i]);
            }
        }
    }

    private static void addNewRoute() {
        System.out.println("Nhập số lượng tuyến đường muốn thêm: ");
        int routeNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < routeNumber; i++) {
            Route route = new Route();
            route.inputInfo();
            saveRoute(route);
        }
    }

    private static void saveRoute(Route route) {
        for (int i = 0; i < routes.length; i++) {
            if (routes[i]==null) {
                routes[i]=route;
                break;
            }
        }
    }

    private static void printDriverList() {
        for (int i = 0; i < drivers.length; i++) {
            if(drivers[i]!=null) {
                System.out.println(drivers[i]);
            }
        }
    }

    private static void addNewDriver() {
        System.out.println("Nhập số lượng tài xế muốn thêm: ");
        int driverNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < driverNumber; i++) {
            Driver driver = new Driver();
            driver.inputInfo();
            saveDriver(driver);
        }
    }

    private static void saveDriver(Driver driver) {
        for (int i = 0; i < drivers.length; i++) {
            if(drivers[i]==null) {
                drivers[i] = driver;
                break;
            }
        }
    }

    private static void showMenu() {
        System.out.println("----BUS DRIVER MANAGEMENT SYSTEM----");
        System.out.println("Vui lòng chọn 1 trong các chức năng sau: ");
        System.out.println("1. Nhập tài xế mới");
        System.out.println("2. In DS tài xế");
        System.out.println("3. Nhập tuyến mới");
        System.out.println("4. In DS tuyến mới");
        System.out.println("5. Lập DS phân công");
        System.out.println("6. Sắp xếp DS phân công");
        System.out.println("7. Bảng kê tổng khoảng cách lái xe trong ngày");
        System.out.println("8. Thoát");
    }

    private static int functionChoice() {
        int choice;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 8) {
                break;
            }
            System.out.println("Chọn sai. Mời chọn lại");
        } while (true);
        return choice;
    }
}