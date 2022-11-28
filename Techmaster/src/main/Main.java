package main;

import action.ClazzAction;
import entities.Clazz;
import entities.Student;
import entities.Techmaster;

import java.util.ArrayList;
import java.util.Scanner;

import static action.ClazzAction.*;

public class Main {
    static Techmaster techmaster;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu(ClazzAction.students);
        }
    }
    private static void showMenu(ArrayList<Student> students) {

        System.out.println("---LỚP HỌC TẠI TECHMASTER---");
        System.out.println("Mời chọn chức năng");
        System.out.println("1. Nhập thông tin trung tâm");
        System.out.println("2. Hiển thị thông tin trung tâm");
        System.out.println("3. Thêm học viên");
        System.out.println("4. Thay đổi học lực");
        System.out.println("5. Xoá học sinh nghỉ học");
        System.out.println("0. Thoát chương trình");

        String choiceInput;
        do {
            choiceInput = scanner.nextLine();
        } while (!functionChoiceCheck(choiceInput, students));
        int choice = Integer.parseInt(choiceInput);
        switch (choice) {
            case 1:
                inputTechmasterInfo(scanner);
                break;
            case 2:
                System.out.println(techmaster);
                break;
            case 3:
                System.out.println("Học viên đã thêm\n" + addNewStudent(scanner));
                break;
            case 4:
                changeRank(scanner);
                break;
            case 5:
                deleteStudent(scanner);
                break;
            case 0:
                System.exit(0);
        }
    }

    private static void inputTechmasterInfo(Scanner scanner) {
        System.out.println("Nhập tên quản lí học sinh");
        String clazzManagement = scanner.nextLine();
        System.out.println("Nhập tên giảng viên: ");
        String tutorName = scanner.nextLine();

        addNewSubject(scanner);
        addNewStudent(scanner);

        Clazz clazz = new Clazz(subjects,students);

        techmaster = new Techmaster(clazzManagement,tutorName,clazz);
    }


    private static boolean functionChoiceCheck(String choiceInput, ArrayList<Student> students) {
        try {
            int choice = Integer.parseInt(choiceInput);
            if (choice>=0 && choice <=5) {
                if (students.size()<=0 && choice!=0 && choice!=1) {
                    System.out.println("Bạn cần nhập thông tin lớp trước. Chọn 1 để nhập");
                    return false;
                }
                return true;
            }
            System.out.println("Không có lựa chọn trên. Mời nhập lại");
            return false;
        }catch (Exception e) {
            System.out.println("Nhập sai định dạng");
            return false;
        }
    }
}