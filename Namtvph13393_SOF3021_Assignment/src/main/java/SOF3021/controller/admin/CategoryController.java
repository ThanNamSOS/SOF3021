package SOF3021.controller.admin;

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

import SOF3021.beans.CategoryModel;
import SOF3021.entities.Account;
import SOF3021.entities.Category;
import SOF3021.repository.CategoryRepository;
import SOF3021.repository.ProductRepository;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
	
	private Category category;
	
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
		model.addAttribute("view", "admin/category/index.jsp");
		return "layouts/main";
	}

	@GetMapping("create")
	private String create(@ModelAttribute("category") CategoryModel categoryModel, Model model) {
		model.addAttribute("view", "admin/category/create.jsp");
		return "layouts/main";
	}

	@PostMapping("store")
	private String store(@Valid @ModelAttribute("category") CategoryModel categoryModel, BindingResult result,
			Model model2) {
		if (result.hasErrors() == true) {
			model2.addAttribute("messages", "Dữ liệu trên Form Không hợp lệ");
			model2.addAttribute("view", "admin/category/create.jsp");
			return "layouts/main";
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
		model.addAttribute("category", cate);
		model.addAttribute("idcategory", cate.getId());
		model.addAttribute("view", "admin/category/edit.jsp");
		return "layouts/main";
	}

	@PostMapping("update/{id}")
	public String update(@Valid @ModelAttribute("category") CategoryModel categoryModel, BindingResult result, Model model) {
		if (result.hasErrors() == true) {
			model.addAttribute("messages", "* Dữ liệu trên Form Không hợp lệ");
			model.addAttribute("category", categoryModel);
			model.addAttribute("idcategory", categoryModel.getId());
			model.addAttribute("view", "admin/category/edit.jsp");
			return "layouts/main";
		} else {
			Category cate = new Category();
			cate.setId(categoryModel.getId());
			cate.setName(categoryModel.getName());
			this.categoryRepository.save(cate);
			return "redirect:/admin/category/index";
		}
	}

}
