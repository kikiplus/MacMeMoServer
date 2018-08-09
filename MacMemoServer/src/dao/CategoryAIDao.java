package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.DBConnectionUtil;
import utils.XMLParser;
import vo.CategoryAI;

import java.sql.*;

/**
 * 버킷 카데고리 관리 DAO
 */
public class CategoryAIDao {

	/**
	 * AI 카데고리 조회
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<CategoryAI> selectCategoryAI() throws SQLException, ClassNotFoundException {

		ArrayList<CategoryAI> boardList = new ArrayList<CategoryAI>();

		Connection con = null;
		String sql = XMLParser.getSqlFromXML("selectCategoryAI");

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
				String categoryName = rs.getNString(2);
				CategoryAI category = new CategoryAI();
				category.setCategoryCode(categoryCode);
				category.setCategoryName(categoryName);
				boardList.add(category);
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
	 * AI 카데고리 추가
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static boolean insertCategoryAI(CategoryAI category) throws SQLException, ClassNotFoundException {

		Connection con = null;

		try {
			con = DBConnectionUtil.getConnection();
			String sql = XMLParser.getSqlFromXML("insertCategoryAI");

			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
			preparedStmt.setInt(1, category.getCategoryCode());
			preparedStmt.setString(2, category.getCategoryName());
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
	 * AI 카데고리 수정
	 * 
	 * @param board
	 * @return 게시판 글 수정 성공 여부
	 * @throws SQLException
	 */
	public static boolean modifyCategoryAI(CategoryAI category) throws SQLException {
		Connection con = null;

		try {
			con = DBConnectionUtil.getConnection();
			String sql = XMLParser.getSqlFromXML("modifyCategoryAI");

			System.out.println(sql);

			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
			preparedStmt.setInt(1, category.getCategoryCode());
			preparedStmt.setString(2, category.getCategoryName());
			preparedStmt.setInt(3, category.getCategoryCode());
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
	 * AI 카데고리 삭제
	 * 
	 * @param board
	 * @return 게시판 글 삭제 성공 여부
	 * @throws SQLException
	 */
	public static boolean deleteCategoryAI(int CategoryCode) throws SQLException {
		Connection con = null;
		try {
			con = DBConnectionUtil.getConnection();
			String sql = XMLParser.getSqlFromXML("deleteCategoryAI");

			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
			preparedStmt.setInt(1, CategoryCode);
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
