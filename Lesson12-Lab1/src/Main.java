import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();
    static StudentAction studentAction = new StudentAction();

    public static void main(String[] args) {
        System.out.println("Mời bạn nhập thông tin học viên");
        while (students.isEmpty() || isAllowInput()) {
            Student stu = studentAction.inputInfo(scanner);
            students.add(stu);
            System.out.println("Bạn có muốn nhập thông tin học viên tiếp theo không");
            System.out.println("1. Có");
            System.out.println("2. Không");
        }
        System.out.println(students);
    }
    private static boolean isAllowInput() {
        int choice;
        while (true) {
            try {
                do {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice == 1 || choice == 2) {
                        break;
                    }
                    System.out.println("Không có lựa chọn trên " + choice +". Mời chọn lại");
                } while (true);
                return choice != 2;
            } catch (Exception error) {
                System.out.println("Nhập sai định dạng. Lựa chọn phải là số nguyên");
            }
        }
    }
}