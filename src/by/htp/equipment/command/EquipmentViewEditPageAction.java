package by.htp.equipment.command;

import static by.htp.equipment.util.ConstantValue.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.PersonCategoryEnum;
import by.htp.equipment.service.EquipmentService;
import by.htp.equipment.service.EquipmentServiceImpl;
import by.htp.equipment.service.ParameterServiceImpl;

public class EquipmentViewEditPageAction implements CommandAction{
	
	private EquipmentService equipService;
	public EquipmentViewEditPageAction() {
		equipService = new EquipmentServiceImpl();
		new ParameterServiceImpl();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String categoryIdS = request.getParameter(ADMIN_REQUEST_PARAM_CATEGORY_ID);
		String equipmentIdS = request.getParameter(ADMIN_REQUEST_PARAM_EQUIPMENT_ID);
		Equipment equipment = equipService.getEquipmentById(equipmentIdS);

		request.setAttribute(REQUEST_PARAM_CATEGORY_ID, categoryIdS);
		request.setAttribute(REQUEST_PARAM_EQUIPMENT, equipment);
		request.setAttribute(REQUEST_PARAM_PERSON_CATEGORIES, PersonCategoryEnum.values());
		
		String page = ADMIN_PAGE_EQUIPMENT_EDIT_PAGE;
		
		return page;
	}
}
