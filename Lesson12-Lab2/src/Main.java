import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        StudentAction studentAction = new StudentAction();

        System.out.println("Bạn muốn nhập điểm cho bao nhiêu học sinh");
        int studentNum;
        while (true) {
            try {
                do {
                    studentNum = Integer.parseInt(scanner.nextLine());
                    if (studentNum>0) {
                        break;
                    }
                    System.out.println("Số lượng học sinh không thể âm hoặc bằng 0\nMời Nhập lại");
                }while (true);
                for (int i = 0; i < studentNum; i++) {
                    System.out.println("Nhập thông tin và điểm của học sinh thứ " + (i + 1));
                    Student student = studentAction.inputInfo(scanner);
                    students.add(student);
                }
                System.out.println(students);
                System.out.println("Tỉ lệ học sinh loại A là: " + rateCal(students).getaRate());
                System.out.println("Tỉ lệ học sinh loại B là: " + rateCal(students).getbRate());
                System.out.println("Tỉ lệ học sinh loại C là: " + rateCal(students).getcRate());
                return;
            } catch (Exception error) {
                System.out.println("Số lượng học sinh không hợp lệ \nMời Nhập lại số lượng học sinh");
            }
        }
    }

    private static ClassAverageRate rateCal(ArrayList<Student> students) {
        int aNum = 0;
        int bNum = 0;
        int cNum = 0;
        int studentNum = students.size();

        for (Student student : students) {
            if (student.getRank().equals("A")) {
                aNum++;
            } else if (student.getRank().equals("B")) {
                bNum++;
            } else {
                cNum++;
            }
        }
        return new ClassAverageRate((float)aNum/studentNum, (float)bNum/studentNum, (float)cNum/studentNum);
    }
}