package by.htp.equipment.service;

import java.util.List;

import by.htp.equipment.dao.CategoryDao;
import by.htp.equipment.dao.CategoryDaoImpl;
import by.htp.equipment.entity.Category;

public class CategoryServiceImpl implements CategoryService{

	private CategoryDao dao;
	
	public CategoryServiceImpl() {
		dao = new CategoryDaoImpl();
	}
	
	@Override
	public List<Category> list() {

		return dao.list();
	}
	
}
