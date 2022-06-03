package SOF3021.controller.admin;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import SOF3021.beans.OrderAndOrderDetailModel;
import SOF3021.entities.Account;
import SOF3021.entities.Order;
import SOF3021.entities.OrderDetail;
import SOF3021.entities.Product;
import SOF3021.repository.AccountRepository;
import SOF3021.repository.OrderDetailRepository;
import SOF3021.repository.OrderRepository;
import SOF3021.repository.ProductRepository;

@Controller
@RequestMapping("/admin/order")
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("index")
	public String index(Model model, @ModelAttribute("orderModel") OrderAndOrderDetailModel orderModel) {
		List<Account> accounts = this.accountRepository.findAll();
		List<Product> products = this.productRepository.findAll();
		List<Object> listOrder = this.orderDetailRepository.getListOder();
		model.addAttribute("accounts", accounts);
		model.addAttribute("products", products);
		model.addAttribute("listOrder", listOrder);
		return "admin/order/index";
	}

	@PostMapping("store")
	public String store(OrderAndOrderDetailModel orderModel) {
		Order order = new Order();
		order.setAddress(orderModel.getAddress());
		Date dates = java.util.Calendar.getInstance().getTime();
		order.setCreatedDate(dates);
		order.setUser(orderModel.getUser());
		this.orderRepository.save(order);

		OrderDetail detail = new OrderDetail();
		detail.setOrder(order);
		detail.setPrice(orderModel.getPrice());
		detail.setProduct(orderModel.getProduct());
		detail.setQuantity(orderModel.getQuatity());
		this.orderDetailRepository.save(detail);
		return "redirect:/admin/order/index";
	}

}