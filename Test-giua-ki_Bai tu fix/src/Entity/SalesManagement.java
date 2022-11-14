package Entity;

import java.util.Arrays;

public class SalesManagement {
    Sales sale;
    productDetail[] productDetails;

    public SalesManagement(Sales sale, productDetail[] productDetails) {
        this.sale = sale;
        this.productDetails = productDetails;
    }

    public Sales getSale() {
        return sale;
    }

    public void setSale(Sales sale) {
        this.sale = sale;
    }

    public productDetail[] getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(productDetail[] productDetails) {
        this.productDetails = productDetails;
    }

    @Override
    public String toString() {
        return "SalesManagement{" +
                "sale=" + sale +
                ", productDetails=" + Arrays.toString(productDetails) +
                '}';
    }
}
