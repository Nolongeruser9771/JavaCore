package LogicHandle;

import Entity.Driver;
import Entity.Route;

import java.util.Scanner;

import static MainRun.Main.drivers;
import static MainRun.Main.routes;

public class RouteLogic {

    public static void addNewRoute(){
        System.out.println("Muốn thêm bao nhiêu tuyến:");
        int routeNum = new Scanner(System.in).nextInt();
        for (int i = 0; i < routeNum; i++) {
            Route route = new Route();
            route.inputInfo();
            saveRouteInfo(route);
        }
    }

    private static void saveRouteInfo(Route route) {
        for (int i = 0; i < routes.length; i++) {
            if(routes[i]==null) {
                routes[i] = route;
                break;
            }
        }
    }

    public static void showRouteInfo() {
        for (int i = 0; i < routes.length; i++) {
            if(routes[i]!=null){
                System.out.println(routes[i]);
            }
        }
    }

    public static Route findRouteById(int routeID) {
        Route route= null;
        for (int i = 0; i < routes.length; i++) {
            if (routes[i] != null && routes[i].getId() == routeID) {
                route = routes[i];
            }
        }
        return route;
    }
}
