package by.htp.equipment.entity;

import java.util.ArrayList;
import java.util.List;

public class Equipment {
	
	private Long id;
	private String model;
	private double price;
	private double weight;
	private double width;
	private double height;
	private PersonCategoryEnum personCategory; // for child or for adult 
	private boolean isRent;
	private int categoryId;
	
	private List<Parameter> parameters = new ArrayList<Parameter>();
	
	public Equipment() {
		
	}
	
	public Equipment(String model, double price, double weight, 
			double width, double height, PersonCategoryEnum personCategory) {
		this.model = model;
		this.price = price;
		this.weight = weight;
		this.width = width;
		this.height = height;
		this.personCategory = personCategory;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public PersonCategoryEnum getPersonCategory() {
		return personCategory;
	}

	public void setPersonCategory(PersonCategoryEnum personCategory) {
		this.personCategory = personCategory;
	}



	@Override
	public String toString() {
		return "Equipment [id=" + id + ", model=" + model + ", price=" + price + ", weight=" + weight + ", width="
				+ width + ", height=" + height + ", personCategory=" + personCategory + ", isRent=" + isRent
				+ ", categoryId=" + categoryId + ", parameters=" + parameters + "]";
	}

	public boolean getIsRent() {
		return isRent;
	}

	public void setIsRent(boolean isRent) {
		this.isRent = isRent;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public List<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}
	
}
