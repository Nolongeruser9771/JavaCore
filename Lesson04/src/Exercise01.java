import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        /* Bài 1: Viết chương trình liệt kê các số nguyên có 7 đến 9 chữ số thoả mãn:
            a) Là số thuận nghịch.
            b) Chỉ có chữ số 0, 6, 8
            c) Tổng chữ số chia hết cho 10*/

        for (long i = 1000000; i < 1000000000; i++) {
            if(soThuanNghich(i)==i && chuaChuSo(i) && tongChuSo(i)%10==0) {
                System.out.println(i);
            }
        }
    }

    public static long soThuanNghich(long n) {
        long number = 0;
        long tempt = n;
        while (tempt > 0) {
            number = number * 10 + tempt % 10;
            tempt /= 10;
        }
        return number;
    }

    public static boolean chuaChuSo(long n) {
        long tempt = n;
//
        while (tempt > 0) {
            if (tempt % 10 != 0 && tempt % 10 != 6 && tempt % 10 != 8) {
                return false;
            }
            tempt /= 10;
        }
        return true;
    }

    public static long tongChuSo(long n) {
        long tempt =n;
        int S=0;

        while (tempt>0) {
            S += tempt % 10;
            tempt/=10;
        }
        return S;
    }
}

