package cj.project.seogaandbook.vo;

/**
 * 사용자의 독서 기록을 저장하기 위한 클래스
 * @author CHUNGJUNG
 *
 */
public class ReadingHistory {
	private int historyNum;
	private int memberNum;
	private long isbn13;
	
	public ReadingHistory() {}
	
	public ReadingHistory(int historyNum, int memberNum, long isbn13) {
		this.historyNum = historyNum;
		this.memberNum = memberNum;
		this.isbn13 = isbn13;
	}
	
	public int getHistoryNum() {
		return historyNum;
	}
	public void setHistoryNum(int historyNum) {
		this.historyNum = historyNum;
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public long getIsbn13() {
		return isbn13;
	}
	public void setIsbn13(long isbn13) {
		this.isbn13 = isbn13;
	}
	
	@Override
	public String toString() {
		return "ReadingHistory [historyNum=" + historyNum + ", memberNum=" + memberNum + ", isbn13=" + isbn13 + "]";
	}
	
}
