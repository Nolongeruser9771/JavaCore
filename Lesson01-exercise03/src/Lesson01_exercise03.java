public class Lesson01_exercise03 {
    public static void main(String[] args) {
        //Exercise-3: Tìm số lớn nhất trong 4 số biết trước.
        int x1 = 20;
        int x2 = 4;
        int x3 = 15;
        int x4 = 12;
        int Max12 = Math.max(x1, x2);
        int Max34 = Math.max(x3, x4);
        System.out.println("Số lớn nhất trong 4 số: " + x1 + "," + x2 + "," + x3 + "," + x4 + " là: " + Math.max(Max12, Max34));
    }
}