package by.htp.equipment.command;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.equipment.entity.User;
import by.htp.equipment.service.EquipmentService;
import by.htp.equipment.service.EquipmentServiceImpl;
import by.htp.equipment.service.ServiceNoSuchUserException;
import by.htp.equipment.service.UserService;
import by.htp.equipment.service.UserServiceImpl;
import by.htp.rental.entity.Equipment;
import by.htp.rental.launch.RentalRunner;
import by.htp.rental.logic.RentalManager;

import static by.htp.equipment.util.ConstantValue.*;

public class LoginCommandAction implements CommanAction{

	private static final String JSP_PATH = "jsp/";
	private UserService userService;
	private EquipmentService equipService;
	
	public LoginCommandAction() {
		userService = new UserServiceImpl();
		equipService = new EquipmentServiceImpl();
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
			if ( !user.isRole() ) {
				HashMap<Integer, Equipment> equipment = equipService.list();
				request.setAttribute(REQUEST_PARAM_LIST_EQ, equipment);
				page = JSP_PATH + PAGE_USER_MAIN;
			} else {
				RentalRunner rentalRunner = new RentalRunner();
				try {
					RentalManager rentalManager = rentalRunner.mainRunner();
					ArrayList<Equipment> eq = new ArrayList<Equipment>();
					eq = rentalManager.getRentedEquipmentsByTime(new Date().getTime() - 60 * 60, new Date().getTime());
					request.setAttribute(REQUEST_PARAM_LIST_EQ, eq);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				page = JSP_PATH + PAGE_ADMIN_MAIN;
			}
		} catch (ServiceNoSuchUserException e1) {
			//e1.printStackTrace();
			page = JSP_PATH + PAGE_ERROR;
			request.setAttribute(REGUEST_PARAM_ERROR_MSG, e1.getMessage());
		}	
		
		return page;
	}

	
}
