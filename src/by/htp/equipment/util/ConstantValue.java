package by.htp.equipment.util;

public final class ConstantValue {
	
	private ConstantValue() {
		
	}
	
	public static final String JSP_FOLDER_PATH = "jsp/";
	public static final String PAGE_ADMIN_MAIN = JSP_FOLDER_PATH + "admin.jsp";
	public static final String PAGE_USER_MAIN = JSP_FOLDER_PATH + "user.jsp";
	public static final String PAGE_ERROR = JSP_FOLDER_PATH + "error.jsp";
	public static final String PAGE_DEFAULT = JSP_FOLDER_PATH + "index.html";
	
	public static final String REQUEST_PAREM_ACTION = "";
	public static final String REQUEST_PARAM_AUTHORISE = "";
	public static final String REQUEST_PARAM_LOGIN = "login";
	public static final String REQUEST_PARAM_PASSWORD = "pass";
	public static final String REQUEST_PARAM_LIST_EQ = "list_eq";
	public static final String REGUEST_PARAM_ERROR_MSG = "error_msg";
	
	public static final String EQUIPMETN_STORAGE = "xml"; // or "db"
	public static final String XML_FILE_PATH = "D:\\java\\JD1\\EquipmentWeb\\resource\\equipments.xml";
	public static final String XML_PARSER_TYPE = "sax";  // or "dom", or "stax"
	
}
