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

@Controller
@RequestMapping("/admin/accounts")
public class AccountController {

	private Account account;

	@Autowired
	private AccountRepository accountRepository;

	@GetMapping("create")
	public String create(@ModelAttribute("account") AccountModel account) {
		return "admin/accounts/create";
	}

	@PostMapping("store")
	public String store(@Valid @ModelAttribute("account") AccountModel account, BindingResult result, Model model2) {
		if (result.hasErrors() == true) {
			model2.addAttribute("messages", "Dữ liệu trên Form Không hợp lệ");
			return "admin/accounts/create";
		} else {
			Account acc = new Account();
			acc.setAdmin(account.getAdmin());
			acc.setEmail(account.getEmail());
			acc.setFullname(account.getFullname());
			acc.setPassword(account.getPassword());
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
	public String edit(@PathVariable("id") Account account, Model model) {
		model.addAttribute("account", accountRepository.findById(account.getId()));
		return "admin/accounts/edit";
	}

	@PostMapping("update")
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
		return "admin/accounts/index";
	}

	@GetMapping("formLogin")
	public String form(@ModelAttribute("account") AccountModel account) {
		return "admin/accounts/login";
	}

	@PostMapping("login")
	public String login(AccountModel account, Model model) {
		String username = account.getUsername();
		String pass = account.getPassword();
		Account acc = this.accountRepository.findByUsername(username);
		System.out.println(acc.getUsername() + acc.getPassword());
		if (pass.equalsIgnoreCase(acc.getPassword())) {
			return "redirect:/admin/accounts/index";
		} else {
			model.addAttribute("message", "mật khẩu sai");
			return "admin/accounts/formLogin";
		}
	}

}