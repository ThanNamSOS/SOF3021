package SOF3021.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SOF3021.entities.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
