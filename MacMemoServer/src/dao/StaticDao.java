package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.DBConnectionUtil;
import utils.XMLParser;
import vo.TodayCnt;

import java.sql.*;

/**
 * 통계 관리 DAO
 */
public class StaticDao {

	/**
	 * 사용자 최종방문일 기준 월별 조회
	 * 
	 * @return 사용자 최종방문일  조회 결과
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<TodayCnt> selecetMonthCnt() throws SQLException, ClassNotFoundException {
		ArrayList<TodayCnt> list = new ArrayList<TodayCnt>();

		Connection con = null;
		String sql = XMLParser.getSqlFromXML("selecetMonthCnt");

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
				String dayofWeek = rs.getNString(1);
				String version = rs.getNString(2);
				String lastDt = rs.getNString(3);

				TodayCnt today = new TodayCnt();
				today.setVersion(version);
				today.setLastDt(lastDt);
				
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
