package entities;

import java.util.ArrayList;

public interface idFindable {
    Product findById(String id, ArrayList<Product> products);
}
