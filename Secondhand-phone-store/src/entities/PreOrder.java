package entities;

public class PreOrder extends Order{
    private int status;
    private String note;
    private Product newProduct;
    public PreOrder(User user, Product oldProduct, Product newProduct, int quantity, String note) {
        super(user, oldProduct, quantity);
        this.newProduct = newProduct;
        this.status = 0;
        this.note = note;
    }
    public Product getNewProduct() {
        return newProduct;
    }

    public void setNewProduct(Product newProduct) {
        this.newProduct = newProduct;
    }
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return id + "\t\t\t" + orderDate + "\t\t" + user.name + "\t\t\t" + product.getProductName() + "\t\t" + newProduct.getProductName()+ "\t\t" + quantity + "\t" + newProduct.getPrice() + "\t" + total+ "\t"+ note+"\n";
    }
}
