package SOF3021.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.NumberFormat;

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
	
	@NotNull(message = "* Không để trống")
	@Min(value = 1, message = "Giá trị nhỏ nhất là 1")
	private double price;

	@NotNull(message = "* Không để trống")
	@Min(value = 1, message = "Giá trị nhỏ nhất là 1")
	private int quantity;
	
	
}
