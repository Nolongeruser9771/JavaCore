import java.util.Scanner;

public class Exercise02 {
    public static void main(String[] args) {
        //Bài 2: Nhập số tự nhiên n rồi liệt kê các ước số của nó. Có bao nhiêu ước số?

        System.out.print("Nhập số tự nhiên n: ");
        int n = new Scanner(System.in).nextInt();
        int j=0;

        System.out.print("Các ước số của "+n+" là:");

        for(int i=1; i<=(n/2);i++){
            if(n%i == 0) {
                System.out.print( i + "\t");
                j++;
            }
        }
        System.out.println("\nTổng số ước là: "+ j);
    }
}
