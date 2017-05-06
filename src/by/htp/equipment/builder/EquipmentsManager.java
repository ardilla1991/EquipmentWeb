package by.htp.equipment.builder;

import by.htp.equipment.entity.Bycicle;
import by.htp.equipment.entity.Equipment;
import by.htp.equipment.entity.Helmet;
import by.htp.equipment.entity.Skate;

public class EquipmentsManager {
	
	public static Equipment createEquipment(String name) {
		switch ( name ) {
			case "bycicle":
				return new Bycicle();
			case "skate":
				return new Skate();
			case "helmet":
				return new Helmet();
		}
		
		return null;
	}
	
	public static Equipment setObjectProperties(Equipment equipment, EquipmentTagName text, String s) {
		if ( equipment instanceof Bycicle ) {
			Bycicle bycicle = (Bycicle) equipment;
			BycicleBuilder.setProperties(bycicle, text, s);
		} else if ( equipment instanceof Skate ) {
			Skate skate = (Skate) equipment;
			SkateBuilder.setProperties(skate, text, s);
		} else if ( equipment instanceof Helmet ) {
			Helmet helmet = (Helmet) equipment;
			HelmetBuilder.setProperties(helmet, text, s);
		}
		
		return equipment;
	}
}
