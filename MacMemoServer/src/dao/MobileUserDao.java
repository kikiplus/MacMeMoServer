package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.DBConnectionUtil;
import utils.XMLParser;
import vo.MobileUser;

import java.sql.*;

/**
 * 모바일 사용자 계정관리 DAO
 */
public class MobileUserDao {

	/**
	 * 사용자 정보 반환(모바일 단)
	 * 
	 * @return 사용자 정보 존재 여부(true - 있음, false - 없음)
	 * @throws SQLException
	 */
	public static boolean insertUser(vo.MobileUser user) throws SQLException {
		Connection con = null;
		try {
			con = DBConnectionUtil.getConnection();

			String nickname = user.getUserNickName();
			try {
				boolean isExistUser = selecetUser(nickname);
				if (isExistUser) {
					System.out.println("@@ 기존 사용자  nickname :  " + nickname);
					String visits = getUserVisits(nickname);
					int nVisit = Integer.valueOf(visits);
					nVisit++;
					user.setVisits(nVisit + "");
					// 기존 사용자면 사용자 정보 삭제 후 신규로 추가
					deleteUser(nickname);
				} else {
					System.out.println("@@ 신규 사용자  nickname :  " + nickname);
					user.setVisits("1");
				}
			} catch (ClassNotFoundException e) {
				System.out.println("@@ 사용자 정보 업데이트 Error");
				e.printStackTrace();
				return false;
			}
			String sql = XMLParser.getSqlFromXML("insertMobileUser");

			System.out.println("@@ 사용자 업데이트 정보 : " + user.toString());
			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
			preparedStmt.setString(1, user.getOS());
			if (user.getUserNickName() != null) {
				preparedStmt.setString(2, user.getUserNickName());
			} else {
				preparedStmt.setString(2, "-");
			}
			preparedStmt.setString(3, user.getPhone());
			preparedStmt.setString(4, user.getVersionName());
			preparedStmt.setString(5, user.getMarket());
			preparedStmt.setString(6, user.getLanuage());
			preparedStmt.setString(7, user.getCountry());
			preparedStmt.setString(8, user.getLastDt());
			preparedStmt.setString(9, user.getGcmToken());
			preparedStmt.setString(10, user.getOsVersion());
			preparedStmt.setString(11, user.getTelGbn());
			preparedStmt.setString(12, user.getVisits());
			System.out.println("@@ user getvisitss : " + user.getVisits());
			preparedStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			con.close();
		}
		return true;
	}

	/**
	 * 사용자 삭제
	 * 
	 * @param 사용자
	 *            전화번호
	 * @return 사용자 삭제 성공 여부
	 * @throws SQLException
	 */
	public static boolean deleteUser(String phone) throws SQLException {
		Connection con = null;
		try {
			con = DBConnectionUtil.getConnection();

			String sql = XMLParser.getSqlFromXML("deleteUser");

			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
			preparedStmt.setString(1, phone);
			preparedStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			con.close();
		}
		return true;

	}

	/**
	 * 사용자 조회
	 * 
	 * @return 사용자 조회 결과
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static boolean selecetUser(String nickname) throws SQLException, ClassNotFoundException {
		Connection con = null;
		String sql = "SELECT * FROM USER_MOBILE WHERE NICKNAME = '" + nickname + "';";
		System.out.println("@@ selectUser : " + sql);
		try {
			con = DBConnectionUtil.getConnection();
			java.sql.Statement st = null;
			ResultSet rs = null;
			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (st.execute(sql)) {
				rs = st.getResultSet();
			}

			int count = 0;
			while (rs.next()) {
				count++;
			}
			if (count > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			con.close();
		}
		return false;
	}

	/**
	 * 사용자 방문수 조회
	 * 
	 * @return 사용자 조회 결과
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static String getUserVisits(String nickname) throws SQLException, ClassNotFoundException {
		Connection con = null;
		String sql = "SELECT VISITS FROM USER_MOBILE WHERE NICKNAME = '" + nickname + "';";
		String visit = null;
		try {
			con = DBConnectionUtil.getConnection();
			java.sql.Statement st = null;
			ResultSet rs = null;
			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (st.execute(sql)) {
				rs = st.getResultSet();
			}

			while (rs.next()) {
				visit = rs.getNString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			con.close();
		}
		return visit;
	}

	/**
	 * 사용자 조회
	 * 
	 * @return 사용자 조회 결과
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<MobileUser> selecetMobileUser() throws SQLException, ClassNotFoundException {
		ArrayList<MobileUser> userList = new ArrayList<MobileUser>();

		Connection con = null;
		String sql = XMLParser.getSqlFromXML("selecetMobileUser");

		try {
			con = DBConnectionUtil.getConnection();
			java.sql.Statement st = null;
			ResultSet rs = null;
			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (st.execute(sql)) {
				rs = st.getResultSet();
			}

			while (rs.next()) {
				String nickname = rs.getNString(1);
				String version = rs.getNString(2);
				String country = rs.getNString(3);
				String lastDt = rs.getNString(4);
				String gcmToken = rs.getNString(5);
				String phone = rs.getNString(6);
				String osVersion = rs.getNString(7);
				String telGbn = rs.getNString(8);
				String visit = rs.getNString(9);

				MobileUser mobileUser = new MobileUser();
				mobileUser.setUserNickName(nickname);
				mobileUser.setVersionName(version);
				mobileUser.setCountry(country);
				
				if (lastDt != null) {
					String tempDate = lastDt.substring(0, 10);
					mobileUser.setLastDt(tempDate);
				}
				
				mobileUser.setGcmToken(gcmToken);
				mobileUser.setPhone(phone);
				mobileUser.setOsVersion(osVersion);
				mobileUser.setTelGbn(telGbn);
				mobileUser.setVisits(visit);
				userList.add(mobileUser);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
		}

		return userList;
	}

	/**
	 * 사용자 GCM Tocket값 조회
	 * 
	 * @return 사용자 조회 결과
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<String> selecetAllMobileUserToken() throws SQLException, ClassNotFoundException {
		ArrayList<String> userList = new ArrayList<String>();

		Connection con = null;
		String sql = XMLParser.getSqlFromXML("selecetMobileUserToken");

		try {
			con = DBConnectionUtil.getConnection();
			java.sql.Statement st = null;
			ResultSet rs = null;
			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (st.execute(sql)) {
				rs = st.getResultSet();
			}

			while (rs.next()) {
				String gcmToken = rs.getNString(1);
				userList.add(gcmToken);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
		}

		return userList;
	}
}
