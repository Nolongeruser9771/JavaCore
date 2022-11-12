package MainRun;

import Constant.JounalistType;
import Entity.ArticleManagement;
import Entity.ArticleType;
import Entity.Jounalist;

import java.util.Scanner;

import static Logic_Handle.ArticleFunction.addNewArticleType;
import static Logic_Handle.ArticleFunction.showNewArticleType;
import static Logic_Handle.ArticleMangamentFunction.*;
import static Logic_Handle.JounalistFunction.addNewJournalist;
import static Logic_Handle.JounalistFunction.showNewJournalist;
import static Logic_Handle.sortMenuLogic.showSortMenu;

public class Main {

    public static Jounalist[] jounalists = new Jounalist[100];
    public static ArticleType[] articleTypes = new ArticleType[100];
    public static ArticleManagement[] articleManagements = new ArticleManagement[100];

    public static void main(String[] args) {
        while (true) {
            ShowMenu();
            functionChoice();
        }
    }
    private static void ShowMenu() {
        System.out.println("----CHƯƠNG TRÌNH QUÁN LÝ PHÓNG VIÊN----");
        System.out.println("Chọn chức năng bên dưới: ");
        System.out.println("1. Nhập và in DS phóng viên");
        System.out.println("2. Nhập và in danh sách kiểu bài viết");
        System.out.println("3. Bảng tính công");
        System.out.println("4. Sắp xếp");
        System.out.println("5. Lập bảng thu kê thu nhập");
        System.out.println("6. Thoát");
    }

    private static void functionChoice() {
        int functionChoice;
        do {
            functionChoice = new Scanner(System.in).nextInt();
            if(functionChoice >=1 && functionChoice <=6) {
                break;
            }
            System.out.println("Sai loại. mời nhập lại");
        } while (true);
        switch (functionChoice) {
            case 1:
                addNewJournalist();
                showNewJournalist();
                break;
            case 2:
                addNewArticleType();
                showNewArticleType();
                break;
            case 3:
                addNewArticleManagementInfo();
                break;
            case 4:
                showSortMenu();
                break;
            case 5:
                break;
            case 6:
                System.exit(0);
        }
    }
}