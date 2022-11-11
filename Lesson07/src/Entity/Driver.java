package Entity;

import Constant.DriverLevel;

import java.util.Scanner;

public class Driver extends Person {

    private static int AUTO_ID=10000;
    private int id;
    private String level;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", level='" + level + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public void inputInfo() {
        AUTO_ID++;
        this.id =AUTO_ID;
        super.inputInfo();
        System.out.println("Nhập trình độ: ");
        System.out.println("1. Trình độ A");
        System.out.println("2. Trình độ B");
        System.out.println("3. Trình độ C");
        System.out.println("4. Trình độ D");
        System.out.println("5. Trình độ E");
        System.out.println("6. Trình độ A");
        int choice;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >=1 && choice <=6) {
                break;
            }
            System.out.println("Chọn sai. Mời chọn lại");
        } while (true);
        switch (choice) {
            case 1:
                this.level = DriverLevel.A.value;
                break;
            case 2:
                this.level = DriverLevel.B.value;
                break;
            case 3:
                this.level = DriverLevel.C.value;
                break;
            case 4:
                this.level = DriverLevel.D.value;
                break;
            case 5:
                this.level = DriverLevel.E.value;
                break;
            case 6:
                this.level = DriverLevel.F.value;
                break;
        }
    }
}
