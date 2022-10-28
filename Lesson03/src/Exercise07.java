import java.util.Scanner;

public class Exercise07 {
    public static void main(String[] args) {
        //Bài 7: Viết chương trình nhập hai số nguyên n,m và in ra hình chữ nhật đặc các dấu * kích thước n*m. Ví dụ với n=5,m=4:

        System.out.print("Nhập n: ");
        int n=new Scanner(System.in).nextInt();

        System.out.print("Nhập m: ");
        int m=new Scanner(System.in).nextInt();

        for (int i = 0; i <m; i++) {
            System.out.println('\n');
            for (int j=0; j<n;j++) {
                System.out.print("* \t \t");
            }
        }
    }
}
