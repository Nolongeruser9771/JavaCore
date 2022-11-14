package Entity;

import java.util.Arrays;

public class productDetail {

    Product product;

    public productDetail(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "productDetail{" +
                "product=" + product +
                '}';
    }
}
