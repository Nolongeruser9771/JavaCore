package Exercise01;

//Bài 1: Viết chương trình tạo lập lớp Sinh viên với các thuộc tính mã sinh viên, tên sinh viên, lớp, khóa.
// Khởi tạo một sinh viên với các giá trị nhập từ bàn phím. In thông tin sinh viên ra màn hình.

import java.util.Scanner;

public class MainRunStudent {
    public static void main(String[] args) {
        System.out.println("Nhập thông tin học viên: ");
        Student student1 = new Student();

        System.out.print("ID: ");
            student1.id = new Scanner(System.in).nextLine();
        System.out.print("Name: ");
            student1.name = new Scanner(System.in).nextLine();
        System.out.print("Class: ");
            student1.Class = new Scanner(System.in).nextLine();
        System.out.print("School Year: ");
            student1.schoolYear = new Scanner(System.in).nextLine();

        student1.showInfo();
    }
}
