package SOF3021.controller.admin;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import SOF3021.beans.OrderAndOrderDetailModel;
import SOF3021.beans.OrderModel;
import SOF3021.entities.Account;
import SOF3021.entities.Order;
import SOF3021.repository.AccountRepository;
import SOF3021.repository.OrderRepository;
import SOF3021.repository.ProductRepository;

@Controller
@RequestMapping("/admin/order")
public class OrderController {

	private Order order;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("index")
	public String index(Model model, @ModelAttribute("orderModel") OrderAndOrderDetailModel orderModel,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "7") int size) {
		List<Order> listOrder = this.orderRepository.findAll();
		model.addAttribute("listOrder", listOrder);
		model.addAttribute("view", "admin/order/index.jsp");
		return "layouts/main";
	}

	@GetMapping("create")
	public String create(@ModelAttribute("orderModel") OrderModel orderModel, Model model) {
		List<Account> accounts = this.accountRepository.findAll();
		model.addAttribute("accounts", accounts);
		model.addAttribute("view", "admin/order/create.jsp");
		return "layouts/main";
	}

	@PostMapping("store")
	public String store(@ModelAttribute("orderModel") OrderModel orderModel, BindingResult result, Model model2) {
		if (result.hasErrors() == true) {
			model2.addAttribute("messages", "Dữ liệu trên Form Không hợp lệ");
			return create(orderModel, model2);
		}
		System.out.println("address----" + orderModel.getAddress());
		Order order = new Order();
		order.setAddress(orderModel.getAddress());
		Date dates = java.util.Calendar.getInstance().getTime();
		order.setCreatedDate(dates);
		order.setUser(orderModel.getUser());
		this.orderRepository.save(order);
		return "redirect:/admin/order/index";
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Order order) {
		this.orderRepository.delete(order);
		return "redirect:/admin/order/index";
	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") Order order, Model model) {
		this.order = order;
		List<Account> accounts = this.accountRepository.findAll();
		model.addAttribute("accounts", accounts);
		model.addAttribute("order", order);
		model.addAttribute("idorder", order.getId());
		model.addAttribute("view", "admin/order/edit.jsp");
		return "layouts/main";
	}

	@PostMapping("update/{id}")
	public String update(OrderModel orderModel, BindingResult result, Model model) {
		if (result.hasErrors() == true) {
			model.addAttribute("messages", "* Dữ liệu trên Form Không hợp lệ");
			return edit(order, model);
		} else {
			Order or = new Order();
			or.setId(orderModel.getId());
			Date dates = java.util.Calendar.getInstance().getTime();
			or.setCreatedDate(dates);
			or.setAddress(orderModel.getAddress());
			or.setUser(orderModel.getUser());
			this.orderRepository.save(or);
			return "redirect:/admin/order/index";
		}
	}
	
}
