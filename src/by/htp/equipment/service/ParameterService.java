package by.htp.equipment.service;

import java.util.List;

import by.htp.equipment.entity.Category;
import by.htp.equipment.entity.Parameter;

public interface ParameterService {
	
	List<Parameter> getParametersByCategory(Category category);
	
	void setParametersValues(long equipmentId, List<Parameter> parameters);
	
	List<Parameter> getParametersValuesByEquipmentId(long equipmentId);
	
	void deleteParametersValues(long equipmentId);
}
