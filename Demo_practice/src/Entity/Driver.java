package Entity;

import Constant.DriverLevelConstant;

import java.util.Scanner;

public class Driver extends Person {

    private static int AUTO_ID =10000;
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
                "id='" + id + '\'' +
                ", level='" + level + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public void inputInfo() {
        AUTO_ID++;
        this.id = AUTO_ID;
        super.inputInfo();
        System.out.println("Nhập trình độ lái xe:");
        System.out.println("Chọn từ A tới F");
        int choice;
        do {
            choice = new Scanner(System.in).nextInt();
            if(choice<=6 && choice>=1) {
                break;
            }
            System.out.println("Sai loại. Mời nhập lại");
        } while (true);
        switch (choice) {
            case 1:
                this.level = DriverLevelConstant.A.value;
                break;
            case 2:
                this.level = DriverLevelConstant.B.value;
                break;
            case 3:
                this.level = DriverLevelConstant.C.value;
                break;
            case 4:
                this.level = DriverLevelConstant.D.value;
                break;
            case 5:
                this.level = DriverLevelConstant.E.value;
                break;
            case 6:
                this.level = DriverLevelConstant.F.value;
                break;
        }
    }
}
