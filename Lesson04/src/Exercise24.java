import java.util.Arrays;
import java.util.Scanner;

public class Exercise24 {
    public static void main(String[] args) {
        //Bài 24: Thực hiện nhập vào một mảng số nguyên a có n phần tử (n > 0). Thực hiện sắp xếp mảng theo thứ tự giảm dần.

        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = new Scanner(System.in).nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = new Scanner(System.in).nextInt();
        }
        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(bubbleSort(arr)));
    }

    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int value = arr[i];
                if (arr[i] < arr[j]) {
                    arr[i] = arr[j];
                    arr[j] = value;
                }
            }
        }
        return arr;
    }
}
