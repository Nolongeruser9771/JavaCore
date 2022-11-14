package Entity;

import Entity.Driver;
import Entity.RouteDetails;

import java.util.Arrays;

public class RouteManagement {
    Driver driver;
    RouteDetails[] routeDetails;
    int routeTotal;

    public int getRouteTotal() {
        return routeTotal;
    }

    public void setRouteTotal(int routeTotal) {
        this.routeTotal = routeTotal;
    }

    public RouteManagement(Driver driver, RouteDetails[] routeDetails) {
        this.driver = driver;
        this.routeDetails = routeDetails;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public RouteDetails[] getRouteDetails() {
        return routeDetails;
    }

    public void setRouteDetails(RouteDetails[] routeDetails) {
        this.routeDetails = routeDetails;
    }

    @Override
    public String toString() {
        return "RouteManagement{" +
                "driver=" + driver +
                ", routeDetails=" + Arrays.toString(routeDetails) +
                '}';
    }
}
