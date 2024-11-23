package fit.iuh.se.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import fit.iuh.se.entities.Product;
import fit.iuh.se.repositories.ProductRepository;
import fit.iuh.se.services.ProductService;



@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Lấy tất cả bác sĩ
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

	@Override
	public boolean save(Product product) {
		productRepository.save(product);
		return true;
		
	}

	@Override
	public boolean delete(int id) {
		 productRepository.deleteById(id);
		  return true;
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).get();
	}

	@Override
    public  boolean updateCategory(Product product) {
        productRepository.saveAndFlush(product);
        return true;
    }

	@Override
	public List<Product> search(String keyword) {
		// TODO Auto-generated method stub
		return productRepository.search(keyword);
	}

   
}
