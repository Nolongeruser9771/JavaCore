package Entity;

import java.util.Scanner;

public class ArticleType implements Inputable{

    private static int AUTO_ID=100;
    private int articleID;
    private String articleName;
    private double price;

    public int getArticleType() {
        return articleID;
    }

    public void setArticleType(int articleType) {
        this.articleID = articleType;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ArticleType{" +
                "articleID='" + articleID + '\'' +
                ", articleName='" + articleName + '\'' +
                ", price=" + price +
                '}';
    }
    @Override
    public void inputInfo() {
        AUTO_ID++;
        this.articleID = AUTO_ID;
        System.out.println("Nhập tên bài: ");
        this.articleName = new Scanner(System.in).nextLine();
        System.out.println("Nhập đơn giá: ");
        this.price = new Scanner(System.in).nextDouble();
    }
}
