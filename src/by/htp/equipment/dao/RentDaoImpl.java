package by.htp.equipment.dao;

import static by.htp.equipment.util.ConstantValue.SQL_STATEMENT_RENT_CREATE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import by.htp.equipment.controller.Loader;
import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.Order;

public class RentDaoImpl implements RentDao{

	@Override
	public void addRentedEquipments(Order order, List<Equipment> equipments) {
		System.out.println("RENT!!!");
		System.out.println(equipments);
		try {
			Connection dbConnector = Loader.LoaderDb();
			//Statement st = conn.createStatement();
			//ResultSet rs = st.executeQuery(SQL_STATEMENT_SELECT_USERs);
			PreparedStatement ps = dbConnector.prepareStatement(SQL_STATEMENT_RENT_CREATE);
			for ( Equipment eq : equipments ) {
				System.out.println(eq);
				ps.setLong(1, order.getOrderId());
				ps.setLong(2, eq.getId());
				ps.addBatch();
			}
						
			ps.executeBatch();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
