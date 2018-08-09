package utils;

/**
 * 문자열 유틸 클래스
 * 
 * @version 1.0
 */
public class StringUtil {

	/** Html 특수문자들 */
	private final static String[][] HTML_CHAR = { { "&quot;", "\"" }, { "&apos;", "'" }, { "&#39;", "'" },
			{ "&lt;", "<" }, { "&gt;", ">" }, { "&lsquo;", "‘" }, { "&rsquo;", "’" }, { "&middot;", "·" },
			{ "&amp;", "&" } };

	/**
	 * Html을 특수문자로 변경한다
	 * 
	 * @param content
	 *            변환할 내용
	 * @return 변환된 내용
	 */
	public static String encodeHtml(String content) {

		for (int i = HTML_CHAR.length - 1; i >= 0; i--) {
			content = content.replace(HTML_CHAR[i][1], HTML_CHAR[i][0]);
		}
		return content;
	}

	/**
	 * 특수문자로 변환된 Html을 원래문자로 변경한다
	 * 
	 * @param content
	 *            변환할 내용
	 * @return 변환된 내용
	 */
	public static String decodeHtml(String content) {

		for (String[] str : HTML_CHAR) {
			content = content.replace(str[0], str[1]);
		}
		return content;
	}

	/**
	 * 줄바꿈(\n)을 &lt;br/&gt; 태그로 치환한다.
	 * 
	 * @param content
	 *            컨텐츠
	 * @return 변경된 문자열
	 */
	public static String replaceLineToBr(String content) {
		return content.replace("\n", "<br/>"); // 개행문자(\n)
	}

	/**
	 * 줄바꿈(\n)을 제거한다.
	 * 
	 * @param content
	 *            컨텐츠
	 * @return 변경된 문자열
	 */
	public static String removeLine(String content) {
		return content.replace("\n", ""); // 개행문자(\n)
	}

	/**
	 * 특수문자로 변환된 문자열을 제거한다. (개행문자 포함)<br/>
	 * 제거되는 문자열 : \n &amp; &apos; &quot; &lt; &gt; &lsquo; &rsquo; &middot;
	 * 
	 * @param content
	 *            컨텐츠
	 * @return 변경된 문자열
	 */
	public static String removeAllEscString(String content) {
		return removeAllEscString(content, true);
	}

	/**
	 * 특수문자로 변환된 문자열을 제거한다. (개행문자 제외)<br/>
	 * 제거되는 문자열 : &amp; &apos; &quot; &lt; &gt; &lsquo; &rsquo; &middot;<br/>
	 * 
	 * @param content
	 *            컨텐츠
	 * @param hasLine
	 *            개행문자(\n)를 제거하면 true, 아니면 false
	 * @return 변경된 문자열
	 */
	public static String removeAllEscStringExceptLine(String content) {
		return removeAllEscString(content, false);
	}

	/**
	 * 특수문자로 변환된 문자열을 제거한다. (개행문자 제외)<br/>
	 * 제거되는 문자열 : &amp; &apos; &quot; &lt; &gt; &lsquo; &rsquo; &middot;<br/>
	 * 제거되는 옵션 문자열 : 개행문자(\n)
	 * 
	 * @param result
	 *            컨텐츠
	 * @param hasLine
	 *            개행문자(\n)를 제거하면 true, 아니면 false
	 * @return 변경된 문자열
	 */
	private static String removeAllEscString(String content, boolean hasLine) {
		String result = content;
		if (hasLine) {
			result = result.replace("\n", ""); // 개행문자(\n)
		}
		result = result.replace("&amp;", ""); // &
		result = result.replace("&#39;", ""); // '
		result = result.replace("&apos;", ""); // '
		result = result.replace("&quot;", ""); // "
		result = result.replace("&lt;", ""); // <
		result = result.replace("&gt;", ""); // >
		result = result.replace("&lsquo;", ""); // ‘
		result = result.replace("&rsquo;", ""); // ’
		result = result.replace("&middot;", ""); // ·
		return result;
	}
}
