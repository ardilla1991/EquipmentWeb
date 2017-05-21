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
	
	
	/************  ACTION  ****************/
	public static final String ADMIN_ACTION_CATEGORY_LIST = "category_list";
	public static final String ADMIN_ACTION_EQUIPMENT_LIST_BY_CATEGORY = "equipment_list_by_category";
	public static final String ADMIN_REQUEST_PARAM_CATEGORY_ID = "category_id";
	
	/************** QUERY   ********************/
	public static final String ADMIN_SQL_STATEMENT_LOG_ADD = "INSERT INTO equipment_web.log (user, action, sub_action, result_of_action, message) "
			+ "VALUES (?, ?, ?, ?, ?);";
	
	public static final String ADMIN_SQL_STATEMENT_CATEGORY_LIST = "SELECT * FROM category";
	
	public static final String ADMIN_SQL_STATEMENT_EQUIPMENT_SELECT_LIST_BY_CATEGORY = "SELECT * FROM equipment WHERE category_id=?";
	
	
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
