package by.htp.equipment.dao;

import java.util.List;

import by.htp.equipment.entity.Equipment;

public interface EquipmentDao {
	
	public List<Equipment> getSpareEquipments();
	
	public List<Equipment> getEngagedEquipments();
	
	public List<Equipment> getEquipments();

	public List<Equipment> list();
	
	public void addEquipment(Equipment equipment);

	public void addEngagedEquipment(Equipment eq);
	
	public void addSpareEquipment(Equipment eq);	
	
	public void deleteSpareEquipment(Equipment eq);
	
	public void deleteEngagedEquipment(Equipment eq);
	
	public List<Equipment> getEquipmentsByIds(String[] ids);

}
