package SOF3021.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@Autowired
	private AccountRepository accountRepository;

	@GetMapping("list")
	private String getAll(Model model) {
		List<Account> listAcc = this.accountRepository.findAll();
		model.addAttribute("listAcc", listAcc);
		return "admin/accounts/listAccounts";
	}

	@GetMapping("create")
	public String create(@ModelAttribute("account") AccountModel account) {
		return "admin/accounts/create";
	}

	@PostMapping("store")
	public String store(AccountModel model) {
		Account account = new Account();
		account.setAdmin(model.getAdmin());
		account.setEmail(model.getEmail());
		account.setFullname(model.getFullname());
		account.setPassword(model.getPassword());
		account.setPhoto(model.getPhoto());
		account.setUsername(model.getUsername());

		this.accountRepository.save(account);
		return "redirect:/admin/accounts/index";
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
	public String update( AccountModel model) {
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

	@GetMapping("index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {

		Pageable pageable = PageRequest.of(page, size);
		Page<Account> p = this.accountRepository.findAll(pageable);
		model.addAttribute("data", p);
		return "admin/accounts/index";
	}
}