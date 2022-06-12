package SOF3021.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import SOF3021.entities.Account;
import SOF3021.entities.Category;
import SOF3021.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query(name = "Product.SearchProduct")
	public List<Product> SearchProduct(@Param("name") String name, @Param("category") Category category);
	
}
