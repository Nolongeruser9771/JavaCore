public class Lesson01_exercise08 {
    public static void main(String[] args) {
        //Exercise 8: Tìm số lớn nhất trong 3 số nguyên a, b, c. Sử dụng lớp Math hỗ trợ.
        int a=5;
        int b=7;
        int c=78;
        int Maxab=Math.max(a,b);
        int Maxabc=Math.max(Maxab,c);
        System.out.println("Số nguyên lớn nhất trong 3 số: "+a+","+b+","+c+" là: "+Maxabc);
    }
}