package vo;

/** 버킷 클래스 */
public class Bucket {

	/** 카테고리코드 */
	private int mCategoryCode;
	/** 카테고리명 */
	private String mCategoryName;
	/** 메모내용 */
	private String mContent;
	/** 날짜 */
	private String mCompleteDate;
	/** 번호 */
	private int mIdx;
	/** 닉네임 */
	private String mNickName = "-";
	/** 사용자 전화번호 */
	private String mPhone = "-";
	/** 이미지 저장경로 */
	private String mImageURl;
	/** 숨긴 여부 */
	private String mIsHidden;

	/** 생성자 */
	public Bucket() {

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

	/** 등록일 설정 메소드 */
	public void setDate(String date) {
		mCompleteDate = date;
	}

	/** 번호 설정 메소드 */
	public void setIdx(int idx) {
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

	/** 카테고리코드 반환 메소드 */
	public int getCategoryCode() {
		return mCategoryCode;
	}

	/** 내용 반환 메소드 */
	public String getContent() {
		return mContent;
	}

	/** 날짜 반환 메소드 */
	public String getDate() {
		return mCompleteDate;
	}

	/** 번호 반환 메소드 */
	public int getIdx() {
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

	/** 카데고리명 반환 메소드 */
	public String getCategoryName() {
		return mCategoryName;
	}

	/** 숨긴여부 반환 메소드 */
	public String getIsHidden() {
		if (mIsHidden == null)
			return "-";
		else
			return mIsHidden;
	}
}
