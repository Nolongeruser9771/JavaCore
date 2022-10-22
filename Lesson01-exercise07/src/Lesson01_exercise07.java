public class Lesson01_exercise07 {
    public static void main(String[] args) {
        //Slide 58: Giải phương trình bậc nhất hai một ẩn ax2 + bx + c = 0 (với a khác 0).
        int a=2;
        int b=14;
        int c=2;
        double delta= Math.pow(b,2) -4*a*c;
        if(delta<0) {
            System.out.println("Phương trình vô nghiệm");
        } else if(delta==0) {
            System.out.println("Phương trình có một nghiệm là: " + (-b / 2 * a));
        } else {
            System.out.println("Phương trình có nghiệm x1="+ (Math.sqrt(delta)-b)/(2*a)+" và x2="+(-Math.sqrt(delta)-b)/(2*a));
        };
    }
}