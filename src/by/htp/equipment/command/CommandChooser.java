package by.htp.equipment.command;

import static by.htp.equipment.util.ConstantValue.*;

public class CommandChooser {
	
	public static CommandAction chooseAction(String action) {
		switch (action) {
			case ACTION_AUTHORISE:
				System.out.println("Login action");
				return new LoginCommandAction();
			case ACTION_MAKE_ORDER:
				System.out.println("Create Order action");
				return new OrderCreateAction();
			case ACTION_ORDER:
				System.out.println("make Order action");
				return new MakeOrderAction();	
			default:
				break;
		}
		
		// STUB!!
		return null;
	}
}
