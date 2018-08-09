package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.DBConnectionUtil;
import utils.XMLParser;
import vo.AIScript;

import java.sql.*;

/**
 * AIScript DAO
 */
public class AIDao {

	/**
	 * AIScript 조회
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<AIScript> selecetAIScriptList() throws SQLException, ClassNotFoundException {

		ArrayList<AIScript> list = new ArrayList<AIScript>();

		Connection con = null;

		String sql = XMLParser.getSqlFromXML("selecetAIScriptList");

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
				int categoryCode = rs.getInt(1);
				String content = rs.getNString(2);
				int idx = rs.getInt(3);
				AIScript script = new AIScript();
				script.setCategoryCode(categoryCode);
				script.setContent(content);
				script.setIdx(idx);

				list.add(script);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
		}

		return list;
	}

	/**
	 * AIScript 조회
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static AIScript selecetAIScript(int reqIdx) throws SQLException, ClassNotFoundException {

		AIScript script = new AIScript();

		Connection con = null;
		String sql = "SELECT CATEGORY_CODE, CONTENT, IDX FROM AI_SCRIPT WHERE IDX =  " + reqIdx + ";";

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
				int categoryCode = rs.getInt(1);
				String content = rs.getNString(2);
				int idx = rs.getInt(3);
				script.setCategoryCode(categoryCode);
				script.setContent(content);
				script.setIdx(idx);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
		}

		return script;
	}

	/**
	 * AIScript 조회
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static AIScript selectAIScript(String reqContent) throws SQLException, ClassNotFoundException {

		AIScript script = new AIScript();

		Connection con = null;
		String sql = "SELECT CATEGORY_CODE, CONTENT, IDX FROM AI_SCRIPT WHERE CONTENT =  '" + reqContent + "';";

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
				int categoryCode = rs.getInt(1);
				String content = rs.getNString(2);
				int idx = rs.getInt(3);
				script.setCategoryCode(categoryCode);
				script.setContent(content);
				script.setIdx(idx);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
		}

		return script;
	}

	/**
	 * AIScript 글 추가
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static boolean insertAIScript(AIScript script) throws SQLException, ClassNotFoundException {

		Connection con = null;

		try {
			con = DBConnectionUtil.getConnection();
			String sql = XMLParser.getSqlFromXML("insertAIScript");

			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
			preparedStmt.setInt(1, script.getCategoryCode());
			preparedStmt.setString(2, script.getContent());

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
	 * AIScript 글 수정
	 * 
	 * @throws SQLException
	 */
	public static boolean modifyAIScript(AIScript script) throws SQLException {
		Connection con = null;

		try {
			con = DBConnectionUtil.getConnection();
			String sql = XMLParser.getSqlFromXML("modifyAIScript");

			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
			preparedStmt.setString(1, script.getContent());
			preparedStmt.setInt(2, script.getIdx());
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
	 * AIScript 글 수정
	 * 
	 * @throws SQLException
	 */
	public static boolean updateAIScript(int categoryCode, int idx) throws SQLException {
		Connection con = null;

		try {
			con = DBConnectionUtil.getConnection();
			String sql = XMLParser.getSqlFromXML("updateAIScript");

			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
			preparedStmt.setInt(1, categoryCode);
			preparedStmt.setInt(2, idx);
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
	 * AIScript 글 삭제
	 * 
	 * @throws SQLException
	 */
	public static boolean deleteAIScript(int idx) throws SQLException {
		Connection con = null;
		try {
			con = DBConnectionUtil.getConnection();
			String sql = XMLParser.getSqlFromXML("deleteAIScript");

			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
			preparedStmt.setInt(1, idx);
			preparedStmt.execute(sql);

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			con.close();
		}
		return true;

	}
}
