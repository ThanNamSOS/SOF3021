package SOF3021.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import SOF3021.beans.AccountModel;
import SOF3021.beans.CategoryModel;
import SOF3021.entities.Account;
import SOF3021.entities.Category;
import SOF3021.repository.AccountRepository;
import SOF3021.repository.CategoryRepository;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@GetMapping("list")
	private String getAll(Model model) {
		List<Category> categorys = this.categoryRepository.findAll();
		model.addAttribute("categorys",categorys);
		return "admin/category/listCategory";
	}
	
	@GetMapping("create")
	public String create(@ModelAttribute("category") CategoryModel category) {
		return "admin/category/create";
	}

	@PostMapping("store")
	public String store(Category modelcate) {
		Category cate = new Category();
		cate.setId(modelcate.getId());
		cate.setName(modelcate.getName());
		
		this.categoryRepository.save(cate);
		return "redirect:/admin/category/create";
	}

	@GetMapping("delete/{id}")
	public String delete(
			@PathVariable("id") Category cate
			) {
		 this.categoryRepository.delete(cate);
		return "redirect:/admin/category/create";
	}
	
	@GetMapping("edit/{id}")
	public String edit(
			@PathVariable("id") Category cate,
			Model model
			) {
		model.addAttribute("account", categoryRepository.findById(cate.getId()));
		return "admin/category/edit";
	}
	
	@PostMapping("update/{id}")
	public String update(@PathVariable("id") String id, CategoryModel model) {
		System.out.println(id);
		Category cate = new Category();
		cate.setId(model.getId());
		cate.setName(model.getName());
		this.categoryRepository.save(cate);
		return "redirect:/admin/accounts/edit/"+model.getId();
	}
	
}
