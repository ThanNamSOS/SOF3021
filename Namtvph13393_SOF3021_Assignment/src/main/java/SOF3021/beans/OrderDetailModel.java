package SOF3021.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import SOF3021.entities.Account;
import SOF3021.entities.Order;
import SOF3021.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailModel {
	private int id;

	private Order order;

	private Product product;

	private double price;

	private int quatity;
}
