package by.htp.equipment.service;

import java.util.List;

import by.htp.equipment.dao.ParameterDao;
import by.htp.equipment.dao.ParameterDaoImpl;
import by.htp.equipment.entity.Category;
import by.htp.equipment.entity.Parameter;

public class ParameterServiceImpl implements ParameterService{
	
	private ParameterDao dao;
	
	public ParameterServiceImpl() {
		dao = new ParameterDaoImpl();
	}

	public List<Parameter> getParametersByCategory(Category category) {
		
		return dao.getListParametersByCategory(category);
	}
	
	public void setParametersValues(long equipmentId, List<Parameter> parameters) {

		dao.setParametersValues(equipmentId, parameters);
	}
	
	public List<Parameter> getParametersValuesByEquipmentId(long equipmentId) {
		
		return dao.getParametersValuesByEquipmentId(equipmentId);
	}
	
	public void deleteParametersValues(long equipmentId) {
		dao.deleteParametersValues(equipmentId);
	}
}
