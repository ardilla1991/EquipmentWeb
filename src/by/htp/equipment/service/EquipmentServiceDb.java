package by.htp.equipment.service;

import java.util.ArrayList;
import java.util.List;

import by.htp.equipment.dao.EquipmentDaoDb;
import by.htp.equipment.entity.Equipment;

public class EquipmentServiceDb extends EquipmentServiceImpl{
	
	static {
		dao = new EquipmentDaoDb();
	}
	
	public EquipmentServiceDb() {
		super();
	}
	
}
