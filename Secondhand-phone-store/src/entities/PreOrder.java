package entities;

public class PreOrder extends Order{
    private int orderStatus;
    private Product newProduct;
    public PreOrder(User user, Product product, Product newProduct, int quantity) {
        super(user, product, quantity);
        this.newProduct = newProduct;
        this.orderStatus = 0;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Product getNewProduct() {
        return newProduct;
    }

    public void setNewProduct(Product newProduct) {
        this.newProduct = newProduct;
    }

    @Override
    public String toString() {
        return "PreOrder{" +
                "orderStatus=" + orderStatus +
                ", newProduct=" + newProduct +
                '}';
    }
}
