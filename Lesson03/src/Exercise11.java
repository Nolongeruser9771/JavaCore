import java.util.Scanner;

public class Exercise11 {
    public static void main(String[] args) {
        /*Bài 11: Nhập số tự nhiên n rồi tính các tổng sau:
        • S = tổng các số tự nhiên không lớn hơn n.
        • S1 = tổng các số tự nhiên lẻ không lớn hơn n.
        • S2 = tổng các số tự nhiên chẵn không lớn hơn n*/
        System.out.print("Nhập số tự nhiên n: ");
        int n = new Scanner(System.in).nextInt();
        int i = 0;
        int S = 0;
        int sOdd = 0;
        int sEven = 0;
        // Tổng các số tự nhiên không lớn hơn n
        while (i < n) {
            S += i;
            if (i % 2 == 0) {
                sEven += i;
            } else {
                sOdd += i;
            }
            i++;
        }
        System.out.printf("tổng các số tự nhiên không lớn hơn %d là %d", n, S);
        System.out.printf("\ntổng các số tự nhiên lẻ không lớn hơn %d là %d", n, sOdd);
        System.out.printf("\ntổng các số tự nhiên chẵn không lớn hơn %d là %d", n, sEven);

        // Tổng các số tự nhiên lẻ không lớn hơn n
    }
}
