package fit.iuh.se.services;

import java.util.List;
import org.springframework.data.domain.Page;

import fit.iuh.se.entities.Category;
import fit.iuh.se.entities.Product;


public interface CategoryService {
   List<Category> findAll();
   
   
}

