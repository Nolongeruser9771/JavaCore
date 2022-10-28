import java.util.Scanner;

//Bài 4: Viết chương trình liệt kê n số nguyên tố đầu tiên.

public class Exercise04 {
    public static void main(String[] args) {
        System.out.println("Nhập số n: ");
        int n = new Scanner(System.in).nextInt();
        int i = 2;
        int count = 0;

        //Thiết lập đếm và trả giá trị n nếu n là SNT
        while (count <= n) {
            if (check(i)) {
                System.out.print(i + "\t");
                count++;
            }
            i++;
        }
    }

    //Kiểm tra xem i có phải số NT không?
    public static boolean check(int n) {
        if (n < 2) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}



