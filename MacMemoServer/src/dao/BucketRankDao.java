package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.DBConnectionUtil;
import utils.XMLParser;
import vo.BucketRank;

import java.sql.*;

/**
 * 버킷 DAO
 */
public class BucketRankDao {

	/**
	 * 버킷 조회(카데고리 추가)
	 * 
	 * @return 게시판 내용
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<BucketRank> selecet(String sql) throws SQLException, ClassNotFoundException {

		ArrayList<BucketRank> BucketList = new ArrayList<BucketRank>();

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
				String content = rs.getNString(2);
				int idx = rs.getInt(3);
				int bestCnt = rs.getInt(4);
				int goodCnt = rs.getInt(5);
				int sosoCnt = rs.getInt(6);

				BucketRank bucket = new BucketRank();
				bucket.setCategoryCode(categoryCode);
				bucket.setContent(content);
				bucket.setIdx(idx);
				bucket.setBestCnt(bestCnt);
				bucket.setGoodCnt(goodCnt);
				bucket.setSoSoCnt(sosoCnt);
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
	public static ArrayList<BucketRank> selecetBucketRank(String sql) throws SQLException, ClassNotFoundException {
		ArrayList<BucketRank> BucketList = new ArrayList<BucketRank>();

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
				String content = rs.getNString(2);
				int idx = rs.getInt(3);
				int bestCnt = rs.getInt(4);
				int goodCnt = rs.getInt(5);
				int sosoCnt = rs.getInt(6);

				BucketRank bucket = new BucketRank();
				bucket.setCategoryCode(categoryCode);
				bucket.setContent(content);
				bucket.setIdx(idx);
				bucket.setBestCnt(bestCnt);
				bucket.setGoodCnt(goodCnt);
				bucket.setSoSoCnt(sosoCnt);
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
	 * 사용자가 체크햇는지 여부 반환을 위해 조회
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static int selecetBucketRankUser(String sql) throws SQLException, ClassNotFoundException {
		int comment = 0;
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
				comment = rs.getInt(1);
				break;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return comment;
		} finally {
			con.close();
		}

		return comment;
	}

	/**
	 * 버킷 랭킹 글 추가
	 * 
	 * @return 게시판 글 추가 성공 여부
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static boolean insertBucketRankUser(String idx, String nickname, String comment)
			throws SQLException, ClassNotFoundException {

		Connection con = null;

		try {
			con = DBConnectionUtil.getConnection();
			String sql = XMLParser.getSqlFromXML("insertBucketRankUser");

			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
			preparedStmt.setInt(1, Integer.valueOf(idx));
			preparedStmt.setString(2, nickname);
			preparedStmt.setInt(3, Integer.valueOf(comment));

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
	 * 버킷 랭킹 글 추가
	 * 
	 * @return 게시판 글 추가 성공 여부
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static boolean insertBucketRank(String idx, String comment) throws SQLException, ClassNotFoundException {

		Connection con = null;
		String sql;
		try {
			con = DBConnectionUtil.getConnection();
			if (comment.equals("1")) {// 괜찮아요
				int count = selecetBucketRankCount("SELECT SOSO_CNT FROM BUCKET_RANK WHERE IDX = " + idx + ";");
				count++;
				sql = "UPDATE BUCKET_RANK SET SOSO_CNT = " + count + " WHERE IDX = " + idx + ";";
			} else if (comment.equals("2")) {// 좋아요
				int count = selecetBucketRankCount("SELECT GOOD_CNT FROM BUCKET_RANK WHERE IDX = " + idx + ";");
				count++;
				sql = "UPDATE BUCKET_RANK SET GOOD_CNT = " + count + " WHERE IDX = " + idx + ";";
			} else {// 최고에요
				int count = selecetBucketRankCount("SELECT BEST_CNT FROM BUCKET_RANK WHERE IDX = " + idx + ";");
				count++;
				sql = "UPDATE BUCKET_RANK SET BEST_CNT = " + count + " WHERE IDX = " + idx + ";";
			}

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
	 * 버킷 랭킹 조회
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static int selecetBucketRankCount(String sql) throws SQLException, ClassNotFoundException {
		int count = 0;
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
				count = rs.getInt(1);
				break;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return count;
		} finally {
			con.close();
		}

		return count;
	}
}
