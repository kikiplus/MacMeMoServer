package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.DBConnectionUtil;
import utils.XMLParser;
import vo.Chat;

import java.sql.*;

/**
 * Chat DAO
 */
public class ChatDao {

	/**
	 * 채팅방 입장
	 * 
	 * @return 게시판 글 추가 성공 여부
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static boolean enterChat(Chat chat) throws SQLException, ClassNotFoundException {

		Connection con = null;

		try {
			con = DBConnectionUtil.getConnection();
			String sql = XMLParser.getSqlFromXML("enterChatRoom");

			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
			preparedStmt.setString(1, chat.getIdx());
			preparedStmt.setString(2, chat.getNickName());
			preparedStmt.setString(3, chat.getDate());
			preparedStmt.setString(4, "E");

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
	 * 채팅방 퇴장
	 * 
	 * @param board
	 * @return 게시판 글 수정 성공 여부
	 * @throws SQLException
	 */
	public static boolean leaveChat(Chat chat) throws SQLException {
		Connection con = null;

		try {
			con = DBConnectionUtil.getConnection();
			String sql = XMLParser.getSqlFromXML("leaveChatRoom");

			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
			preparedStmt.setString(1, chat.getNickName());
			preparedStmt.setString(2, chat.getDate());
			preparedStmt.setString(3, "L");
			preparedStmt.setString(4, chat.getIdx());
			preparedStmt.setString(5, chat.getNickName());
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
	 * 채팅방 내용 입력
	 * 
	 * @param board
	 * @return 게시판 글 수정 성공 여부
	 * @throws SQLException
	 */
	public static boolean sendChat(Chat chat) throws SQLException {
		Connection con = null;

		try {
			con = DBConnectionUtil.getConnection();
			String sql = XMLParser.getSqlFromXML("insertChatContent");

			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
			preparedStmt.setString(1, chat.getIdx());
			preparedStmt.setString(2, chat.getNickName());
			preparedStmt.setString(3, chat.getDate());
			preparedStmt.setString(4, chat.getContent());
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
	 * 채팅 내용 조회(모바일단)
	 *
	 * @return 게시판 내용
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<Chat> selectChat(String sql) throws SQLException, ClassNotFoundException {
		ArrayList<Chat> chatList = new ArrayList<Chat>();

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
				String date = rs.getNString(2);
				String content = rs.getNString(3);
				int seq = rs.getInt(4);

				Chat chat = new Chat();
				chat.setNickName(nickName);
				chat.setContent(content);
				chat.setDate(date);
				chat.setSeq(seq);
				chatList.add(chat);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
		}

		return chatList;
	}
}
