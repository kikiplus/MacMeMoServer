package vo;

/** 버전 클래스 */
public class Version {

	/** 버전 코드 */
	private int mVersionCode;
	/** 버전명 */
	private String mVersionName;
	/** 강제업데이트 여부 */
	private String mForceYN;

	/** 생성자 */
	public Version() {

	}

	/** 버전코드 설정 메소드 */
	public void setVersionCode(int versionCode) {
		mVersionCode = versionCode;
	}

	/** 버전명 설정 메소드 */
	public void setVersionName(String versionName) {
		mVersionName = versionName;
	}
	
	/** 강제업데이트 설정 메소드 */
	public void setForceYN(String force) {
		mForceYN = force;
	}

	/** 버전코드 반환 메소드 */
	public int getVersionCode() {
		return mVersionCode;
	}

	/** 버전명 반환 메소드 */
	public String getVersionName() {
		return mVersionName;
	}
	
	/** 강제업데이트 반환 메소드 */
	public String getForceYN() {
		return mForceYN;
	}
}
