import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Student> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        StudentLogic studentLogic = new StudentLogic();
        
        String studentNumInput;
        int i = 0;
        //Nhập studentNum số học sinh
        do {
            System.out.println("Bạn muốn nhập bao nhiêu học sinh:");
            studentNumInput = scanner.nextLine();
        }while (!studentLogic.isNumberValid(studentNumInput));
        int studentNum = Integer.parseInt(studentNumInput);
        
        //Nhập thông tin học sinh của studentNum học sinh + lưu vào map
        while (i<studentNum) {
            Student student = studentLogic.InfoInput(scanner);
            map.put(student.getId(), student);
            i++;
        }
        studentLogic.showList(map);
        
        //Tìm student bằng Id.
        String idInput;
        boolean flag;
        int id = 0;
        do {
            flag = true;
            try {
                System.out.println("Mời bạn nhập id của học sinh cần tìm:");
                idInput = scanner.nextLine();
                id = Integer.parseInt(idInput);
                //Nếu kết quả tìm id bằng null thì thông báo và yêu cầu nhập lại
                if (studentLogic.getStudentById(id, map) == null) {
                    System.out.println("Không có học sinh có id " + id + ". Mời nhập lại");
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Dữ liệu không hợp lệ!");
                flag = false;
            }
        } while (!flag);
        System.out.println("Thông tin của học sinh có id "+ id + " là: ");
        System.out.println(studentLogic.getStudentById(id, map));

        System.out.println("Mời nhập thông tin update của học sinh này: ");
        Student addedStudent = studentLogic.InfoInput(scanner);
        studentLogic.updateStudent(id,addedStudent,map);

        System.out.println("Danh sách học sinh sau khi được update:");
        studentLogic.showList(map);
    }
}