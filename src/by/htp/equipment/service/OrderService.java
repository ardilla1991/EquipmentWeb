package by.htp.equipment.service;

import java.sql.Date;
import java.util.ArrayList;

import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.Order;
import by.htp.equipment.entity.User;

public interface OrderService {
	
	public boolean rent(Order order);
	
	public void prepareBase(EquipmentService equipService);
	
	public ArrayList<Equipment> getRentedEquipmentsByTime(long from, long to);
	
	public Order makeOrder(User user, Equipment equipment, Date start, Date end);
}
