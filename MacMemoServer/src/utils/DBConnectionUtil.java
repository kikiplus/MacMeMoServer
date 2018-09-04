package utils;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;


/**
 * DB 연결 관리 유틸 클래스
 * 
 * @author grapegirl
 */
public class DBConnectionUtil {

	/** DB driver */
	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver"; //개발 
//	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver"; //운영
	
	private static final String DB_NAME = "kikiplus";
	
	private static final String DB_PASSWORD = "tkfkdgo4596"; // 개발 
//	private static final String DB_PASSWORD = "tkfkdgo4596!"; //운영 
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/kikiplus?serverTimezone=UTC&verifyServerCertificate=false&useSSL=false&allowPublicKeyRetrieval=true"; // 개발 
//	private static final String DB_URL = "jdbc:mysql://localhost:3306/kikiplus?serverTimezone=UTC&verifyServerCertificate=false&useSSL=false"; // 운영 
			
			
			//"jdbc:mysql://localhost:3306/kikiplus?autoReconnect=true&useSSL=false&serverTimezone=UTC&characterEncoding=utf8&characterSetResults=utf8&verifyServerCertificate=false";
			
	/** 커넥션 */
	
	private static Connection mConnection = null;

	/**
	 * @Method : getConnection
	 * @Description : 커넥션 반환 메소드
	 */
	public static Connection getConnection() throws SQLException {
		System.out.println("@@ getConnection");
		
		try {
			Class.forName(DRIVER_NAME);
		    System.out.println("@@ name : "+ DB_NAME + ", password : " + DB_PASSWORD + ", url : "+  DB_URL);
			mConnection = (Connection) DriverManager.getConnection(DB_URL, DB_NAME, DB_PASSWORD);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("@@ DBConnectionUtil getConnection ClassNotFoundException Error");
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("@@ DBConnectionUtil getConnection Exception : " + e.getMessage());
		}
		return mConnection;
	}

	/***
	 * @Method : closeConnection
	 * @Description : 커넥션 닫기 메소드
	 */
	public static void closeConnection() {
		if (mConnection != null) {
			try {
				mConnection.close();
			} catch (Exception e) {
			}
		}
	}
}