package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.DBConnectionUtil;
import utils.XMLParser;
import vo.UpdateApp;

import java.sql.*;

/**
 * 업데이트내역 DAO
 */
public class UpdateAppDao {

	/**
	 * 게시판 조회
	 * 
	 * @return 게시판 내용
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<UpdateApp> selecetUpdateApp(String sql) throws SQLException, ClassNotFoundException {

		ArrayList<UpdateApp> boardList = new ArrayList<UpdateApp>();

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
				int idx = rs.getInt(1);
				String content = rs.getNString(2);

				UpdateApp update = new UpdateApp();
				update.setVersionCode(idx);
				update.setContent(content);
				boardList.add(update);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if(con != null) {
				con.close();
			}
		}

		return boardList;
	}

	/**
	 * 게시판 글 추가
	 * 
	 * @return 게시판 글 추가 성공 여부
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static boolean insertUpdateApp(UpdateApp board) throws SQLException, ClassNotFoundException {

		Connection con = null;

		try {
			con = DBConnectionUtil.getConnection();

			String sql = XMLParser.getSqlFromXML("insertUpdateApp");
			System.out.println("@@ sql : " + sql);	
			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
			preparedStmt.setString(1, board.getContent());
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
	 * 게시판 글 수정
	 * 
	 * @param board
	 * @return 게시판 글 수정 성공 여부
	 * @throws SQLException
	 */
	public static boolean modifyUpdateApp(UpdateApp board) throws SQLException {
		Connection con = null;

		try {
			con = DBConnectionUtil.getConnection();

			String sql = XMLParser.getSqlFromXML("modifyUpdateApp");
			System.out.println(sql);

			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
			preparedStmt.setInt(1, board.getVersionCode());
			preparedStmt.setString(2, board.getContent());
			preparedStmt.setInt(3, board.getVersionCode());
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
	 * 게시판 글 삭제
	 * 
	 * @param board
	 * @return 게시판 글 삭제 성공 여부
	 * @throws SQLException
	 */
	public static boolean deleteUpdateApp(int idx) throws SQLException {
		Connection con = null;
		try {
			con = DBConnectionUtil.getConnection();

			String sql = XMLParser.getSqlFromXML("deleteUpdateApp");

			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
			preparedStmt.setInt(1, idx);
			preparedStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			con.close();
		}
		return true;

	}
}
