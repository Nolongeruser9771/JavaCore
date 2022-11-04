import java.util.Scanner;

public class Exercise25 {
    public static void main(String[] args) {
        //Bài 25: Thực hiện nhập vào một mảng số nguyên a có n phần tử (n > 0). Đếm xem trong mảng có bao nhiêu số lẻ và bao nhiêu số chẵn.

        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = new Scanner(System.in).nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = new Scanner(System.in).nextInt();
        }

        System.out.println("Tổng số chẵn trong mảng đã nhập: "+ EvenCount(arr));
        System.out.println("Tổng số lẻ trong mảng đã nhập: "+ oddCount(arr));
    }

    public static int EvenCount(int[] arr) {
        int evenCount = 0;
        for (int i : arr) {
            if (i % 2 == 0) {
                evenCount++;
            }
        }
        return evenCount;
    }

    public static int oddCount(int[] arr) {
        int oddCount = 0;
        for (int i : arr) {
            if (i % 2 != 0) {
                oddCount++;
            }
        }
        return oddCount;
    }
}
