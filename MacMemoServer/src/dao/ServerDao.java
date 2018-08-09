package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.DBConnectionUtil;
import utils.XMLParser;
import vo.IP;

import java.sql.*;

/**
 * 서버관리 DAO
 */
public class ServerDao {

	/**
	 * IP 조회
	 * 
	 * @return 게시판 내용
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<IP> selectIP(String sql) throws SQLException, ClassNotFoundException {

		ArrayList<IP> IPList = new ArrayList<IP>();

		Connection con = null;

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
				int versionCode = rs.getInt(1);
				String versionName = rs.getNString(2);
				IP ip = new IP();
				ip.setVersionCode(versionCode);
				ip.setVersionName(versionName);
				IPList.add(ip);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
		}

		return IPList;
	}

	/**
	 * IP 추가
	 * 
	 * @return IP 추가 성공 여부
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static boolean insertIP(IP ip) throws SQLException, ClassNotFoundException {

		Connection con = null;

		try {
			con = DBConnectionUtil.getConnection();
			String sql = XMLParser.getSqlFromXML("insertIP");

			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
			preparedStmt.setInt(1, ip.getVersionCode());
			preparedStmt.setString(2, ip.getVersionName());
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
	 * IP 수정
	 * 
	 * @param IP
	 * @return IP 수정 성공 여부
	 * @throws SQLException
	 */
	public static boolean modifyIP(IP ip) throws SQLException {
		Connection con = null;

		try {
			con = DBConnectionUtil.getConnection();
			String sql = "UPDATE IP SET VERSION_CODE = '" + ip.getVersionCode() + "', VERSION_NAME = '"
					+ ip.getVersionName() + "' WHERE VERSION_CODE = " + ip.getVersionCode() + "";

			System.out.println(sql);

			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
			preparedStmt.execute(sql);

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			con.close();
		}
		return true;

	}

	/**
	 * IP 삭제
	 * 
	 * @param versionCode
	 *            버전코드
	 * @return 삭제 성공 여부
	 * @throws SQLException
	 */
	public static boolean deleteIP(int versionCode) throws SQLException {
		Connection con = null;
		try {
			con = DBConnectionUtil.getConnection();
			String sql = XMLParser.getSqlFromXML("deleteIP");

			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
			preparedStmt.setInt(1, versionCode);
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
	 * 최신 IP 정보 반환
	 * 
	 * @return 최신 IP 정보 반환
	 * @throws SQLException
	 */
	public static IP getLastestIP() throws SQLException {
		Connection con = null;
		IP ip = new IP();
		String sql = XMLParser.getSqlFromXML("selectMobileIP");

		try {
			con = DBConnectionUtil.getConnection();
			java.sql.Statement st = null;
			ResultSet rs = null;
			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (st.execute(sql)) {
				rs = st.getResultSet();
			}

			int mVersionCode = -1;
			while (rs.next()) {
				int versionCode = rs.getInt(1);
				String versionName = rs.getNString(2);

				if (mVersionCode < versionCode) {
					mVersionCode = versionCode;
					ip.setVersionCode(versionCode);
					ip.setVersionName(versionName);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
		}

		return ip;
	}
}
