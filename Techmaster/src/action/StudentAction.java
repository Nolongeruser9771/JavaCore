package action;

import entities.RankConstant;
import entities.Student;

import java.util.Scanner;

public class StudentAction {

    public Student inputInfo(Scanner scanner) {
        System.out.println("Nhập tên học sinh");
        String name = scanner.nextLine();

        String ageInput;
        do {
            System.out.println("Nhập tuổi học sinh");
            ageInput = scanner.nextLine();
        } while (!isAgeValid(ageInput));
        int age = Integer.parseInt(ageInput);

        String rankChoiceInput;
        do {
            System.out.println("Nhập học lực học sinh");
            System.out.println("1. Xuất Sắc");
            System.out.println("2. Giỏi");
            System.out.println("3. Khá");
            System.out.println("4. Trung Bình");
            System.out.println("5. Yếu");
            System.out.println("6. Kém");
            rankChoiceInput = scanner.nextLine();
        } while (!rankChoiceCheck(rankChoiceInput));
        String rank = rankReturn(Integer.parseInt(rankChoiceInput));

        return new Student(name, age, rank);
    }

    private boolean isAgeValid(String ageInput) {
        try {
            int age = Integer.parseInt(ageInput);
            if (age > 0 ) {
                return true;
            }
            System.out.println("Tuổi không thể là số âm");
            return false;
        } catch (Exception e) {
            System.out.println("Không đúng định dạng");
            return false;
        }
    }

    public static boolean rankChoiceCheck(String rankChoiceInput) {
        try {
            int rankChoice = Integer.parseInt(rankChoiceInput);
            if (rankChoice >= 1 && rankChoice <= 6) {
                return true;
            }
            System.out.println("Không có lựa chọn này");
            return false;
        } catch (Exception e) {
            System.out.println("Nhập không đúng định dạng");
            return false;
        }
    }

    public static String rankReturn(int rankChoice) {
        String rank = null;
        switch (rankChoice) {
            case 1:
                rank = RankConstant.XS.value;
                break;
            case 2:
                rank = RankConstant.G.value;
                break;
            case 3:
                rank = RankConstant.K.value;
                break;
            case 4:
                rank = RankConstant.TB.value;
                break;
            case 5:
                rank = RankConstant.Y.value;
                break;
            case 6:
                rank = RankConstant.KEM.value;
                break;
        }
        return rank;
    }
}
