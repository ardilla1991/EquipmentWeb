package by.htp.equipment.service;

import java.util.List;

import by.htp.equipment.dao.RentDao;
import by.htp.equipment.dao.RentDaoImpl;
import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.Order;

public class RentServiceImpl implements RentService{

	private RentDao dao;
	
	public RentServiceImpl() {
		dao = new RentDaoImpl();
	}
	
	@Override
	public void createRentedList(Order order, List<Equipment> equipments) {
		
		dao.addRentedEquipments(order, equipments);
	}

}
