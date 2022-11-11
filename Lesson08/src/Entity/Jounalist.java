package Entity;

import Constant.JounalistType;

import java.util.Scanner;

public class Jounalist extends Person {

    private static int AUTO_ID=10000;
    private int id;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Jounalist{" +
                "id=" + id +
                ", type='" + type + '\'' +
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
        System.out.println("Nhập loại phóng viên: ");
        System.out.println("1. Chuyên nghiệp");
        System.out.println("2. Nghiệp dư");
        System.out.println("3. CTV");
    int choice;
    do {
        choice = new Scanner(System.in).nextInt();
        if(choice >=1 && choice <=3) {
            break;
        }
        System.out.println("Sai loại. mời nhập lại");
    } while (true);
    switch (choice) {
        case 1:
            this.type = JounalistType.CN.value;
            break;
        case 2:
            this.type = JounalistType.ND.value;
            break;
        case 3:
            this.type = JounalistType.CTV.value;
            break;
    }
}
}
