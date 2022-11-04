import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Scanner;

public class Exercise13 {
    public static void main(String[] args) {
        //Bài 13: Nhập vào 2 số tự nhiên m và n, sao cho m < n. Hãy liệt kê các số chính phương trong đoạn [m,n]. Có bao nhiêu số chính phương?

        System.out.print("Nhập số m: ");
        int m = new Scanner(System.in).nextInt();

        System.out.print("Nhập số n: (n> m) ");
        int n = new Scanner(System.in).nextInt();

        System.out.println("\nTổng số chính phương trong đoạn [" + m + "," + n + "] là: " + "\n" + timSoChinhPhuong(m,n));
    }

    public static int timSoChinhPhuong(int m, int n) {
        int count = 0;

        System.out.println("Các số chính phương trong đoạn [" + m + "," + n + "] là: ");
        while (m <= n) {
            int i = (int) Math.sqrt(m);
            if (i * i == m) {
                System.out.print(m + "\t");
                count++;
            }
            m++;
        }
        return count;
    }
}
