import java.sql.SQLOutput;
import java.util.Scanner;

public class Exercise09 {
    public static void main(String[] args) {
        //Bài 9: Viết chương trình nhập số nguyên h và in ra màn hình tam giác vuông cân đặc có độ cao h. Ví dụ với h=4:
        System.out.print("Nhập giá trị h: ");
        int h=new Scanner(System.in).nextInt();

        for (int i = 1; i <=h ; i++) {
            System.out.println("\n");
            for (int j = 1; j <=h ; j++) {
                if(j<=i) {
                    System.out.print("*\t\t");
                }
            }
        }
    }
}
