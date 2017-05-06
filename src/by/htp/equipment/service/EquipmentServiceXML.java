package by.htp.equipment.service;

import java.util.List;

import by.htp.equipment.builder.AbstractEquipmentsBuilder;
import by.htp.equipment.builder.EquipmentBuilderFactory;
import by.htp.equipment.dao.EquipmentDaoXML;
import by.htp.equipment.entity.Equipment;
import static by.htp.equipment.util.ConstantValue.*;

public class EquipmentServiceXML extends EquipmentServiceImpl{	
	
	static {
		dao = new EquipmentDaoXML();
		setList();
	}
	
	public EquipmentServiceXML() {
		super();
		System.out.println("service xml");
	}
	
	public static void setList() {
		
		EquipmentBuilderFactory sFactory = new EquipmentBuilderFactory();
		AbstractEquipmentsBuilder builder = sFactory.createEquipmentBuilder(XML_PARSER_TYPE);
		builder.buildListEquipments(XML_FILE_PATH);

		for ( Equipment equipment : builder.getEquipments() ) {
			dao.addEquipment(equipment);
		}
	}
	
}
