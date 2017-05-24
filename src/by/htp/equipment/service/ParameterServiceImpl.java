package by.htp.equipment.service;

import java.util.List;

import by.htp.equipment.dao.ParameterDao;
import by.htp.equipment.dao.ParameterDaoImpl;
import by.htp.equipment.entity.Parameter;

public class ParameterServiceImpl implements ParameterService{
	
	private ParameterDao dao;
	
	public ParameterServiceImpl() {
		dao = new ParameterDaoImpl();
	}

	public List<Parameter> getParametersByCategory(int categoryId) {
		
		return dao.getListParametersByCategory(categoryId);
	}
}
