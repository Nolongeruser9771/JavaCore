package Logic_Handle;

import Constant.JounalistType;
import Entity.Jounalist;
import MainRun.Main;

import java.util.Scanner;

import static MainRun.Main.*;
import static MainRun.Main.jounalists;

public class sortMenuLogic {
    public static void showSortMenu() {
        System.out.println("Chọn phương thức sắp xếp");
        System.out.println("1. Sắp xếp theo tên");
        System.out.println("2. Sắp xếp theo số lượng bài giảm dần");
        int choice;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 2) {
                break;
            }
            System.out.println("Sai loại. mời nhập lại");
        } while (true);
        switch (choice) {
            case 1:
                nameSort();
                break;
            case 2:
                articleQuantitySort();
                break;
        }
    }

    public static void articleQuantitySort() {

    }

    public static void nameSort() {
        for (int i = 0; i < jounalists.length - 1; i++) {
            for (int j = i + 1; j < jounalists.length; j++) {
                if (jounalists[i].getName().compareTo(jounalists[j].getName()) > 0) {
                    Jounalist value = jounalists[i];
                    jounalists[i] = jounalists[j];
                    jounalists[j]=value;
                }
            }
        }
    }
}
