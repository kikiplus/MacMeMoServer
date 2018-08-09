package vo;

/** 방문 기록 클래스 */
public class TodayCnt {

	/** 날짜 */
	private String mDate;
	/** 방문수 */
	private int mCnt;
	/** 요일 */
	private String mDay;
	/** 최근방문일 */
	private String mLastDt;
	/** 버전명 */
	private String mVersion;

	/** 생성자 */
	public TodayCnt() {

	}

	/** 날짜 설정 메소드 */
	public void setDate(String date) {
		mDate = date;
	}

	/** 방문수 설정 메소드 */
	public void setTodayCnt(int cnt) {
		mCnt = cnt;
	}

	/** 요일 설정 메소드 */
	public void setDay(int day) {
		switch (day) {
		case 1:
			mDay = "일";
			break;
		case 2:
			mDay = "월";
			break;
		case 3:
			mDay = "화";
			break;
		case 4:
			mDay = "수";
			break;
		case 5:
			mDay = "목";
			break;
		case 6:
			mDay = "금";
			break;
		case 7:
			mDay = "토";
			break;
		}

	}

	/** 요일 설정 메소드 */
	public void setDay(String day) {
		switch (day) {
		case "1":
			mDay = "일";
			break;
		case "2":
			mDay = "월";
			break;
		case "3":
			mDay = "화";
			break;
		case "4":
			mDay = "수";
			break;
		case "5":
			mDay = "목";
			break;
		case "6":
			mDay = "금";
			break;
		case "7":
			mDay = "토";
			break;
		}

	}

	/** 방문수 설정 메소드 */
	public void setLastDt(String day) {
		mLastDt = day;
	}

	/** 버전명 설정 메소드 */
	public void setVersion(String version) {
		mVersion = version;
	}

	/** 날짜 메소드 */
	public String getDate() {
		return mDate;
	}

	/** 방문수 반환 메소드 */
	public int getTodayCnt() {
		return mCnt;
	}

	/** 요일 설정 메소드 */
	public String getDay() {
		return mDay;
	}

	/** 방문수 반환 메소드 */
	public String getLastDt() {
		return mLastDt;
	}

	/** 버전명 반환 메소드 */
	public String getVersion() {
		return mVersion;
	}
}
