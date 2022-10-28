import java.util.Scanner;

public class Exercise06 {
    public static void main(String[] args) {
        //Bài 6: Hãy viết chương trình tính tổng các chữ số của một số nguyên bất kỳ. Ví dụ: Số 8545604 có tổng các chữ số là: 8+5+4+5+6+0+4=32
        System.out.print("Nhập một số nguyên bất kì: ");
        String n= new Scanner(System.in).nextLine();
        int i=0;
        String charIndex;
        int Sum=0;

        for (; i<String.valueOf(n).length() ; i++) {
            charIndex= String.valueOf(n.charAt(i));
            Sum+=Integer.valueOf(charIndex);
        }
        System.out.println("Tổng các chữ số là: "+Sum);
    }
}
