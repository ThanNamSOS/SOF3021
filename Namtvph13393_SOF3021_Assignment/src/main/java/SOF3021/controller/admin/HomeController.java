package SOF3021.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SOF3021.entities.Product;
import SOF3021.repository.ProductRepository;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("home")
	public String home(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Product> p = this.productRepository.findAll(pageable);
		model.addAttribute("products", p);
		model.addAttribute("view", "pages/home.jsp");
		return "layouts/main";
	}
	
}
