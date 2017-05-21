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
import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.PersonCategoryEnum;
import by.htp.equipment.entity.User;

public class EquipmentDaoDb implements EquipmentDao{
	//private static List<Equipment> equipments = new ArrayList<Equipment>();
	//private static List<Equipment> spareEquipments = new ArrayList<Equipment>();
	//private static List<Equipment> engagedEquipments = new ArrayList<Equipment>();
	public EquipmentDaoDb() {
		
	}
	
	public List<Equipment> getSpareEquipments() {
		System.out.println("get!");
		List<Equipment> equipments = new ArrayList<Equipment>();
		
		try {
			Connection dbConnector = Loader.LoaderDb();
			Statement st = dbConnector.createStatement();
			ResultSet rs = st.executeQuery(SQL_STATEMENT_EQUIPMENT_SELECT_SPARE_EQUIPMENTS);
			
			System.out.println("oook");
			while ( rs.next() ) {
				System.out.println("next");
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
				eq.setCategoryId(categoryId);
				
				equipments.add(eq);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(equipments);
		return equipments;
	}
	
	public List<Equipment> getListByCategory(int categoryId) {
		
		System.out.println("get!");
		List<Equipment> equipments = new ArrayList<Equipment>();
		
		try {
			Connection dbConnector = Loader.LoaderDb();
			PreparedStatement ps = dbConnector.prepareStatement(ADMIN_SQL_STATEMENT_EQUIPMENT_SELECT_LIST_BY_CATEGORY);
			ps.setInt(1, categoryId);
			ResultSet rs = ps.executeQuery();
			
			System.out.println("oook");
			while ( rs.next() ) {
				System.out.println("next");
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
				eq.setCategoryId(categoryIdEl);
				
				equipments.add(eq);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(equipments);
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
	
	public void addEquipment(Equipment equipment) {
		equipment.setId(generateIdOfEquipment());
		//equipments.add(equipment);
		//spareEquipments.add(equipment);
	}
	
	private static Long generateIdOfEquipment() {
		return (long) (Math.random() * 100000);
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
		System.out.println("get!");
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
				eq.setCategoryId(categoryId);
				
				equipments.add(eq);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(equipments);
		
		return equipments;
	}
}
