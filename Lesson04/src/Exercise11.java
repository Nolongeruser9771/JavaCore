import java.util.Scanner;

public class Exercise11 {
    public static void main(String[] args) {
        //Bài 11: Viết chương trình nhập số liệu cho ma trận các số nguyên A cấp mxn trong đó m, n là các số tự nhiên.
        //Sau đó tìm ma trận chuyển vị B = (bij) cấp n x m của A, với bij = aji

        System.out.println("Nhập số dòng của ma trận A (m) : ");
        int m = new Scanner(System.in).nextInt();
        System.out.println("Nhập số cột của ma trận A (n) : ");
        int n = new Scanner(System.in).nextInt();
        int[][] arr = new int[m][n];

        System.out.println("Nhập giá trị phần tử mảng arr1: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("arr[" + i + "][" + j + "] = ");
                arr[i][j] = new Scanner(System.in).nextInt();
            }
        }

        System.out.print("Ma trận chuyển vị B: ");
        for (int[] innerArray:AT(arr,m,n)) {
            System.out.println();
            for (int i:innerArray) {
                System.out.print(i + "\t");
            }
        }
    }

    public static int[][] AT(int [][] arr, int m, int n) {
        int[][] arrAT = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arrAT[i][j] = arr[j][i];
            }
        }
        return arrAT;
    }
}
