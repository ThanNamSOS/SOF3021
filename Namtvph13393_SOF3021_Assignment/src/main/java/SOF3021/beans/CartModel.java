package SOF3021.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartModel {
	private int ProductID;
	private String productName;
	private long price;
	private int quantity;
	
	
}
