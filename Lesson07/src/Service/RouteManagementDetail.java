package Service;

import Entity.Route;

public class RouteManagementDetail {
    private Route route;
    private int routeQuantity;

    public RouteManagementDetail(Route route, int routeQuantity) {
        this.route = route;
        this.routeQuantity = routeQuantity;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public int getRoteQuantity() {
        return routeQuantity;
    }

    public void setRoteQuantity(int roteQuantity) {
        this.routeQuantity = roteQuantity;
    }

    @Override
    public String toString() {
        return "RouteManagementDetail{" +
                "route=" + route +
                ", roteQuantity=" + routeQuantity +
                '}';
    }
}
