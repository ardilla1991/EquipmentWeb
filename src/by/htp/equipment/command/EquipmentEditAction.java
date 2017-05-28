package by.htp.equipment.command;

import static by.htp.equipment.util.ConstantValue.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.equipment.entity.Category;
import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.Parameter;
import by.htp.equipment.entity.PersonCategoryEnum;
import by.htp.equipment.service.EquipmentService;
import by.htp.equipment.service.EquipmentServiceImpl;
import by.htp.equipment.service.ParameterService;
import by.htp.equipment.service.ParameterServiceImpl;

public class EquipmentEditAction implements CommandAction{

	private EquipmentService equipService;
	private ParameterService parameterService;
	
	public EquipmentEditAction() {
		equipService = new EquipmentServiceImpl();
		parameterService = new ParameterServiceImpl();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("add equipment");
		String categoryIdS = request.getParameter(ADMIN_REQUEST_PARAM_CATEGORY_ID);

		String equipmentIdS = request.getParameter(ADMIN_REQUEST_PARAM_EQUIPMENT_ID);
		String model = request.getParameter(ADMIN_PARAM_EQUIPMENT_MODEL);
		String price = request.getParameter(ADMIN_PARAM_EQUIPMENT_PRICE);
		String weight = request.getParameter(ADMIN_PARAM_EQUIPMENT_WEIGHT);
		String width = request.getParameter(ADMIN_PARAM_EQUIPMENT_WIDTH);
		String height = request.getParameter(ADMIN_PARAM_EQUIPMENT_HEIGHT);
		String personCategory = request.getParameter(ADMIN_PARAM_EQUIPMENT_PERSON_CATEGORY);

		Equipment equipment = new Equipment();
		equipment.setId(Long.valueOf(equipmentIdS));
		equipment.setModel(model);
		equipment.setPrice(Double.valueOf(price));
		equipment.setWeight(Double.valueOf(weight));
		equipment.setWidth(Double.valueOf(width));
		equipment.setHeight(Double.valueOf(height));
		equipment.setPersonCategory(PersonCategoryEnum.valueOf(personCategory));
		equipment.setIsRent(false);
		
		Category category = new Category();
		category.setId(Integer.valueOf(categoryIdS));
		equipment.setCategory(category);
		
		List<Parameter> parameters = parameterService.getParametersByCategory(category);

		for ( Parameter param : parameters ) {
			String paramValue = request.getParameter(ADMIN_PARAM_EQUIPMENT_PARAM_START_INPUT_TITLE + param.getId());
			if ( paramValue.length() > 0 )
				param.setValue(paramValue);		
		}

		equipment.setParameters(parameters);
		
		equipService.editEquipment(equipment);

		List<Equipment> equipments = equipService.getListByCategory(categoryIdS);

		request.setAttribute(REQUEST_PARAM_CATEGORY_ID, categoryIdS);
		request.setAttribute(REQUEST_PARAM_LIST_EQ, equipments);
		
		String page = ADMIN_PAGE_EQUIPMENT_BY_CATEGORY;
		
		return page;
	}


}
