package LogicHandle;

import java.util.Scanner;
import Main.Main;

public class sortLogicById {
    public static void sortByIdMenu(int i) {
        System.out.println("Bạn muốn thao tác gì trên sản phẩm này");
        System.out.println("1. Xoá sản phẩm");
        System.out.println("2. Cập nhật lại số lượng sản phẩm");
        int choice;
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice <= 2) {
                break;
            }
            System.out.println("Nhập sai lựa chọn. mời nhập lại");
        } while (true);

        switch (choice) {
            case 1:
                Main.products.remove(i);
                break;
            case 2:
                System.out.println("Thay đổi số lượng sản phẩm này thành:");
                int fixQuantity = new Scanner(System.in).nextInt();
                Main.products.get(i).setQuantity(fixQuantity);
                System.out.println(Main.products.get(i));
                break;
        }
    }
}
