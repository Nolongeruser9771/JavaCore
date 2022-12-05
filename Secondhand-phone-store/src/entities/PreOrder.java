package entities;

public class PreOrder extends Order{
    private int status;
    private String note;
    private int purchasePrice;
    private Product newProduct;
    public PreOrder(User user, Product oldProduct, int purchasePrice,Product newProduct, int quantity, String note) {
        super(user, oldProduct, quantity);
        this.newProduct = newProduct;
        this.total = setTotal(purchasePrice,newProduct);
        this.purchasePrice = purchasePrice;
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

    public int getTotal() {
        return total;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int setTotal(int purchasePrice, Product newProduct) {
        if (newProduct.getPrice()>purchasePrice){
            return newProduct.getPrice()-purchasePrice;
        } else return 0;
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
        return id + "\t\t\t" + orderDate + "\t\t" + user.name + "\t\t\t" + product.getProductName() + "\t\t\t" + newProduct.getProductName()+ "\t\t\t" + quantity + "\t\t" + newProduct.getPrice() + "\t\t" + total+ "\t"+ note+"\n";
    }
}
