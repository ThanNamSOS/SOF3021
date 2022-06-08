package SOF3021.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SOF3021.beans.AccountModel;
import SOF3021.entities.Account;
import SOF3021.repository.AccountRepository;
import SOF3021.utils.EncryptUtil;

@Controller
@RequestMapping("/admin/accounts")
public class AccountController {

	private Account account;

	@Autowired
	private AccountRepository accountRepository;

	@GetMapping("create")
	public String create(@ModelAttribute("account") AccountModel account, Model model) {
		model.addAttribute("view", "admin/accounts/create.jsp");
		return "layouts/main";
	}

	@PostMapping("store")
	public String store(@Valid @ModelAttribute("account") AccountModel account, 
			BindingResult result, Model model2) {
		if (result.hasErrors() == true) {
			model2.addAttribute("messages", "Dữ liệu trên Form Không hợp lệ");
			model2.addAttribute("view", "admin/accounts/create.jsp");
			return "layouts/main";
		} else {
			Account acc = new Account();
			acc.setAdmin(account.getAdmin());
			acc.setEmail(account.getEmail());
			acc.setFullname(account.getFullname());
			String encrypted = EncryptUtil.encrypt(account.getPassword());
			acc.setPassword(encrypted);
			acc.setPhoto(account.getPhoto());
			acc.setUsername(account.getUsername());
			this.accountRepository.save(acc);
			return "redirect:/admin/accounts/index";
		}
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Account account) {
		this.accountRepository.delete(account);
		return "redirect:/admin/accounts/index";
	}

	@GetMapping("edit/{id}")
	public String edit(
			@PathVariable("id") Account account, Model model) {
		model.addAttribute("account", account);
		model.addAttribute("idAccount", account.getId());
		model.addAttribute("view", "admin/accounts/edit.jsp");
		return "layouts/main";
	}

	@PostMapping("update/{id}")
	public String update(AccountModel model, BindingResult result, Model model2) {
		if (result.hasErrors() == true) {
			model2.addAttribute("messages", "* Dữ liệu trên Form Không hợp lệ");
			return edit(account, model2);
		} else {
			Account account = new Account();
			account.setId(model.getId());
			account.setActivated(model.getActivated());
			account.setAdmin(model.getAdmin());
			account.setEmail(model.getEmail());
			account.setFullname(model.getFullname());
			account.setPassword(model.getPassword());
			account.setPhoto(model.getPhoto());
			account.setUsername(model.getUsername());
			this.accountRepository.save(account);
			return "redirect:/admin/accounts/index";
		}
	}

	@GetMapping("index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {

		Pageable pageable = PageRequest.of(page, size);
		Page<Account> p = this.accountRepository.findAll(pageable);
		model.addAttribute("data", p);
		model.addAttribute("view", "admin/accounts/index.jsp");
		return "layouts/main";
	}

}