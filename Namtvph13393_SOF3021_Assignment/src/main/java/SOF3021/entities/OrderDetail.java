package SOF3021.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import lombok.Data;

@Data
@Entity
@Table(name="order_details")

@NamedQueries(
		@NamedQuery(name = "OrderDetail.findOrder",
		query = "SELECT o.user, o.createdDate, o.address, od.product, od.price,od.quantity "
				+ "FROM Order o "
				+" JOIN OrderDetail od ON od.order = o.id ")
		)
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;

	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	@Column(name="price")
	private double price;

	@Column(name="quantity")
	private int quantity;
}