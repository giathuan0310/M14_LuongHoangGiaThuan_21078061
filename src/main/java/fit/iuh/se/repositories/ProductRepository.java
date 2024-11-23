package fit.iuh.se.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;


import fit.iuh.se.entities.Product;




@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query(value = "SELECT * FROM product p WHERE p.name LIKE %:keyword%"
			+ " OR p.code LIKE %:keyword%"
	        + " OR p.description LIKE %:keyword%"
	        + " OR CAST(p.register_date AS CHAR) LIKE %:keyword%"
			
			, nativeQuery = true)
	List<Product> search(@Param("keyword") String keyword);

}
