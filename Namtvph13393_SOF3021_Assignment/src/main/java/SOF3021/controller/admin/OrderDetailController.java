package SOF3021.controller.admin;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SOF3021.beans.OrderAndOrderDetailModel;
import SOF3021.beans.OrderDetailModel;
import SOF3021.beans.OrderModel;
import SOF3021.entities.Account;
import SOF3021.entities.Order;
import SOF3021.entities.OrderDetail;
import SOF3021.entities.Product;
import SOF3021.repository.AccountRepository;
import SOF3021.repository.OrderDetailRepository;
import SOF3021.repository.OrderRepository;
import SOF3021.repository.ProductRepository;

@Controller
@RequestMapping("/admin/orderDetail")
public class OrderDetailController {
	
	private OrderDetail orderDetail;
	
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("index")
	public String index(Model model, @ModelAttribute("orderModel") OrderDetailModel orderModel,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "7") int size) {
		List<OrderDetail> listOrder = this.orderDetailRepository.findAll();
		model.addAttribute("listOrder", listOrder);
		model.addAttribute("view", "admin/orderDetail/index.jsp");
		return "layouts/main";
	}

	@GetMapping("create")
	public String create(Model model, @ModelAttribute("detailModel") OrderDetailModel detailModel) {
		List<Order> orders = this.orderRepository.findAll();
		List<Product> products = this.productRepository.findAll();
		model.addAttribute("orders", orders);
		model.addAttribute("products", products);
		model.addAttribute("view", "admin/orderDetail/create.jsp");
		return "layouts/main";
	}

	@PostMapping("store")
	public String store(@ModelAttribute("orderModel") OrderDetailModel detailModel, BindingResult result,
			Model model2) {
		if (result.hasErrors() == true) {
			model2.addAttribute("messages", "Dữ liệu trên Form Không hợp lệ");
			return create(model2, detailModel);
		}
		OrderDetail detail = new OrderDetail();
		detail.setOrder(detailModel.getOrder());
		detail.setPrice(detailModel.getPrice());
		detail.setProduct(detailModel.getProduct());
		detail.setQuantity(detailModel.getQuantity());
		this.orderDetailRepository.save(detail);
		return "redirect:/admin/orderDetail/index";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Order order) {
		this.orderRepository.delete(order);
		return "redirect:/admin/orderDetail/index";
	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") OrderDetail orderDe, Model model) {
		this.orderDetail = orderDe;
		//List<Account> accounts = this.accountRepository.findAll();
		List<Order> orders = this.orderRepository.findAll();
		List<Product> products = this.productRepository.findAll();
		model.addAttribute("orders", orders);
		model.addAttribute("products", products);
		//model.addAttribute("accounts", accounts);
		model.addAttribute("orderDe", orderDe);
		model.addAttribute("idorderDe", orderDe.getId());
		model.addAttribute("view", "admin/orderDetail/edit.jsp");
		return "layouts/main";
	}

	@PostMapping("update/{id}")
	public String update(OrderDetailModel orderDe, BindingResult result, Model model) {
		if (result.hasErrors() == true) {
			model.addAttribute("messages", "* Dữ liệu trên Form Không hợp lệ");
			return edit(orderDetail, model);
		} else {
			OrderDetail or = new OrderDetail();
			or.setId(orderDe.getId());
			or.setQuantity(orderDe.getQuantity());
			or.setOrder(orderDe.getOrder());
			or.setPrice(orderDe.getPrice());
			or.setProduct(orderDe.getProduct());
			System.out.println("order quantity: "+orderDe.getQuantity());
			this.orderDetailRepository.save(or);
			return "redirect:/admin/orderDetail/index";
		}
	}
	
}
