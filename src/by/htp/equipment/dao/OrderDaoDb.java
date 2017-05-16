package by.htp.equipment.dao;

import static by.htp.equipment.util.ConstantValue.SQL_STATEMENT_ORDER_CREATE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import by.htp.equipment.controller.Loader;
import by.htp.equipment.entity.Order;
import by.htp.equipment.entity.Person;
import by.htp.equipment.entity.User;

public class OrderDaoDb implements OrderDao{

	public HashMap<Integer, ArrayList<Order>> getUnits() {
		return null;
	}
	
	public ArrayList<Order> getEquipmentsOfPerson(User user) {
		return null;
	}

	@Override
	public void createOrder(Order  order) {
		User user = null;
		
		try {
			Connection dbConnector = Loader.LoaderDb();
			
			//Statement st = conn.createStatement();
			//ResultSet rs = st.executeQuery(SQL_STATEMENT_SELECT_USERs);
			PreparedStatement ps = dbConnector.prepareStatement(SQL_STATEMENT_ORDER_CREATE, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setLong(1, order.getUser().getUserId());
			ps.setLong(2, order.getEquipment().getId());
			ps.setDate(3, order.getDateStart());
			ps.setDate(4, order.getDateEnd());
			
			int id = ps.RETURN_GENERATED_KEYS;
			ps.executeUpdate();
			
			
			/*while (rs.next()) {
				String log = rs.getString(2);
				String pass = rs.getString(3);
				System.out.println("log=" + log + "; pass=" + pass);
			}*/
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Order> fetchAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
