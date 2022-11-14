package Entity;

import java.util.Arrays;

public class SalesManagement {
    Sales sale;
    Product[] product;

    public SalesManagement(Sales sale, Product[] product) {
        this.sale = sale;
        this.product = product;
    }

    public Sales getSale() {
        return sale;
    }

    public void setSale(Sales sale) {
        this.sale = sale;
    }

    public Product[] getProduct() {
        return product;
    }

    public void setProduct(Product[] product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "SalesManagement{" +
                "sale=" + sale +
                ", product=" + Arrays.toString(product) +
                '}';
    }
}
