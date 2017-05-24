package by.htp.equipment.dao;

import static by.htp.equipment.util.ConstantValue.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.equipment.controller.Loader;
import by.htp.equipment.entity.Category;
import by.htp.equipment.entity.CategoryTypeEnum;
import by.htp.equipment.entity.Parameter;

public class ParameterDaoImpl implements ParameterDao{

	@Override
	public List<Parameter> getListParametersByCategory(int categoryId) {
		System.out.println("get!");
		List<Parameter> paremeters = new ArrayList<Parameter>();
		
		try {
			Connection dbConnector = Loader.LoaderDb();
			PreparedStatement ps = dbConnector.prepareStatement(ADMIN_SQL_STATEMENT_PARAMETERS_LIST_BY_CATEGORY);
			ps.setInt(1, categoryId);
			
			ResultSet rs = ps.executeQuery();
			
			System.out.println("oook");
			while ( rs.next() ) {
				System.out.println("next");
				
				int id = rs.getInt(1);
				int category = rs.getInt(2);
				String title = rs.getString(3);
				
				Parameter param = new Parameter();
				param.setId(id);
				param.setTitle(title);
				Category cat = new Category();
				cat.setId(category);
				param.setCategory(cat);
				
				paremeters.add(param);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(paremeters);
		
		return paremeters;
	}

}
