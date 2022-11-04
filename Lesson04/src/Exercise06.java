import java.util.Scanner;

public class Exercise06 {
    public static void main(String[] args) {
        //Bài 6: Nhập số liệu cho dãy số nguyên a[0], a[1],…, a[n-1] và 2 số nguyên b, c (b < c).
        // Tính trung bình cộng các phần tử của dãy nằm trong đoạn [b, c].

        System.out.println("Nhập số lượng phần tử của mảng: ");
        int n = new Scanner(System.in).nextInt();
        int[] arr = new int[n];

        System.out.println("Nhập số b: ");
        int b= new Scanner(System.in).nextInt();

        System.out.println("Nhập số c (c>b): ");
        int c= new Scanner(System.in).nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("arr["+i+"] = ");
            arr[i]= new Scanner(System.in).nextInt();
        }
        System.out.println("Trung bình cộng các phần tử trong đoạn ["+b+","+c+"] là: "+tinhTrungBinhCong(arr,b,c));
    }

    public static double tinhTrungBinhCong(int[] arr, int b, int c) {
        double S=0;
        int count=0;
        double TB=0;

        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] >= b) && (arr[i] <= c)) {
                S += arr[i];
                count++;
            }
        }
            if(count!=0) {
                TB= S/count;
            }
        return TB;
    }
}
