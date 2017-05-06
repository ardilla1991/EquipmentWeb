package by.htp.equipment.service;

import static by.htp.equipment.util.ConstantValue.*;

public class EquipmentServiceChooser {
	
	public static EquipmentService chooseStorage() {
		switch (EQUIPMETN_STORAGE) {
			case "xml":
				System.out.println("xml storage");
				return new EquipmentServiceXML();
			case "db":
				System.out.println("db storage");
				return new EquipmentServiceDb();
			default:
				break;
		}
		return null;
	}
}
