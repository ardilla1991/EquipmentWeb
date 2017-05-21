package by.htp.equipment.dao;

import static by.htp.equipment.util.ConstantValue.ADMIN_SQL_STATEMENT_CATEGORY_LIST;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.equipment.controller.Loader;
import by.htp.equipment.entity.Category;
import by.htp.equipment.entity.CategoryTypeEnum;

public class CategoryDaoImpl implements CategoryDao{

	@Override
	public List<Category> list() {
		System.out.println("get!");
		List<Category> categories = new ArrayList<Category>();
		
		try {
			Connection dbConnector = Loader.LoaderDb();
			Statement st = dbConnector.createStatement();
			ResultSet rs = st.executeQuery(ADMIN_SQL_STATEMENT_CATEGORY_LIST);
			
			System.out.println("oook");
			while ( rs.next() ) {
				System.out.println("next");
				int id = rs.getInt(1);
				String title = rs.getString(2);
				CategoryTypeEnum type = CategoryTypeEnum.valueOf(rs.getString(3));
				
				Category category = new Category();
				category.setId(id);
				category.setTitle(title);
				category.setType(type);
				
				categories.add(category);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(categories);
		return categories;
	}

}
