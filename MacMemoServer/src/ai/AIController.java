package ai;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import org.json.simple.JSONObject;

import api.APIConstants;
import api.APIErrorCode;
import dao.BucketDao;
import utils.DBConnectionUtil;

import java.sql.*;

import vo.Bucket;

@SuppressWarnings("unchecked")
public class AIController {

	/**
	 * AI 대답하기
	 * 
	 * @return JSONObject
	 * @throws Exception
	 */

	public static JSONObject getResponse(String strNickName) throws Exception {
		JSONObject jsonObj = new JSONObject();
		try {
			jsonObj.put("replay", getAIResponse(strNickName));
		} catch (Exception e) {
			e.printStackTrace();

			jsonObj.clear();
			jsonObj.put(APIConstants.IS_VALID, false);
			jsonObj.put(APIConstants.INVALID_MSG, APIErrorCode.AI_ERROR.getErrorMsg());
			return jsonObj;
		}
		jsonObj.put(APIConstants.IS_VALID, true);
		return jsonObj;
	}

	/**
	 * AI 대답하기 로직단
	 * 
	 * @return JSONObject
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	private static String getAIResponse(String nickname) throws ClassNotFoundException, SQLException {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH");
		String createDate = sdf.format(calendar.getTime());

		int currentHour = Integer.valueOf(createDate);
		// 1.현재 시간을 확인을 한다.
		System.out.println("@@ AI reqeust nickname : " + nickname);
		if (currentHour >= 7 && currentHour < 9) {
			System.out.println("@@ 아침 인사 전문 조회");
			return selectAIScript(1);
		} else if (currentHour >= 12 && currentHour < 14) {
			System.out.println("@@ 점심 인사 전문 조회");
			return selectAIScript(2);
		} else if (currentHour >= 18 && currentHour < 20) {
			System.out.println("@@ 저녁 인사 전문 조회");
			return selectAIScript(3);
		}
		// 2. 기타인 경우 사용자가 공유한 내역이 있는지 확인한다.
		else if (nickname != null && (!nickname.equals("null") || !nickname.equals(""))) {
			int shareLength = getUserShareInformation(nickname);
			System.out.println("@@ 사용자 공유 내역 갯수 : " + shareLength);
//			if (shareLength > 0) {
//				return selectUserAIInformation(nickname);
//			} else {
				return selectAIScript(4, 5, 6);
//			}
		}
		// 3. 공유한 내역이 없는 경우, 홍보와 응원 메시지를 리턴한다.
		else {
			return selectAIScript(4, 5, 6);
		}
	}

	/**
	 * AI 스크립트 조회
	 * 
	 * @return 응답 내용
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static String selectAIScript(int category) throws SQLException, ClassNotFoundException {
		String replay = null;
		Connection con = null;
		ArrayList<String> list = new ArrayList<String>();
		String sql = "SELECT CATEGORY_CODE, CONTENT FROM AI_SCRIPT WHERE CATEGORY_CODE = " + category + ";";

		try {
			con = DBConnectionUtil.getConnection();
			java.sql.Statement st = null;
			ResultSet rs = null;
			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (st.execute(sql)) {
				rs = st.getResultSet();
			}

			int rows = 0;
			while (rs.next()) {
				list.add(rs.getString(2));
				rows++;
			}
			//System.out.println("@@ rows count : " + rows);
			Random random = new Random();
			int index = random.nextInt(rows);
			//System.out.println("@@ rows index : " + index);

			replay = list.get(index);
			System.out.println("@@ AI replay : " + replay);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
		}

		return replay;
	}

	/**
	 * AI 스크립트 조회(홍보와 응원 메시지에서 스크립트 조회)
	 * 
	 * @return 응답 내용
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static String selectAIScript(int category, int category2, int category3) throws SQLException, ClassNotFoundException {
		String replay = null;
		Connection con = null;

		ArrayList<String> list = new ArrayList<String>();
		String sql = "SELECT CATEGORY_CODE, CONTENT FROM AI_SCRIPT WHERE CATEGORY_CODE = " + category
				+ " OR CATEGORY_CODE = " + category2 + " OR CATEGORY_CODE = " + category3 + ";";

		try {
			con = DBConnectionUtil.getConnection();
			java.sql.Statement st = null;
			ResultSet rs = null;
			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (st.execute(sql)) {
				rs = st.getResultSet();
			}
			int rows = 0;
			while (rs.next()) {
				list.add(rs.getString(2));
				rows++;
			}
			//System.out.println("@@ rows count : " + rows);
			Random random = new Random();
			int index = random.nextInt(rows);
			//System.out.println("@@ rows index : " + index);

			replay = list.get(index);
			System.out.println("@@ AI replay : " + replay);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
		}

		return replay;
	}

	/**
	 * 사용자 공유 내역 갯수 반환
	 * 
	 * @param nickname
	 *            닉네임
	 * @return
	 */
	public static int getUserShareInformation(String nickname) {
		int size = 0;
		String sql = "SELECT CATEGORY_CODE, IDX FROM BUCKET WHERE NICKNAME = '" + nickname + "';";
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
			int rows = 0;
			while (rs.next()) {
				rows++;
			}
			size = rows;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return size;
	}

