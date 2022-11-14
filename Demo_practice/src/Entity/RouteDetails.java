package Entity;

import Entity.Route;

public class RouteDetails {
    Route route;
    int routeQuantity;
    public RouteDetails(Route route, int routeQuantity) {
        this.route = route;
        this.routeQuantity = routeQuantity;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public int getRouteQuantity() {
        return routeQuantity;
    }

    public void setRouteQuantity(int routeQuantity) {
        this.routeQuantity = routeQuantity;
    }

    @Override
    public String toString() {
        return "RouteDetails{" +
                "route=" + route +
                ", routeQuantity=" + routeQuantity +
                '}';
    }
}
