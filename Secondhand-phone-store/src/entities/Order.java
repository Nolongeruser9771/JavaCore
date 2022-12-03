package entities;

import java.time.LocalDate;

public class Order {
    private static int AUTO_ID;
    protected int id;
    protected LocalDate orderDate;
    protected User user;
    protected Product product;
    protected int quantity;
    protected int rewardPoint;
    protected int total;

    public Order(User user,Product product, int quantity) {
        this.id = ++AUTO_ID;
        this.orderDate = LocalDate.now();
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.rewardPoint = 0;
        this.total = quantity* product.getPrice();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getRewardPoint() {
        return rewardPoint;
    }

    public void setRewardPoint(int rewardPoint) {
        this.rewardPoint = rewardPoint;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return  id +"\t\t\t"+ orderDate +"\t\t\t"+ user.name +"\t\t\t"+ product.getProductName() +"\t\t\t"+ quantity +"\t\t\t\t"+ product.getPrice() +"\t\t\t\t" + rewardPoint +"\t\t\t"+total+"\n";
    }
}
