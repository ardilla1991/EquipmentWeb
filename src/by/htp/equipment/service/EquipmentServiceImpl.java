package by.htp.equipment.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import by.htp.equipment.dao.EquipmentDao;
import by.htp.equipment.entity.Accessory;
import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.MainEquipment;
import by.htp.equipment.entity.Order;
import by.htp.equipment.entity.Person;

public abstract class EquipmentServiceImpl implements EquipmentService{	

	protected static EquipmentDao dao = null;
	
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
	
	/*public boolean rent(Order order) {
		if ( isExceededNumberOfEquipmentForUser(order) )
				return false;

		orderDB.addOrder(order); // add order to person
		rentStation.addEngagedEquipment(order.getEquipment());
		rentStation.deleteSpareEquipment(order.getEquipment());
		
		return true;
	}
	
	private boolean isExceededNumberOfEquipmentForUser(Order order) {
		if ( order.getEquipment() instanceof Accessory ) {
			return false;
		}
		
		if ( countRentedMainEquipmentByUser(order.getPerson()) == NUM_ALLOW_EQUIPMENT_FOR_RENT ) {
			return true;
		}
		
		return false;
	}
	
	private int countRentedMainEquipmentByUser(Person person) {
		ArrayList<Order> orders = orderDB.getEquipmentsOfPerson(person);
		int counter = 0;
		for (Order order : orders ){
			if ( order.getEquipment() instanceof MainEquipment ) {
				counter++;
			}
		}
		
		return counter;
	}
	
	public void resetEquipments() {
		for (ArrayList<Order> value : (orderDB.getUnits()).values()) {
			for (int i = 0; i < value.size(); i++){
				if ( value.get(i) != null && isEquipmentIsRentByDate(value.get(i))) {
					rentStation.deleteEngagedEquipment(value.get(i).getEquipment());
					rentStation.addSpareEquipment(value.get(i).getEquipment());
					value.remove(i);	
				}
			}
		}
	}
	
	private boolean isEquipmentIsRentByDate(Order order) {
		return order.getRentDate().getTime() + order.getRentPeriod() * 60 * 60 < new Date().getTime();
	}*/

}
