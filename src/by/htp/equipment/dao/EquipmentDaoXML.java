package by.htp.equipment.dao;

import java.util.ArrayList;
import java.util.List;

import by.htp.equipment.entity.Equipment;

public class EquipmentDaoXML implements EquipmentDao{
	
	private static List<Equipment> equipments = new ArrayList<Equipment>();
	private static List<Equipment> spareEquipments = new ArrayList<Equipment>();
	private static List<Equipment> engagedEquipments = new ArrayList<Equipment>();
	
	public List<Equipment> getSpareEquipments() {
		
		return spareEquipments;
	}
	
	public List<Equipment> getEngagedEquipments() {
		
		return engagedEquipments;
	}
	
	public List<Equipment> getEquipments() {
		return equipments;
	}

	public List<Equipment> list() {
		
		return equipments;
	}
	
	public void addEquipment(Equipment equipment) {
		equipment.setId(generateIdOfEquipment());
		equipments.add(equipment);
		spareEquipments.add(equipment);
	}
	
	private int generateIdOfEquipment() {
		return (int) (Math.random() * 100000);
	}
	
	public void addEngagedEquipment(Equipment eq) {
		engagedEquipments.add(eq);
	}
	
	public void addSpareEquipment(Equipment eq) {
		engagedEquipments.add(eq);
	}	
	
	public void deleteSpareEquipment(Equipment eq) {
		spareEquipments.remove(eq);
	}
	
	public void deleteEngagedEquipment(Equipment eq) {
		engagedEquipments.remove(eq);
	}
	
	@Override
	public String toString() {
		return "RentStation [equipments=" + equipments + "]";
	}
	
}
