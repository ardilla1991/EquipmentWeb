package by.htp.equipment.service;

import java.util.List;

import by.htp.equipment.entity.Parameter;

public interface ParameterService {
	
	List<Parameter> getParametersByCategory(int categoryId);
}
