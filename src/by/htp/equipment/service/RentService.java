package by.htp.equipment.service;

import java.util.List;

import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.Order;

public interface RentService {
	
	void createRentedList(Order order, List<Equipment> equipments);
}
