package by.htp.equipment.dao;

import java.util.List;

import by.htp.equipment.entity.Category;
import by.htp.equipment.entity.Parameter;

public interface ParameterDao {

	List<Parameter> getListParametersByCategory(Category category);
	
	void setParametersValues(long equipmentId, List<Parameter> parameters);
	
	List<Parameter> getParametersValuesByEquipmentId(long equipmentId);
	
	void deleteParametersValues(long equipmentId);
}
