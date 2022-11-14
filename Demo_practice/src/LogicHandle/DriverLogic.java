package LogicHandle;

import Entity.Driver;

import java.util.Scanner;

import static MainRun.Main.drivers;

public class DriverLogic {
    public static void addNewDriver() {
        System.out.println("Muốn thêm bao nhiêu tài xế:");
        int driverNum = new Scanner(System.in).nextInt();
        for (int i = 0; i < driverNum; i++) {
            Driver driver = new Driver();
            driver.inputInfo();
            saveDriverInfo(driver);
        }
    }

    private static void saveDriverInfo(Driver driver) {
        for (int i = 0; i < drivers.length; i++) {
            if (drivers[i] == null) {
                drivers[i] = driver;
                break;
            }
        }
    }

    public static void showDriverInfo() {
        for (int i = 0; i < drivers.length; i++) {
            if (drivers[i] != null) {
                System.out.println(drivers[i]);
            }
        }
    }

    public static Driver findDriverById(int driverID) {
        Driver driver = null;
        for (int i = 0; i < drivers.length; i++) {
            if (drivers[i] != null && drivers[i].getId() == driverID) {
                driver = drivers[i];
            }
        }
        return driver;
    }
}
