package SOF3021.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import SOF3021.entities.OrderDetail;
@Repository
public interface OrderDetailRepository  extends JpaRepository<OrderDetail, Integer>{
	
	@Query(name = "OrderDetail.findOrder")
	List<Object> getListOder();
	
}
