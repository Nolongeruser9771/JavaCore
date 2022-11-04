package Exercise04;


import java.util.Arrays;
import java.util.Scanner;

public class MainRunMyPoint {
    public static void main(String[] args) {
        System.out.println("Số lượng điểm muốn tạo: ");
        int n = new Scanner(System.in).nextInt();
        MyPoint[] point = new MyPoint[n];

        for (int i = 0; i < n; i++) {
            point[i] = new MyPoint();
            System.out.print("Nhập x" + i + ": ");
            point[i].x = new Scanner(System.in).nextDouble();
            System.out.print("Nhập y" + i + ": ");
            point[i].y = new Scanner(System.in).nextDouble();
        }

        System.out.println("Tập hợp các điểm đã nhập: " + Arrays.toString(point));
        double Max = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (point[i].distance(point[j]) > Max) {
                    Max = point[i].distance(point[j]);
                }
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (point[i].distance(point[i], point[j]) == Max) {
                    System.out.println("-----------------------------------------");
                    System.out.println("2 điểm có khoảng cách xa nhất là: (" + point[i].x + "," + point[i].y + ")" + " và (" + point[j].x + "," + point[j].y + ")");
                    System.out.println("Khoảng cách là: " + Max);
                }
            }
        }
    }
}
