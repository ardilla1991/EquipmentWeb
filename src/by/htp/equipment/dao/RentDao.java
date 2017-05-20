package by.htp.equipment.dao;

import java.util.List;

import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.Order;

public interface RentDao {
	
	void addRentedEquipments(Order order, List<Equipment> equipments);
}
