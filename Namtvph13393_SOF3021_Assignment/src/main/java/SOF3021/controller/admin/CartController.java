package SOF3021.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SOF3021.entities.Account;
import SOF3021.entities.Order;
import SOF3021.entities.OrderDetail;
import SOF3021.entities.Product;
import SOF3021.repository.ProductRepository;


@Controller
@RequestMapping(value = "/")
public class CartController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping(value = "cart/{product}")
	public String addToCart(
			@ModelAttribute(name = "order") Order order ,
			Model model, 
			@PathVariable("product") Product params, 
			HttpSession session) {
		Map<Integer, OrderDetail> cart = (HashMap<Integer, OrderDetail>) session.getAttribute("cart");
		if (cart == null) {
			cart = new HashMap<Integer, OrderDetail>();
		}
		Product product = params;
		if (cart.containsKey(product.getId())) {
			OrderDetail od = cart.get(product.getId());
			od.setQuantity(od.getQuantity() + 1);
		} else {
			OrderDetail o = new OrderDetail();
			o.setProduct(product);
			o.setQuantity(1);
			cart.put(product.getId(), o);
		}
		session.setAttribute("cart", cart);
		model.addAttribute("view", "user/cart/index.jsp");
		return "layouts/main";
	}

	@GetMapping("cartMe")
	public String goCart(Model model,HttpSession session) {
		model.addAttribute("view", "user/cart/index.jsp");
		return "layouts/main";
	}

	@GetMapping(value = "cart/delete/{cart}")
	public String removeProductFromCart(
			@PathVariable("cart") int params,
			@ModelAttribute(name = "order") Order order ,
			HttpSession session, 
			Model model) {
		HashMap<Integer, OrderDetail> cart = (HashMap<Integer, OrderDetail>) session.getAttribute("cart");
		cart.remove(params);
		session.setAttribute("cart", cart);
		model.addAttribute("view", "user/cart/index.jsp");
		return "layouts/main";
	}
}
