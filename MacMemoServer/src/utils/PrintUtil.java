package utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

/**
 * @Class Name : PrintUtil.java
 * @version 1.0
 */
public class PrintUtil {

	/**
	 * 패턴에 맞는 날짜 형식으로 변환
	 * 
	 * @param pattern
	 *            날짜 포맷
	 * @return
	 */
	public static void printHeaderAndContents(HttpServletRequest request) {
		// System.out.println("request params: " +
		// request.getParameterMap().toString());
		// System.out.println("request getCharacterEncoding: " +
		// request.getCharacterEncoding());
		// System.out.println("request getContentLength: " +
		// request.getContentLength());

		// 헤더에서 정보 가져오기
		// System.out.println("=========== Request Header ==================");
		Enumeration<String> eHeader = request.getHeaderNames();
		while (eHeader.hasMoreElements()) {
			String hName = (String) eHeader.nextElement();
			String hValue = request.getHeader(hName);

			System.out.println(hName + " : " + hValue);
		}
		// System.out.println("=============================");
		// Request에 정보 담을때 가져오기
		// System.out.println("========== Request ===================");
		Enumeration<String> eParam = request.getParameterNames();
		while (eParam.hasMoreElements()) {
			String pName = (String) eParam.nextElement();
			String pValue = request.getParameter(pName);

			// System.out.println(pName + " : " + pValue);
		}
		// System.out.println("=============================");
	}
}
