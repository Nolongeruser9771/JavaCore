package Logic_Handle;

import Entity.ArticleType;

import java.util.Scanner;

import static MainRun.Main.articleTypes;

public class ArticleFunction {

    public static void showNewArticleType() {
        for (int i = 0; i < articleTypes.length; i++) {
            if(articleTypes[i]!=null) {
                System.out.println(articleTypes[i]);
            }
        }
    }

    public static void addNewArticleType() {
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
}
