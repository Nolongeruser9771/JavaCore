package Lab1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Nhập số lượng thành viên muốn thêm: ");
        int memNum;
        do {
            memNum = new Scanner(System.in).nextInt();
            if (memNum >= 3) {
                break;
            }
            System.out.println("Phải nhập ít nhất 3 thành viên");
        } while (true);

        ArrayList<Member> memberList = new ArrayList<>();
        for (int i = 0; i < memNum; i++) {
            Member member = new Member();
            member.inputInfo();
            memberList.add(member);
        }

        exportArrayList(memberList);

    }

    public static void exportArrayList(ArrayList<Member> memberList) {
        System.out.println("---THÔNG TIN THÀNH VIÊN---");
        for (Member member: memberList) {
            System.out.println(member);
        }
    }
}