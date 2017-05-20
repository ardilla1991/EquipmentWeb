package by.htp.equipment.entity;

import java.sql.Date;
import java.util.List;

public class Order {

	private Long orderId;
	private User user;
	private List<Equipment> equipments;
	
	private Date dateStart;
	private Date dateEnd;

	public Order() {
		super();
	}
	
	public Order(User user, List<Equipment> equipments, Date dateStart, Date dateEnd) {
		this.user = user;
		this.equipments = equipments;
		
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
	}

	public List<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	
	
}
