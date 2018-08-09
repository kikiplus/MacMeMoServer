package api;

/**
 * Mobile SQL API 콘트롤러 클래스
 * 
 * @since 2017.02.17
 * @version 1.0
 */
public class SqlController {

	/**
	 * 모두 가지 조회
	 */
	public static String getBucketList(int categoryCode) {
		String BUCKET_LIST = "SELECT CATEGORY_CODE, NICKNAME, PHONE, CONTENT, IMAGE_URL, CREATE_DT, IDX FROM BUCKET WHERE CATEGORY_CODE = "
				+ categoryCode + " AND HIDDEN = 'N' ORDER BY IDX DESC LIMIT 20;";
		return BUCKET_LIST;
	}

	/**
	 * 버킷 랭킹 조회
	 */
	public static String getBucketRankList() {
		String sql = "SELECT CATEGORY_CODE, CONTENT, IDX, BEST_CNT, GOOD_CNT, SOSO_CNT FROM BUCKET_RANK ORDER BY BEST_CNT DESC, GOOD_CNT DESC, SOSO_CNT DESC;";
		return sql;
	}
}
