package by.htp.equipment.filter;

import static by.htp.equipment.util.ConstantValue.ADMIN_SQL_STATEMENT_LOG_ADD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import by.htp.equipment.controller.Loader;

public class RequestLoggingFilter implements Filter{

	public void init(FilterConfig filterConfigObj) {
		  //this.filterConfigObj = filterConfigObj;
		  }
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		Enumeration<String> params = req.getParameterNames();
		while(params.hasMoreElements()) {
			String name = params.nextElement();
			String value = request.getParameter(name);
		}
		
		try {
			Connection dbConnector = Loader.LoaderDb();
			//Statement st = conn.createStatement();
			//ResultSet rs = st.executeQuery(SQL_STATEMENT_SELECT_USERs);
			PreparedStatement ps = dbConnector.prepareStatement(ADMIN_SQL_STATEMENT_LOG_ADD);
			ps.setString(1, "userLogin");
			//ps.setLong(2, order.getEquipments().getId());
			ps.setString(2, "action");
			ps.setString(3, "sub_action");
			ps.setInt(4, 1);
			ps.setString(5, "All are good");
						
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		chain.doFilter(request, response);
	}
	
	 public void destroy() { }

}
