public class Lesson01_exercise09 {
    public static void main(String[] args) {
        /*Slide 61: Tìm thương của 2 số nguyên, làm tròn kết quả tới 3 chữ số thập phân.*/
        int n1=20;
        int n2=70;
        double div12=(double)n1/n2;
        System.out.println("Thương của "+n1+" và "+n2+" là: "+ (double)Math.round(div12*1000)/1000);;
    }
}