import java.util.Random;
import java.util.Scanner;

public class Exercise09 {
    public static void main(String[] args) {
        //Bài 9: Viết chương trình tạo ngẫu nhiên mảng a gồm N phần tử bao gồm các số nguyên. In ra các số khác nhau
        //trong dãy.

        System.out.println("Nhập số lượng phần tử của mảng: ");
        int n = new Scanner(System.in).nextInt();
        int[] arr = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(10);
            System.out.println("arr[" + i + "] = " + arr[i]);
        }

        System.out.println("Các phần tử khác nhau trong dãy: ");
        for (int i = 0; i < n; i++) {
            if (differentNumber(arr)[i]!=0) {
                System.out.print(i + "\t");
            }
        }
    }

    public static int[] differentNumber(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    arr[i] = 0;
                    arr[j] = 0;
                }
            }
        }
        return arr;
    }
}