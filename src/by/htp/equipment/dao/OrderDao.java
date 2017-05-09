package by.htp.equipment.dao;

import java.util.ArrayList;
import java.util.HashMap;

import by.htp.equipment.entity.Order;
import by.htp.equipment.entity.Person;

public interface OrderDao {

	public void addOrder(Order newOrder);

	public HashMap<Integer, ArrayList<Order>> getUnits();
	
	public ArrayList<Order> getEquipmentsOfPerson(Person person);
}
