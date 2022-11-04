import java.util.Scanner;

public class Exercise28 {
    public static void main(String[] args) {
        //Bài 28: Thực hiện nhập vào ma trận vuông số nguyên a có n dòng và n cột (n>0). Tính tổng đường chéo chính của ma trận này.

        System.out.println("Nhập số dòng và số cột của mảng (n) : ");
        int n = new Scanner(System.in).nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("arr[" + i + "][" + j + "] = ");
                arr[i][j] = new Scanner(System.in).nextInt();
            }
        }
        //Export arr
        for (int[] innerArray:arr) {
            System.out.println();
            for (int i:innerArray) {
                System.out.print(i + "\t");
            }
        }
        System.out.println("\nTổng đường chéo chính của ma trận: "+ diagonalLine(arr,n));

    }

    public static int diagonalLine(int[][]arr, int n) {
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum += arr[i][i];
        }
        return sum;
        }
    }
