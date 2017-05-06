package by.htp.equipment.builder;

import java.util.ArrayList;
import java.util.List;

import by.htp.equipment.entity.Equipment;

public abstract class AbstractEquipmentsBuilder {
	// protected ��� ��� � ���� ����� ���������� �� ���������
	protected List<Equipment> eq;
	
	public AbstractEquipmentsBuilder() {
		eq = new ArrayList<Equipment>();
	}
	
	public AbstractEquipmentsBuilder(List<Equipment> equipments) {
		this.eq = equipments;
	}
	
	public List<Equipment> getEquipments() {
		return eq;
	}
	
	abstract public void buildListEquipments(String fileName);
}
