
import java.util.Scanner;

public class StudentAction {
    private int AUTO_ID = 0;
    public Student inputInfo(Scanner scanner) {
        AUTO_ID++;
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        System.out.println("Nhập địa chỉ");
        String address = scanner.nextLine();
        while (true) {
            try {
                int age;
                do {
                    System.out.println("Nhập tuổi");
                    age = Integer.parseInt(scanner.nextLine());
                    if (age > 0) {
                        break;
                    }
                    System.out.println("Nhập sai định dạng. Tuổi không thể là số bé hơn hoặc bằng 0");
                } while (true);
                return new Student(AUTO_ID, name, address, age);
            } catch (Exception error) {
                System.out.println("Nhập sai định dạng. Tuổi phải là một số");
            }
        }
    }
}
