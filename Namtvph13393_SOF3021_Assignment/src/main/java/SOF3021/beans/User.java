package SOF3021.beans;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User {

	@NotBlank
	@Size(min=1, max=255)
	private String hoTen;

	@NotBlank
	private String diaChi;

	@NotNull
	@Size(min=0, max=1)
	private String gioiTinh;

	@NotBlank
	@Email()
	@Pattern(regexp="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
	private String email;
	
	@NotBlank
	@Min(6)
	private String password;
	
	@NotBlank
	@Pattern(regexp="^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$")
	@Size(min=10, max=11)
	private String sdt;
	
	@NotBlank
	private String avatar;
}
