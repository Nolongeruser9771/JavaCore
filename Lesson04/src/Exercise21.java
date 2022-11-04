import java.util.Scanner;

public class Exercise21 {
    public static void main(String[] args) {
        //Bài 21: Thực hiện nhập vào một ma trận số nguyên a có n dòng và m cột (n, m>0). Tính tổng, trung bình cộng của tất cả các giá trị trong ma trận.

        System.out.println("Nhập số dòng của mảng (n) : ");
        int r = new Scanner(System.in).nextInt();
        System.out.println("Nhập số cột của mảng (m) : ");
        int c = new Scanner(System.in).nextInt();
        int[][] arr = new int[r][c];

        System.out.println("Nhập giá trị phần tử mảng arr1: ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("arr[" + i + "][" + j + "] = ");
                arr[i][j] = new Scanner(System.in).nextInt();
            }
        }

        System.out.println("Tổng các giá trị trong mảng: " + TinhTong(arr,r,c));
        System.out.println("Trung bình cộng các giá trị trong mảng: " + (double)TinhTong(arr,r,c)/(r*c));
    }

    public static int TinhTong(int[][] arr, int r, int c) {
        int S = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                S += arr[i][j];
            }
        }
        return S;
    }

}
