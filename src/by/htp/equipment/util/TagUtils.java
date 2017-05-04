package by.htp.equipment.util;

import by.htp.rental.entity.Equipment;

public class TagUtils {
	
	//Checks to see if Object 'o' is an instance of the class in the string "className"
    public static boolean isInstanceOf(Equipment o, String className) {
        boolean returnValue;
        try {
            returnValue = Class.forName("by.htp.rental.entity." + className).isInstance(o);
        } catch(ClassNotFoundException e) {
            returnValue = false;
        }
        
        return returnValue;
    }
}