package by.htp.equipment.service;

import java.util.List;

import by.htp.equipment.entity.Equipment;

public interface EquipmentService {
	
	List<Equipment> list();
	
	List<Equipment> getListByCategory(String categoryIdS);
	
	List<Equipment> listOfSpareEquipments();
	
	List<Equipment> findEquipmentByParams(double price);
	
	Equipment findSpareEquipmentByType(String type) throws ClassNotFoundException;
	
	List<Equipment> prepareEquipmentForRent(String equipmentsStr);
	
	long addEquipment(Equipment equipment);
	
	Equipment getEquipmentById(String equipmentIdS);
	
	long editEquipment(Equipment equipment);
}
