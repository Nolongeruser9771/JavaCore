package Service;

import Entity.Driver;

import java.util.Arrays;

public class RouteManagement {
    private Driver driver;
    private RouteManagementDetail[] routeManagementDetails;

    public RouteManagement(Driver driver, RouteManagementDetail[] routeManagementDetails) {
        this.driver = driver;
        this.routeManagementDetails = routeManagementDetails;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public RouteManagementDetail[] getRouteManagementDetails() {
        return routeManagementDetails;
    }

    public void setRouteManagementDetails(RouteManagementDetail[] routeManagementDetails) {
        this.routeManagementDetails = routeManagementDetails;
    }

    @Override
    public String toString() {
        return "RouteManagement{" +
                "driver=" + driver +
                ", routeManagementDetails=" + Arrays.toString(routeManagementDetails) +
                '}';
    }
}
