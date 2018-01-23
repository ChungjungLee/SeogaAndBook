package cj.project.seogaandbook.vo;

/**
 * 서평 게시글에 달리는 댓글을 저장하기 위한 클래스
 * @author CHUNGJUNG
 *
 */
public class Reply {
	private int replyNum;
	private int reviewNum;
	private int memberNum;
	private String indate;
	private int parentNum;
	private int level;
	
	public Reply() {}
	
	public Reply(int replyNum, int reviewNum, int memberNum, String indate, int parentNum) {
		this.replyNum = replyNum;
		this.reviewNum = reviewNum;
		this.memberNum = memberNum;
		this.indate = indate;
		this.parentNum = parentNum;
		this.level = 0;
	}
	
	public Reply(int replyNum, int reviewNum, int memberNum, String indate, int parentNum, int level) {
		this.replyNum = replyNum;
		this.reviewNum = reviewNum;
		this.memberNum = memberNum;
		this.indate = indate;
		this.parentNum = parentNum;
		this.level = level;
	}
	
	public int getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}
	public int getReviewNum() {
		return reviewNum;
	}
	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public int getParentNum() {
		return parentNum;
	}
	public void setParentNum(int parentNum) {
		this.parentNum = parentNum;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	@Override
	public String toString() {
		return "Reply [replyNum=" + replyNum + ", reviewNum=" + reviewNum + ", memberNum=" + memberNum + ", indate="
				+ indate + ", parentNum=" + parentNum + ", level=" + level + "]";
	}
	
}
