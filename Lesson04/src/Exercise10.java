import java.sql.SQLOutput;
import java.util.Scanner;

public class Exercise10 {
    public static void main(String[] args) {
        //Bài 10: Nhập một dãy số có n phần tử trong đó không cho phép nhập các số trùng nhau. Nếu nhập một số đã có
        //thì yêu cầu nhập lại. Sau khi đủ n phần tử thì in dãy số đã nhập ra màn hình.

        System.out.println("Nhập số lượng phần tử của mảng: ");
        int n = new Scanner(System.in).nextInt();
        int[] arr = new int[n];
        int i = 0;

        do {
            System.out.print("[" + i + "] = ");
            arr[i] = new Scanner(System.in).nextInt();

            if (InputRequire(arr,i)!=1) {
                i++;
            }
        }
        while (i < n);

        System.out.print("Input Array: [");
        ExportArr(arr);
        System.out.print("]");
    }

    public static int InputRequire(int[] arr,int i) {
        int tempt=0;
        for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    System.out.print("Trùng với phần tử đã tồn tại. Mời nhập lại ");
                    tempt=1;
                    break;
                }
            }
        return tempt;
    }

    public static void ExportArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
    }
}

