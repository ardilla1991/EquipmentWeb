package by.htp.equipment.command;

import static by.htp.equipment.util.ConstantValue.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.equipment.entity.Category;
import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.PersonCategoryEnum;
import by.htp.equipment.service.ParameterServiceImpl;

public class EquipmentViewAddPageAction implements CommandAction{

	private ParameterServiceImpl parameterService;
	
	public EquipmentViewAddPageAction() {
		parameterService = new ParameterServiceImpl();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String categoryIdS = request.getParameter(ADMIN_REQUEST_PARAM_CATEGORY_ID);
		Equipment equipment = new Equipment();
		Category category = new Category();
		category.setId(Integer.valueOf(categoryIdS));
		equipment.setCategory(category);
		equipment.setParameters(parameterService.getParametersByCategory(category));
		request.setAttribute(REQUEST_PARAM_CATEGORY_ID, categoryIdS);
		request.setAttribute(REQUEST_PARAM_EQUIPMENT, equipment);
		request.setAttribute(REQUEST_PARAM_PERSON_CATEGORIES, PersonCategoryEnum.values());
		
		String page = ADMIN_PAGE_EQUIPMENT_EDIT_PAGE;
		
		return page;
	}

}
