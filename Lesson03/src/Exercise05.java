import java.util.Scanner;

public class Exercise05 {
    public static void main(String[] args) {
        /* Bài 5: Một số được gọi là số thuận nghịch nếu ta đọc từ trái sang phải hay từ phải sang trái số đó ta vẫn
         nhận được một số giống nhau. Hãy nhập một số và kiểm tra xem số đó có phải số thuật nghịch hay không (ví dụ số: 558855).*/

        System.out.print("Nhập 1 số n có ít nhất 2 chữ số để kiểm tra: ");
        long n = new Scanner(System.in).nextLong();
        long tempt = n;
        long Number = 0;

        while (tempt > 0) {
            Number = Number*10 + tempt%10;
            tempt/=10;
        }

        if(Number==n) {
            System.out.println(n+" là số thuận nghịch");
        } else {
            System.out.println(n+" không là số thuận nghịch");
        }
    }
}
