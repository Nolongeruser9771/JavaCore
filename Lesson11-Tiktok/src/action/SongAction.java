package action;

import entities.Song;

import java.util.Scanner;

public class SongAction {
    private int AUTO_ID =0;
    public Song inputInfo(Scanner scanner) {
        AUTO_ID++;

        System.out.println("Nhập tên bài hát: ");
        String name = scanner.nextLine();
        System.out.println("Nhập tên ca sĩ: ");
        String singer = scanner.nextLine();

        Song song = new Song(AUTO_ID, name, singer);
        return song;
    }
}
