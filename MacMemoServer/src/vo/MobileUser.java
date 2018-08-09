package vo;

/** 사용자 클래스 */
public class MobileUser {

	/** 모바일 OS */
	private String mOs;
	/** 사용자 전화번호 */
	private String mPhone;
	/** 사용자 닉네임 */
	private String mUserNickName;
	/** 사용자 버전명 */
	private String mVersionName;
	/** 사용자 마켓구분 */
	private String mMarket;
	/** 사용자 언어 */
	private String mLanguage;
	/** 사용자 나라 */
	private String mCountry;
	/** 사용자 최근 방문 날짜 */
	private String mLastDt;
	/** 사용자 생성 날짜 */
	private String mCreateDt;
	/** 사용자 토큰키 */
	private String mGcmToken;
	/** 사용자 OS버전 */
	private String mOsVersion;
	/** 사용자 통신사 */
	private String mTelGbn;
	/** 사용자 방문수 */
	private String mVisits;

	/** 생성자 */
	public MobileUser() {

	}

	/** 모바일 OS 반환 메소드 */
	public String getOS() {
		return mOs;
	}

	/** 사용자 전화번호 반환 메소드 */
	public String getPhone() {
		return mPhone;
	}

	/** 사용자 닉네임 반환 메소드 */
	public String getUserNickName() {
		return mUserNickName;
	}

	/** 사용자 버전명 반환 메소드 */
	public String getVersionName() {
		return mVersionName;
	}

	/** 사용자 마켓 반환 메소드 */
	public String getMarket() {
		return mMarket;
	}

	/** 사용자 언어 반환 메소드 */
	public String getLanuage() {
		return mLanguage;
	}

	/** 사용자 나라 반환 메소드 */
	public String getCountry() {
		return mCountry;
	}

	/** 사용자 최근 방문 날짜 반환 메소드 */
	public String getLastDt() {
		return mLastDt;
	}

	/** 사용자 최초 방문 날짜 반환 메소드 */
	public String getCreateDt() {
		return mCreateDt;
	}

	/** 사용자 OS버전 */
	public String getGcmToken() {
		return mGcmToken;
	}

	/** 사용자 토큰 반환 메소드 */
	public String getOsVersion() {
		return mOsVersion;
	}

	/** 사용자 통신사반환 메소드 */
	public String getTelGbn() {
		return mTelGbn;
	}

	/** 방문자 수 반환 메소드 */
	public String getVisits() {
		return mVisits;
	}
	
	/** 방문자 수 설정 메소드 */
	public void setVisits(String visit) {
		mVisits = visit;
	}
	/** 모바일 OS 설정 메소드 */
	public void setOS(String os) {
		mOs = os;
	}

	/** 사용자 전화번호 설정 메소드 */
	public void setPhone(String phone) {
		mPhone = phone;
	}

	/** 사용자 닉네임 설정 메소드 */
	public void setUserNickName(String nickname) {
		mUserNickName = nickname;
	}

	/** 사용자 버전명 설정 메소드 */
	public void setVersionName(String version) {
		mVersionName = version;
	}

	/** 사용자 마켓 설정 메소드 */
	public void setMarket(String market) {
		mMarket = market;
	}

	/** 사용자 언어 설정 메소드 */
	public void setLanuage(String lang) {
		mLanguage = lang;
	}

	/** 사용자 나라 설정 메소드 */
	public void setCountry(String county) {
		mCountry = county;
	}

	/** 사용자 최근 방문 날짜 설정 메소드 */
	public void setLastDt(String last) {
		mLastDt = last;
	}

	/** 사용자 최초 방문 날짜 설정 메소드 */
	public void setCreateDt(String dt) {
		mCreateDt = dt;
	}

	/** 사용자 토큰 설정 메소드 */
	public void setGcmToken(String token) {
		mGcmToken = token;
	}

	/** 사용자 토큰 설정 메소드 */
	public void setOsVersion(String osVersion) {
		mOsVersion = osVersion;
	}

	/** 사용자 통신사 설정 메소드 */
	public void setTelGbn(String telGbn) {
		mTelGbn = telGbn;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Os=");
		sb.append(mOs);
		sb.append(",");
		sb.append("UserNickName=");
		sb.append(mUserNickName);
		sb.append(",");
		sb.append("VersionName=");
		sb.append(mVersionName);
		sb.append(",");
		sb.append("Market=");
		sb.append(mMarket);
		sb.append(",");
		sb.append("Language=");
		sb.append(mLanguage);
		sb.append(",");
		sb.append("Country=");
		sb.append(mCountry);
		sb.append(",");
		sb.append("LastDt=");
		sb.append(mLastDt);
		sb.append(",");
		sb.append("CreateDt=");
		sb.append(mCreateDt);
		sb.append(",");
		sb.append("GcmToken=");
		sb.append(mGcmToken);
		sb.append(",");
		sb.append("OsVersion=");
		sb.append(mOsVersion);
		sb.append(",");
		sb.append("TelGbn=");
		sb.append(mTelGbn);

		return sb.toString();
	}

}
