package SOF3021.controller.admin;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SOF3021.beans.AccountModel;
import SOF3021.beans.CategoryModel;
import SOF3021.beans.OrderModel;
import SOF3021.entities.Account;
import SOF3021.entities.Category;
import SOF3021.entities.Order;
import SOF3021.entities.Product;
import SOF3021.repository.AccountRepository;
import SOF3021.repository.OrderRepository;

@Controller
@RequestMapping("/admin/order")
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private AccountRepository accountRepository;
	@GetMapping("index")
	public String index(Model model,@ModelAttribute("orderModel") OrderModel orderModel) {
		List<Account> accounts = this.accountRepository.findAll();
		model.addAttribute("accounts",accounts);
		return "admin/order/index";
	}
	
	@PostMapping("store")
	public String store(OrderModel orderModel) {
		Order order = new Order();
		order.setAddress(orderModel.getAddress());
		Date dates = java.util.Calendar.getInstance().getTime();
		order.setCreatedDate(dates);
		order.setUser(orderModel.getUser());
		this.orderRepository.save(order);
		return "admin/order/index";
	}
	
}
