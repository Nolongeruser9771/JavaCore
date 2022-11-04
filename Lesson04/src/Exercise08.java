import java.util.Arrays;
import java.util.Scanner;

public class Exercise08 {
    public static void main(String[] args) {
        //Bài 8: Nhập mảng a gồm N phần tử bao gồm các số nguyên dương. In phần tử có số lần xuất hiện nhiều nhất trong a.

        System.out.println("Nhập số lượng phần tử của mảng: ");
        int n = new Scanner(System.in).nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = new Scanner(System.in).nextInt();
        }
        System.out.println("Phần tử có số lần xuất hiện nhiều nhất: " + soLanXuatHienNhieuNhat(arr));
    }
    public static int[] sapXepMang(int[] arr) {
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

    public static int soLanXuatHienNhieuNhat(int[] arr) {
        int countMax = 0;
        int count = 1;
        int index=0;

        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]==arr[i+1]) {
                count++;
            }else {
                count=1;
            }
            if(count>countMax) {
                countMax=count;
                index=arr[i];
            }
        }
        return index;
    }
}
