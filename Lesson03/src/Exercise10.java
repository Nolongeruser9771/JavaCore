import java.util.Scanner;

public class Exercise10 {
    public static void main(String[] args) {
        //Bài 10: Viết chương trình nhập số nguyên h và in ra màn hình tam giác cân có độ cao h. Ví dụ với h=4:`

        System.out.print("Nhập giá trị h: ");
        int h=new Scanner(System.in).nextInt();

        for (int i = 0; i <h ; i++) {
            System.out.println("\n");
            for (int j = -h; j<h ; j++) {
                if(Math.abs(j)<=i) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
        }
    }
}
