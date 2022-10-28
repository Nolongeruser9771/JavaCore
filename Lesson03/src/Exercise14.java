import java.util.Scanner;

public class Exercise14 {
    public static void main(String[] args) {
        //Bài 14: Nhập số tự nhiên n rồi in ra các số chẵn nhỏ hơn n và các số lẻ nhỏ hơn n.
        System.out.print("Nhập số tự nhiên n: ");
        int n = new Scanner(System.in).nextInt();
        int i = 0;
        int sOdd = 0;
        int sEven = 0;
        // Tổng các số tự nhiên không lớn hơn n
        while (i < n) {
            if (i % 2 == 0) {
                sEven += i;
            } else {
                sOdd += i;
            }
            i++;
        }
        System.out.printf("\ntổng các số tự nhiên lẻ nhỏ hơn %d là %d", n, sOdd);
        System.out.printf("\ntổng các số tự nhiên chẵn nhỏ hơn %d là %d", n, sEven);
    }
}
