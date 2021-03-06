package by.htp.equipment.builder;

import by.htp.equipment.entity.Skate;

public class SkateBuilder {
	
	public static void setProperties(Skate equipment, EquipmentTagName text, String s) {
		switch (text) {
			case TERM_OF_SERVICE:
				equipment.setTermOfService(Integer.parseInt(s));
				break;
			case SIZE:
				equipment.setSize(Integer.parseInt(s));
				break;
		}
	}
}
