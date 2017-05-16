package by.htp.equipment.util;

public final class ConstantValue {
	
	private ConstantValue() {
		
	}
	
	public static final String ACTION_AUTHORISE = "login";
	public static final String ACTION_MAKE_ORDER = "create_order";
	public static final String ACTION_ORDER = "make_order";
	
	public static final String JSP_FOLDER_PATH = "jsp/";
	public static final String PAGE_ADMIN_MAIN = JSP_FOLDER_PATH + "admin.jsp";
	public static final String PAGE_USER_MAIN = JSP_FOLDER_PATH + "user.jsp";
	
	public static final String PAGE_ORDER_ALL = JSP_FOLDER_PATH + "orders.jsp";
	public static final String PAGE_ORDER_CREATE = JSP_FOLDER_PATH + "order.jsp";
	
	public static final String PAGE_ERROR = JSP_FOLDER_PATH + "error.jsp";
	public static final String PAGE_DEFAULT = "index.html";
	
	public static final String REQUEST_PAREM_ACTION = "";
	public static final String REQUEST_PARAM_AUTHORISE = "";
	public static final String REQUEST_PARAM_LOGIN = "login";
	public static final String REQUEST_PARAM_PASSWORD = "pass";
	public static final String REQUEST_PARAM_LIST_EQ = "list_eq";
	public static final String REGUEST_PARAM_ERROR_MSG = "error_msg";
	
	public static String PARAM_USER_ID = "user_id";
	public static String PARAM_EQUIPMENT_ID = "equipment_id";
	public static String PARAM_DATE_START = "date_start";
	public static String PARAM_DATE_END = "date_end";
	
	public static final String EQUIPMETN_STORAGE = "db"; // or "db"
	public static final String XML_FILE_PATH = "D:\\java\\JD1\\EquipmentWeb\\resources\\equipments.xml";
	public static final String XML_PARSER_TYPE = "sax";  // or "dom", or "stax"
	
	public static final int NUM_ALLOW_EQUIPMENT_FOR_RENT = 3;
	
	public static final String SQL_STATEMENT_SELECT_USERS = "SELECT * FROM user";
	public static final String SQL_STATEMENT_SELECT_USER = "SELECT * FROM user WHERE login=? AND password=?";
	public static final String SQL_STATEMENT_ORDER_CREATE = "INSERT INTO sport.order (id_user, id_equipment, date_start, date_end) VALUES (?, ?, ?, ?);";
	
	public static final String SQL_STATEMENT_EQUIPMENT_SELECT_SPARE_EQUIPMENTS = "SELECT * FROM equipment WHERE is_rent=0";
	public static final String SQL_STATEMENT_EQUIPMENT_SELECT_EQUIPMENTS_BY_IDS = "SELECT * FROM equipment WHERE id IN ";
}
