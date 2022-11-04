public class Exercise18 {
    public static void main(String[] args) {
        //Bài 18: Viết chương trình liệt kê các số thuận nghịch có 6 chữ số mà tổng chữ số chia hết cho 10 (ví dụ số: 721127).

        for (int i = 100000; i <1000000 ; i++) {
            if (KTSoThuanNghich(i) && tongChuSo(i)) {
                System.out.println(i + "\t");
            }
        }

    }
    public static boolean KTSoThuanNghich(int i) {
        int tempt= i;
        int number = 0;

        while(tempt>0) {
            number = number*10 + tempt%10;
            tempt/=10;
        }
        if (number!=i) {
            return false;
        }
        return true;
    }

    public static boolean tongChuSo(int i) {
        int sum =0;
        while(i>0) {
            sum += i%10;
            i/=10;
        }
        if (sum%10!=0) {
            return false;
        }
        return true;
    }
}
