public class Exercise02 {
    public static void main(String[] args) {
        /*Bài 2: Viết chương trình liệt kê các số nguyên có 7 chữ số thoả mãn:
        a) Là số nguyên tố.
        b) Tất cả các chữ số là nguyên tố
        c) Đảo của nó cũng là một số nguyên tố*/

        for (long i = 100000; i <10000000 ; i++) {
            if(kiemTraSNT(i) && kiemTraChuSo(i) && soThuanNghich(i)) {
                System.out.println(i);
            }
        }
    }


    public static boolean kiemTraSNT(long n) {
        boolean check=true;

        for (long i = 100000; i < Math.sqrt(n); i++) {
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }

        public static boolean kiemTraChuSo(long n){
            long tempt = n;
            long number = 0;
            while (tempt > 0) {
                number = tempt % 10;
                tempt /= 10;
                if (number != 2 && number != 3 && number != 5 && number != 7) {
                    return false;
                }
            }
            return true;
        }

        public static boolean soThuanNghich ( long n){
            long tempt = n;
            long number = 0;
            while (tempt > 0) {
                number = number * 10 + tempt % 10;
                tempt /= 10;
            }
            if ((number == n)) {
                return true;
            }
            return false;
        }
    }
