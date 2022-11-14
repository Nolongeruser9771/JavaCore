package LogicHandle;

import Entity.Driver;
import Entity.Route;
import Entity.RouteDetails;
import Entity.RouteManagement;

import java.util.Scanner;

import static MainRun.Main.*;

public class RouteManagementLogic {
    public static void addNewRouteManagement() {
            if(!isOfNull()) {
                System.out.println("Bạn cần có dữ liệu để phân công");
                return;
            }
            System.out.println("Muốn phân công cho bao nhiêu tài xế:");
            int driverNum = new Scanner(System.in).nextInt();
            for (int i = 0; i < driverNum; i++) {
                System.out.println("Phân công cho tài xế thứ " + (i + 1));
                System.out.println("Nhập id tài xế thứ " + (i + 1));
                int driverID;
                Driver driver;
                do {
                    driverID = new Scanner(System.in).nextInt();
                    driver = DriverLogic.findDriverById(driverID);
                    if (driver != null) {
                        break;
                    }
                    System.out.println("Không có tài xế ID" + driverID);
                } while (true);
                System.out.println("Muốn phân công bao nhiêu loại tuyến cho tài xế này");
                int routeTypeNum = new Scanner(System.in).nextInt();
                RouteDetails[] routeDetails = new RouteDetails[routeTypeNum];
                int count = 0;
                int totalRoute=0;
                Route route;
                for (int j = 0; j < routeTypeNum; j++) {
                    System.out.println("Nhập id loại tuyến thứ " + (j + 1));
                    int routeID;
                    do {
                        routeID = new Scanner(System.in).nextInt();
                        route = RouteLogic.findRouteById(routeID);
                        if (route == null) {
                            System.out.println("Không có loại tuyến id " + routeID);
                            continue;
                        }
                        if (!isOfIdAvailable(routeDetails, routeID)) {
                            break;
                        }
                        System.out.println("Id đã tồn tại. mời nhập lại");
                    } while (true);
                    System.out.println("Muốn phân công mấy chuyến tuyến này");
                    int routeQuantity;
                    do {
                        routeQuantity = new Scanner(System.in).nextInt();
                        if (isRouteQuantityOver(totalRoute, routeQuantity)) {
                            break;
                        }
                        System.out.println("Nếu nhận thêm " + routeQuantity + " chuyến, số chuyến s vướt quá 15");
                    } while (true);
                    routeDetails[count] = new RouteDetails(route, routeQuantity);
                    totalRoute += routeQuantity;
                    count++;
                }
                RouteManagement routeManagement = new RouteManagement(driver, routeDetails);
                routeManagement.setRouteTotal(totalRoute);
                saveRouteManagament(routeManagement);
            }
        }

    private static boolean isRouteQuantityOver(int totalRoute, int routeQuantity) {
        boolean checkRouteQuantity= false;
        if(totalRoute+routeQuantity < 15) {
            checkRouteQuantity = true;
        }
        return checkRouteQuantity;
    }

    private static boolean isOfIdAvailable(RouteDetails[] routeDetails, int routeID) {
        boolean checkIdAvailable = false;
        for (int i = 0; i < routeDetails.length; i++) {
            if(routeDetails[i]!=null && routeDetails[i].getRoute().getId() == routeID) {
                checkIdAvailable = true;
                break;
            }
        }
        return checkIdAvailable;
    }

    private static void saveRouteManagament(RouteManagement routeManagement) {
        for (int i = 0; i < routeManagements.length; i++) {
            if(routeManagements[i]==null) {
                routeManagements[i] = routeManagement;
                break;
            }
        }
    }

    public static void showRouteManagement () {
            for (int i = 0; i < routeManagements.length; i++) {
                if (routeManagements[i] != null) {
                    System.out.println(routeManagements[i]);
                }
            }
        }

    private static boolean isOfNull(){
        boolean driversValid = false;
        boolean routesValid = false;
        for (int i = 0; i < drivers.length; i++) {
            if(drivers[i]!=null){
                driversValid = true;
            }
        }
        for (int i = 0; i < routes.length; i++) {
            if (drivers[i]!=null) {
                routesValid = true;
            }
        }
        return driversValid && routesValid;
    }

    static RouteManagement[] sortByRouteQuantity() {
        for (int i = 0; i < routeManagements.length-1; i++) {
            RouteManagement route1 = routeManagements[i];
            if (route1==null) {
                continue;
            }
            for (int j = i; j < routeManagements.length; j++) {
                RouteManagement route2 = routeManagements[j];
                if (route2==null) {
                    continue;
                }
                if (route1.getRouteTotal() < route2.getRouteTotal()) {
                    routeManagements[i] = route2;
                    routeManagements[j] = route1;
                }
            }
        }
        return routeManagements;
    }

    static Driver[] sortByName() {
        for (int i = 0; i < drivers.length-1; i++) {
            Driver driver1 = drivers[i];
            if (driver1==null) {
                continue;
            }
            for (int j = i; j < drivers.length; j++) {
                Driver driver2 = drivers[j];
                if(driver2==null) {
                    continue;
                }
                if((driver1.getName().compareTo(driver2.getName())>0)) {
                    drivers[i] = drivers[j];
                    drivers[j] = driver1;
                }
            }
        }
        return drivers;
    }

    public static void showRouteManagementAfterSortByQuantity (RouteManagement[] routeManagements) {
        for (int i = 0; i < routeManagements.length; i++) {
            if (routeManagements[i] != null) {
                System.out.println(routeManagements[i]);
            }
        }
    }

    public static void showRouteManagementAfterSortByName (Driver[] drivers) {
        for (int i = 0; i < drivers.length; i++) {
            if (drivers[i] != null) {
                System.out.println(drivers[i]);
            }
        }
    }

    public static void routeDistanceCal() {
        double distance =0;
        for (int i = 0; i < routeManagements.length; i++) {
            RouteManagement route1 = routeManagements[i];
            if(route1==null) {
                continue;
            }
            String driverName = route1.getDriver().getName();
            RouteDetails[] routeDetails = route1.getRouteDetails();
            for (int j = 0; j < routeDetails.length; j++) {
                distance += routeDetails[j].getRouteQuantity()* routeDetails[j].getRoute().getDistance();
            }
            System.out.println("Khoảng cách tài xế " + driverName+ " đã đi là " + distance);
        }
    }
}
