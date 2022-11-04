import java.util.Scanner;

public class Exercise22 {
    public static void main(String[] args) {
        //Bài 22: Thực hiện nhập vào một ma trận số nguyên a có n dòng và m cột (n, m>0). Tìm giá trị lớn nhất và nhỏ nhất của ma trận này.

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
        System.out.println("Giá trị lớn nhất của ma trận: " + Max(arr));
        System.out.println("Giá trị nhỏ nhất của ma trận: " + Min(arr));
    }

    public static int Max(int[][]arr) {
        int Max = arr[0][0];

        for(int[] innerArray: arr) {
            for(int i: innerArray) {
                if(i>Max) {
                    Max=i;
                }
            }
        }
        return Max;
    }

    public static int Min(int[][]arr) {
        int Min = arr[0][0];

        for(int[] innerArray: arr) {
            for(int i: innerArray) {
                if(i<Min) {
                    Min=i;
                }
            }
        }
        return Min;
    }
}
