package Logic_Handle;

import Entity.ArticleManagement;
import Entity.ArticleType;
import Entity.Jounalist;
import Entity.PostDetail;
import MainRun.Main;

import java.util.Scanner;

import static MainRun.Main.*;

public class ArticleMangamentFunction {


    public static void addNewArticleManagementInfo() {
        if (!isOfNull()){
            System.out.println("Bạn cần có dữ liệu để phân công");
            return;
        }
        System.out.println("Muốn lập bảng cho bao nhiêu phóng viên: ");
        int journalistNum = new Scanner(System.in).nextInt();
        for (int i = 0; i < journalistNum; i++) {
            System.out.println("Phân công cho phóng viên thứ "+ (i+1));
            System.out.println("Nhâp ID của phóng viên thứ "+ (i+1));
            Jounalist jounalist;
            int JounalistID;
            do {
                JounalistID = new Scanner(System.in).nextInt();
                jounalist = JournalistLogic.findJounalistById(JounalistID);
                if(jounalist!=null) {
                    break;
                }
                System.out.println("Không tìm thấy ID "+ JounalistID);
            } while (true);
            System.out.println("Nhập số lượng loại bài viết phóng viên này đã viết: ");
            int postNum =new Scanner(System.in).nextInt();
            PostDetail[] postDetails = new PostDetail[postNum];
            int count = 0;
            int totalPost = 0;
            for (int j = 0; j < postNum; j++) {
                System.out.println("Nhập id loại bài viết thứ " + (j+1));
                int articleID;
                ArticleType articleType=null;
                do {
                    articleID = new Scanner(System.in).nextInt();
                    articleType = PostLogic.findPostById(articleID);
                    if(articleType != null) {
                        break;
                    }
                    System.out.println("Không tìm thấy ID bài viết "+ articleID);
                } while (true);
                System.out.println("Nhập số lượng bài viết thể loại này");
                int articleQuantity = new Scanner(System.in).nextInt();
                postDetails[count] = new PostDetail(articleType,articleQuantity);
                totalPost+= articleQuantity;
                count++;
            }
            ArticleManagement articleManagement = new ArticleManagement(jounalist,postDetails);
            saveArticleManagementInfo(articleManagement);
            articleManagement.
        }
        showArticleManagementInfo();
        }


    public static boolean isOfNull() {
        boolean articleCheck = false;
        boolean jounalistCheck = false;
        for (int i = 0; i < articleTypes.length; i++) {
            if (articleTypes[i]!=null) {
                articleCheck  = true;
                break;
            }
        }
        for (int i = 0; i < jounalists.length; i++) {
            if(jounalists[i]!=null) {
                jounalistCheck =true;
                break;
            }
        }
        return  articleCheck && jounalistCheck;
    }

    private static void saveArticleManagementInfo(ArticleManagement articleManagement) {
        for (int i = 0; i < Main.articleManagements.length; i++) {
            if(Main.articleManagements[i] == null ) {
                Main.articleManagements[i] = articleManagement;
                break;
            }
        }
}
    public static void showArticleManagementInfo() {
        for (int i = 0; i < Main.articleManagements.length; i++) {
            if(Main.articleManagements[i] != null) {
                System.out.println(Main.articleManagements[i]);
            }
        }
    }
}

