package by.htp.equipment.command;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.User;
//import by.htp.equipment.launch.RentalRunner;
//import by.htp.equipment.logic.RentalManager;
import by.htp.equipment.service.EquipmentService;
import by.htp.equipment.service.EquipmentServiceImpl;
import by.htp.equipment.service.OrderService;
import by.htp.equipment.service.OrderServiceImpl;
import by.htp.equipment.service.ServiceNoSuchUserException;
import by.htp.equipment.service.UserService;
import by.htp.equipment.service.UserServiceImpl;

import static by.htp.equipment.util.ConstantValue.*;

public class LoginCommandAction implements CommandAction{

	private UserService userService;
	private EquipmentService equipService;
	private OrderService orderService;
	
	public LoginCommandAction() {
		userService = new UserServiceImpl();
		equipService = new EquipmentServiceImpl();
		orderService = new OrderServiceImpl();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String login = request.getParameter(REQUEST_PARAM_LOGIN);
		String password = request.getParameter(REQUEST_PARAM_PASSWORD);
		String page = PAGE_DEFAULT;
		
		User user;
		try {
			user = userService.authorise(login, password);
			//orderService.prepareBase(equipService);
			if ( !user.isRole() ) { // simple user
				List<Equipment> equipment = equipService.listOfSpareEquipments();
				request.setAttribute(REQUEST_PARAM_LIST_EQ, equipment);
				
				page = PAGE_USER_MAIN;
			} else {
				List<Equipment> equipment = orderService.getRentedEquipmentsByTime(new Date().getTime() - 60 * 60, new Date().getTime());
				//System.out.println(equipment);

				request.setAttribute(REQUEST_PARAM_LIST_EQ, equipment);

				page = PAGE_ADMIN_MAIN;
			}
		} catch (ServiceNoSuchUserException e1) {
			//e1.printStackTrace();
			page = PAGE_ERROR;
			request.setAttribute(REGUEST_PARAM_ERROR_MSG, e1.getMessage());
		}	
		
		return page;
	}
	
}
