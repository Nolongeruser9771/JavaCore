import java.util.Random;
import java.util.Scanner;

public class Exercise12 {
    public static void main(String[] args) {
        //Bài 12: Viết chương trình tính tích 2 ma trận các số nguyên A cấp mxn và B cấp n x k.

        System.out.println("Nhập số dòng của ma trận A (m) : ");
        int m = new Scanner(System.in).nextInt();
        System.out.println("Nhập số cột của ma trận A và số dòng của ma trận B (n) : ");
        int n = new Scanner(System.in).nextInt();
        System.out.println("Nhập số cột của ma trận B (k) : ");
        int k = new Scanner(System.in).nextInt();
        Random random = new Random();
        int[][] arr1 = new int[m][n];
        int[][] arr2 = new int[n][k];

        System.out.print("Ma trận A:");
        for (int i = 0; i < m; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                arr1[i][j] = random.nextInt(100);
                System.out.print(arr1[i][j]+"\t");
            }
        }
        System.out.print("\nMa trận B:");
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < k; j++) {
                arr2[i][j] = random.nextInt(100);
                System.out.print(arr2[i][j]+"\t");
            }
        }

        System.out.print("\nTích 2 mã trận A và B là ma trận C = ");
        ExportArr(arr1,arr2,m,n,k);
    }

    public static int[][] multiplication(int[][]arr1,int[][]arr2, int m, int n, int k) {
        int [][] C= new int [m][k];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < n; l++) {
                    C[i][j] += arr1[i][l]*arr2[l][j];
                }

            }

        }
        return C;
    }

    public static void ExportArr(int[][]arr1,int[][]arr2, int m, int n,int k) {
        for (int i = 0; i < m; i++) {
            System.out.println();
            for (int j = 0; j < k; j++) {
                System.out.print(multiplication(arr1,arr2,m,n,k)[i][j]+"\t");
            }
        }
    }
}
