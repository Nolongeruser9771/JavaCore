import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        //Bài 1: Viết chương trình nhập vào 4 số nguyên a, b, c và d. In ra màn hình kết quả xem số nào lớn nhất trong 4 số vừa nhập.

        System.out.print("Nhập vào số a: ");
        int a= new Scanner(System.in).nextInt();

        System.out.print("Nhập vào số b: ");
        int b= new Scanner(System.in).nextInt();

        System.out.print("Nhập vào số c: ");
        int c= new Scanner(System.in).nextInt();

        System.out.print("Nhập vào số d: ");
        int d= new Scanner(System.in).nextInt();

        int Max;
        if (a>b) {
            Max=a;
        } else {
            Max=b;
        } if (c>Max) {
            Max = c;
        } if (d>Max) {
            Max= d;
        }
        System.out.println("Số lớn nhât trong 4 số trên là: " + Max);
    }
}
