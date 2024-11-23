package fit.iuh.se.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fit.iuh.se.entities.Category;
import fit.iuh.se.entities.Product;




@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	

}
