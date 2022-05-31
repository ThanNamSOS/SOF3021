package SOF3021.controller.admin;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import SOF3021.entities.Account;
import SOF3021.entities.User;

@Controller
@RequestMapping("/admin/users")
public class UserController {
	
	@GetMapping("create")
	public String create(@ModelAttribute("user") User user) {
		return "/admin/users/create";
	}
	
	@PostMapping("store")
	public String store(
			@Valid
			@ModelAttribute("accounts") Account accounts,
			BindingResult result
			) {
		if(result.hasErrors() == true) {
			System.out.println("Form k hop le");
		}else {
			System.out.println("Form hop le");
		}
		
		return "/admin/users/create";
	}
}
