package Logic_Handle;

import Entity.ArticleType;

import static MainRun.Main.articleManagements;
import static MainRun.Main.articleTypes;

public class PostLogic {
    public static ArticleType findPostById(int articleID) {
        ArticleType articleType = null;
        for (int i = 0; i < articleTypes.length; i++) {
            if (articleTypes[i] != null && articleTypes[i].getArticleID() == articleID) {
                articleType = articleTypes[i];
                break;
            }
        }
        return articleType;
    }
}
