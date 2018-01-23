package cj.project.seogaandbook.vo;

public class Category {
	private int categoryNum;
	private String name;
	private int parentNum;
	
	public Category() {}
	
	public Category(int categoryNum, String name, int parentNum) {
		this.categoryNum = categoryNum;
		this.name = name;
		this.parentNum = parentNum;
	}
	
	public int getCategoryNum() {
		return categoryNum;
	}
	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParentNum() {
		return parentNum;
	}
	public void setParentNum(int parentNum) {
		this.parentNum = parentNum;
	}
	
	@Override
	public String toString() {
		return "Category [categoryNum=" + categoryNum + ", name=" + name + ", parentNum=" + parentNum + "]";
	}
	
}
