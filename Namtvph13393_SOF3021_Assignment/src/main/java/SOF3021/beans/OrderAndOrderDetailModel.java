package SOF3021.beans;

import java.util.Date;

import SOF3021.entities.Account;
import SOF3021.entities.Order;
import SOF3021.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderAndOrderDetailModel {

	private Account user;

	private Date createdDate;

	private String address;
	
	
	private Order order;

	private Product product;

	private double price;

	private int quatity;
}
