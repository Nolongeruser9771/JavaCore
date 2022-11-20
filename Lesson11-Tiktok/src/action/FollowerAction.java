package action;

import entities.Follower;

import java.util.Scanner;

public class FollowerAction {
    private int AUTO_ID = 0;
    public Follower inputInfo(Scanner scanner) {
        AUTO_ID++;
        System.out.println("Nhập tên follower: ");
        String name = scanner.nextLine();
        System.out.println("Nhập email follower: ");
        String email = scanner.nextLine();
        System.out.println("Nhập số lượt like của follower này: ");
        int likeNum = Integer.parseInt(scanner.nextLine());

        Follower follower = new Follower(name, AUTO_ID, email, likeNum);
        return follower;
    }
}
