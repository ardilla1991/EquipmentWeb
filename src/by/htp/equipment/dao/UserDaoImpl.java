package by.htp.equipment.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import static by.htp.equipment.util.ConstantValue.*;

import by.htp.equipment.entity.User;

public class UserDaoImpl implements UserDao{

	@Override
	public User fetchByCredentials(String login, String password) {
		
		ResourceBundle rb = ResourceBundle.getBundle("config");
		String dbUrl = rb.getString("db.url");
		String dbUser = rb.getString("db.login");
		String dbPass = rb.getString("db.pass");
		String driverName = rb.getString("db.driver.name");
		System.out.println(dbUrl);
		
		User user = null;
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName(driverName);
			Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
			
			//Statement st = conn.createStatement();
			//ResultSet rs = st.executeQuery(SQL_STATEMENT_SELECT_USERs);
			PreparedStatement ps = conn.prepareStatement(SQL_STATEMENT_SELECT_USER);
			ps.setString(1, login);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			/*while (rs.next()) {
				String log = rs.getString(2);
				String pass = rs.getString(3);
				System.out.println("log=" + log + "; pass=" + pass);
			}*/
			if ( rs.next() ) {
				String log = rs.getString(2);
				String pass = rs.getString(3);
				String firstName = rs.getString(4);
				String secondName = rs.getString(5);
				String passport = rs.getString(6);
				boolean role = rs.getBoolean(7);
				
				user = new User();
				user.setLogin(log);
				user.setPassword(pass);
				user.setFirstName(firstName);
				user.setSecondName(secondName);
				user.setPassport(passport);
				user.setRole(role);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return user;
	}

}
