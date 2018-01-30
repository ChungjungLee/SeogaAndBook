package cj.project.seogaandbook.vo;

/**
 * 질문 게시글에 대한 답변을 저장하기 위한 클래스
 * @author CHUNGJUNG
 *
 */
public class Answer {
	private int answerNum;
	private int questionNum;
	private int memberNum;
	private String memberName;
	private String content;
	private String indate;
	private int hits;
	
	public Answer() {}
	
	public Answer(int answerNum, int questionNum, int memberNum, String memberName, String content, String indate, int hits) {
		this.answerNum = answerNum;
		this.questionNum = questionNum;
		this.memberNum = memberNum;
		this.memberName = memberName;
		this.content = content;
		this.indate = indate;
		this.hits = hits;
	}
	
	public int getAnswerNum() {
		return answerNum;
	}
	public void setAnswerNum(int answerNum) {
		this.answerNum = answerNum;
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
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
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
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	
	@Override
	public String toString() {
		return "Answer [answerNum=" + answerNum + ", questionNum=" + questionNum + ", memberNum=" + memberNum
				+ ", content=" + content + ", indate=" + indate + ", hits=" + hits + "]";
	}
	
}
