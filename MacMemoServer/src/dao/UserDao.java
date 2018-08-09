package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import utils.DBConnectionUtil;

import java.sql.*;

/**
 * 계정관리 DAO
 */
public class UserDao {

	/**
	 * 사용자 정보 반환(관리자 단)
	 * 
	 * @param user
	 * @return 사용자 정보 존재 여부(true - 있음, false - 없음)
	 * @throws SQLException
	 */
	public static boolean checkUser(vo.User user) throws SQLException {
		Connection con = null;
		String sql = "SELECT ID, PASSWORD FROM ACCOUNT WHERE ID = '" + user.getUserID() + "' AND PASSWORD = '"
				+ user.getUserPassword() + "';";

		System.out.println(sql);
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
				String id = rs.getNString(1);
				String pw = rs.getNString(2);

				System.out.println("@@ id : " + id);
				System.out.println("@@ pw : " + pw);
				if (id.equals(user.getUserID()) && pw.equals(user.getUserPassword())) {
					return true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				con.close();
			}
		}
		return false;
	}
	
	/**
	 * 사용자 정보 반환(관리자 단)
	 * 
	 * @param user
	 * @return admin 계정 체크(true - 있음, false - 없음)
	 * @throws SQLException
	 */
	public static boolean checkAdmin(vo.User user) throws SQLException {
		Connection con = null;
		String sql = "SELECT ID, PASSWORD FROM ACCOUNT WHERE ID = 'admin';";

		try {
			con = DBConnectionUtil.getConnection();
			System.out.println("con : " +con);
			
			java.sql.Statement st = null;
			ResultSet rs = null;
			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (st.execute(sql)) {
				rs = st.getResultSet();
			}

			while (rs.next()) {
				String id = rs.getNString(1);
				String pw = rs.getNString(2);

				System.out.println("@@ id : " + id);
				System.out.println("@@ pw : " + pw);
				if (id.equals(user.getUserID()) && pw.equals(user.getUserPassword())) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				con.close();
			}
			
		}
		return false;
	}
}
