import java.util.Scanner;
import java.lang.Math;

public class Exercise02 {
    public static void main(String[] args) {
        //Exercise 2: Giải và biện luận phương trình bậc hai ax2 + bx + c = 0, với a, b và c nhập vào từ bàn phím, a khác 0.
        Scanner scanner= new Scanner(System.in);

        System.out.println("Nhập a, với a khác 0: ");
        float a=scanner.nextFloat();
        System.out.println("Nhập b: ");
        float b=scanner.nextFloat();
        System.out.println("Nhập c: ");
        float c=scanner.nextFloat();

        double delta= Math.pow(b,2) - (4*a*c);
        String concl=(delta<0)? "vô nghiệm":(delta==0)? "có 2 nghiệm kép x1= x2= "+ (-b/(2*a)):
                    "có 2 nghiệm: x1= "+ ((-b-Math.sqrt(delta))/(2*a))+" và x2= "+((-b+Math.sqrt(delta))/(2*a));
        System.out.println("Kết luận phương trình: "+a+"x2"+" +"+b+"x"+" +"+c+" = 0 :"+ concl);
    }
}
