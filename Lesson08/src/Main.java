import Constant.JounalistType;
import Entity.ArticleManagement;
import Entity.ArticleType;
import Entity.Jounalist;

import java.util.Scanner;

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

    private static void addNewArticleManagement() {
        System.out.println("Lập bảng cho bao nhiêu phóng viên?");
        int articleNum = new Scanner(System.in).nextInt();
        for (int i = 0; i < articleNum; i++) {
            System.out.println("Nhập thông tin tính công cho phóng viên :"+ (i+1));
            System.out.println("Nhập mã phóng viên muốn tính công");
            int JournalistID = new Scanner(System.in).nextInt();
            Jounalist jounalist;
            for (int j = 0; j < jounalists.length; j++) {
                if(jounalists[j].getId()== JournalistID) {
                    jounalist = jounalists[i];
                    break;
                }
            }
            System.out.println("Nhập số lượng loại bài viết mà phóng viên này đã viết:");
            int articleNumber = new Scanner(System.in).nextInt();
            for (int j = 0; j < articleNumber; j++) {
                System.out.println("Nhập thông tin thể loại bài thứ "+ (j+1));
                System.out.println("Nhập id của loại bi viết thứ "+ (j+1));
                int articleID = new Scanner(System.in).nextInt();
                ArticleType articleType = null;
                int article_ID = new Scanner(System.in).nextInt();


            }
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
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                System.exit(0);
        }
    }

    private static void showNewArticleType() {
        for (int i = 0; i < articleTypes.length; i++) {
            if(articleTypes[i]!=null) {
                System.out.println(articleTypes[i]);
            }
        }
    }

    private static void addNewArticleType() {
        System.out.println("Nhập số lượng bài muốn thêm: ");
        int articleNum = new Scanner(System.in).nextInt();
        for (int i = 0; i < articleNum; i++) {
            ArticleType articleType = new ArticleType();
            articleType.inputInfo();
            saveArticleInfo(articleType);
        }
    }

    private static void saveArticleInfo(ArticleType articleType) {
        for (int i = 0; i < articleTypes.length; i++) {
            if(articleTypes[i]==null) {
                articleTypes[i] = articleType;
                break;
            }
        }
    }

    private static void showNewJournalist() {
        for (int i = 0; i < jounalists.length; i++) {
            if(jounalists[i]!=null) {
                System.out.println(jounalists[i]);
            }
        }
    }

    private static void addNewJournalist() {
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