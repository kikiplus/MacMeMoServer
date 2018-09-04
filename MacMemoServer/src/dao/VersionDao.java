package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.DBConnectionUtil;
import utils.XMLParser;
import vo.Version;

import java.sql.*;

/**
 * 버전관리 DAO
 */
public class VersionDao {

	/**
	 * 버전 조회
	 * 
	 * @return 게시판 내용
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<Version> selectVersion(String sql) throws SQLException, ClassNotFoundException {

		ArrayList<Version> boardList = new ArrayList<Version>();

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
				String force = rs.getNString(3);
				Version board = new Version();
				board.setVersionCode(versionCode);
				board.setVersionName(versionName);
				board.setForceYN(force);
				boardList.add(board);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
		}

		return boardList;
	}

	/**
	 * 버전 조회(1건)
	 * 
	 * @return 게시판 내용
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Version selectCurrentVersion(String sql) throws SQLException, ClassNotFoundException {

		Version versionVO = new Version();

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
				String force = rs.getNString(3);
				versionVO.setVersionCode(versionCode);
				versionVO.setVersionName(versionName);
				versionVO.setForceYN(force);
				break;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
		}

		return versionVO;
	}

	/**
	 * 버전 추가
	 * 
	 * @return 게시판 글 추가 성공 여부
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static boolean insertVersion(Version version) throws SQLException, ClassNotFoundException {

		Connection con = null;

		try {
			con = DBConnectionUtil.getConnection();
			String sql = XMLParser.getSqlFromXML("insertVersion");

			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
			preparedStmt.setInt(1, version.getVersionCode());
			preparedStmt.setString(2, version.getVersionName());
			preparedStmt.setString(3, version.getForceYN());
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
	 * 버전 수정
	 * 
	 * @param board
	 * @return 게시판 글 수정 성공 여부
	 * @throws SQLException
	 */
	public static boolean modifyVersion(Version board) throws SQLException {
		Connection con = null;

		try {
			con = DBConnectionUtil.getConnection();
			String sql = XMLParser.getSqlFromXML("modifyVersion");

			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
			preparedStmt.setInt(1, board.getVersionCode());
			preparedStmt.setString(2, board.getVersionName());
			preparedStmt.setString(3, board.getForceYN());
			preparedStmt.setInt(4, board.getVersionCode());

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
	 * 버전 삭제
	 * 
	 * @param board
	 * @return 게시판 글 삭제 성공 여부
	 * @throws SQLException
	 */
	public static boolean deleteVersion(int versionCode) throws SQLException {
		Connection con = null;
		try {
			con = DBConnectionUtil.getConnection();
			String sql = XMLParser.getSqlFromXML("deleteVersion");

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
	 * 최신 버전 정보 반환
	 * 
	 * @param board
	 * @return 게시판 글 삭제 성공 여부
	 * @throws SQLException
	 */
	public static Version getLastestVersion() throws SQLException {
		Connection con = null;
		Version version = new Version();
		String sql = XMLParser.getSqlFromXML("selectMobileVersion");

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
				String forceYN = rs.getNString(3);

				if (mVersionCode < versionCode) {
					mVersionCode = versionCode;
					version.setVersionCode(versionCode);
					version.setVersionName(versionName);
					version.setForceYN(forceYN);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
		}

		return version;
	}

	/**
	 * 최신 버전 정보 반환
	 * 
	 * @param board
	 * @return 최신 버전 정
	 * @throws SQLException
	 */
	public static Version getLastVersion() throws SQLException {
		Connection con = null;
		String sql = XMLParser.getSqlFromXML("selectAppLastVersion");
		Version version = new Version();
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
				version.setVersionCode(versionCode);
				version.setVersionName(versionName);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
		}

		return version;
	}
	
	/**
	 * 최신 버전 정보 반환
	 * 
	 * @param board
	 * @return 최신 버전 정
	 * @throws SQLException
	 */
	public static String getLastVersionName() throws SQLException {
		Connection con = null;
		String sql = XMLParser.getSqlFromXML("selectAppLastVersion");
		String strVersion = "";
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
				strVersion = rs.getNString(2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
		}

		return strVersion;
	}

}
