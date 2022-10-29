import java.util.Scanner;

public class Exercise06 {
    public static void main(String[] args) {
        //Bài 6: Hãy viết chương trình tính tổng các chữ số của một số nguyên bất kỳ. Ví dụ: Số 8545604 có tổng các chữ số là: 8+5+4+5+6+0+4=32

        System.out.print("Nhập một số nguyên bất kì: ");
        long n = new Scanner(System.in).nextLong();
        long tempt = n;
        long Sum = 0;

        while (tempt > 0) {
            Sum += tempt%10;
            tempt/=10;
        }
        System.out.println("Tổng các chữ số là: "+Sum);
    }
}
