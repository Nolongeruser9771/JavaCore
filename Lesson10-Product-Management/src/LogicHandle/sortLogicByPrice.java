package LogicHandle;

import java.util.Scanner;

import static LogicHandle.ProductLogic.*;

public class sortLogicByPrice {
    public static void sortByPriceMenu() {
        System.out.println("Bạn muốn tìm các sản phẩm theo mức giá nào?");
        System.out.println("Chọn 1 trong các lựa chọn sau:");
        System.out.println("1. Dưới 50.000");
        System.out.println("2. Từ 50.000 đến dưới 100.000");
        System.out.println("3. Từ 100.000");
        int choice;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 3) {
                break;
            }
            System.out.println("Không có lựa chọn trên. Mời chọn lại");
        } while (true);

        switch (choice) {
            case 1:
                findUnder50();
                break;
            case 2:
                findFrom50To100();
                break;
            case 3:
                findOver100();
                break;
        }
    }
}