package SOF3021.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SOF3021.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
