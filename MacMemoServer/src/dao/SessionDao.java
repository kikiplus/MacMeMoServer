package dao;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * SessionDao DAO
 */
public class SessionDao {

	/**
	 * 세션에 값 추가하기
	 */
	public static void addSessionValue(HttpServletRequest request, String key, String value) {
		HttpSession session = request.getSession();
		session.setAttribute(key, value);
		session.setMaxInactiveInterval(3600000);
		System.out.println("@@ addSessionValue key : " + key + ", value : " + value);
	}

	/**
	 * 세션 값 반환하기
	 * 
	 * @param key
	 *            키값
	 * @return 저장된 키값
	 */
	public static String getSessionValue(HttpServletRequest request, String key) {
		HttpSession session = request.getSession();
		String value = (String) session.getAttribute(key);
		System.out.println("@@ getSessionValue key : " + key + ", value : " + value);
		return value;
	}

	/**
	 * 세션 값 삭제하기
	 * 
	 * @param key
	 *            키값
	 */
	public static void removeSessionValue(HttpServletRequest request, String key) {
		HttpSession session = request.getSession();
		session.removeAttribute(key);
	}

	/**
	 * 세션 값 모두 출력하기
	 */
	public static void printSessionValues(HttpServletRequest request) {
		HttpSession session = request.getSession();

		System.out.println("======= Seesion Print Start ");
		Enumeration<String> sessionArray = (Enumeration<String>) session.getAttributeNames();
		while (sessionArray.hasMoreElements()) {
			System.out.println(sessionArray.nextElement());
		}
		System.out.println("======= Seesion Print End ");

	}
}
