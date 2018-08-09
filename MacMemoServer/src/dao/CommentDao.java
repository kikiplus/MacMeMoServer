package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.DBConnectionUtil;
import utils.XMLParser;
import vo.Comment;

import java.sql.*;

/**
 * 버킷 DAO
 */
public class CommentDao {

	/**
	 * 버킷 조회
	 * 
	 * @return 게시판 내용
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<Comment> selecetComment(String sql) throws SQLException, ClassNotFoundException {

		ArrayList<Comment> CommentList = new ArrayList<Comment>();

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
				String nickName = rs.getNString(1);
				String content = rs.getNString(2);
				String date = rs.getNString(3);
				int idx = rs.getInt(4);
				int bucketNo = rs.getInt(5);
				Comment comment = new Comment();

				comment.setNickName(nickName);
				comment.setContent(content);
				comment.setDate(date);
				comment.setIdx(idx);
				comment.setBucketNo(bucketNo);
				CommentList.add(comment);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
		}

		return CommentList;
	}

	/**
	 * 버킷 댓글 글 추가
	 * 
	 * @return 댓글 추가 성공 여부
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static boolean insertComment(Comment comment) throws SQLException, ClassNotFoundException {

		Connection con = null;

		try {
			con = DBConnectionUtil.getConnection();
			String sql = XMLParser.getSqlFromXML("insertMobileComment");

			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
			preparedStmt.setString(1, comment.getNickName());
			preparedStmt.setString(2, comment.getContent());
			preparedStmt.setString(3, comment.getDate());
			preparedStmt.setInt(4, comment.getBucketNo());

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
