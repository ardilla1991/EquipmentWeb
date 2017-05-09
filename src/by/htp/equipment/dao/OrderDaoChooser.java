package by.htp.equipment.dao;

import static by.htp.equipment.util.ConstantValue.EQUIPMETN_STORAGE;

public class OrderDaoChooser {
	public static OrderDao chooseStorage() {
		switch (EQUIPMETN_STORAGE) {
			case "xml":
				System.out.println("xml storage");
				return new OrderDaoXML();
			case "db":
				System.out.println("db storage");
				return new OrderDaoDb();
			default:
				break;
		}
		return null;
	}
}
