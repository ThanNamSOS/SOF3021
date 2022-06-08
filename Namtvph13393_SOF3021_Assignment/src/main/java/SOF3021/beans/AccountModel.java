package SOF3021.beans;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountModel {
	
	private int id;
	@NotBlank(message = "* Không để chống mục này")
	@Size(min = 6, max = 255, message = "* Độ dài từ 6 - 255 ký tự")
	private String fullname;
	@NotBlank(message = "* Không để chống mục này")
	@Email(message = "* Email erro")
	@Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
			+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message = "* Email sai định dạng")
	private String email;
	@NotBlank(message = "* Không để chống mục này")
	@Size(min = 6, max = 255, message = "* Giá trị 6-255 ký tự")
	private String username;
	
	@NotBlank(message = "* Không để chống mục này")
	@Size(min = 6, message = "* Độ dài từ 6 ký tự")
	private String password;
	
	@NotBlank(message = "* Bạn chưa chọn hình ảnh")
	private String photo;
	
	@NotNull(message = "* Mời bạn chọn trức vụ")
	@Min(value = 0, message = "* Erro  trức vụ")
	@Max(value = 1, message = "* Erro  trức vụ")
	private int admin;
	
	private int activated;
}