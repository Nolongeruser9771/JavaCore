import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercise04 {
    public static void main(String[] args) {
        /*Nhập vào ngày tháng năm sinh của một người theo định dạng nhất định, tính tuổi của người đó
        (chỉ quan tâm tới năm, không cần tính chính xác tới ngày và tháng).
         */
        Scanner scanner= new Scanner(System.in);
        System.out.println("Nhập năm sinh của bạn theo định dạng dd/MM/yyyy:");
        String BD= scanner.nextLine();
        LocalDate birth= LocalDate.parse(BD, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        int age= LocalDate.now().getYear()-birth.getYear();
        System.out.println("Tuổi của bạn: "+age);
    }
}
