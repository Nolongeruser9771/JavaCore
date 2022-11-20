package main;

import action.TeamAction;
import entities.SummonRift;
import entities.Team;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("---THÔNG TIN TRẬN ĐẤU---");
        ArrayList<Team> teams = new ArrayList<>();
        TeamAction teamAction = new TeamAction();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            System.out.println("Mời nhập thông tin team "+ (i+1));
            Team team = teamAction.inputInfo(scanner);
            teams.add(team);
        }

        System.out.println("Nhập thời gian diễn ra trận đấu theo định dạng dd/MM/yyyy: ");
        String date = scanner.nextLine();
        LocalDate matchDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        SummonRift summonRift = new SummonRift(teams, matchDate);
        System.out.println(summonRift);
    }
}