package action;

import entities.Figure;
import entities.Team;

import java.util.ArrayList;
import java.util.Scanner;

public class TeamAction {
    private int AUTO_ID;
    public Team inputInfo(Scanner scanner) {
        AUTO_ID++;
        int i = 0;
        ArrayList<Figure> figures = new ArrayList<>();
        FigureAction figureAction = new FigureAction();
        while (i<5) {
        Figure figure = figureAction.inputInfo(scanner);
        figures.add(figure);
        i++;
        }
        Team team = new Team(AUTO_ID, figures);
        return team;
    }
}
