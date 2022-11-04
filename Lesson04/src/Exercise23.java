import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.deepToString;

public class Exercise23 {
    public static void main(String[] args) {
        //Bài 23: Thực hiện nhập vào hai ma trận số nguyên a, b có n dòng và m cột (n, m>0). Thực hiện tính tổng hai ma trận này.
        System.out.println("Nhập số dòng của mảng (n) : ");
        int r = new Scanner(System.in).nextInt();
        System.out.println("Nhập số cột của mảng (m) : ");
        int c = new Scanner(System.in).nextInt();
        int[][] arr1 = new int[r][c];
        int[][] arr2 = new int[r][c];

        System.out.println("Nhập giá trị phần tử mảng arr1: ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("arr[" + i + "][" + j + "] = ");
                arr1[i][j] = new Scanner(System.in).nextInt();
            }
        }
        System.out.println("Nhập giá trị phần tử mảng arr2: ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("arr[" + i + "][" + j + "] = ");
                arr2[i][j] = new Scanner(System.in).nextInt();
            }
        }

        System.out.println("Tổng 2 mảng đã nhập: ");
        System.out.println(deepToString(tinhTong(arr1, arr2, r, c)));
    }
    public static int[][] tinhTong(int[][]arr1, int[][]arr2, int r, int c) {
        int[][] arr3=new int[r][c];
        for (int i = 0; i < r; i++) {
             for (int j = 0; j < c; j++) {
                 arr3[i][j] = arr1[i][j] + arr2[i][j];
             }
        }
        return arr3;
    }
    }