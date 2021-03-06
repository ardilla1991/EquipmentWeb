package by.htp.equipment.util;

public final class ConstantValue {
	
	private ConstantValue() {
		
	}
	
	public static final String JSP_FOLDER_AJAX = "AJAX/";
	public static final String JSP_FOLDER_PATH = "/WEB-INF/jsp/";
	public static final String PAGE_ERROR = JSP_FOLDER_PATH + "error.jsp";
	public static final String PAGE_DEFAULT = "index.html";
	
	
	/*********************************** ADMIN  ********************************************************/
	
	/************  PAGE  ****************/
	public static final String PAGE_ADMIN = "admin/";
	public static final String JSP_FOLDER_PATH_ADMIN = "/WEB-INF/jsp/" + PAGE_ADMIN;
	public static final String PAGE_ADMIN_MAIN = JSP_FOLDER_PATH_ADMIN + "rented.jsp";
	public static final String ADMIN_PAGE_CATEGORY_LIST = JSP_FOLDER_PATH_ADMIN + "categoryList.jsp";
	
	
	/************   AJAX PAGE  ****************/
	public static final String ADMIN_PAGE_EQUIPMENT_BY_CATEGORY = JSP_FOLDER_PATH_ADMIN + JSP_FOLDER_AJAX + "categories.jsp";
	public static final String ADMIN_PAGE_EQUIPMENT_EDIT_PAGE = JSP_FOLDER_PATH_ADMIN + JSP_FOLDER_AJAX + "equipmentEditPage.jsp";
	
	/************  ACTION  ****************/
	public static final String ADMIN_ACTION_CATEGORY_LIST = "category_list";
	public static final String ADMIN_ACTION_EQUIPMENT_LIST_BY_CATEGORY = "equipment_list_by_category";
	public static final String ADMIN_ACTION_EQUIPMENT_VIEW_ADD_PAGE = "viewAddEquipmentPage";
	public static final String ADMIN_ACTION_EQUIPMENT_VIEW_EDIT_PAGE = "viewEditEquipmentPage";
	public static final String ADMIN_ACTION_EQUIPMENT_ADD = "add_equipment";
	public static final String ADMIN_ACTION_EQUIPMENT_EDIT = "edit_equipment";
	
	
	/************** QUERY   ********************/
	public static final String ADMIN_SQL_STATEMENT_LOG_ADD = "INSERT INTO equipment_web.log (user, action, sub_action, result_of_action, message) "
			+ "VALUES (?, ?, ?, ?, ?);";
	
	public static final String ADMIN_SQL_STATEMENT_CATEGORY_LIST = "SELECT * FROM category";
	
	public static final String ADMIN_SQL_STATEMENT_EQUIPMENT_SELECT_LIST_BY_CATEGORY = "SELECT * FROM equipment WHERE category_id=?";
	public static final String ADMIN_SQL_STATEMENT_PARAMETERS_LIST_BY_CATEGORY = "SELECT * FROM parameter WHERE category_id=?";
	public static final String ADMIN_SQL_STATEMENT_EQUIPMENT_ADD = "INSERT INTO equipment (model, price, weight, width, height, person_category, is_rent, category_id, img) "
				+ "VALUES(?,?,?,?,?,?,?,?,?)";
	public static final String ADMIN_SQL_STATEMENT_EQUIPMENT_EDIT = "UPDATE equipment SET model=?, price=?, weight=?, width=?, height=?, person_category=?, is_rent=?, category_id=?, img=? WHERE id=?";
	public static final String ADMIN_SQL_STATEMENT_EQUIPMENT_PARAMETER_VALUE_ADD = "INSERT INTO parameter_value (id_param, id_equipment, value) VALUES(?,?,?)";
	public static final String ADMIN_SQL_STATEMENT_EQUIPMENT_SELECT_BY_ID = "SELECT * FROM equipment WHERE id=?";
	public static final String ADMIN_SQL_STATEMENT_PARAMETERS_VALUES_BY_EQUIPMENT_ID = "SELECT p.*, pv.value FROM parameter as p LEFT JOIN parameter_value as pv ON p.id=pv.id_param WHERE pv.id_equipment=?";
	public static final String ADMIN_SQL_STATEMENT_PARAMETERS_VALUES_DELETE_BY_EQUIPMENT_ID = "DELETE FROM parameter_value WHERE id_equipment=?";
	
	
	/************  REGUEST PARAM   **************/
	public static final String REQUEST_PARAM_EQUIPMENT = "equipment";
	public static final String REQUEST_PARAM_PERSON_CATEGORIES = "person_categories";
	public static final String ADMIN_REQUEST_PARAM_CATEGORY_ID = "category_id";
	public static final String ADMIN_REQUEST_PARAM_EQUIPMENT_ID = "id";
	
