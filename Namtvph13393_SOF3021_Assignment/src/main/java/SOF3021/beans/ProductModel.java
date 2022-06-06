package SOF3021.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import SOF3021.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
	
	private int id;
	@NotBlank(message = "* Không để chống mục này")
	
	@Size(min = 1, max = 255, message = "* Giá trị từ 1 - 255 ký tự")
	private String name;
	
	@NotBlank(message = "* Không để chống mục này")
	private String image;
	
	@NotNull(message = "* Không để chống mục này")
	@Min(value = 1, message = "* Giá trị nhỏ nhất là 1")
	@Max(value = 200, message = "* Giá trị lớn nhất là 200")
	@NumberFormat(style = Style.NUMBER)
	private double price;

	private Date createdDate;
	
	@NotNull(message = "* Không để chống mục này")
	@Min(value = 1, message = "Giá trị nhỏ nhất là 1")
	private int available;
	
	@NotNull(message = "* Không để chống mục này")
	private Category category;
}
