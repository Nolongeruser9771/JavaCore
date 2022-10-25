import java.util.Scanner;

public class Exercise06 {
    public static void main(String[] args) {
        //Exercise 6: Nhập bán kính hình tròn, tính diện tích hình tròn đó
        Scanner scanner= new Scanner(System.in);
        System.out.println("Nhập bán kính R của hình tròn: ");
        float R=scanner.nextFloat();
        double S=Math.pow(R,2)*Math.PI;
        System.out.println("Diện tích hình tròn là S= "+S);
    }
}
