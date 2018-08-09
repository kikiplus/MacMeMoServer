package vo;

/** 게시판 클래스 */
public class UpdateApp {

	/** 타이틀 */
	private int mVersionCode;
	/** 내용 */
	private String mContent;

	/** 생성자 */
	public UpdateApp() {

	}

	/** 버전 설정 메소드 */
	public void setVersionCode(int versionCode) {
		mVersionCode = versionCode;
	}

	/** 내용 설정 메소드 */
	public void setContent(String content) {
		mContent = content;
	}

	/** 버전 반환 메소드 */
	public int getVersionCode() {
		return mVersionCode;
	}

	/** 내용 반환 메소드 */
	public String getContent() {
		return mContent;
	}
}
