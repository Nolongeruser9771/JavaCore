import java.util.Scanner;

public class Exercise03 {
    public static void main(String[] args) {
        //Exercise 3: Nhập vào chiều dài và chiều rộng của hình chữ nhật, tính chu vi và diện tích của hình chữ nhật đó.
        Scanner scanner= new Scanner(System.in);

        System.out.println("Nhập chiều dài:");
        float a= scanner.nextFloat();
        System.out.println("Nhập chiều rộng:");
        float b= scanner.nextFloat();

        System.out.println("Chu vi của hình chữ nhật có chiều đài "+a+" và chiều rộng "+b+" là: "+((a+b)*2));
        System.out.println("Diện tích của hình chữ nhật có chiều đài "+a+" và chiều rộng "+b+" là: "+(a*b));
    }
}
