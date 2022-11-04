import java.util.Arrays;
import java.util.Scanner;

public class Exercise27 {
    public static void main(String[] args) {
        //Bài 27: Thực hiện nhập vào hai mảng số nguyên a, b đều có n phần tử (n>0).
        // Thực hiện tính tổng hai mảng này theo quy tắc: phần tử đầu của a sẽ được cộng với phần tử cuối của
        // b để cho ra phần tử đầu của mảng kết quả, tiếp theo phần tử thứ 2 của a và phần tử gần cuối của b
        // được cộng vào để cho ra phần tử thứ 2 của mảng kết quả, …

        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = new Scanner(System.in).nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("arr1[" + i + "] = ");
            arr1[i] = new Scanner(System.in).nextInt();
        }

        for (int i = 0; i < n; i++) {
            System.out.print("arr2[" + i + "] = ");
            arr2[i] = new Scanner(System.in).nextInt();
        }

        System.out.println("Tổng 2 mảng theo nguyên tắc như đề bài: "+ Arrays.toString(Sum(arr1, arr2)));

    }
    public static int[] Sum(int[]arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr3[i]=arr1[i]+arr2[arr1.length-1-i];
        }
        return arr3;
    }
}
