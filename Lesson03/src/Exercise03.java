import java.util.Scanner;

public class Exercise03 {
    public static void main(String[] args) {
        //Bài 3: Viết chương trình tìm ước số chung lớn nhất và bội số chung nhỏ nhất của hai số nguyên dương a và b.

        //Tính ước chung lớn nhất của a và b:
        System.out.print("Nhập số nguyên dương a: ");
        int a = new Scanner(System.in).nextInt();

        System.out.print("Nhập số nguyên dương b: ");
        int b = new Scanner(System.in).nextInt();

        int UC = 0;
        int UCLN = 0;

            for (int i = 1; i <= Math.max(a, b); i++) {
                if (a % i == 0 && b % i == 0) {
                    UC = i;
                    System.out.print(UC+"\t");
                }
                if (UCLN < UC) {
                    UCLN = UC;
                }
            }
            System.out.printf("\nƯớc chung lớn nhất của %d và %d là: %d",a,b,UCLN);

        //Tính bội chung nhỏ nhất của a và b
        int BCNN = (a*b)/UCLN;
        System.out.printf("\nBội số chung nhỏ nhất của %d và %d là: %d",a,b,BCNN);
    }
}
