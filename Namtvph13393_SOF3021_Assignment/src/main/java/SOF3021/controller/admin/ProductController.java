package SOF3021.controller.admin;

import java.util.Date;
import java.util.List;

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

import SOF3021.beans.ProductModel;
import SOF3021.entities.Category;
import SOF3021.entities.Product;
import SOF3021.repository.CategoryRepository;
import SOF3021.repository.ProductRepository;

@Controller
@RequestMapping("/admin/product")
public class ProductController {

	private Product product;

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
		model.addAttribute("view", "admin/product/index.jsp");
		return "layouts/main";
	}

	@GetMapping("create")
	public String create(@ModelAttribute("productModel") ProductModel productModel, Model model2) {
		List<Category> categories = this.categoryRepository.findAll();
		model2.addAttribute("categorys", categories);
		model2.addAttribute("view", "admin/product/create.jsp");
		return "layouts/main";
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
	public String edit(@PathVariable("id") Product pro, Model model) {
		List<Category> categories = this.categoryRepository.findAll();
		model.addAttribute("product", pro);
		model.addAttribute("idProduct", pro.getId());
		model.addAttribute("categorys", categories);
		model.addAttribute("view", "admin/product/edit.jsp");
		return "layouts/main";
	}

	@PostMapping("update/{id}")
	public String update(@Valid @ModelAttribute("product") ProductModel productModel, BindingResult result, Model model) {
		if (result.hasErrors() == true) {
			model.addAttribute("messages", "* Dữ liệu trên Form Không hợp lệ");
			List<Category> categories = this.categoryRepository.findAll();
			model.addAttribute("product", productModel);
			model.addAttribute("idProduct", productModel.getId());
			model.addAttribute("categorys", categories);
			model.addAttribute("view", "admin/product/edit.jsp");
			return "layouts/main";
		} else {
			Product product = new Product();
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
			return "redirect:/admin/product/index";
		}
	}

}
