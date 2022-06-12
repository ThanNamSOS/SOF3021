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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SOF3021.beans.ProductModel;
import SOF3021.entities.Category;
import SOF3021.entities.Product;
import SOF3021.repository.CategoryRepository;
import SOF3021.repository.ProductRepository;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("home")
	public String home(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size
			, @ModelAttribute("product") Product product
			) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Product> p = this.productRepository.findAll(pageable);
		List<Category> categories = this.categoryRepository.findAll();
		model.addAttribute("products", p);
		model.addAttribute("categorys",categories);
		model.addAttribute("view", "pages/home.jsp");
		return "layouts/main";
	}
	
	@GetMapping("search")
	private String search(@ModelAttribute("product") Product productModel,
			Model model
			) {
		List<Category> categories = this.categoryRepository.findAll();
		List<Product> products = this.productRepository.SearchProduct(productModel.getName(), productModel.getCategory());
		model.addAttribute("products", products);
		model.addAttribute("categorys",categories);
		model.addAttribute("view", "pages/searchProduct.jsp");
		return "layouts/main";
	}
	
	
}
