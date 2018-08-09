package vo;

/** 서버 IP 클래스 */
public class IP {

	/** 버전 코드 */
	private int mVersionCode;
	/** 버전명 */
	private String mVersionName;

	/** 생성자 */
	public IP() {

	}

	/** 버전코드 설정 메소드 */
	public void setVersionCode(int versionCode) {
		mVersionCode = versionCode;
	}

	/** 버전명 설정 메소드 */
	public void setVersionName(String versionName) {
		mVersionName = versionName;
	}

	/** 버전코드 반환 메소드 */
	public int getVersionCode() {
		return mVersionCode;
	}

	/** 버전명 반환 메소드 */
	public String getVersionName() {
		return mVersionName;
	}
	
}
