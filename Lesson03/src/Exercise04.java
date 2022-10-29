import java.util.Scanner;

public class Exercise04 {
    public static void main(String[] args) {

        //Bài 4: Viết chương trình liệt kê n số nguyên tố đầu tiên.

        System.out.print("Nhập vào n: ");
        int n = new Scanner(System.in).nextInt();

        boolean check = true;
        int num = 2;
        int count = 0;

        System.out.println(n + " Số nguyên tố đầu tiên là:");

        while(count<n) {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.print(num+"\t");
                count++;
            }
            check = true;
            num++;
        }
    }
}

