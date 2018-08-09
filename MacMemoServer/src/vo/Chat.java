package vo;

/**  채팅 클래스 */
public class Chat {

	/** 내용 */
	private String mContent;
	/** 날짜 */
	private String mDate;
	/** 방번호 */
	private String mIdx;
	/** 닉네임 */
	private String mNickName = "";
	/** 사용자 전화번호 */
	private String mPhone = "";
	/** 이미지 저장경로 */
	private String mImageURl;
	/** 숨긴 여부 */
	private String mIsHidden;
	/** seq */
	private int mSeq;

	
	/** 생성자 */
	public Chat() {

	}

	/** 내용 설정 메소드 */
	public void setContent(String content) {
		mContent = content;
	}

	/** 날짜 설정 메소드 */
	public void setDate(String date) {
		mDate = date;
	}

	/** 번호 설정 메소드 */
	public void setIdx(String idx) {
		mIdx = idx;
	}

	/** 닉네임 설정 메소드 */
	public void setNickName(String NickName) {
		mNickName = NickName;
	}

	/** 전화번호 설정 메소드 */
	public void setPhone(String Phone) {
		mPhone = Phone;
	}

	/** 이미지 경로 설정 메소드 */
	public void setImageUrl(String imageUrl) {
		mImageURl = imageUrl;
	}

	/** 숨긴여부 설정 메소드 */
	public void setHidden(String hidden) {
		mIsHidden = hidden;
	}

	/** seq 설정 메소드 */
	public void setSeq(int seq) {
		mSeq = seq;
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
	public String getIdx() {
		return mIdx;
	}

	/** 닉네임 반환 메소드 */
	public String getNickName() {
		return mNickName;
	}

	/** 전화번호 반환 메소드 */
	public String getPhone() {
		return mPhone;
	}

	/** 이미지 경로 반환 메소드 */
	public String getImageUrl() {
		return mImageURl;
	}

	/** 숨긴여부 반환 메소드 */
	public String getIsHidden() {
		if (mIsHidden == null)
			return "-";
		else
			return mIsHidden;
	}
	
	/** seq 반환 메소드 */
	public int getSeq() {
		return mSeq;
	}
	

}
