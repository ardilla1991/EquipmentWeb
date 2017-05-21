package by.htp.equipment.command;

import static by.htp.equipment.util.ConstantValue.ADMIN_PAGE_EQUIPMENT_BY_CATEGORY;
import static by.htp.equipment.util.ConstantValue.REQUEST_PARAM_LIST_EQ;
import static by.htp.equipment.util.ConstantValue.ADMIN_REQUEST_PARAM_CATEGORY_ID;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.equipment.entity.Equipment;
import by.htp.equipment.service.EquipmentService;
import by.htp.equipment.service.EquipmentServiceImpl;

public class EquipmentListByCategoryAction implements CommandAction{

	private EquipmentService equipService;
	
	public EquipmentListByCategoryAction() {
		equipService = new EquipmentServiceImpl();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("list by category");
		String categoryIdS = request.getParameter(ADMIN_REQUEST_PARAM_CATEGORY_ID);
		List<Equipment> equipment = equipService.getListByCategory(categoryIdS);
		System.out.println(equipment);
		request.setAttribute(REQUEST_PARAM_LIST_EQ, equipment);
		
		String page = ADMIN_PAGE_EQUIPMENT_BY_CATEGORY;
		
		return page;
	}

}
