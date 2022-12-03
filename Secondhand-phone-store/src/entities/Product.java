package entities;

public class Product {
    private static int AUTO_ID;
    private int id;
    private String productName;
    private String productType;
    private String description;
    private int price;
    private int stock;
    private String stockStatus;
    public Product(String productName, String productType, String description, int price,int stock) {
        this.id = ++AUTO_ID;
        this.productName = productName;
        this.productType = productType;
        this.description = description;
        this.price = price;

        this.stock = stock;
        this.stockStatus = setStockStatus(stock);
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getStockStatus() {
        return stockStatus;
    }

    public String setStockStatus(int stock) {
        if (stock!=0) {
            return "Còn hàng";
        } else return "Hết hàng";
    }

    @Override
    public String toString() {
        return id +"\t" + productName + "\t\t" + productType +"\t\t" + description + "\t\t" + price +"\t\t"+ stock +"\t\t" + stockStatus+ "\n";
    }
}
