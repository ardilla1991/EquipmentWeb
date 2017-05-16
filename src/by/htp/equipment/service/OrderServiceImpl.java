package by.htp.equipment.service;

import java.util.ArrayList;
import java.sql.Date;

import by.htp.equipment.dao.EquipmentDao;
import by.htp.equipment.dao.EquipmentDaoChooser;
import by.htp.equipment.dao.OrderDao;
import by.htp.equipment.dao.OrderDaoChooser;
import by.htp.equipment.entity.Accessory;
import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.MainEquipment;
import by.htp.equipment.entity.Order;
import by.htp.equipment.entity.User;

import static by.htp.equipment.util.ConstantValue.NUM_ALLOW_EQUIPMENT_FOR_RENT;

public class OrderServiceImpl implements OrderService{

	private OrderDao dao;
	private EquipmentDao daoEq = EquipmentDaoChooser.chooseStorage();
	
	public OrderServiceImpl() {
		dao = OrderDaoChooser.chooseStorage();
	}
	
	@Override
	public boolean rent(Order order) {
		if ( isExceededNumberOfEquipmentForUser(order) )
				return false;
	
		dao.createOrder(order); // add order to person
		daoEq.addEngagedEquipment(order.getEquipment());
		daoEq.deleteSpareEquipment(order.getEquipment());
		
		return true;
	}

	private boolean isExceededNumberOfEquipmentForUser(Order order) {
		if ( order.getEquipment() instanceof Accessory ) {
			return false;
		}
		
		if ( countRentedMainEquipmentByUser(order.getUser()) == NUM_ALLOW_EQUIPMENT_FOR_RENT ) {
			return true;
		}
		
		return false;
	}

	private int countRentedMainEquipmentByUser(User user) {
		ArrayList<Order> orders = dao.getEquipmentsOfPerson(user);
		int counter = 0;
		for (Order order : orders ){
			if ( order.getEquipment() instanceof MainEquipment ) {
				counter++;
			}
		}
		
		return counter;
	}
	
	public void resetEquipments() {
		for (ArrayList<Order> value : (dao.getUnits()).values()) {
			for (int i = 0; i < value.size(); i++){
				if ( value.get(i) != null && isEquipmentIsRentByDate(value.get(i))) {
					daoEq.deleteEngagedEquipment(value.get(i).getEquipment());
					daoEq.addSpareEquipment(value.get(i).getEquipment());
					value.remove(i);	
				}
			}
		}
	}
	
	private boolean isEquipmentIsRentByDate(Order order) {
		//return order.getRentDate().getTime() + order.getRentPeriod() * 60 * 60 < new Date().getTime();
		return false;
	}
	
	public void prepareBase(EquipmentService equipService) {
		User person1 = new User(new Long(1), "user", "user", false);

		resetEquipments();
		Equipment equipmentForRent;
		try {
			equipmentForRent = equipService.findSpareEquipmentByType("Bycicle");
			if ( equipmentForRent != null ) {
				Order order1 = new Order(person1, equipmentForRent, new Date(12345), new Date(12345));
				boolean resRent1 = rent(order1);
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		////////////////////////////////
		resetEquipments();
		Equipment equipmentForRent2;
		try {
			equipmentForRent2 = equipService.findSpareEquipmentByType("Bycicle");
			if ( equipmentForRent2 != null ) {
				Order order2 = new Order(person1, equipmentForRent2, new Date(12345), new Date(12345));
				boolean resRent2 = rent(order2);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public ArrayList<Equipment> getRentedEquipmentsByTime(Date from, Date to) {
		ArrayList<Equipment> eq = new ArrayList<Equipment>();
		for (ArrayList<Order> value : (dao.getUnits()).values()) {
			for (int i = 0; i < value.size(); i++){
				/*if ( value.get(i) != null && value.get(i).getDateStart() >= from 
						&& value.get(i).getDateStart() <= to ) {
					System.out.println(value.get(i).getEquipment());
					eq.add(value.get(i).getEquipment());
				}*/
			}
		}
		return eq;
	}

	@Override
	public ArrayList<Equipment> getRentedEquipmentsByTime(long from, long to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order makeOrder(User user, Equipment equipment, Date start, Date end) {
		
		Order order = new Order();
		order.setEquipment(equipment);
		order.setUser(user);
		order.setDateStart(start);
		order.setDateEnd(end);
		
		dao.createOrder(order);

		// STUB!
		return null;
	}
}
