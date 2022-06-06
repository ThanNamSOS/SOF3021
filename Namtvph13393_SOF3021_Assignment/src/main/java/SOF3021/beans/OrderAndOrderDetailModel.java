package SOF3021.beans;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

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
	@NotBlank(message = "* Không để chống mục này")
	@Size(min = 6, max = 255, message = "* Giá trị từ 6 - 255 ký tự")
	private String address;
	
	@NotNull(message = "* Không để trống mục này")
	private Order order;

	@NotNull(message = "* Không để trống mục này")
	private Product product;
	
	@NotNull(message = "* Không để trống mục này")
	@Min(value = 1, message = "Giá trị nhỏ nhất là 1")
	@Pattern(regexp = ".*[^0-9].*",message = "* Gía trị phải là số")
	private double price;

	@NotNull(message = "* Không để trống mục này")
	@Min(value = 1, message = "Giá trị nhỏ nhất là 1")
	@Pattern(regexp = ".*[^0-9].*",message = "* Gía trị phải là số")
	private int quatity;
}
