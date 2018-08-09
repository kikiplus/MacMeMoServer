package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import utils.DBConnectionUtil;
import vo.Board;

import java.sql.*;

/**
 * 게시판 DAO
 * 실제로 사용하지 않음
 */
public class BoardDao {

	/**
	 * 게시판 조회
	 * 
	 * @return 게시판 내용
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<Board> selecetBoard(String sql) throws SQLException, ClassNotFoundException {

		ArrayList<Board> boardList = new ArrayList<Board>();

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
				String title = rs.getNString(1);
				String content = rs.getNString(2);
				String date = rs.getNString(3);
				int idx = rs.getInt(4);
				Board board = new Board();
				board.setTitle(title);
				board.setContent(content);
				board.setDate(date);
				board.setIdx(idx);
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
	 * 게시판 글 추가
	 * 
	 * @return 게시판 글 추가 성공 여부
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static boolean insertBoard(Board board) throws SQLException, ClassNotFoundException {

		Connection con = null;

		try {
			con = DBConnectionUtil.getConnection();
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String currentTime = sdf.format(calendar.getTime());

			String sql = "INSERT BOARD (TITLE, CONTENT, BOARD_DATE)" + "Values (?, ?, ?)";

			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
			preparedStmt.setString(1, board.getTitle());
			preparedStmt.setString(2, board.getContent());
			preparedStmt.setString(3, currentTime);
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
	public static boolean modifyBoard(Board board) throws SQLException {
		Connection con = null;

		try {
			con = DBConnectionUtil.getConnection();
			String sql = "UPDATE BOARD SET TITLE = '" + board.getTitle() + "', CONTENT = '" + board.getContent()
					+ "' WHERE IDX = " + board.getIdx() + "";

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
	 * 게시판 글 삭제
	 * 
	 * @param board
	 * @return 게시판 글 삭제 성공 여부
	 * @throws SQLException
	 */
	public static boolean deleteBoard(int idx) throws SQLException {
		Connection con = null;
		try {
			con = DBConnectionUtil.getConnection();
			String sql = "DELETE FROM BOARD WHERE IDx = " + idx + ";";

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
}
