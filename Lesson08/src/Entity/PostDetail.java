package Entity;

public class PostDetail {
    ArticleType articleType;
    int quantity;

    public ArticleType getArticleType() {
        return articleType;
    }

    public void setArticleType(ArticleType articleType) {
        this.articleType = articleType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "PostDetail{" +
                "articleType=" + articleType +
                ", quantity=" + quantity +
                '}';
    }
}
