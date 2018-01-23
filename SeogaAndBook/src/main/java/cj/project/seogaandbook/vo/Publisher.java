package cj.project.seogaandbook.vo;

public class Publisher {
	private int publisherNum;
	private String name;
	
	public Publisher() {}
	
	public Publisher(int publisherNum, String name) {
		this.publisherNum = publisherNum;
		this.name = name;
	}
	
	public int getPublisherNum() {
		return publisherNum;
	}
	public void setPublisherNum(int publisherNum) {
		this.publisherNum = publisherNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Publisher [publisherNum=" + publisherNum + ", name=" + name + "]";
	}
	
}
