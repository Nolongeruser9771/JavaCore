public class Lesson01_exercise01 {
    public static void main(String[] args) {
        //Exercise-1: Tính chu vi và diện tích hình chữ nhật khi biết chiều dài và chiều rộng của chúng.
        int a = 30;
        float b = 12.25f;
        float C = (a + b) * 2;
        float S = a * b;
        System.out.println("Chu vi hình chữ nhật có chiều dài " + a + "cm và chiều rộng " + b + "cm là: " + C + "cm");
        System.out.println("Diện tích hình chữ nhật có chiều dài " + a + "cm và chiều rộng " + b + "cm là: " + S + "cm2");
    }
}