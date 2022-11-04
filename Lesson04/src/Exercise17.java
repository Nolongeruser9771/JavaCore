import java.util.Scanner;

public class Exercise17 {
    public static void main(String[] args) {
        //Bài 17: Nhập 2 số tự nhiên m,n rồi kiểm tra xem chúng có nguyên tố cùng nhau không. (Hai số nguyên tố cùng nhau là 2 số có UCLN là 1).

        System.out.print("Nhập số tự nhiên m: ");
        int m = new Scanner(System.in).nextInt();

        System.out.print("Nhập số tự nhiên n: ");
        int n = new Scanner(System.in).nextInt();

        if (UCLN(m,n)==1) {
            System.out.println(m +" và "+ n +" là 2 số nguyên tố cùng nhau");
        } else {
            System.out.println(m +" và "+ n +" không là 2 số nguyên tố cùng nhau");
        }
    }

    public static int UCLN(int m, int n) {
        int UC = 0;
        int UCLN = 0;
        for (int i = 1; i <= Math.min(m,n); i++) {
            if(m%i==0 && n%i==0) {
                UC =i;
            }
            if (UC>UCLN){
                UCLN = UC;
            }
        }
        return UCLN;
    }
}
