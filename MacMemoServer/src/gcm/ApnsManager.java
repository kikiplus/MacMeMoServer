package gcm;

import javapns.devices.*;
import javapns.devices.Device;
import javapns.devices.implementations.basic.BasicDevice;
import javapns.notification.*;

public class ApnsManager {

	public static int RUN_MODE_DEVELOPMENT = 1;
	public static int RUN_MODE_PRODUCTION = 2;
	
	/**
	 * IOS 메시지 전송 메소드
	 * 
	 * @param runMode
	 *          RUN_MODE_DEVELOPMENT 개발용  RUN_MODE_PRODUCTION 배포
	 * @param deviceToken
	 *           디바이스토큰
	 * @param alertMessage
	 *           메시
	 * @param badgeCount
	 *           뱃지 카운트
	 * @param soundFile
	 *           사운          
	 * @throws Exception
	 *             예외
	 */
	public static boolean sendAPNSMessage(int runMode, String deviceToken, String alertMessage, 
			int badgeCount, String soundFile, String certPassword) throws Exception {
		
		boolean result = false;
		try {
			
			String host = null;
			String certificatePath = null;
			
			if (runMode == RUN_MODE_DEVELOPMENT) {
				host = "gateway.sandbox.push.apple.com";
				certificatePath = "Key/development_key.p12";
			} else if (runMode == RUN_MODE_PRODUCTION) {
				host = "gateway.push.apple.com";
				certificatePath = "Key/production_key.p12";
			}

			int port = 2195;
			
			PushNotificationManager pushManager = new PushNotificationManager();
			pushManager.initializeConnection(new AppleNotificationServerBasicImpl(certificatePath, certPassword,"PKCS12",host,port));
			 
			PushNotificationPayload payLoad = new PushNotificationPayload();
			payLoad.addBadge(1);
			payLoad.addSound("default");
			payLoad.addAlert("테스트 입니다."); // 아이폰에 보낼 메세지
			Device device = new BasicDevice();
			device.setToken(deviceToken);
			PushedNotification notification = pushManager.sendNotification(device, payLoad);
			result = notification.isSuccessful();
			 
			System.out.println("========== END ==========");

		} catch (Exception ex) {
			ex.printStackTrace(); 
			System.out.println("@@ sendAPNSMessage Exception : " + ex.toString());
			return false;
		}
		
		return result;
	}
}
