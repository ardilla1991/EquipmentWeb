package by.htp.equipment.command;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.equipment.entity.User;
import by.htp.rental.entity.Equipment;
import by.htp.rental.launch.RentalRunner;
import by.htp.rental.logic.RentalManager;

public class LoginCommandAction implements CommanAction{

	private static final String JSP_PATH = "jsp/";
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		String password = request.getParameter("pass");
		String page = "";
		if ( "user".equals(login) && "user".equals(password)) {
			
			RentalRunner rentalRunner = new RentalRunner();
			try {
				RentalManager rentalManager = rentalRunner.mainRunner();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/*List<User> users = new ArrayList<User>();
			users.add(new User("user1", "user1", false));
			users.add(new User("user2", "user2", false));
			users.add(new User("user3", "user3", false));
			request.setAttribute("list", users);*/
			
			RentalRunner rentalRunner1 = new RentalRunner();
			RentalManager rentalManager;
			try {
				rentalManager = rentalRunner1.mainRunner();
				HashMap<Integer, Equipment> eq = new HashMap<Integer, Equipment>();
				eq = rentalManager.getRentStation().getSpareEquipments();
				System.out.println(eq);
				request.setAttribute("equipments", eq);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			page = JSP_PATH + "/user.jsp";
			// список оборудования доступного к прокату из XML ( каталог )
		} else if ( "admin".equals(login) && "admin".equals(password) ) {
			RentalRunner rentalRunner = new RentalRunner();
			try {
				RentalManager rentalManager = rentalRunner.mainRunner();
				ArrayList<Equipment> eq = new ArrayList<Equipment>();
				eq = rentalManager.getRentedEquipmentsByTime(new Date().getTime() - 60 * 60, new Date().getTime());
				//System.out.println(eq);
				request.setAttribute("equipments", eq);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			/*List<User> users = new ArrayList<User>();
			users.add(new User("admin1", "admin1", true));
			users.add(new User("admin2", "admin2", true));
			users.add(new User("admin3", "admin3", true));
			request.setAttribute("list", users);*/
			page = JSP_PATH + "/admin.jsp";
		} else {
			page = JSP_PATH + "/error.jsp";
		}
		return page;
	}

	
}
