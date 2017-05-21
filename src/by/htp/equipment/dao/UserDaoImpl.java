package by.htp.equipment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static by.htp.equipment.util.ConstantValue.*;

import by.htp.equipment.controller.Loader;
import by.htp.equipment.entity.User;

public class UserDaoImpl implements UserDao{

	@Override
	public User fetchByCredentials(String login, String password) {
		
		User user = null;
		
		try {
			Connection dbConnector = Loader.LoaderDb();
			
			//Statement st = conn.createStatement();
			//ResultSet rs = st.executeQuery(SQL_STATEMENT_SELECT_USERS);
			PreparedStatement ps = dbConnector.prepareStatement(SQL_STATEMENT_SELECT_USER);
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
				String name = rs.getString(4);
				//String firstName = rs.getString(4);
				//String secondName = rs.getString(5);
				//String passport = rs.getString(6);
				boolean role = rs.getBoolean(6);
				
				user = new User();
				user.setLogin(log);
				user.setPassword(pass);
				user.setName(name);
				//user.setFirstName(firstName);
				//user.setSecondName(secondName);
				//user.setPassport(passport);
				user.setRole(role);
			}
			
			System.out.println("user!!!");
			System.out.println(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return user;
	}

}
