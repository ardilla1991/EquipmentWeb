package by.htp.equipment.dao;

import static by.htp.equipment.util.ConstantValue.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.htp.equipment.controller.Loader;
import by.htp.equipment.entity.Category;
import by.htp.equipment.entity.Parameter;

public class ParameterDaoImpl implements ParameterDao{

	@Override
	public List<Parameter> getListParametersByCategory(Category category) {
		List<Parameter> paremeters = new ArrayList<Parameter>();
		
		try {
			Connection dbConnector = Loader.LoaderDb();
			PreparedStatement ps = dbConnector.prepareStatement(ADMIN_SQL_STATEMENT_PARAMETERS_LIST_BY_CATEGORY);
			ps.setInt(1, category.getId());
			
			ResultSet rs = ps.executeQuery();

			while ( rs.next() ) {
				
				int id = rs.getInt(1);
				int categoryId = rs.getInt(2);
				String title = rs.getString(3);
				String description = rs.getString(4);
				
				Parameter param = new Parameter();
				param.setId(id);
				param.setTitle(title);
				param.setDescription(description);
				Category cat = new Category();
				cat.setId(categoryId);
				param.setCategory(cat);
				
				paremeters.add(param);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return paremeters;
	}
	
	public void setParametersValues(long equipmentId, List<Parameter> parameters) {

		try {
			Connection dbConnector = Loader.LoaderDb();
			
			for ( Parameter parameter : parameters ) {
				PreparedStatement ps = dbConnector.prepareStatement(ADMIN_SQL_STATEMENT_EQUIPMENT_PARAMETER_VALUE_ADD);
				ps.setLong(1, parameter.getId());
				ps.setLong(2, equipmentId);
				ps.setString(3, parameter.getValue());
				ps.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
		
	}
	
	public List<Parameter> getParametersValuesByEquipmentId(long equipmentId) {
		List<Parameter> paremeters = new ArrayList<Parameter>();
		
		try {
			Connection dbConnector = Loader.LoaderDb();
			PreparedStatement ps = dbConnector.prepareStatement(ADMIN_SQL_STATEMENT_PARAMETERS_VALUES_BY_EQUIPMENT_ID);
			ps.setLong(1, equipmentId);
			
			ResultSet rs = ps.executeQuery();

			while ( rs.next() ) {

				int id = rs.getInt(1);
				
				int categoryId = rs.getInt(2);
				Category cat = new Category();
				cat.setId(categoryId);
				
				String title = rs.getString(3);
				String description = rs.getString(4);
				String value = rs.getString(5);
				
				Parameter param = new Parameter();
				param.setId(id);
				param.setTitle(title);
				param.setDescription(description);
				param.setCategory(cat);
				param.setValue(value);
				
				paremeters.add(param);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
		return paremeters;
	}

	public void deleteParametersValues(long equipmentId) {
	
		try {
			Connection dbConnector = Loader.LoaderDb();
			PreparedStatement ps = dbConnector.prepareStatement(ADMIN_SQL_STATEMENT_PARAMETERS_VALUES_DELETE_BY_EQUIPMENT_ID);
			ps.setLong(1, equipmentId);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
