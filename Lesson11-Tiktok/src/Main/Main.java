package Main;

import action.IdolAction;
import action.SongAction;
import action.TiktokAction;
import entities.Idol;
import entities.Song;
import entities.Tiktok;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bạn cần khởi tạo bao nhiêu tài khoản tiktok: ");
        int num = new Scanner(System.in).nextInt();

        ArrayList<Tiktok> tiktoks = new ArrayList<>();
        TiktokAction tiktokAction = new TiktokAction();
        for (int i = 0; i < num; i++) {
            Scanner scanner = new Scanner(System.in);
            Tiktok tiktok = tiktokAction.getInfo(scanner);
            tiktoks.add(tiktok);
        }

        showTiktok(tiktoks);
    }
    public static void showTiktok(ArrayList<Tiktok> tiktoks) {
        for (Tiktok tiktok: tiktoks) {
            System.out.println(tiktok);
        }
    }
}