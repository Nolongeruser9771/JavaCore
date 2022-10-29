import java.util.Scanner;

public class Exercise15 {
    public static void main(String[] args) {
        //Bài 15: Nhập 2 số tự nhiên m,n rồi kiểm tra xem chúng có nguyên tố cùng nhau không. (Hai số nguyên tố cùng nhau là 2 số có UCLN là 1).
        System.out.print("Nhập số tự nhiên m: ");
        int m = new Scanner(System.in).nextInt();

        System.out.print("Nhập số tự nhiên n: ");
        int n = new Scanner(System.in).nextInt();
        int UC = 0;
        int UCLN = 0;

        for (int i = 1; i < Math.min(m, n); i++) {
            if (n % i == 0 && m % i == 0) {
                UC = i;
            }
            if (UC > UCLN) {
                UCLN = UC;
            }
        }
        if (UCLN == 1) {
            System.out.printf("%d và %d là 2 số nguyên tố cùng nhau", m, n);
        } else {
            System.out.printf("%d và %d không là 2 số nguyên tố cùng nhau", m, n);
        }
    }
}
