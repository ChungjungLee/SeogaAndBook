package cj.project.seogaandbook.vo;

public class Book {
	private long isbn13;
	private String title;
	private String introduction;
	private int categoryNum;
	private int publisherNum;
	private int authorNum;
	
	public Book() {}
	
	public Book(long isbn13, String title, String introduction, int categoryNum, int publisherNum, int authorNum) {
		this.isbn13 = isbn13;
		this.title = title;
		this.introduction = introduction;
		this.categoryNum = categoryNum;
		this.publisherNum = publisherNum;
		this.authorNum = authorNum;
	}
	
	public long getIsbn13() {
		return isbn13;
	}
	public void setIsbn13(long isbn13) {
		this.isbn13 = isbn13;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public int getCategoryNum() {
		return categoryNum;
	}
	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
	}
	public int getPublisherNum() {
		return publisherNum;
	}
	public void setPublisherNum(int publisherNum) {
		this.publisherNum = publisherNum;
	}
	public int getAuthorNum() {
		return authorNum;
	}
	public void setAuthorNum(int authorNum) {
		this.authorNum = authorNum;
	}
	
	@Override
	public String toString() {
		return "Book [isbn13=" + isbn13 + ", title=" + title + ", introduction=" + introduction + ", categoryNum="
				+ categoryNum + ", publisherNum=" + publisherNum + ", authorNum=" + authorNum + "]";
	}
	
}
