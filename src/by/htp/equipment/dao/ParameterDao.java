package by.htp.equipment.dao;

import java.util.List;

import by.htp.equipment.entity.Parameter;

public interface ParameterDao {

	List<Parameter> getListParametersByCategory(int categoryId);
}
