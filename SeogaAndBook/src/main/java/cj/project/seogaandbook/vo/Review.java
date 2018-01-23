package cj.project.seogaandbook.vo;

/**
 * 서평 게시글을 저장하기 위한 클래스
 * @author CHUNGJUNG
 *
 */
public class Review {
	private int reviewNum;
	private long isbn13;
	private int memberNum;
	private String title;
	private String content;
	private String indate;
	private int views;
	private int hits;
	
	public Review() {}
	
	public Review(int reviewNum, long isbn13, int memberNum, String title, String content, String indate, int views,
			int hits) {
		this.reviewNum = reviewNum;
		this.isbn13 = isbn13;
		this.memberNum = memberNum;
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
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
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
		return "Review [reviewNum=" + reviewNum + ", isbn13=" + isbn13 + ", memberNum=" + memberNum + ", title=" + title
				+ ", content=" + content + ", indate=" + indate + ", views=" + views + ", hits=" + hits + "]";
	}
	
}
