package by.htp.equipment.dao;

import static by.htp.equipment.util.ConstantValue.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import by.htp.equipment.controller.Loader;
import by.htp.equipment.entity.Order;
import by.htp.equipment.entity.User;

public class OrderDaoDb implements OrderDao{

	public HashMap<Integer, ArrayList<Order>> getUnits() {
		return null;
	}
	
	public ArrayList<Order> getEquipmentsOfPerson(User user) {
		return null;
	}

	@Override
	public Long createOrder(Order  order) {
		Long id = (long) 0;
		
		try {
			Connection dbConnector = Loader.LoaderDb();
			//Statement st = conn.createStatement();
			//ResultSet rs = st.executeQuery(SQL_STATEMENT_SELECT_USERs);
			PreparedStatement ps = dbConnector.prepareStatement(SQL_STATEMENT_ORDER_CREATE, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setLong(1, order.getUser().getUserId());
			//ps.setLong(2, order.getEquipments().getId());
			ps.setDate(2, order.getDateStart());
			ps.setDate(3, order.getDateEnd());
						
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
			    id = rs.getLong(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return id;
	}

	@Override
	public List<Order> fetchAll() {
		return null;
	}

	@Override
	public List<Order> getOrdersByUser(User user) {
		List<Order> orders = new ArrayList<Order>();
		
		try {
			Connection dbConnector = Loader.LoaderDb();
			PreparedStatement ps = dbConnector.prepareStatement(SQL_STATEMENT_ORDER_LIST_BY_USER);
			ps.setLong(1, user.getUserId());
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next() ) {
				Long id = rs.getLong(1);
				//Long id_user = rs.getLong(2);
				System.out.println(rs.getDate(3));
				Date dateStart = rs.getDate(3);
				Date dateEnd = rs.getDate(4);
								
				Order order = new Order();
				order.setOrderId(id);
				order.setUser(user);
				order.setDateStart(dateStart);
				order.setDateEnd(dateEnd);
				
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return orders;
	}

}
