package SOF3021.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import SOF3021.beans.AccountModel;
import SOF3021.entities.Account;
import SOF3021.repository.AccountRepository;
import SOF3021.utils.EncryptUtil;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private AccountRepository accountRepository;

	@GetMapping("login")
	public String form(@ModelAttribute("account") AccountModel account, Model model) {
		model.addAttribute("account", account);
		model.addAttribute("view", "pages/login.jsp");
		return "layouts/main";
	}

	@PostMapping("loginForm")
	public String login(
			@ModelAttribute("account")AccountModel account, 
			Model model,
			HttpSession session
			) {
		String email = account.getEmail();
		String pass = account.getPassword();
		Account acc = this.accountRepository.findByEmail(email);
		if (acc != null) {
			if (EncryptUtil.check(pass, acc.getPassword())) {
				session.setAttribute("acc", acc);
				return "redirect:/home";
			} else {
				model.addAttribute("messages", "mật khẩu sai");
				model.addAttribute("view", "pages/login.jsp");
				return "layouts/main";
			}
		} else {
			model.addAttribute("messages", "Tài khoản không tồn tại");
			model.addAttribute("view", "pages/login.jsp");
			return "layouts/main";
		}
	}
}
