package fit.iuh.se.services;

import java.util.List;
import org.springframework.data.domain.Page;


import fit.iuh.se.entities.Product;


public interface ProductService {
    List<Product> findAll();
    Product findById(int id);
    boolean save(Product product );
    boolean delete(int id);
    boolean updateCategory(Product product);
    List<Product> search(String keyword);
}

