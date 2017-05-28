package by.htp.equipment.dao;

import static by.htp.equipment.util.ConstantValue.*;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import by.htp.equipment.controller.Loader;
import by.htp.equipment.entity.Category;
import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.PersonCategoryEnum;

public class EquipmentDaoDb implements EquipmentDao{
	//private static List<Equipment> equipments = new ArrayList<Equipment>();
	//private static List<Equipment> spareEquipments = new ArrayList<Equipment>();
	//private static List<Equipment> engagedEquipments = new ArrayList<Equipment>();
	public EquipmentDaoDb() {
		
	}
	
	public List<Equipment> getSpareEquipments() {

		List<Equipment> equipments = new ArrayList<Equipment>();
		
		try {
			Connection dbConnector = Loader.LoaderDb();
			Statement st = dbConnector.createStatement();
			ResultSet rs = st.executeQuery(SQL_STATEMENT_EQUIPMENT_SELECT_SPARE_EQUIPMENTS);

			while ( rs.next() ) {
				Long id = rs.getLong(1);
				String model = rs.getString(2);
				double price = rs.getDouble(3);
				double weight = rs.getDouble(4);
				double width = rs.getDouble(5);
				double height = rs.getDouble(6);
				String personCategory = rs.getString(7);
				boolean isRent = rs.getBoolean(8);
				int categoryId = rs.getInt(9);
				
				Equipment eq = new Equipment();
				eq.setId(id);
				eq.setModel(model);
				eq.setPrice(price);
				eq.setWeight(weight);
				eq.setWidth(width);
				eq.setHeight(height);
				eq.setPersonCategory(PersonCategoryEnum.valueOf(personCategory));
				eq.setIsRent(isRent);
				Category category = new Category();
				category.setId(categoryId);
				eq.setCategory(category);
				
				equipments.add(eq);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return equipments;
	}
	
	public List<Equipment> getListByCategory(int categoryId) {

		List<Equipment> equipments = new ArrayList<Equipment>();
		
		try {
			Connection dbConnector = Loader.LoaderDb();
			PreparedStatement ps = dbConnector.prepareStatement(ADMIN_SQL_STATEMENT_EQUIPMENT_SELECT_LIST_BY_CATEGORY);
			ps.setInt(1, categoryId);
			ResultSet rs = ps.executeQuery();

			while ( rs.next() ) {
				Long id = rs.getLong(1);
				String model = rs.getString(2);
				double price = rs.getDouble(3);
				double weight = rs.getDouble(4);
				double width = rs.getDouble(5);
				double height = rs.getDouble(6);
				String personCategory = rs.getString(7);
				boolean isRent = rs.getBoolean(8);
				int categoryIdEl = rs.getInt(9);
				
				Equipment eq = new Equipment();
				eq.setId(id);
				eq.setModel(model);
				eq.setPrice(price);
				eq.setWeight(weight);
				eq.setWidth(width);
				eq.setHeight(height);
				eq.setPersonCategory(PersonCategoryEnum.valueOf(personCategory));
				eq.setIsRent(isRent);
				Category category = new Category();
				category.setId(categoryIdEl);
				eq.setCategory(category);
				
				equipments.add(eq);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return equipments;
	}
	
	public List<Equipment> getEngagedEquipments() {
		
		return null;
	}
	
	public List<Equipment> getEquipments() {
		return null;
	}

	public List<Equipment> list() {
		
		return null;
	}
	
	public long addEquipment(Equipment equipment) {

		Long id = (long) 0;

		try {
			Connection dbConnector = Loader.LoaderDb();
			PreparedStatement ps = dbConnector.prepareStatement(ADMIN_SQL_STATEMENT_EQUIPMENT_ADD, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, equipment.getModel());
			ps.setDouble(2, equipment.getPrice());
			ps.setDouble(3, equipment.getWeight());
			ps.setDouble(4, equipment.getWidth());
			ps.setDouble(5, equipment.getHeight());
			ps.setString(6, equipment.getPersonCategory().toString());
			ps.setBoolean(7, equipment.getIsRent());
			ps.setInt(8, equipment.getCategory().getId());
			ps.setString(9, "");
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
	
	public void addEngagedEquipment(Equipment eq) {
		//engagedEquipments.add(eq);
	}
		
	public void addSpareEquipment(Equipment eq) {
		//engagedEquipments.add(eq);
	}	
	
	public void deleteSpareEquipment(Equipment eq) {
		//spareEquipments.remove(eq);
	}
	
	public void deleteEngagedEquipment(Equipment eq) {
		//engagedEquipments.remove(eq);
	}
	
	@Override
	public String toString() {
		return "";
	}
	
	public List<Equipment> getEquipmentsByIds(String[] ids) {
		List<Equipment> equipments = new ArrayList<Equipment>();
		
		try {
			Connection dbConnector = Loader.LoaderDb();
			StringBuilder st = new StringBuilder();
			for ( int i = 0; i < ids.length; i++ ) {
				st.append("?,");
			}
			st.setLength(st.length() - 1);
			PreparedStatement ps = dbConnector.prepareStatement(SQL_STATEMENT_EQUIPMENT_SELECT_EQUIPMENTS_BY_IDS + "(" + st + ")");
			for ( int i = 0; i < ids.length; i++ ) {
				ps.setInt(i+1, Integer.parseInt(ids[i]));
			}
			ResultSet rs = ps.executeQuery();
			while ( rs.next() ) {
				Long id = rs.getLong(1);
				String model = rs.getString(2);
				double price = rs.getDouble(3);
				double weight = rs.getDouble(4);
				double width = rs.getDouble(5);
				double height = rs.getDouble(6);
				String personCategory = rs.getString(7);
				boolean isRent = rs.getBoolean(8);
				int categoryId = rs.getInt(9);
				
				Equipment eq = new Equipment();
				eq.setId(id);
				eq.setModel(model);
				eq.setPrice(price);
				eq.setWeight(weight);
				eq.setWidth(width);
				eq.setHeight(height);
				eq.setPersonCategory(PersonCategoryEnum.valueOf(personCategory));
				eq.setIsRent(isRent);
				Category category = new Category();
				category.setId(categoryId);
				eq.setCategory(category);
				
				equipments.add(eq);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return equipments;
	}
	
	public Equipment getEquipmentById(long id) {

		Equipment equipment = null;
		
		try {
			Connection dbConnector = Loader.LoaderDb();

			PreparedStatement ps = dbConnector.prepareStatement(ADMIN_SQL_STATEMENT_EQUIPMENT_SELECT_BY_ID);
			ps.setLong(1, id);

			ResultSet rs = ps.executeQuery();
			while ( rs.next() ) {
				Long equipmentId = rs.getLong(1);
				String model = rs.getString(2);
				double price = rs.getDouble(3);
				double weight = rs.getDouble(4);
				double width = rs.getDouble(5);
				double height = rs.getDouble(6);
				String personCategory = rs.getString(7);
				boolean isRent = rs.getBoolean(8);
				int categoryId = rs.getInt(9);
				
				equipment = new Equipment();
				equipment.setId(equipmentId);
				equipment.setModel(model);
				equipment.setPrice(price);
				equipment.setWeight(weight);
				equipment.setWidth(width);
				equipment.setHeight(height);
				equipment.setPersonCategory(PersonCategoryEnum.valueOf(personCategory));
				equipment.setIsRent(isRent);
				Category category = new Category();
				category.setId(categoryId);
				equipment.setCategory(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return equipment;
	}
	
	public long editEquipment(Equipment equipment) {

		try {
			Connection dbConnector = Loader.LoaderDb();
			PreparedStatement ps = dbConnector.prepareStatement(ADMIN_SQL_STATEMENT_EQUIPMENT_EDIT);
			ps.setString(1, equipment.getModel());
			ps.setDouble(2, equipment.getPrice());
			ps.setDouble(3, equipment.getWeight());
			ps.setDouble(4, equipment.getWidth());
			ps.setDouble(5, equipment.getHeight());
			ps.setString(6, equipment.getPersonCategory().toString());
			ps.setBoolean(7, equipment.getIsRent());
			ps.setInt(8, equipment.getCategory().getId());
			ps.setString(9, "");
			ps.setLong(10, equipment.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
		
		return equipment.getId();
	}
}
