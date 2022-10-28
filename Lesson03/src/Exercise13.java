import java.util.Scanner;

public class Exercise13 {
    public static void main(String[] args) {
        //Bài 13: Nhập số tự nhiên n rồi tính tổng các số tự nhiên không lớn hơn n và chia hết cho 7.

        System.out.print("Nhập số tự nhiên n: ");
        int n = new Scanner(System.in).nextInt();
        int i = 0;
        int S = 0;

        while (i < n) {
            if (i % 7 == 0) {
                S += i;
            }
            i++;
        }
        System.out.printf("tổng các số tự nhiên không lớn hơn %d và chia hết cho 7 là %d", n, S);
    }
}
