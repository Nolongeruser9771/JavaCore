public class Lesson01_exercise04 {
    public static void main(String[] args) {
        //Exercise-4: Khai căn một số dương bất kì, kết quả làm tròn tới 3 chữ số thập phân.
        float i = 12.5f;
        double squarerooti = Math.sqrt(i);
        System.out.println("Căn bậc 2 của " + i + " là: " + (double) Math.round(squarerooti * 1000) / 1000);
    }
}