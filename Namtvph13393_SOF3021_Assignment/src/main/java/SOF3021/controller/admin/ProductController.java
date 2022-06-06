package SOF3021.controller.admin;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.validator.internal.util.privilegedactions.GetMethods;
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
import SOF3021.beans.CategoryModel;
import SOF3021.beans.ProductModel;
import SOF3021.entities.Account;
import SOF3021.entities.Category;
import SOF3021.entities.Product;
import SOF3021.repository.CategoryRepository;
import SOF3021.repository.ProductRepository;

@Controller
@RequestMapping("/admin/product")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Product> p = this.productRepository.findAll(pageable);
		model.addAttribute("products", p);
		return "admin/product/index";
	}

	@GetMapping("home")
	public String home(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Product> p = this.productRepository.findAll(pageable);
		model.addAttribute("products", p);
		return "admin/product/home";
	}

	@GetMapping("create")
	public String create(@ModelAttribute("productModel") ProductModel productModel, Model model2) {
		List<Category> categories = this.categoryRepository.findAll();
		model2.addAttribute("categorys", categories);
		return "admin/product/create";
	}

	@PostMapping("store")
	public String store(@Valid @ModelAttribute("productModel") ProductModel productModel, BindingResult result,
			Model model2) {
		List<Category> categories = this.categoryRepository.findAll();
		model2.addAttribute("categorys", categories);
		if (result.hasErrors() == true) {
			System.out.println("Không hợp lệ");
			model2.addAttribute("messages", "Dữ liệu trên Form Không hợp lệ");
			return create(productModel, model2);
		}
		Product p = new Product();
		p.setAvailable(productModel.getAvailable());
		p.setCategory(productModel.getCategory());
		Date dates = java.util.Calendar.getInstance().getTime();
		p.setCreatedDate(dates);
		p.setImage(productModel.getImage());
		p.setName(productModel.getName());
		p.setPrice(productModel.getPrice());
		this.productRepository.save(p);
		return "redirect:/admin/product/index";

	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Product product) {
		this.productRepository.delete(product);
		return "redirect:/admin/product/index";
	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") Product product, Model model) {
		model.addAttribute("product", productRepository.findById(product.getId()));
		List<Category> categories = this.categoryRepository.findAll();
		model.addAttribute("categorys", categories);
		return "admin/product/edit";
	}

	@PostMapping("update")
	public String update(ProductModel productModel) {
		Product product = new Product();
		try {
			product.setId(productModel.getId());
			product.setAvailable(productModel.getAvailable());
			product.setCategory(productModel.getCategory());
			Date dates = java.util.Calendar.getInstance().getTime();
			product.setCreatedDate(dates);
			System.out.println("date" + dates);
			product.setImage(productModel.getImage());
			product.setName(productModel.getName());
			product.setPrice(productModel.getPrice());
			this.productRepository.save(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.productRepository.save(product);
		return "redirect:/admin/product/index";
	}

}