	/**
	 * 사용자 정보로 판단하기
	 * 
	 * @return 응답 내용
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static String selectUserAIInformation(String nickname) throws SQLException, ClassNotFoundException {
		String replay = null;
		Connection con = null;
		// 사용자의 버킷 코드별 리스트
		ArrayList<String> bucketCdList = new ArrayList<String>();
		// 사용자의 버킷 index 리스트
		ArrayList<Integer> bucketIdxList = new ArrayList<Integer>();
		ArrayList<Bucket> bucketList = new ArrayList<Bucket>();
		String sql = "SELECT CATEGORY_CODE, IDX FROM BUCKET WHERE NICKNAME = '" + nickname + "';";

		int index, num;
		Random random = new Random();
		// 1. 사용자 정보로 버킷 리스트 가져오기
		try {
			con = DBConnectionUtil.getConnection();
			java.sql.Statement st = null;
			ResultSet rs = null;
			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (st.execute(sql)) {
				rs = st.getResultSet();
			}

			int rows = 0;
			while (rs.next()) {
				bucketCdList.add(rs.getString(1));
				bucketIdxList.add(rs.getInt(2));
				rows++;
			}

			int value = random.nextInt(rows);
			System.out.println("@@ replay bucket rand count : " + value);
			index = bucketIdxList.get(value);
			System.out.println("@@ replay bucket idx : " + index);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			con.close();
		}

		// 2. 버킷 리스트에서 분류 코드가 가장 많은 것을 파악하기
		int[] codeCntList = new int[10];
		for (int i = 0; i < codeCntList.length; i++) {
			codeCntList[i] = 0;
		}
		for (int i = 0; i < bucketCdList.size(); i++) {
			int temp = Integer.valueOf(bucketCdList.get(i));
			int value = codeCntList[temp];
			codeCntList[temp] = value + 1;
		}
		int maxValue = 0;
		int maxCd = 0;
		// 가장 많이 공유한 버킷 분류 찾기
		for (int i = 0; i < codeCntList.length; i++) {
			int temp = codeCntList[i];
			if (temp > maxValue) {
				maxValue = temp;
				maxCd = i;
			}
		}
		//System.out.println("@@ 사용자의 가장 많은 카테고리 분류 : " + maxCd);
		// 버킷 내용 가져오기
		for (int i = 0; i < bucketCdList.size(); i++) {
			String cd = bucketCdList.get(i);
			int temp = Integer.valueOf(cd);
			if (temp == maxCd) {
				Bucket bucket = BucketDao.selecetBucket(bucketIdxList.get(i));
				bucketList.add(bucket);
			}
		}

		num = random.nextInt(maxCd);
		Bucket returnBucket = bucketList.get(num);

		replay = returnBucket.getContent() + "\n";
		// 3. 가장 많은 분류 코드에 따라 되묻기
		switch (maxCd) {
		case 1:// LIFE
			replay = replay + "당신의 LIFE을 위해 노력하는 군요. \n당신의 다른 이야기도 궁금한걸요? ";
			break;
		case 2:// LOVE
			replay = replay + "로맨틱한 사랑 이야기도 공유해주세요~부러워요!! ";
			break;
		case 3:// WORK
			replay = replay + "일하는 당신, 떠나라~~~";
			break;
		case 4:// EDUCATION
			replay = replay + "열심히 공부하는 당신! 멋있어요~";
			break;
		case 5:// FAMILY
			replay = replay + "가족과 함께 하는 시간 아주 소중해요!";
			break;
		case 6:// FINANCE
			replay = replay + "재테크 하는 방법도 공유해주시면 좋겠네요?ㅋㅋㅋ";
			break;
		case 7:// DEVELOP
			replay = replay + "자기계발은 쉽지않지만 꼭 그 시간들이 나중에 멋진 결과를 낼거에요~!";
			break;
		case 8:// HEALTH
			replay = replay + "건강한 몸을 가지는 것! 운동은 어떻게 하는거죠?ㅋㅋㅋㅋ";
			break;
		case 9:// ETC
			replay = replay + "그리고 무엇에 관심이 있으시나요?";
			break;
		}
		return replay;
	}

}
