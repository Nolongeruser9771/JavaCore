import java.util.Scanner;

public class Exercise04 {
    public static void main(String[] args) {
        //Bài 4: Nhập số liệu cho dãy số nguyên a[0], a[1],…, a[n-1]. Đếm xem có bao nhiêu cặp 2 phần tử liên tiếp bằng nhau
        // trong dãy trên (tức là đếm số cặp a[i] , a[i+1] sao cho a[i] = a[i+1]; nếu có trường hợp a[i] = a[i+1] = a[i+2] thì được xem là có 2 cặp).

        System.out.println("Nhập số lượng phần tử của mảng: ");
        int n = new Scanner(System.in).nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = new Scanner(System.in).nextInt();
        }
        System.out.println("Tổng số cặp phần tử liên tiếp bằng nhau là:"+ kiemTra(arr));
    }

    public static int kiemTra(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]==arr[i+1]) {
                count++;
            }
        }
        return count;
    }
}
