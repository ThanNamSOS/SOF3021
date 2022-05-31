package SOF3021.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SOF3021.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
