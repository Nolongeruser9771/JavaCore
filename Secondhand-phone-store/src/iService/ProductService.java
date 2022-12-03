package iService;

import entities.Product;

import java.util.ArrayList;

public interface ProductService {
    Product findById(String id, ArrayList<Product> products);
}
