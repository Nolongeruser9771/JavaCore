import java.util.Arrays;
import java.util.Scanner;

public class Exercise20 {
    public static void main(String[] args) {
        //Bài 20: Thực hiện nhập vào một mảng số nguyên a có n phần tử (n>0) và một giá trị thực x.
        // Thực hiện sắp xếp mảng a theo thứ tự tăng dần và chèn giá trị x vào trong mảng a sao cho vẫn giữ được tính sắp xếp của mảng.


        System.out.println("Nhập số lượng phần tử của mảng: ");
        int n = new Scanner(System.in).nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = new Scanner(System.in).nextInt();
        }

        System.out.println("Nhập giá trị x: ");
        int x=new Scanner(System.in).nextInt();

        System.out.println("Mảng sau khi sắp xếp = " + Arrays.toString(bubbleSort(arr)));
        System.out.println("Mảng sau khi thêm giá trị x = " + Arrays.toString(insert(arr, x)));
    }

    public static  int[] bubbleSort(int[] arr) {
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
    public static int[] insert(int[] arr, int k) {
        int[] arr1 = bubbleSort(arr);
        int indexK=0;
        int[] arr2 = new int[arr1.length+1];

        for (int i = 0; i < arr1.length-1; i++) {
            if ((arr1[i] <= k) && (k < arr1[i + 1])) {
                indexK = i + 1;
            } else if (k>=arr1[arr1.length-1]) {
                indexK = arr1.length;
            }
        }
        for (int j = 0; j < arr2.length; j++) {
                if (j<indexK){
                    arr2[j]=arr1[j];
                }
                if(j==indexK) {
                    arr2[j] = k;
                }
                if(indexK<j) {
                    arr2[j] = arr1[j-1];
            }
        }
        return arr2;
    }

    //> c2: Thêm vào cuối dãy rồi sắp xếp lại;

//    public static int[] insertAndRebubbleSort(int [] arr, int k) {
//        int[] temptArr = new int[arr.length+1];
//        for (int i = 0; i < arr.length; i++) {
//            temptArr[i]=arr[i];
//        }
//            temptArr[temptArr.length-1] =k;
//        for (int i = 0; i < temptArr.length - 1; i++) {
//            for (int j = i + 1; j < temptArr.length; j++) {
//                if (temptArr[i] > temptArr[j]) {
//                    int value = temptArr[i];
//                    temptArr[i] = temptArr[j];
//                    temptArr[j] = value;
//                }
//            }
//        }
//        return temptArr;
//    }

}
