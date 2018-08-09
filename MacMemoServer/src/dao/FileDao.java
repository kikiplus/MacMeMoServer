package dao;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.DBConnectionUtil;
import utils.XMLParser;
import vo.Bucket;

import java.sql.*;

/**
 * 모바일 사용자 계정관리 DAO
 */
public class FileDao {

	/**
	 * 이미지 정보 업데이트(모바일 단)
	 * 
	 * @return 이미지 정보 업데이트 성공 여부(true - 있음, false - 없음)
	 * @throws SQLException
	 */
	public static boolean updateBucketImage(Bucket bucket) throws SQLException {
		Connection con = null;

		try {
			con = DBConnectionUtil.getConnection();
			String sql = XMLParser.getSqlFromXML("updateBucketImage");

			System.out.println(sql);

			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
			preparedStmt.setString(1, bucket.getImageUrl());
			preparedStmt.setInt(2, bucket.getIdx());
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
	 * 이미지 정보 다운로드(모바일 단)
	 * 
	 * @return 이미지 정보 업데이트 성공 여부(true - 있음, false - 없음)
	 * @throws SQLException
	 */
	public static File downloadBucketImage(int bucketNo) throws SQLException {

		Connection con = null;
		String sql = "SELECT IMAGE_URL FROM BUCKET WHERE IDX= " + bucketNo + ";";

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
				String imageUrl = rs.getNString(1);
				if (imageUrl.equals("N")) {
				} else {
					String folderName = XMLParser.getXMLObject("fileUploadPath");
					String filePath = folderName + "/" + imageUrl;
					File file = new File(filePath);
					return file;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			con.close();
		}
		File file = null;
		return file;
	}

	/**
	 * DB 정보 업데이트(모바일 단)
	 * 
	 * @return 이미지 정보 업데이트 성공 여부(true - 있음, false - 없음)
	 * @throws SQLException
	 */
	public static boolean updateDB(String nickname, String path, String date) throws SQLException {
		Connection con = null;

		try {
			con = DBConnectionUtil.getConnection();
			String sql = XMLParser.getSqlFromXML("insertDBFile");

			System.out.println(sql);

			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
			preparedStmt.setString(1, nickname);
			preparedStmt.setString(2, path);
			preparedStmt.setString(3, date);
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
