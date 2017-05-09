package by.htp.equipment.service;

import java.util.ArrayList;

import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.Order;

public interface OrderService {
	
	public boolean rent(Order order);
	
	public void prepareBase(EquipmentService equipService);
	
	public ArrayList<Equipment> getRentedEquipmentsByTime(long from, long to);
}
