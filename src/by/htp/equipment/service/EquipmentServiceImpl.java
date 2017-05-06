package by.htp.equipment.service;

import static by.htp.equipment.util.ConstantValue.REQUEST_PARAM_LIST_EQ;

import java.util.ArrayList;
import java.util.List;

import by.htp.equipment.entity.Equipment;

public class EquipmentServiceImpl implements EquipmentService{

	@Override
	public List<Equipment> list() {
		List<Equipment> eq = new ArrayList<Equipment>();
		
		// get list from DB		
		
		return eq;
	}
	
	public List<Equipment> listOfSpareEquipments() {
		
		return null;
	}

}
