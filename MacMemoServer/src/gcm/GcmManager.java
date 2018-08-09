package gcm;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.google.android.gcm.server.Message.Builder;

import utils.XMLParser;

import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

/***
 * @Class Name : GcmManager
 * @Description :GcmManager 관리 클래스
 * @since 2015. 8. 25.
 * @version 1.0
 */
public class GcmManager {

	/**
	 * 메시지 전송 메소드
	 * 
	 * @param registrationId
	 *            (GCM RegID)
	 * @param content
	 *            (전송할 내용)
	 * @throws Exception
	 *             예외
	 */
	public static boolean sendMessage(String registrationId, String content) {

		String gcmAPIKey = XMLParser.getXMLObject("gcmProjectAPIKey");
		System.out.println("@@ sendMessage : " + gcmAPIKey);
		Sender sender = new com.google.android.gcm.server.Sender(gcmAPIKey);
		Builder builder = new com.google.android.gcm.server.Message.Builder();
		try {
			builder.addData("msg", URLEncoder.encode(content, "UTF-8"));
			builder.delayWhileIdle(true);
			Result userAppResult;
			try {
				userAppResult = (Result) sender.send(builder.build(), registrationId, 0);
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			String resultMessage = userAppResult.toString();

			//System.out.println("@@ resulst : " + resultMessage);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
