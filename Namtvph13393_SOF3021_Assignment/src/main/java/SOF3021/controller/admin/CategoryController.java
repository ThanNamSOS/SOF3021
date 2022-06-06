package SOF3021.controller.admin;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.catalina.Store;
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
import SOF3021.entities.Account;
import SOF3021.entities.Category;
import SOF3021.entities.Product;
import SOF3021.repository.AccountRepository;
import SOF3021.repository.CategoryRepository;
import SOF3021.repository.ProductRepository;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {

		Pageable pageable = PageRequest.of(page, size);
		Page<Category> p = this.categoryRepository.findAll(pageable);
		model.addAttribute("categorys", p);
		return "admin/category/index";
	}

	@GetMapping("create")
	private String create(
			@ModelAttribute("category") CategoryModel categoryModel
			) {
		return "admin/category/create";
	}
	
	@PostMapping("store")
	private String store(
			@Valid
			@ModelAttribute("category") CategoryModel categoryModel,
			BindingResult result,
			Model model2
			) {
		if (result.hasErrors() == true) {
			model2.addAttribute("messages", "Dữ liệu trên Form Không hợp lệ");
			return "admin/category/create";
		} else {
		Category category = new Category();
		category.setName(categoryModel.getName());
		this.categoryRepository.save(category);
		return "redirect:/admin/category/index";
		}
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Category cate) {

		this.categoryRepository.delete(cate);
		return "redirect:/admin/category/index";
	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") Category cate, Model model) {
		model.addAttribute("category", categoryRepository.findById(cate.getId()));
		return "admin/category/create";
	}

	@PostMapping("update")
	public String update(CategoryModel model) {
		Category cate = new Category();
		cate.setId(model.getId());
		cate.setName(model.getName());
		this.categoryRepository.save(cate);
		return "redirect:/admin/category/index";
	}

}
