package SOF3021.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import SOF3021.beans.AccountModel;
import SOF3021.entities.Account;

@Controller
@RequestMapping("/")
public class Logout {
	@GetMapping("logout")
	public String form( @ModelAttribute("account") AccountModel acc,Model model,HttpServletRequest req, HttpServletResponse res) {
		model.addAttribute("account", acc);
		HttpSession session = req.getSession();
		Account account = (Account) session.getAttribute("acc");
		if(account != null) {
			account = null;
			session.invalidate();
		}
		model.addAttribute("view", "pages/login.jsp");
		return "layouts/main";
	}
}
