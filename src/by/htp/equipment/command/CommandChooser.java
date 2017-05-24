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
			case ADMIN_ACTION_CATEGORY_LIST:
				System.out.println("category list action");
				return new CategoryListAction();
			case ADMIN_ACTION_EQUIPMENT_LIST_BY_CATEGORY:
				System.out.println("equipment_list_by_category");
				return new EquipmentListByCategoryAction();
			case ADMIN_ACTION_EQUIPMENT_VIEW_EDIT_PAGE:
				System.out.println("equipment_edit_page");
				return new EquipmentViewEditPageAction();
			default:
				break;
		}
		
		// STUB!!
		return null;
	}
}
