package by.htp.equipment.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.equipment.entity.Equipment;
import by.htp.equipment.service.EquipmentService;
import by.htp.equipment.service.EquipmentServiceImpl;

import static by.htp.equipment.util.ConstantValue.*;

import java.util.List;

public class MakeOrderAction implements CommandAction{

	private EquipmentService service;
	
	public MakeOrderAction() {
		service = new EquipmentServiceImpl();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String equipmentsStr = request.getParameter("equipments_ids");
		List<Equipment> equipments = service.prepareEquipmentForRent(equipmentsStr);

		request.setAttribute(REQUEST_PARAM_LIST_EQ, equipments);
		
		return PAGE_ORDER_CREATE;
	}
	
}
