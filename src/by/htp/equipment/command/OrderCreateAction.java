package by.htp.equipment.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.Order;
import by.htp.equipment.entity.User;
import by.htp.equipment.service.OrderService;
import by.htp.equipment.service.OrderServiceImpl;
import by.htp.equipment.service.RentService;
import by.htp.equipment.service.RentServiceImpl;

import static by.htp.equipment.util.ConstantValue.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OrderCreateAction implements CommandAction{

	private OrderService service;
	private RentService serviceRent; 
	
	
	public OrderCreateAction() {
		service = new OrderServiceImpl();
		serviceRent = new RentServiceImpl();
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String page = PAGE_ORDER_ALL;
		//String page = PAGE_DEFAULT;
		
		 
		String userId = request.getParameter(PARAM_USER_ID);
		String[] equipmentIds = request.getParameterValues(PARAM_CHOOSED_EQUIPMENTS_IDS);
		String dateStart = request.getParameter(PARAM_DATE_START);
		String dateEnd = request.getParameter(PARAM_DATE_END);
		
		User user = new User();
		user.setUserId(Long.valueOf(userId));
		
		List<Equipment> equipmentList = new ArrayList<Equipment>();
		for ( int i = 0; i < equipmentIds.length; i++ ) {
			Equipment eq = new Equipment();
			eq.setId(Long.valueOf(equipmentIds[i]));
			equipmentList.add(eq);
		}

		Date start = Date.valueOf(dateStart);
		Date end = Date.valueOf(dateEnd);
		
		Order order = service.makeOrder(user, start, end);
		serviceRent.createRentedList(order, equipmentList);
		
		List<Order> orders = service.getOrderListByUser(user);
		request.setAttribute(REQUEST_PARAM_LIST_EQ, orders);
		
		return page;
	}

}
