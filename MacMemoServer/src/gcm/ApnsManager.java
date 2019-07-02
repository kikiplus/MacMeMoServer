package gcm;
import javapns.back.PushNotificationManager;
import javapns.back.SSLConnectionHelper;
import javapns.data.Device;
import javapns.data.PayLoad;

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
		
		try {
			
			PayLoad payLoad = new PayLoad();
			payLoad.addAlert(alertMessage);
			payLoad.addBadge(badgeCount);
			payLoad.addSound(soundFile);

			PushNotificationManager pushManager = PushNotificationManager.getInstance();
			pushManager.addDevice("iPhone", deviceToken);

			String host = null;
			String certificatePath = null;
			
			if (runMode == RUN_MODE_DEVELOPMENT) {
				host = "gateway.sandbox.push.apple.com";
				certificatePath = "./Key/development_key.p12";
			} else if (runMode == RUN_MODE_PRODUCTION) {
				host = "gateway.push.apple.com";
				certificatePath = "./Key/production_key.p12";
			}

			int port = 2195;
			pushManager.initializeConnection(host, port, certificatePath, certPassword, SSLConnectionHelper.KEYSTORE_TYPE_PKCS12);

			Device client = pushManager.getDevice("iPhone");
			pushManager.sendNotification(client, payLoad);
			pushManager.stopConnection();

			pushManager.removeDevice("iPhone");
			
			
		} catch (Exception ex) {
			ex.printStackTrace(); 
			System.out.println("@@ sendAPNSMessage Exception : " + ex.toString());
			return false;
		}
		
		return true;
	}
}
