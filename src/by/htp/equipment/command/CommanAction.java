package by.htp.equipment.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommanAction {
	public String execute(HttpServletRequest request, HttpServletResponse response);
}
