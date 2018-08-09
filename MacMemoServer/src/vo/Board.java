package vo;

/** 게시판 클래스 */
public class Board {

	/** 타이틀 */
	private String mTitle;
	/** 내용 */
	private String mContent;
	/** 날짜 */
	private String mDate;
	/** 번호 */
	private int mIdx;

	/** 생성자 */
	public Board() {

	}

	/** 타이틀 설정 메소드 */
	public void setTitle(String title) {
		mTitle = title;
	}

	/** 내용 설정 메소드 */
	public void setContent(String content) {
		mContent = content;
	}

	/** 등록일 설정 메소드 */
	public void setDate(String date) {
		mDate = date;
	}

	/** 번호 설정 메소드 */
	public void setIdx(int idx) {
		mIdx = idx;
	}

	/** 타이틀 반환 메소드 */
	public String getTitle() {
		return mTitle;
	}

	/** 내용 반환 메소드 */
	public String getContent() {
		return mContent;
	}

	/** 날짜 반환 메소드 */
	public String getDate() {
		return mDate;
	}

	/** 번호 반환 메소드 */
	public int getIdx() {
		return mIdx;
	}
}
