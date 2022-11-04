import java.util.Arrays;
import java.util.Scanner;

public class Exercise07 {
    public static void main(String[] args) {
        //Bài 7: Nhập mảng a gồm N phần tử bao gồm các số nguyên dương.
        // Kiểm tra xem a có phải là mảng đối xứng hay không (ví dụ: [15 2 1 2 15] là mảng đối xứng).

        System.out.println("Nhập số lượng phần tử của mảng: ");
        int n = new Scanner(System.in).nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = new Scanner(System.in).nextInt();
        }
            if(kiemTraMangDoiXung(arr,n)) {
                System.out.println(Arrays.toString(arr) + " là mảng đối xứng");
            } else {
                System.out.println(Arrays.toString(arr) + " không là mảng đối xứng");
            }
    }

    public static boolean kiemTraMangDoiXung(int[] arr, int n) {
        for (int i = 0; i < arr.length/2; i++) {
            if(arr[i]!=arr[n-1-i]) {
                return false;
            }
        }
        return true;
    }
}
