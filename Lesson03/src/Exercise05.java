import java.util.Scanner;

public class Exercise05 {
    public static void main(String[] args) {
        /* Bài 5: Một số được gọi là số thuận nghịch nếu ta đọc từ trái sang phải hay từ phải sang trái số đó ta vẫn
         nhận được một số giống nhau. Hãy nhập một số và kiểm tra xem số đó có phải số thuật nghịch hay không (ví dụ số: 558855).*/

        System.out.print("Nhập 1 số n để kiểm tra: ");
        String n= new Scanner(System.in).nextLine();
        int i=String.valueOf(n).length();
        String nreverse = "";

        for (; i >0 ; i--) {
           nreverse+=n.charAt(i-1);
        }
            int a=Integer.valueOf(nreverse);
            int b=Integer.valueOf(n);
            if(a==b) {
                System.out.println(n+" là số thuận nghịch");
            } else {
                System.out.println(n+" không là số thuận nghịch");
            }
    }
}
