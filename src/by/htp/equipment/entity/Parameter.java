package by.htp.equipment.entity;

public class Parameter {
	
	private int id;
	private Category category;
	@Override
	public String toString() {
		return "Parameter [id=" + id + ", category=" + category + ", title=" + title + ", value=" + value + "]";
	}

	private String title;
	private String value;
	private String description;
	
	
	public Parameter() {
		
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/*public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}*/
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
