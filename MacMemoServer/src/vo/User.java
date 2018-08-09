package vo;

/** 사용자  클래스 */
public class User {

	/** 사용자 아이디 */
	private String mUserId;
	/** 사용자 비밀번호 */
	private String mUserPassword;

	/** 생성자 */
	public User() {

	}

	/** 사용자 아이디 설정 메소드 */
	public void setUserID(String UserId) {
		mUserId = UserId;
	}

	/** 사용자 비밀번호 설정 메소드 */
	public void setUserPassword(String UserPassword) {
		mUserPassword = UserPassword;
	}

	/** 사용자 아이디 반환 메소드 */
	public String getUserID() {
		return mUserId;
	}

	/** 사용자 비밀번호 반환 메소드 */
	public String getUserPassword() {
		return mUserPassword;
	}
}