	public static final String ADMIN_PARAM_EQUIPMENT_MODEL = "model";
	public static final String ADMIN_PARAM_EQUIPMENT_PRICE = "price";
	public static final String ADMIN_PARAM_EQUIPMENT_WEIGHT = "weight";
	public static final String ADMIN_PARAM_EQUIPMENT_WIDTH = "width";
	public static final String ADMIN_PARAM_EQUIPMENT_HEIGHT = "height";
	public static final String ADMIN_PARAM_EQUIPMENT_PERSON_CATEGORY = "person_category";
	public static final String ADMIN_PARAM_EQUIPMENT_IS_RENT = "is_rent";
	public static final String ADMIN_PARAM_EQUIPMENT_PARAM_START_INPUT_TITLE = "param_";
	
	
	/****************************************************************************************************/
	/*********************************** FRONT END   ****************************************************/
	/****************************************************************************************************/
	
	public static final String ACTION_AUTHORISE = "login";
	public static final String ACTION_MAKE_ORDER = "create_order";
	public static final String ACTION_ORDER = "make_order";
	
	
	public static final String PAGE_USER_MAIN = JSP_FOLDER_PATH + "forRent.jsp";
	
	public static final String PAGE_ORDER_ALL = JSP_FOLDER_PATH + "orders.jsp";
	public static final String PAGE_ORDER_CREATE = JSP_FOLDER_PATH + "order.jsp";

	
	public static final String REQUEST_PAREM_ACTION = "";
	public static final String REQUEST_PARAM_AUTHORISE = "";
	public static final String REQUEST_PARAM_LOGIN = "login";
	public static final String REQUEST_PARAM_PASSWORD = "pass";
	public static final String REQUEST_PARAM_LIST_EQ = "list_eq";
	
	public static final String REGUEST_PARAM_CATEGORY_LIST = "list_categories";
	public static final String REQUEST_PARAM_CATEGORY_ID = "category_id";
	
	public static final String REGUEST_PARAM_ERROR_MSG = "error_msg";
	
	public static String PARAM_USER_ID = "user_id";
	public static String PARAM_EQUIPMENT_ID = "equipment_id";
	public static String PARAM_DATE_START = "date_start";
	public static String PARAM_DATE_END = "date_end";
	public static String PARAM_CHOOSED_EQUIPMENTS_IDS = "choosedIds";	
	
	public static final String EQUIPMETN_STORAGE = "db"; // or "db"
	public static final String XML_FILE_PATH = "D:\\java\\JD1\\EquipmentWeb\\resources\\equipments.xml";
	public static final String XML_PARSER_TYPE = "sax";  // or "dom", or "stax"
	
	public static final int NUM_ALLOW_EQUIPMENT_FOR_RENT = 3;
	
	public static final String SQL_STATEMENT_SELECT_USERS = "SELECT * FROM user";
	public static final String SQL_STATEMENT_SELECT_USER = "SELECT * FROM user WHERE login=? AND password=?";
	
	public static final String SQL_STATEMENT_ORDER_CREATE = "INSERT INTO equipment_web.order (id_user, date_start, date_end) VALUES (?, ?, ?);";
	public static final String SQL_STATEMENT_RENT_CREATE = "INSERT INTO equipment_web.rent_list (order_id, equipment_id) VALUES (?, ?);";
	public static final String SQL_STATEMENT_ORDER_LIST_BY_USER = "SELECT * FROM equipment_web.order WHERE id_user=?";

	
	public static final String SQL_STATEMENT_EQUIPMENT_SELECT_SPARE_EQUIPMENTS = "SELECT * FROM equipment WHERE is_rent=0";
	public static final String SQL_STATEMENT_EQUIPMENT_SELECT_EQUIPMENTS_BY_IDS = "SELECT * FROM equipment WHERE id IN ";
	

}
