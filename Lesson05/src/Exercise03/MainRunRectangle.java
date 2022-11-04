package Exercise03;

import java.util.Scanner;

public class MainRunRectangle {
    public static void main(String[] args) {

        //Tạo HCM có kích thước, màu sắc nhập từ bàn phím. In thông tin, diện tích, chu vi
        Rectangle rectangle3 = new Rectangle();
        System.out.println("Nhập thông tin HCN: ");
        System.out.println("Chiều rộng: ");
        rectangle3.width = new Scanner(System.in).nextDouble();

        System.out.println("Chiều dài: ");
        rectangle3.height = new Scanner(System.in).nextDouble();

        System.out.println("Màu sắc: ");
        rectangle3.color = new Scanner(System.in).nextLine();

        System.out.println(rectangle3);
        System.out.println("Diện tích HCN: "+ rectangle3.findArea());
        System.out.println("Chu vi HCN: "+ rectangle3.findPerimeter());
    }
}
