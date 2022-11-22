import java.util.Scanner;

public class StudentAction {
    private int AUTO_ID;
    public Student inputInfo(Scanner scanner) {
        AUTO_ID++;
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        float scoreMath;
        float scorePhysic;
        float scoreChemistry;
        while (true) {
            try {
                System.out.println("Nhập điểm toán:");
                scoreMath = Float.parseFloat(scanner.nextLine());
                System.out.println("Nhập điểm lý:");
                scorePhysic = Float.parseFloat(scanner.nextLine());
                System.out.println("Nhập điểm hoá:");
                scoreChemistry = Float.parseFloat(scanner.nextLine());

                if (isValidScore(scoreMath, scorePhysic, scoreChemistry)) {
                    double scoreAverage = (scoreMath + scorePhysic + scoreChemistry) / 3;
                    String rank = rank(scoreAverage);
                    return new Student(AUTO_ID, name, scoreMath, scorePhysic, scoreChemistry, scoreAverage, rank);
                }
                System.out.println("Điểm của ít nhất 1 trong 3 môn bị sai. Điểm không được là số âm hoặc lớn hơn 10. Mời nhập lại");

            } catch (Exception error) {
                System.out.println("Lỗi định dạng: điểm phải là 1 số. Vui lòng nhập lại");
            }
        }
    }

    public boolean isValidScore(float scoreMath, float scorePhysic, float scoreChemistry) {
        if (scoreMath<0||scoreMath>10||scorePhysic<0||scorePhysic>10||scoreChemistry<0||scoreChemistry>10) {
            return false;
        }
        return true;
    }
    public String rank(double scoreAverage) {
        String rank;
        if (scoreAverage >=8) {
            rank ="A";
        } else if (scoreAverage<8 && scoreAverage>=6.5) {
            rank ="B";
        } else {
            rank = "C";
        }
        return rank;
    }
}
