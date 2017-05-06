package by.htp.equipment.command;

public class CommandChooser {
	
	public static CommandAction chooseAction(String action) {
		switch (action) {
			case "login":
				System.out.println("Login action");
				return new LoginCommandAction();
			default:
				break;
		}
		return null;
	}
}
