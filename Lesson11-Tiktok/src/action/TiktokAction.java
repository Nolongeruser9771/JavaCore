package action;

import entities.Idol;
import entities.Song;
import entities.Tiktok;

import java.util.ArrayList;
import java.util.Scanner;

public class TiktokAction {

    IdolAction  idolAction = new IdolAction();
    public Tiktok getInfo(Scanner scanner) {

        Idol idol = idolAction.inputInfo(scanner);

        ArrayList<Idol> idols = new ArrayList<>();
        idols.add(idol);


        System.out.println("Idol này hát bao nhiêu bài: ");
        int songNum = Integer.parseInt(scanner.nextLine());
        ArrayList<Song> songs = new ArrayList<>();
        SongAction songAction = new SongAction();

        for (int i = 0; i < songNum; i++) {
        Song song = songAction.inputInfo(scanner);
        songs.add(song);
        }

        Tiktok tiktok = new Tiktok(idols, songs);
        return tiktok;
    }
}
