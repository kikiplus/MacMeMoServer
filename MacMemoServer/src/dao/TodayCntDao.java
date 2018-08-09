package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import utils.DBConnectionUtil;
import utils.XMLParser;
import vo.TodayCnt;

import java.sql.*;

/**
 * 모바일 사용자 방문 카운트 관리 DAO
 */
public class TodayCntDao {

	/**
	 * 오늘의 날짜별 사용자 로그인 수 확인
	 * 
	 * @throws SQLException
	 */
	public static boolean insertUserLogin() throws SQLException {
		Connection con = null;
		try {
			con = DBConnectionUtil.getConnection();

			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String currentTime = sdf.format(calendar.getTime());

			int cnt = -1;
			try {
				// 오늘 날짜의 조회수 가져오기
				cnt = getCount(currentTime);
//				System.out.println("@@ 오늘날짜  조회수  :" + cnt);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			if (cnt == -1) {
				insertCount(1);
//				System.out.println("@@ 첫 손님임");
			} else {
				cnt++;
				updateCount(cnt);
//				System.out.println("@@ 추가  조회수  :" + cnt);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			con.close();
		}

		return true;
	}

	/**
	 * 조회수 추가
	 * 
	 * @throws SQLException
	 */
	public static boolean insertCount(int num) throws SQLException {
		Connection con = null;
		try {
			con = DBConnectionUtil.getConnection();

			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String currentTime = sdf.format(calendar.getTime());

			String sql = "INSERT TODAY_CNT (DATE, IDX)" + "Values (?, ?)";
			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
			preparedStmt.setString(1, currentTime);
			preparedStmt.setInt(2, num);
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
	 * 조회수 업데이트
	 * 
	 * @throws SQLException
	 */
	public static boolean updateCount(int num) throws SQLException {
		Connection con = null;
		try {
			con = DBConnectionUtil.getConnection();

			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String currentTime = sdf.format(calendar.getTime());

			String sql = "UPDATE TODAY_CNT SET IDX=" + num + " WHERE DATE='" + currentTime + "';";

			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(sql);
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
	 * 조회수 가져오기
	 * 
	 * @return 조회 결과
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static int getCount(String currentDate) throws SQLException, ClassNotFoundException {
		Connection con = null;
		String sql = "SELECT IDX FROM TODAY_CNT WHERE DATE =  '" + currentDate + "';";
		int resultCnt = -1;

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
				resultCnt = rs.getInt(1);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return resultCnt;
	}

	/**
	 * 사용자 조회
	 * 
	 * @return 사용자 조회 결과
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<TodayCnt> selecetTodayCnt() throws SQLException, ClassNotFoundException {
		ArrayList<TodayCnt> list = new ArrayList<TodayCnt>();

		Connection con = null;
		String sql = XMLParser.getSqlFromXML("selectTodayCnt");

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
				int dayofWeek = rs.getInt(1);
				String date = rs.getNString(2);
				int cnt = rs.getInt(3);

				TodayCnt today = new TodayCnt();
				today.setDay(dayofWeek);
				today.setDate(date);
				today.setTodayCnt(cnt);
				list.add(today);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
		}

		return list;
	}
}
