package by.htp.equipment.command;

import static by.htp.equipment.util.ConstantValue.*;

public class CommandChooser {
	
	public static CommandAction chooseAction(String action) {
		switch (action) {
			case ACTION_AUTHORISE:
				return new LoginCommandAction();
			case ACTION_MAKE_ORDER:
				return new OrderCreateAction();
			case ACTION_ORDER:
				return new MakeOrderAction();
			case ADMIN_ACTION_CATEGORY_LIST:
				return new CategoryListAction();
			case ADMIN_ACTION_EQUIPMENT_LIST_BY_CATEGORY:
				return new EquipmentListByCategoryAction();
			case ADMIN_ACTION_EQUIPMENT_VIEW_ADD_PAGE:
				return new EquipmentViewAddPageAction();
			case ADMIN_ACTION_EQUIPMENT_ADD:
				return new EquipmentAddAction();
			case ADMIN_ACTION_EQUIPMENT_EDIT:
				return new EquipmentEditAction();
			case ADMIN_ACTION_EQUIPMENT_VIEW_EDIT_PAGE:
				return new EquipmentViewEditPageAction();
			default:
				break;
		}
		
		// STUB!!
		return null;
	}
}
