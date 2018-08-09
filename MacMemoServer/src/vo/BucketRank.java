package vo;

/** 버킷 랭킹 클래스 */
public class BucketRank {

	/** 카테고리코드 */
	private int mCategoryCode;
	/** 카테고리명 */
	private String mCategoryName;
	/** 메모내용 */
	private String mContent;
	/** 번호 */
	private int mIdx;
	/** 최고에요 카운트 */
	private int mBestCnt;
	/** 좋아요 카운트 */
	private int mGoodCnt;
	/** 괜찮아요 카운트 */
	private int mSoSoCnt;
	/** 사용자 카운트 */
	private int mComment;

	/** 생성자 */
	public BucketRank() {

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

	/** 최고에요 카운트 설정 메소드 */
	public void setBestCnt(int cnt) {
		mBestCnt = cnt;
	}

	/** 좋아요 카운트 설정 메소드 */
	public void setGoodCnt(int cnt) {
		mGoodCnt = cnt;
	}

	/** 괜찮아요 카운트 설정 메소드 */
	public void setSoSoCnt(int cnt) {
		mSoSoCnt = cnt;
	}

	/** 사용자 카운트 설정 메소드 */
	public void setUserComment(int cnt) {
		mComment = cnt;
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

	/** 최고에요 카운트 반환 메소드 */
	public int getBestCnt() {
		return mBestCnt;
	}

	/** 좋아요 카운트 반환 메소드 */
	public int getGoodCnt() {
		return mGoodCnt;
	}

	/** 괜찮아요 카운트 반환 메소드 */
	public int getSoSoCnt() {
		return mSoSoCnt;
	}
	
	/** 사용자 카운트 반환 메소드 */
	public int getUserComment() {
		return mComment; 
	}
}
