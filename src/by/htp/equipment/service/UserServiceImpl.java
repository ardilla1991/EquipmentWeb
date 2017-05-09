package by.htp.equipment.service;

import by.htp.equipment.dao.UserDao;
import by.htp.equipment.dao.UserDaoImpl;
import by.htp.equipment.entity.User;
import by.htp.equipment.service.ServiceNoSuchUserException;

public class UserServiceImpl implements UserService{

	private UserDao dao;
	
	public UserServiceImpl() {
		dao = new UserDaoImpl();
	}
	
	@Override
	public User authorise(String login, String password) throws ServiceNoSuchUserException{
		User user = dao.fetchByCredentials(login, password);
		/*if ( "user".equals(login) && "user".equals(password) ){
			user = new User("user1", "user1", false);
		} else if ( "admin".equals(login) && "admin".equals(password) ) {
			user = new User("admin1", "admin1", true);
		} else {
			throw new ServiceNoSuchUserException("Invalid credentials");
		}*/
		if ( user == null ) {
			throw new ServiceNoSuchUserException("Invalid credentials");
		}
		return user;
	}

	@Override
	public boolean logOut(User user) {
		
		
		return false;
	}

}
