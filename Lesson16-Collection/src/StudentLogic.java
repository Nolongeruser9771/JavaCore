import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StudentLogic implements StudentService<Student>{
    public Student InfoInput(Scanner scanner){
        String name, ageInput, scoreInput;
        System.out.println("Mời nhập tên học sinh: ");
        name = scanner.nextLine();
        do {
            System.out.println("Mời nhập tuổi học sinh: ");
            ageInput = scanner.nextLine();
        } while (!isNumberValid(ageInput));
        int age = Integer.parseInt(ageInput);

        do {
            System.out.println("Mời nhập điểm học sinh: ");
            scoreInput = scanner.nextLine();
        }while (!isScoreValid(scoreInput));
        float score = Float.parseFloat(scoreInput);
        return new Student(name,age,score);
    }


    public Student getStudentById(int id, Map<Integer, Student> map){
        return map.get(id);
    }

    public boolean isNumberValid(String numberInput) {
        try {
            if (Integer.parseInt(numberInput)>0) {
                return true;
            }
            System.out.println("Dữ liệu phải lớn hơn 0");
            return false;
        } catch (Exception e) {
            System.out.println("Dữ liệu không hợp lệ. Mời nhập lại!");
            return false;
        }
    }

    public boolean isScoreValid(String numberInput) {
        try {
            if (Float.parseFloat(numberInput)>=0 && Float.parseFloat(numberInput)<=10) {
                return true;
            }
            System.out.println("Điểm phải nằm trong khoảng 0 đến 10");
            return false;
        } catch (Exception e) {
            System.out.println("Dữ liệu không hợp lệ. Mời nhập lại!");
            return false;
        }
    }

    @Override
    public void updateStudent(int id, Student object, Map<Integer, Student> map) {
        for (Map.Entry<Integer,Student> entry: map.entrySet()) {
            if (entry.getKey() == id) {
                object.setId(id);
                entry.setValue(object);
                break;
            }
        }
    }

    public void showList(Map<Integer, Student> map) {
        for (Map.Entry<Integer,Student> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
