package by.htp.equipment.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import by.htp.equipment.entity.Order;
import by.htp.equipment.entity.User;

public interface OrderDao {

	public Long createOrder(Order newOrder);

	public HashMap<Integer, ArrayList<Order>> getUnits();
	
	public ArrayList<Order> getEquipmentsOfPerson(User user);
	
	List<Order> fetchAll();
	
	List<Order> getOrdersByUser(User user);
}
