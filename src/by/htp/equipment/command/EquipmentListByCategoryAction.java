package by.htp.equipment.command;

import static by.htp.equipment.util.ConstantValue.*;

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
		
		String categoryIdS = request.getParameter(ADMIN_REQUEST_PARAM_CATEGORY_ID);
		List<Equipment> equipment = equipService.getListByCategory(categoryIdS);

		request.setAttribute(REQUEST_PARAM_CATEGORY_ID, categoryIdS);
		request.setAttribute(REQUEST_PARAM_LIST_EQ, equipment);
		
		String page = ADMIN_PAGE_EQUIPMENT_BY_CATEGORY;
		
		//response.setCharacterEncoding("UTF-8");
		
		return page;
	}

}
