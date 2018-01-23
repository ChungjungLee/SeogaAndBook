package cj.project.seogaandbook.vo;

/**
 * 질문 게시글을 저장하기 위한 클래스
 * @author CHUNGJUNG
 *
 */
public class Question {
	private int questionNum;
	private int memberNum;
	private String title;
	private String content;
	private String indate;
	private int views;
	
	public Question() {}
	
	public Question(int questionNum, int memberNum, String title, String content, String indate, int views) {
		this.questionNum = questionNum;
		this.memberNum = memberNum;
		this.title = title;
		this.content = content;
		this.indate = indate;
		this.views = views;
	}
	
	public int getQuestionNum() {
		return questionNum;
	}
	public void setQuestionNum(int questionNum) {
		this.questionNum = questionNum;
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
	
	@Override
	public String toString() {
		return "Question [questionNum=" + questionNum + ", memberNum=" + memberNum + ", title=" + title + ", content="
				+ content + ", indate=" + indate + ", views=" + views + "]";
	}
	
}
