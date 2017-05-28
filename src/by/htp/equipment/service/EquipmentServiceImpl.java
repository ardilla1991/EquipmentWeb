package by.htp.equipment.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import by.htp.equipment.dao.EquipmentDao;
import by.htp.equipment.dao.EquipmentDaoChooser;
import by.htp.equipment.entity.Equipment;

public class EquipmentServiceImpl implements EquipmentService{	

	private EquipmentDao dao = EquipmentDaoChooser.chooseStorage();
	private ParameterService parameterService;
	
	public EquipmentServiceImpl() {
		super();
		parameterService = new ParameterServiceImpl();
	}
	
	public List<Equipment> list() {

		return dao.getEquipments();
	}
	
	public List<Equipment> getListByCategory(String categoryIdS) {
		int categoryId = Integer.valueOf(categoryIdS);
		return dao.getListByCategory(categoryId);
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

	public List<Equipment> prepareEquipmentForRent(String equipmentsStr) {
		String[] ids = equipmentsStr.split(",");
		List<Equipment> equipments = dao.getEquipmentsByIds(ids);

		return equipments;
	}
	
	public long addEquipment(Equipment equipment) {
		long id = dao.addEquipment(equipment); 
		equipment.setId(id);
		parameterService.setParametersValues(equipment.getId(), equipment.getParameters());
		return id;
	}
	
	public Equipment getEquipmentById(String equipmentIdS) {
		Equipment equipment = dao.getEquipmentById(Long.valueOf(equipmentIdS));
		equipment.setParameters(parameterService.getParametersValuesByEquipmentId(equipment.getId()));

		return equipment;
	}
	
	public long editEquipment(Equipment equipment) {
		long id = dao.editEquipment(equipment); 
		parameterService.deleteParametersValues(equipment.getId());
		parameterService.setParametersValues(equipment.getId(), equipment.getParameters());
		
		return id;
	}
}
