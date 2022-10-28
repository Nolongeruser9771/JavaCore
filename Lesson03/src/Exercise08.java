import java.util.Scanner;

public class Exercise08 {
    public static void main(String[] args) {
        //Bài 8: Viết chương trình nhập hai số nguyên n,m và in ra hình chữ nhật rỗng các dấu * kích thước n*m. Ví dụ với n=5,m=4:

        System.out.print("Nhập n: ");
        int n=new Scanner(System.in).nextInt();

        System.out.print("Nhập m: ");
        int m=new Scanner(System.in).nextInt();

        for (int i = 0; i <m; i++) {
            System.out.println('\n');
            for (int j=0; j<n;j++) {
                if (i != 0 && i != (m - 1) && j!=0 && j != (n - 1)) {
                    System.out.print("\t");
                } else {
                    System.out.print("* \t");
                }
            }
        }
    }
}
