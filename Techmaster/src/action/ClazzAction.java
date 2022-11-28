package action;

import entities.Student;
import entities.Subject;

import java.util.ArrayList;
import java.util.Scanner;

public class ClazzAction {
    static StudentAction studentAction = new StudentAction();
    public static ArrayList<Subject> subjects = new ArrayList<>();
    public static ArrayList<Student> students = new ArrayList<>();


    private static boolean isValidNumber(String studentNumInput) {
        try {
            int studentNum = Integer.parseInt(studentNumInput);
            if (studentNum<=0) {
                System.out.println("Số lượng học viên phải lớn hơn 0");
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println("Không đúng định dạng");
            return false;
        }
    }

    public static void addNewSubject(Scanner scanner) {
        String subjectNumInput;
        do {
            System.out.println("Bạn muốn thêm bao nhiêu môn học");
            subjectNumInput = scanner.nextLine();
        } while (!isValidNumber(subjectNumInput));
        int subjectNum = Integer.parseInt(subjectNumInput);

        for (int i = 0; i < subjectNum; i++) {
            System.out.println("Tên môn học thứ " + (i + 1));
            String subjectName = scanner.nextLine();
            subjects.add(new Subject(subjectName));
        }
    }
    public static ArrayList<Student> addNewStudent(Scanner scanner) {
        String studentNumInput;
        do {
            System.out.println("Bạn muốn thêm bao nhiêu học viên");
            studentNumInput = scanner.nextLine();
        } while (!isValidNumber(studentNumInput));
        int studentNum = Integer.parseInt(studentNumInput);

        for (int i = 0; i < studentNum; i++) {
            System.out.println("=== Thông tin hoc sinh thứ " + (i + 1) + " ===");
            students.add(studentAction.inputInfo(scanner));
        }
        return students;
    }

    public static void changeRank(Scanner scanner) {
        String idInput;
        Student student;
        while (true) {
            try {
                System.out.println("Nhập id học viên muốn tìm");
                idInput = scanner.nextLine();
                int id = Integer.parseInt(idInput);
                student = findById(id);
                if (student!=null) {
                    System.out.println(student);
                    String rankChoiceInput;
                    do {
                        System.out.println("Muốn thay đổi học lực học sinh này thành loại gì?");
                        System.out.println("1. Xuất Sắc");
                        System.out.println("2. Giỏi");
                        System.out.println("3. Khá");
                        System.out.println("4. Trung Bình");
                        System.out.println("5. Yếu");
                        System.out.println("6. Kém");
                        rankChoiceInput = scanner.nextLine();
                    } while (!StudentAction.rankChoiceCheck(rankChoiceInput));
                    String newRank = StudentAction.rankReturn(Integer.parseInt(rankChoiceInput));
                    student.setRank(newRank);
                    System.out.println("Thay đổi học lực thành công!");
                    return;
                }
                System.out.println("Không có học viên có id "+ id);
            } catch (Exception e) {
                System.out.println("Lỗi định dạng nhập liệu");
            }
        }
    }

    private static Student findById(int id) {
        Student student = null;
        for (Student checkedStudent : students) {
            if (checkedStudent != null && checkedStudent.getId() == id) {
                student = checkedStudent;
                break;
            }
        }
        return student;
    }

    public static void deleteStudent(Scanner scanner) {
        String idInput;
        Student student;
        while (true) {
            try {
                System.out.println("Nhập id học viên muốn xoá");
                idInput = scanner.nextLine();
                int id = Integer.parseInt(idInput);
                student = findById(id);
                if (student != null) {
                    System.out.println(student);
                    students.remove(student);
                    System.out.println("Xoá học viên thành công!");
                    return;
                }
                System.out.println("Không có học viên id "+ id);
            } catch (Exception e) {
                System.out.println("Lỗi định dạng nhập liệu");
            }
        }
    }
}
