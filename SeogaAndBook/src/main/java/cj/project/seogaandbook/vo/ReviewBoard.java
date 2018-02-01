package cj.project.seogaandbook.vo;

/**
 * 서평 게시판에서 서평 하나하나를 저장하는 클래스
 * @author CHUNGJUNG
 *
 */
public class ReviewBoard {
	private int reviewNum;
	private long isbn13;
	private String bookTitle;
	private String authorName;
	private String publisherName;
	private int memberNum;
	private String memberName;
	private String title;
	private String content;
	private String indate;
	private int views;
	private int hits;
	
	public ReviewBoard() {}
	
	public ReviewBoard(int reviewNum, long isbn13, String bookTitle, String authorName, String publisherName,
			int memberNum, String memberName, String title, String content, String indate, int views, int hits) {
		this.reviewNum = reviewNum;
		this.isbn13 = isbn13;
		this.bookTitle = bookTitle;
		this.authorName = authorName;
		this.publisherName = publisherName;
		this.memberNum = memberNum;
		this.memberName = memberName;
		this.title = title;
		this.content = content;
		this.indate = indate;
		this.views = views;
		this.hits = hits;
	}
	
	public int getReviewNum() {
		return reviewNum;
	}
	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}
	public long getIsbn13() {
		return isbn13;
	}
	public void setIsbn13(long isbn13) {
		this.isbn13 = isbn13;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	
	@Override
	public String toString() {
		return "ReviewBoard [reviewNum=" + reviewNum + ", isbn13=" + isbn13 + ", bookTitle=" + bookTitle
				+ ", authorName=" + authorName + ", publisherName=" + publisherName + ", memberNum=" + memberNum
				+ ", memberName=" + memberName + ", title=" + title + ", content=" + content + ", indate=" + indate
				+ ", views=" + views + ", hits=" + hits + "]";
	}
	
}
