import java.util.Scanner;

public class Exercise26 {
    public static void main(String[] args) {
        //Bài 26: Thực hiện nhập vào một mảng số nguyên a có n phần tử (n > 0) và một số nguyên x. Đếm số lần xuất hiện của x trong mảng a.

        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = new Scanner(System.in).nextInt();
        int[] arr = new int[n];

        System.out.print("Nhập số nguyên x bất kì: ");
        int x= new Scanner(System.in).nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = new Scanner(System.in).nextInt();
        }

        System.out.println("Số lần xuất hiện của "+x+" trong mảng là: "+xFrequency(arr,x));
    }

    public static int xFrequency(int[]arr, int x) {
        int count=0;
        for (int i: arr) {
            if (i==x) {
                count++;
            }
        }
        return count;
    }
}
