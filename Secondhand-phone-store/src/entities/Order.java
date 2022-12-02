package entities;

import java.time.LocalDate;

public class Order {
    private static int AUTO_ID;
    private static int reward;
    private int id;
    private LocalDate orderDate;
    private Member member;
    private Product product;
    private int quantity;
    private int rewardPoint;
    private double total;

    public Order(LocalDate orderDate, Member member,Product product, int quantity) {
        this.id = ++AUTO_ID;
        this.orderDate = orderDate;
        this.member = member;
        this.product = product;
        this.quantity = quantity;
        this.rewardPoint = reward;
        this.total = quantity* product.getPrice() - rewardPoint;
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

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", member=" + member +
                ", product=" + product +
                ", quantity=" + quantity +
                ", rewardPoint=" + rewardPoint +
                ", total=" + total +
                '}';
    }
}
