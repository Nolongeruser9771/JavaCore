import java.util.Scanner;

public class Exercise05 {
    public static void main(String[] args) {
        /* Exercise 5a. Nhập vào một chuỗi bất kỳ và một ký tự nào đó. Tìm kiếm vị trí xuất hiện đầu tiên và cuối cùng của ký tự đó trong chuỗi vừa nhập.*/
        Scanner scanner= new Scanner(System.in);
        System.out.println("Nhập vào một chuỗi kí tự bất kì");
        String str= scanner.nextLine();
        System.out.println("Nhập vào 1 kí tự bất kì");
        String character=scanner.nextLine();

        System.out.println("Vị trí xuất hiện đầu tiên của kí tự "+character+" trong chuỗi vừa nhập: "+ str.indexOf(character,0));
        System.out.println("Vị trí xuất hiện cuối cùng của kí tự "+character+" trong chuỗi vừa nhập: "+ str.lastIndexOf(character));

        /* Exercise 5b. Nhập 3 xâu ký tự ký tự s, s1, s2. Tìm tất cả những lần xuất hiện của s1 trong s và thay thế bằng s2. Xuất s ra màn hình Ví dụ:
        s = “TIM KIEM VA THAY THE”, s1 = “TH”, s2 = “123”. Kết quả xâu ký tự s sẽ là: “TIM KIEM VA 123AY 123E”*/
        System.out.println("Nhập vào chuỗi kí tự s");
        String s= scanner.nextLine();
        System.out.println("Nhập vào chuỗi kí tự s1");
        String s1= scanner.nextLine();
        System.out.println("Nhập vào chuỗi kí tự s2");
        String s2= scanner.nextLine();
        System.out.println("Kết quả sau khi thay s1 bằng s2 là: "+s.replace(s1,s2));
        }
}
