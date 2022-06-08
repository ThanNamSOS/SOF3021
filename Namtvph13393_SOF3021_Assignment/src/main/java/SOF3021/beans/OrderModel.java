package SOF3021.beans;

import java.util.Date;

import SOF3021.entities.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderModel {
	private int id;

	private Account user;

	private Date createdDate;

	private String address;
}
