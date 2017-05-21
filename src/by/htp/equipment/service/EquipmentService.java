package by.htp.equipment.service;

import java.util.List;

import by.htp.equipment.entity.Equipment;

public interface EquipmentService {
	
	List<Equipment> list();
	
	List<Equipment> getListByCategory(String categoryIdS);
	
	List<Equipment> listOfSpareEquipments();
	
	public List<Equipment> findEquipmentByParams(double price);
	
	public Equipment findSpareEquipmentByType(String type) throws ClassNotFoundException;
	
	public List<Equipment> prepareEquipmentForRent(String equipmentsStr);
}
