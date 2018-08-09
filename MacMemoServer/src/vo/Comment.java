package vo;

/** 버킷 클래스 */
public class Comment {

	/** 메모내용 */
	private String mContent;
	/** 날짜 */
	private String mDate;
	/** 닉네임 */
	private String mNickName;
	/** 번호 */
	private int mIdx;
	/** 버킷No */
	private int mBucketNo;

	/** 생성자 */
	public Comment() {

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

	/** 버킷No 설정 메소드 */
	public void setBucketNo(int BucketNo) {
		mBucketNo = BucketNo;
	}

	/** 닉네임 설정 메소드 */
	public void setNickName(String NickName) {
		mNickName = NickName;
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

	/** 닉네임 반환 메소드 */
	public String getNickName() {
		return mNickName;
	}

	/** 버킷No 반환 메소드 */
	public int getBucketNo() {
		return mBucketNo;
	}

}
