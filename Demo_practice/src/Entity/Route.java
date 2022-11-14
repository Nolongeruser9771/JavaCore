package Entity;

import java.util.Scanner;

public class Route implements Inputable{
    private static int AUTO_ID=100;
    private int id;
    private double distance;
    private int stop;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getStop() {
        return stop;
    }

    public void setStop(int stop) {
        this.stop = stop;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", distance=" + distance +
                ", stop=" + stop +
                '}';
    }
    @Override
    public void inputInfo() {
        AUTO_ID++;
        this.id = AUTO_ID;
        System.out.println("Nhập khoảng cách tuyến");
        this.distance = new Scanner(System.in).nextDouble();
        System.out.println("Nhập số điểm dừng");
        this.stop = new Scanner(System.in).nextInt();
    }
}
