import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
    //Giải và biện luận phương trình bậc nhất ax + b = 0, với a và b nhập vào từ bàn phím.
        Scanner scanner= new Scanner(System.in);
        System.out.println("Nhập vào số a: ");
        float a=scanner.nextFloat();
        System.out.println("Nhập vào số b: ");
        float b=scanner.nextFloat();

        String concl=(a==0&&b!=0)? "Vô nghiệm":(a==0&&b==0)? "Vô số nghiệm": "Có nghiệm là: "+(-b/a);
        System.out.println("Kết luận phương trình "+a+"x + "+b+" = 0 : "+concl);
    }
}
