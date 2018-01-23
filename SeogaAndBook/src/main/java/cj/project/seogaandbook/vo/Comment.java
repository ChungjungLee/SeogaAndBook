package cj.project.seogaandbook.vo;

/**
 * 한 줄 평, 평점을 저장하기 위한 클래스
 * @author CHUNGJUNG
 *
 */
public class Comment {
	private int commentNum;
	private long isbn13;
	private int memberNum;
	private String onelineReview;
	private String indate;
	private int score;
	
	public Comment() {}
	
	public Comment(int commentNum, long isbn13, int memberNum, String onelineReview, String indate, int score) {
		this.commentNum = commentNum;
		this.isbn13 = isbn13;
		this.memberNum = memberNum;
		this.onelineReview = onelineReview;
		this.indate = indate;
		this.score = score;
	}
	
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
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
	public String getOnelineReview() {
		return onelineReview;
	}
	public void setOnelineReview(String onelineReview) {
		this.onelineReview = onelineReview;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Comment [commentNum=" + commentNum + ", isbn13=" + isbn13 + ", memberNum=" + memberNum
				+ ", onelineReview=" + onelineReview + ", indate=" + indate + ", score=" + score + "]";
	}
	
}
