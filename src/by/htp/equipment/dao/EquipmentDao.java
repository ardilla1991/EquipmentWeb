package by.htp.equipment.dao;

import java.util.List;

import by.htp.equipment.entity.Equipment;

public interface EquipmentDao {
	
	public List<Equipment> getSpareEquipments();

	List<Equipment> getListByCategory(int categoryId);
	
	List<Equipment> getEngagedEquipments();
	
	List<Equipment> getEquipments();

	List<Equipment> list();
	
	long addEquipment(Equipment equipment);

	void addEngagedEquipment(Equipment eq);
	
	void addSpareEquipment(Equipment eq);	
	
	void deleteSpareEquipment(Equipment eq);
	
	void deleteEngagedEquipment(Equipment eq);
	
	List<Equipment> getEquipmentsByIds(String[] ids);
	
	Equipment getEquipmentById(long id);
	
	long editEquipment(Equipment equipment);
}
