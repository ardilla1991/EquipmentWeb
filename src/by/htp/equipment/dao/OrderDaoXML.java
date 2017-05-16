package by.htp.equipment.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import by.htp.equipment.entity.Order;
import by.htp.equipment.entity.Person;
import by.htp.equipment.entity.User;

public class OrderDaoXML implements OrderDao{
	private static HashMap <Integer, ArrayList<Order>> units = new HashMap<>();
	
	public OrderDaoXML() {
		super();
		setOrders();
	}

	@Override
	public void createOrder(Order newOrder) {
		ArrayList<Order> eq;
		if ( units.containsKey(newOrder.getUser().hashCode()) && units.get(newOrder.getUser().hashCode()).size() > 0  ) {
			 eq = units.get(newOrder.getUser().hashCode());
		} else {
			eq = new ArrayList<>(3);
		}
		eq.add(newOrder);
		units.put(newOrder.getUser().hashCode(), eq);
	}

	public HashMap<Integer, ArrayList<Order>> getUnits() {
		return units;
	}
	
	public ArrayList<Order> getEquipmentsOfPerson(User user) {
		if ( units.containsKey(user.hashCode()) ) {
			return units.get(user.hashCode());
		} else {
			ArrayList<Order> eq = new ArrayList<>(0); 
			return eq;
		}
	}

	@Override
	public String toString() {
		String str = "";
		for (ArrayList<Order> value : units.values() ){
			for (int i=0; i<value.size(); i++){
				str += "Value: " + value.get(i);
			}
		}
		return str;
	}
	
	private void setOrders() {
		
	}

	/*@Override
	public void createOrder(Order newOrder) {
		// TODO Auto-generated method stub
		
	}*/

	@Override
	public List<Order> fetchAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
