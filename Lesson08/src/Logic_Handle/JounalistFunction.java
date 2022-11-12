package Logic_Handle;

import Entity.Jounalist;

import java.util.Scanner;

import static MainRun.Main.jounalists;

public class JounalistFunction {
    public static void showNewJournalist() {
        for (int i = 0; i < jounalists.length; i++) {
            if(jounalists[i]!=null) {
                System.out.println(jounalists[i]);
            }
        }
    }

    public static void addNewJournalist() {
        System.out.println("Nhập số lượng phóng viên muốn thêm: ");
        int JournalNum = new Scanner(System.in).nextInt();
        for (int i = 0; i < JournalNum; i++) {
            Jounalist journal = new Jounalist();
            journal.inputInfo();
            saveJournalInfo(journal);
        }
    }

    private static void saveJournalInfo(Jounalist journal) {
        for (int i = 0; i < jounalists.length; i++) {
            if(jounalists[i]==null) {
                jounalists[i] = journal;
                break;
            }
        }
    }
}
