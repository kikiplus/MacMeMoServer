package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.DBConnectionUtil;
import utils.XMLParser;
import vo.Bucket;

import java.sql.*;

/**
 * 버킷 DAO
 */
public class BucketDao {

	/**
	 * 버킷 조회(카데고리 추가)
	 * 
	 * @return 게시판 내용
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<Bucket> selecetBucketCategory(String sql) throws SQLException, ClassNotFoundException {

		ArrayList<Bucket> BucketList = new ArrayList<Bucket>();

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
				int categoryCode = rs.getInt(1);
				String nickName = rs.getNString(2);
				String phone = rs.getNString(3);
				String content = rs.getNString(4);
				String imageUrl = rs.getNString(5);
				String date = rs.getNString(6);
				int idx = rs.getInt(7);
				String categoryname = rs.getNString(8);
				String hidden = rs.getNString(9);
				Bucket bucket = new Bucket();
				bucket.setCategoryCode(categoryCode);
				bucket.setNickName(nickName);
				bucket.setPhone(phone);
				bucket.setContent(content);
				bucket.setImageUrl(imageUrl);
				bucket.setDate(date);
				bucket.setIdx(idx);
				bucket.setCategoryName(categoryname);
				bucket.setHidden(hidden);
				BucketList.add(bucket);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
		}

		return BucketList;
	}

	/**
	 * 버킷 조회(모바일단)
	 * 
	 * @return 게시판 내용
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<Bucket> selecetBucket(String sql) throws SQLException, ClassNotFoundException {
		ArrayList<Bucket> BucketList = new ArrayList<Bucket>();

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
				int categoryCode = rs.getInt(1);
				String nickName = rs.getNString(2);
				String phone = rs.getNString(3);
				String content = rs.getNString(4);
				String imageUrl = rs.getNString(5);
				String date = rs.getNString(6);
				int idx = rs.getInt(7);
				Bucket bucket = new Bucket();
				bucket.setCategoryCode(categoryCode);
				bucket.setNickName(nickName);
				bucket.setPhone(phone);
				bucket.setContent(content);
				bucket.setImageUrl(imageUrl);
				bucket.setDate(date);
				bucket.setIdx(idx);
				BucketList.add(bucket);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
		}

		return BucketList;
	}

	/**
	 * 버킷 조회
	 * 
	 * @return 게시판 내용
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Bucket selecetBucket(int reqIdx) throws SQLException, ClassNotFoundException {

		Bucket bucket = new Bucket();

		Connection con = null;
		String sql = "SELECT CATEGORY_CODE, NICKNAME, PHONE, CONTENT, IMAGE_URL, CREATE_DT, IDX FROM BUCKET WHERE IDX =  "
				+ reqIdx + ";";

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
				String nickName = rs.getNString(2);
				String phone = rs.getNString(3);
				String content = rs.getNString(4);
				String imageUrl = rs.getNString(5);
				String date = rs.getNString(6);
				int idx = rs.getInt(7);
				bucket.setCategoryCode(categoryCode);
				bucket.setNickName(nickName);
				bucket.setPhone(phone);
				bucket.setContent(content);
				bucket.setImageUrl(imageUrl);
				bucket.setDate(date);
				bucket.setIdx(idx);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
		}

		return bucket;
	}

	/**
	 * 버킷 조회
	 * 
	 * @return 게시판 내용
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Bucket selectBucket(String reqContent) throws SQLException, ClassNotFoundException {

		Bucket bucket = new Bucket();

		Connection con = null;
		String sql = "SELECT CATEGORY_CODE, NICKNAME, PHONE, CONTENT, IMAGE_URL, CREATE_DT, IDX FROM BUCKET WHERE CONTENT =  '"
				+ reqContent + "';";

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
				String nickName = rs.getNString(2);
				String phone = rs.getNString(3);
				String content = rs.getNString(4);
				String imageUrl = rs.getNString(5);
				String date = rs.getNString(6);
				int idx = rs.getInt(7);
				bucket.setCategoryCode(categoryCode);
				bucket.setNickName(nickName);
				bucket.setPhone(phone);
				bucket.setContent(content);
				bucket.setImageUrl(imageUrl);
				bucket.setDate(date);
				bucket.setIdx(idx);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
		}

		return bucket;
	}

	/**
	 * 버킷 글 추가
	 * 
	 * @return 게시판 글 추가 성공 여부
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static boolean insertBucket(Bucket bucket) throws SQLException, ClassNotFoundException {

		Connection con = null;

		try {
			con = DBConnectionUtil.getConnection();
			String sql = XMLParser.getSqlFromXML("insertBucket");

			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
			preparedStmt.setInt(1, bucket.getCategoryCode());
			preparedStmt.setString(2, bucket.getNickName());
			preparedStmt.setString(3, bucket.getPhone());
			preparedStmt.setString(4, bucket.getContent());
			preparedStmt.setString(5, bucket.getImageUrl());
			preparedStmt.setString(6, bucket.getDate());
			preparedStmt.setString(7, bucket.getIsHidden());

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
	 * 버킷 글 수정
	 * 
	 * @param board
	 * @return 게시판 글 수정 성공 여부
	 * @throws SQLException
	 */
	public static boolean modifyBucket(Bucket board) throws SQLException {
		Connection con = null;

		try {
			con = DBConnectionUtil.getConnection();
			String sql = XMLParser.getSqlFromXML("modifyBucket");

			System.out.println(sql);

			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
			preparedStmt.setString(1, board.getDate());
			preparedStmt.setString(2, board.getContent());
			preparedStmt.setInt(3, board.getIdx());
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
	 * 버킷 글 수정(카데고리 코드)
	 * 
	 * @param categoryCode
	 * @return 게시판 글 수정 성공 여부
	 * @throws SQLException
	 */
	public static boolean updateBucketCateogry(int categoryCode, int idx) throws SQLException {
		Connection con = null;

		try {
			con = DBConnectionUtil.getConnection();
			String sql = XMLParser.getSqlFromXML("updateBucketHidden");

			System.out.println(sql);

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
	 * 버킷 글 수정(슴김 코드)
	 * 
	 * @param categoryCode
	 * @return 게시판 글 수정 성공 여부
	 * @throws SQLException
	 */
	public static boolean updateBucketHidden(String hiddenCode, int idx) throws SQLException {
		Connection con = null;

		try {
			con = DBConnectionUtil.getConnection();
			String sql = XMLParser.getSqlFromXML("updateBucketHidden");

			System.out.println(sql);

			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
			preparedStmt.setString(1, hiddenCode);
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
	 * 버킷 글 삭제
	 * 
	 * @param board
	 * @return 게시판 글 삭제 성공 여부
	 * @throws SQLException
	 */
	public static boolean deleteBucket(int idx) throws SQLException {
		Connection con = null;
		try {
			con = DBConnectionUtil.getConnection();
			String sql = XMLParser.getSqlFromXML("deleteBucket");

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

	/**
	 * 버킷 조회(폰번호로 조회하기)
	 * 
	 * @return 게시판 내용
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Bucket selecetUserBucket(String phone) throws SQLException, ClassNotFoundException {

		Bucket bucket = new Bucket();

		Connection con = null;
		String sql = "SELECT  CATEGORY_CODE, CONTENT FROM BUCKET WHERE PHONE =  '" + phone + "';";

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
				bucket.setCategoryCode(categoryCode);
				bucket.setContent(content);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
		}

		return bucket;
	}

	/**
	 * 버킷 조회
	 * 
	 * @return 게시판 내용
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Bucket selectBucket(int idx) throws SQLException, ClassNotFoundException {

		Bucket bucket = new Bucket();

		Connection con = null;
		String sql = "SELECT CATEGORY_CODE, NICKNAME, PHONE, CONTENT, IMAGE_URL, CREATE_DT FROM BUCKET WHERE IDX = "
				+ idx + ";";

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
				String nickName = rs.getNString(2);
				String phone = rs.getNString(3);
				String content = rs.getNString(4);
				String imageUrl = rs.getNString(5);
				String date = rs.getNString(6);
				bucket.setCategoryCode(categoryCode);
				bucket.setNickName(nickName);
				bucket.setPhone(phone);
				bucket.setContent(content);
				bucket.setImageUrl(imageUrl);
				bucket.setDate(date);
				bucket.setIdx(idx);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
		}

		return bucket;
	}
}
