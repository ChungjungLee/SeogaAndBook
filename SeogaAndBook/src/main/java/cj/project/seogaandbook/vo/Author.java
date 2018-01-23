package cj.project.seogaandbook.vo;

public class Author {
	private int authorNum;
	private String name;
	private String introduction;
	
	public Author() {}
	
	public Author(int authorNum, String name, String introduction) {
		this.authorNum = authorNum;
		this.name = name;
		this.introduction = introduction;
	}
	
	public int getAuthorNum() {
		return authorNum;
	}
	public void setAuthorNum(int authorNum) {
		this.authorNum = authorNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	@Override
	public String toString() {
		return "Author [authorNum=" + authorNum + ", name=" + name + ", introduction=" + introduction + "]";
	}
	
}
