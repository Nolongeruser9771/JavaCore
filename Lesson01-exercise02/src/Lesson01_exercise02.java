public class Lesson01_exercise02 {
    public static void main(String[] args) {
        //Exercise-2: Tính chu vi và diện tích hình tròn khi biết bán kính của nó.
        float r = 12.5f;
        double Cr = (r * 2) * Math.PI;
        double Sr = Math.pow(r, 2) * Math.PI;
        System.out.println("Chu vi hình tròn có bán kính " + r + "cm là: " + Cr + "cm");
        System.out.println("Diện tích hình tròn có bán kính " + r + "cm là: " + Sr + "cm2");
    }
}