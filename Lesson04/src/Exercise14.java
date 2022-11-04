import java.util.Scanner;

public class Exercise14 {
    public static void main(String[] args) {
        //Bài 14: Nhập số tự nhiên n rồi tính tổng: S= 1+ (1/2) + (1/3) + ...+ (1/n)

        System.out.println("Nhập số tự nhiên n: ");
        int n = new Scanner(System.in).nextInt();

        System.out.println("Tổng nghịch đảo các số từ 1 đến "+n+" là: " + TinhTong(n));
    }

    public static double TinhTong(int n) {
        double S =0;
        for (double i = 1; i <= n; i++) {
            S+=(1/i);
        }
        return S;
    }
}
