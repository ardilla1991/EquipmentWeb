package by.htp.equipment.service;

import java.util.List;

import by.htp.equipment.builder.AbstractEquipmentsBuilder;
import by.htp.equipment.builder.EquipmentBuilderFactory;
import by.htp.equipment.dao.EquipmentDaoXML;
import by.htp.equipment.entity.Equipment;
import static by.htp.equipment.util.ConstantValue.*;

public class EquipmentServiceXML implements EquipmentService{	
	
	private static EquipmentDaoXML dao = null;
	
	static {
		dao = new EquipmentDaoXML();
		setList();
	}
	
	public EquipmentServiceXML() {
		System.out.println("service xml");
		//dao = new EquipmentDaoXML();
	}
	
	public static void setList() {
		EquipmentBuilderFactory sFactory = new EquipmentBuilderFactory();
		AbstractEquipmentsBuilder builder = sFactory.createEquipmentBuilder(XML_PARSER_TYPE);
		builder.buildListEquipments(XML_FILE_PATH);

		dao.setEquipments(builder.getEquipments());
	}
	
	public List<Equipment> list() {
		//setList();
			
		return dao.getEquipments();
	}
	
	public List<Equipment> listOfSpareEquipments() {
		//setList();
		
		return dao.getSpareEquipments();
	}
}
