import java.util.Scanner;

public class Exercise12 {
    public static void main(String[] args) {
        //Bài 12: Nhập vào 2 số tự nhiên m và n, sao cho m < n. Hãy liệt kê các số chính phương trong đoạn [m,n]. Có bao nhiêu số chính phương?

        System.out.print("Nhập số n: ");
        int n=new Scanner(System.in).nextInt();

        System.out.print("Nhập số m (m<n): ");
        int m=new Scanner(System.in).nextInt();
        int i= (int) Math.sqrt(m);
        int count=0;

        while (m<n){
            i= (int) Math.sqrt(m);
            if(i*i==m) {
                System.out.print(m +"\t");
                count++;
            }
                m++;
        }
        System.out.printf("\nGiữa 2 số m và n có %d số chính phương",count);
    }
}
