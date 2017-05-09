package by.htp.equipment.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import by.htp.equipment.dao.EquipmentDao;
import by.htp.equipment.dao.EquipmentDaoChooser;
import by.htp.equipment.entity.Accessory;
import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.MainEquipment;
import by.htp.equipment.entity.Order;
import by.htp.equipment.entity.Person;

public class EquipmentServiceImpl implements EquipmentService{	

	private EquipmentDao dao = EquipmentDaoChooser.chooseStorage();
	
	public EquipmentServiceImpl() {
		super();
	}
	
	public List<Equipment> list() {

		return dao.getEquipments();
	}
	
	public List<Equipment> listOfSpareEquipments() {

		return dao.getSpareEquipments();
	}
	
	public List<Equipment> findEquipmentByParams(double price) {
		List<Equipment> eq = new ArrayList<Equipment>();
		for ( Equipment equipment : dao.getEquipments() ) {
			if ( equipment.getPrice() < price && !Arrays.asList(dao.getSpareEquipments()).contains(equipment.getId()) ) {
				eq.add(equipment);
			}
		}

		return eq;
	}
	
	public Equipment findSpareEquipmentByType(String type) 
			throws ClassNotFoundException {
		for ( Equipment equipment : dao.getSpareEquipments() ) {
			if ( Class.forName("by.htp.equipment.entity."+type).isInstance(equipment)) {
				return equipment;
			}
		}
		return null;
	}

}
