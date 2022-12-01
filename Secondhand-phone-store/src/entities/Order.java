package entities;

import java.time.LocalDate;

public class Order {
    protected static int AUTO_ID;
    protected int id;
    protected LocalDate orderDate;
    protected Product product;
    protected int quantity;
    protected double total;

    public Order(LocalDate orderDate, Product product, int quantity) {
        this.id = ++AUTO_ID;
        this.orderDate = orderDate;
        this.product = product;
        this.quantity = quantity;
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
                ", product=" + product +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }
}
