package by.htp.equipment.command;

import static by.htp.equipment.util.ConstantValue.ADMIN_PAGE_CATEGORY_LIST;
import static by.htp.equipment.util.ConstantValue.REGUEST_PARAM_CATEGORY_LIST;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.equipment.entity.Category;
import by.htp.equipment.service.CategoryService;
import by.htp.equipment.service.CategoryServiceImpl;

public class CategoryListAction implements CommandAction{

	private CategoryService service;
	
	public CategoryListAction() {
		service = new CategoryServiceImpl();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		List<Category> categories = service.list();

		request.setAttribute(REGUEST_PARAM_CATEGORY_LIST, categories);
		
		return ADMIN_PAGE_CATEGORY_LIST;
	}

}
