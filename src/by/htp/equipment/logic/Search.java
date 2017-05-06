package by.htp.equipment.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import by.htp.equipment.entity.Equipment;

public class Search {
	///// find equipment by param
	public static List<Equipment> findEquipmentByParams(double price) {
		List<Equipment> eq = new ArrayList<Equipment>();
		for ( Equipment equipment : rentStation.getEquipments() ) {
			if ( equipment.getPrice() < price && !Arrays.asList(rentStation.getSpareEquipments()).contains(equipment.getId()) ) {
				eq.add(equipment);
			}
		}

		return eq;
	}
	
	public static Equipment findSpareEquipmentByType(String type) 
			throws ClassNotFoundException {
		for ( Equipment equipment : rentStation.getSpareEquipments() ) {
			if ( Class.forName("by.htp.rental.entity."+type).isInstance(equipment)) {
				return equipment;
			}
		}
		return null;
	}
}
