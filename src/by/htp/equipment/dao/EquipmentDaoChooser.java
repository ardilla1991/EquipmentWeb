package by.htp.equipment.dao;

import static by.htp.equipment.util.ConstantValue.EQUIPMETN_STORAGE;

public class EquipmentDaoChooser {
	public static EquipmentDao chooseStorage() {
		switch (EQUIPMETN_STORAGE) {
			case "xml":
				System.out.println("xml storage");
				return new EquipmentDaoXML();
			case "db":
				System.out.println("db storage");
				return new EquipmentDaoDb();
			default:
				break;
		}
		return null;
	}
}
