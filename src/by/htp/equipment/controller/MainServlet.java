package by.htp.equipment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.equipment.command.CommandAction;
import by.htp.equipment.command.CommandChooser;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 5756373958726035336L;

    public MainServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//UserDao dao = new UserDaoImpl();
		//dao.fetchByCredentials("", "");
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String page = null;
		if ( action != null ) {
			CommandAction currAction = CommandChooser.chooseAction(action);
			page = currAction.execute(request, response);
			
			RequestDispatcher disp = request.getRequestDispatcher(page);
			disp.forward(request, response);
		}
	}

}
