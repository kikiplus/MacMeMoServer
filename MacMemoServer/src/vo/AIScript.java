package vo;

/** 버킷 클래스 */
public class AIScript {

	/** 카테고리코드 */
	private int mCategoryCode;
	/** 카테고리명 */
	private String mCategoryName;
	/** 메모내용 */
	private String mContent;
	/** 번호 */
	private int mIdx;

	/** 생성자 */
	public AIScript() {

	}

	/** 카테고리코드 설정 메소드 */
	public void setCategoryCode(int CategoryCode) {
		mCategoryCode = CategoryCode;
	}

	/** 카데고리명 설정 메소드 */
	public void setCategoryName(String CategoryName) {
		mCategoryName = CategoryName;
	}

	/** 내용 설정 메소드 */
	public void setContent(String content) {
		mContent = content;
	}

	/** 번호 설정 메소드 */
	public void setIdx(int idx) {
		mIdx = idx;
	}

	/** 카테고리코드 반환 메소드 */
	public int getCategoryCode() {
		return mCategoryCode;
	}

	/** 내용 반환 메소드 */
	public String getContent() {
		return mContent;
	}

	/** 번호 반환 메소드 */
	public int getIdx() {
		return mIdx;
	}

	/** 카데고리명 반환 메소드 */
	public String getCategoryName() {
		return mCategoryName;
	}

}
