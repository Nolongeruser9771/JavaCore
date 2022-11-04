import java.util.Scanner;

public class Exercise05 {
    public static void main(String[] args) {
        //Bài 5: Nhập số liệu cho dãy số nguyên a[0], a[1],…, a[n-1].
        // Tìm số lớn thứ hai và vị trí của nó trong dãy. Chú ý trường hợp cả dãy bằng nhau thì sẽ không có số lớn thứ 2.

        System.out.println("Nhập số lượng phần tử của mảng: ");
        int n = new Scanner(System.in).nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = new Scanner(System.in).nextInt();
        }
        System.out.println(timSo(arr));
    }
    public static int timSo(int[] arr) {

        int firstNumber=0;
        int secondNumber=0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > firstNumber) {
                secondNumber = firstNumber;
                firstNumber = arr[i];
            } else if (arr[i] != firstNumber && arr[i] > secondNumber) {
                secondNumber = arr[i];
            }
        }
        return secondNumber;
    }
}

