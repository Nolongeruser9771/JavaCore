import java.util.Scanner;

public class Exercise19 {
    public static void main(String[] args) {
        //Bài 19: Thực hiện nhập vào một mảng số nguyên a có n phần tử (n>0). Tìm số lớn nhất và nhỏ nhất trong mảng a.

        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = new Scanner(System.in).nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("arr["+i+"] = ");
            arr[i] = new Scanner(System.in).nextInt();
        }
        System.out.println("Phần tử lớn nhất của mảng: "+ Max(arr));
        System.out.println("Phần tử nhỏ nhất của mảng: "+  Min(arr));
    }

    public static int Max(int[]arr) {
        int Max=arr[0];

        for (int i:arr) {
            if (i>Max) {
                Max=i;
            }
        }
        return Max;
    }

    public static int Min(int[]arr) {
        int Min=arr[0];

        for (int i:arr) {
            if (i<Min) {
                Min=i;
            }
        }
        return Min;
    }
}
