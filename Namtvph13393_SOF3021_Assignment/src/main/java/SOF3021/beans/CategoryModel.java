package SOF3021.beans;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryModel {
	private int id;
	
	@NotBlank(message  = "* Không để chống mục này")
	@Size(min = 6, max = 255, message = "* Giá trị 6-255 ký tự")
	private String name;
}
