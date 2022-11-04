import java.util.Arrays;
import java.util.Scanner;

public class Exercise03 {
    public static void main(String[] args) {
        //Bài 3: Nhập số n và dãy các số nguyên a[0], a[1],…, a[n-1] rồi sắp xếp dãy trên theo thứ tự tăng dần.

        System.out.println("Nhập số lượng phần tử của mảng: ");
        int n = new Scanner(System.in).nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + " ] = ");
            arr[i] = new Scanner(System.in).nextInt();
        }
        System.out.println(Arrays.toString(sapXep(arr)));
    }

    public static int[] sapXep(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int value = arr[i];
                    arr[i] = arr[j];
                    arr[j] = value;
                }
            }
        }
        return arr;
    }
}
