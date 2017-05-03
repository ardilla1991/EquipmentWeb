package by.htp.equipment.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.equipment.entity.User;

public class LoginCommandAction implements CommanAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		String password = request.getParameter("pass");
		String page = "";
		if ( "user".equals(login) && "user".equals(password)) {
			List<User> users = new ArrayList<User>();
			users.add(new User("user1", "user1", false));
			users.add(new User("user2", "user2", false));
			users.add(new User("user3", "user3", false));
			request.setAttribute("list", users);
			page = "/user.jsp";
			// список оборудования доступного к прокату из XML ( каталог )
		} else if ( "admin".equals(login) && "admin".equals(password) ) {
			
			List<User> users = new ArrayList<User>();
			users.add(new User("admin1", "admin1", true));
			users.add(new User("admin2", "admin2", true));
			users.add(new User("admin3", "admin3", true));
			request.setAttribute("list", users);
			page = "/admin.jsp";
			
			// отчет за текущий день
		} else {
			page = "/error.jsp";
		}
		return page;
	}

	
}
