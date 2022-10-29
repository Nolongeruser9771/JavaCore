import java.util.Scanner;

public class Exercise14 {
    public static void main(String[] args) {
        //Bài 14: Nhập số tự nhiên n rồi in ra các số chẵn nhỏ hơn n và các số lẻ nhỏ hơn n.
        System.out.print("Nhập số tự nhiên n: ");
        int n = new Scanner(System.in).nextInt();
        
        System.out.println("Các số tự nhiên chẳn nhỏ hơn n: ");
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                System.out.print(i+"\t");
            }
        }
        System.out.println("\nCác số tự nhiên lẻ nhỏ hơn n: ");
        for (int i = 0; i < n; i++) {
            if(i%2!=0) {
                System.out.print(i+"\t");
            }
        }
    }
}
