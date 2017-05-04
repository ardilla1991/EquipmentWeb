package by.htp.equipment.service;

import static by.htp.equipment.util.ConstantValue.REQUEST_PARAM_LIST_EQ;

import java.util.HashMap;

import by.htp.rental.entity.Equipment;
import by.htp.rental.launch.RentalRunner;
import by.htp.rental.logic.RentalManager;

public class EquipmentServiceImpl implements EquipmentService{

	@Override
	public HashMap<Integer, Equipment> list() {
		HashMap<Integer, Equipment> eq = new HashMap<Integer, Equipment>();
		
		RentalRunner rentalRunner1 = new RentalRunner();
		RentalManager rentalManager;
		try {
			rentalManager = rentalRunner1.mainRunner();
			eq = rentalManager.getRentStation().getSpareEquipments();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return eq;
	}
	
	

}
