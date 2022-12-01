package entities;

public class Product {
    private static int AUTO_ID;
    private int id;
    private String productName;
    private String productType;
    private String description;
    private int price;

    public Product(String productName, String productType, String description, int price) {
        this.id = ++AUTO_ID;
        this.productName = productName;
        this.productType = productType;
        this.description = description;
        this.price = price;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  id +"\t"+ productName +"\t"+ productType +"\t"+ description +"\t"+ price;
    }
}
