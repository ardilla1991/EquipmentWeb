package by.htp.equipment.command;

import static by.htp.equipment.util.ConstantValue.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.PersonCategoryEnum;
import by.htp.equipment.service.EquipmentService;
import by.htp.equipment.service.EquipmentServiceImpl;
import by.htp.equipment.service.ParameterServiceImpl;

public class EquipmentViewEditPageAction implements CommandAction{

	private EquipmentService equipService;
	private ParameterServiceImpl parameterService;
	
	public EquipmentViewEditPageAction() {
		equipService = new EquipmentServiceImpl();
		parameterService = new ParameterServiceImpl();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("view add page");
		String categoryIdS = request.getParameter(ADMIN_REQUEST_PARAM_CATEGORY_ID);
		int categoryId = Integer.valueOf(categoryIdS);
		Equipment equipment = new Equipment();
		equipment.setCategoryId(categoryId);
		equipment.setParameters(parameterService.getParametersByCategory(categoryId));
		System.out.println(equipment);
		request.setAttribute(REQUEST_PARAM_CATEGORY_ID, categoryIdS);
		request.setAttribute(REQUEST_PARAM_EQUIPMENT, equipment);
		request.setAttribute(REQUEST_PARAM_PERSON_CATEGORIES, PersonCategoryEnum.values());
		
		String page = ADMIN_PAGE_EQUIPMENT_EDIT_PAGE;
		
		return page;
	}

}
