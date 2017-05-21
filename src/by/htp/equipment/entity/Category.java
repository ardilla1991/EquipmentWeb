package by.htp.equipment.entity;

public class Category {
	
	private int id;
	private String title;
	private CategoryTypeEnum type;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public CategoryTypeEnum getType() {
		return type;
	}
	
	public void setType(CategoryTypeEnum type) {
		this.type = type;
	}
}
