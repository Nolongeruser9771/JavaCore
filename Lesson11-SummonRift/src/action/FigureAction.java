package action;

import entities.Figure;

import java.util.Scanner;

public class FigureAction {
    private int AUTO_ID = 0;
    public Figure inputInfo(Scanner scanner) {
        AUTO_ID++;
        System.out.println("Nhập tên vị tướng: ");
        String name = scanner.nextLine();
        System.out.println("Nhập vị trí đánh của vị tướng này: ");
        String position = scanner.nextLine();

        Figure figure = new Figure(AUTO_ID, name, position);
        return figure;
    }
}
