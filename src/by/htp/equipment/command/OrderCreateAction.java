package by.htp.equipment.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.equipment.entity.Bycicle;
import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.User;
import by.htp.equipment.service.OrderService;
import by.htp.equipment.service.OrderServiceImpl;

import static by.htp.equipment.util.ConstantValue.*;

import java.sql.Date;

public class OrderCreateAction implements CommandAction{

	private OrderService service;
	
	
	public OrderCreateAction() {
		service = new OrderServiceImpl();
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		//String page = PAGE_ORDER_ALL;
		String page = PAGE_DEFAULT;
		
		String userId = request.getParameter(PARAM_USER_ID);
		String equipmentId = request.getParameter(PARAM_EQUIPMENT_ID);
		String dateStart = request.getParameter(PARAM_DATE_START);
		String dateEnd = request.getParameter(PARAM_DATE_END);
		
		User user = new User();
		user.setUserId(Long.valueOf(userId));
		
		Equipment equipment = new Bycicle();
		//equipment.setId(Long.valueOf(equipmentId));
		equipment.setId(Integer.valueOf(equipmentId));
		
		System.out.println(dateStart);
		Date start = Date.valueOf(dateStart);
		Date end = Date.valueOf(dateEnd);
		
		service.makeOrder(user, equipment, start, end);
		
		return page;
	}

}
