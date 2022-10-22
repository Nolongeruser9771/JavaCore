public class Lesson01_exercise05 {
    public static void main(String[] args) {
        //Slide 48: Bài toán tính sin, cos của một góc trong tam giác vuông khi biết độ dài 3 cạnh.
        int AB = 22;
        int BC = 37;
        int AC = 56;
        double sin = (double) AB / AC;
        double cos = (double) BC / AC;
        System.out.println("Sin alpha của tam giác vuông ABC là: " + sin);
        System.out.println("Cos alpha của tam giác vuông ABC là: " + cos);
    }
}