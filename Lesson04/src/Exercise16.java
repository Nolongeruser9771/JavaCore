import java.util.Scanner;

public class Exercise16 {
    public static void main(String[] args) {
        //Bài 16: Nhập số tự nhiên n rồi in ra các số chẵn nhỏ hơn n và các số lẻ nhỏ hơn n.

        System.out.print("Nhập số tự nhiên n: ");
        int n = new Scanner(System.in).nextInt();

        System.out.println("Các số chẵn: ");
        for (int i = 0; i < n; i++) {
            if (kiemTraChanLe(i)) {
                System.out.print(i + "\t");
            }
        }
        System.out.println("\nCác số lẻ: ");
        for (int i = 0; i < n; i++) {
            if (!kiemTraChanLe(i)) {
                System.out.print(i + "\t");
            }
        }

            }
    public static boolean kiemTraChanLe(int i) {
            if(i%2==0) {
                return true;
            }
            return false;
        }
}
