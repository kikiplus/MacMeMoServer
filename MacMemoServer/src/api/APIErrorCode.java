package api;

import java.util.HashMap;
import java.util.Map;

/**
 * API Error Code 정의 클래스
 * 
 * @since 2017.02.21
 * @version 1.0
 */
public enum APIErrorCode {
	/** 알수없는 오류인 경우 */
	UNDEFINED_ERROR_CODE(-10, "UNDEFINED_ERROR_CODE"),
	/** API단 에러 메시지 */
	API_COMMON_ERROR(-20, "API_COMMON_ERROR"),
	/** Server 설정 에러 메시지 */
	SERVER_COMMON_ERROR(-21, "SERVER_COMMON_ERROR"),
	/** API단 에러 메시지 */
	API_DATA_ERROR(-22, "API_DATA_INPUT_ERROR"),
	/** AI 에러 메시지 */
	AI_ERROR(-30, "AI_RESPOD_ERROR"),
	/** CHAT 에러 메시지 */
	CHAT_ERROR(-40, "CHAT_RESPOD_ERROR"),
	/** CHAT 에러 메시지 */
	CHAT_DATA_ERROR(-41, "CHAT_API_DATA_INPUT_ERROR");

	private final int errorCode;
	private String errorMsg;
	private static final Map<Integer, APIErrorCode> reverseMap = new HashMap<Integer, APIErrorCode>(5);

	static {
		for (APIErrorCode errorCode : APIErrorCode.values()) {
			reverseMap.put(errorCode.getErrorCode(), errorCode);
		}
	}

	APIErrorCode(final int errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public static APIErrorCode valueOf(final Integer i) {
		if (i == null)
			return null;
		APIErrorCode errorCode = reverseMap.get(i);
		if (errorCode != null)
			return errorCode;
		else
			return UNDEFINED_ERROR_CODE;
	}
}
