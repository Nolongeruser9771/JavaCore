package action;

import entities.Follower;
import entities.Idol;

import java.util.ArrayList;
import java.util.Scanner;

public class IdolAction {

    private int AUTO_ID =0;

    public Idol inputInfo(Scanner scanner) {
        AUTO_ID++;

        System.out.println("Nhập tên idol: ");
        String name = scanner.nextLine();
        System.out.println("Nhập email idol: ");
        String email = scanner.nextLine();
        System.out.println("Nhập nhóm của idol: ");
        String group = scanner.nextLine();

        ArrayList<Follower> followers = new ArrayList<>();

        System.out.println("Idol này có bao nhiêu followers: ");
        int followerNum = Integer.parseInt(scanner.nextLine());
        FollowerAction followerAction = new FollowerAction();

        for (int i = 0; i < followerNum; i++) {
        Follower follower = followerAction.inputInfo(scanner);
        followers.add(follower);
        }

        Idol idol = new Idol(name, AUTO_ID, email, group, followers);
        return idol;
    }
}
