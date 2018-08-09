package api;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dao.BucketDao;
import dao.BucketRankDao;
import dao.CategoryBucketDao;
import dao.CommentDao;
import dao.FileDao;
import dao.MobileUserDao;
import dao.UpdateAppDao;
import dao.VersionDao;
import utils.XMLParser;
import vo.Bucket;
import vo.BucketRank;
import vo.CategoryBucket;
import vo.Comment;
import vo.MobileUser;
import vo.UpdateApp;
import vo.Version;

/**
 * 모바일 API 콘트롤러 클래스
 * 
 * @since 2015.12.19
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public class MobileAPIController {

	/**
	 * GCM 프로젝트 ID
	 * 
	 * @return JSONObject
	 * @throws Exception
	 */
	public static JSONObject gcmProjectId() throws Exception {
		JSONObject jsonObj = new JSONObject();
		try {
			// GCM Project Id
			jsonObj.put("gcmProjectId", XMLParser.getXMLObject("gcmProjectId"));
		} catch (Exception e) {
			e.printStackTrace();

			jsonObj.clear();
			jsonObj.put(APIConstants.IS_VALID, false);
			jsonObj.put(APIConstants.INVALID_MSG, APIErrorCode.API_COMMON_ERROR.getErrorMsg());
			return jsonObj;
		}
		jsonObj.put(APIConstants.IS_VALID, true);
		return jsonObj;
	}

	/**
	 * 버전 정보
	 * 
	 * @return JSONObject
	 * @throws Exception
	 */
	public static JSONObject getVersion() throws Exception {
		JSONObject jsonObj = new JSONObject();
		try {
			Version version = VersionDao.getLastestVersion();
			jsonObj.put("versionCode", version.getVersionCode());
			jsonObj.put("versionName", version.getVersionName());
			jsonObj.put("forceYN", version.getForceYN());
		} catch (Exception e) {
			e.printStackTrace();

			jsonObj.clear();
			jsonObj.put(APIConstants.IS_VALID, false);
			jsonObj.put(APIConstants.INVALID_MSG, APIErrorCode.API_COMMON_ERROR.getErrorMsg());
			return jsonObj;
		}
		jsonObj.put(APIConstants.IS_VALID, true);
		return jsonObj;
	}

	/**
	 * 버전 정보
	 * 
	 * @return JSONObject
	 * @throws Exception
	 */
	public static JSONObject getVersion(String version) throws Exception {
		JSONObject jsonObj = new JSONObject();
		try {
			String sql = "SELECT * FROM VERSION WHERE VERSION_NAME = '" + version + "';";
			Version versionVO = VersionDao.selectCurrentVersion(sql);
			jsonObj.put("versionCode", versionVO.getVersionCode());
			jsonObj.put("versionName", versionVO.getVersionName());
			jsonObj.put("forceYN", versionVO.getForceYN());
		} catch (Exception e) {
			e.printStackTrace();

			jsonObj.clear();
			jsonObj.put(APIConstants.IS_VALID, false);
			jsonObj.put(APIConstants.INVALID_MSG, APIErrorCode.API_COMMON_ERROR.getErrorMsg());
			return jsonObj;
		}
		jsonObj.put(APIConstants.IS_VALID, true);
		return jsonObj;
	}

	/**
	 * 업데이트 정보
	 * 
	 * @return JSONObject
	 * @throws Exception
	 */
	public static JSONObject getUpdateApp() throws Exception {
		JSONObject jsonObj = new JSONObject();
		try {

			String sql = XMLParser.getSqlFromXML("selectMobileUpdateApp");
			ArrayList<UpdateApp> updateList = UpdateAppDao.selecetUpdateApp(sql);

			JSONArray jsonArr = new JSONArray();
			for (int i = 0; i < updateList.size(); i++) {
				JSONObject obj = new JSONObject();
				obj.put("versionCode", updateList.get(i).getVersionCode());
				obj.put("updateContent", updateList.get(i).getContent());
				jsonArr.add(obj);
			}
			jsonObj.put("updateVOList", jsonArr);

		} catch (Exception e) {
			e.printStackTrace();

			jsonObj.clear();
			jsonObj.put(APIConstants.IS_VALID, false);
			jsonObj.put(APIConstants.INVALID_MSG, APIErrorCode.API_COMMON_ERROR.getErrorMsg());
			return jsonObj;
		}
		jsonObj.put(APIConstants.IS_VALID, true);
		return jsonObj;
	}

	/**
	 * 카데고리 정보
	 * 
	 * @return JSONObject
	 * @throws Exception
	 */
	public static JSONObject getCategory() throws Exception {
		JSONObject jsonObj = new JSONObject();
		try {
			String sql = XMLParser.getSqlFromXML("selectMobileCategoryBucket");
			ArrayList<CategoryBucket> List = CategoryBucketDao.selectCategoryBucket(sql);

			JSONArray jsonArr = new JSONArray();
			for (int i = 0; i < List.size(); i++) {
				JSONObject obj = new JSONObject();
				obj.put("categoryCode", List.get(i).getCategoryCode());
				obj.put("categoryName", List.get(i).getCategoryName());
				jsonArr.add(obj);
			}
			jsonObj.put("categoryVOList", jsonArr);

		} catch (Exception e) {
			e.printStackTrace();

			jsonObj.clear();
			jsonObj.put(APIConstants.IS_VALID, false);
			jsonObj.put(APIConstants.INVALID_MSG, APIErrorCode.API_COMMON_ERROR.getErrorMsg());
			return jsonObj;
		}
		jsonObj.put(APIConstants.IS_VALID, true);
		return jsonObj;
	}

	/**
	 * 분류코드대로 버킷 정보 반환 하는 메소드
	 * 
	 * @param categoryCode
	 *            카데고리 분류코드
	 * @return JSONObject
	 * @throws Exception
	 */
	public static JSONObject getBucketList(String sql) throws Exception {
		JSONObject jsonObj = new JSONObject();
		try {
			ArrayList<Bucket> List = BucketDao.selecetBucket(sql);

			JSONArray jsonArr = new JSONArray();
			for (int i = 0; i < List.size(); i++) {
				JSONObject obj = new JSONObject();
				obj.put("categoryCode", List.get(i).getCategoryCode());
				obj.put("nickName", List.get(i).getNickName());
				obj.put("phone", "");
				obj.put("content", List.get(i).getContent());
				obj.put("imageUrl", List.get(i).getImageUrl());
				obj.put("createDt", List.get(i).getDate());
				obj.put("idx", List.get(i).getIdx());
				jsonArr.add(obj);
			}
			jsonObj.put("bucketList", jsonArr);

		} catch (Exception e) {
			e.printStackTrace();

			jsonObj.clear();
			jsonObj.put(APIConstants.IS_VALID, false);
			jsonObj.put(APIConstants.INVALID_MSG, APIErrorCode.API_COMMON_ERROR.getErrorMsg());
			return jsonObj;
		}
		jsonObj.put(APIConstants.IS_VALID, true);
		return jsonObj;
	}

	/**
	 * 버킷 상세 정보
	 * 
	 * @return JSONObject
	 * @throws Exception
	 */
	public static JSONObject getBucketDetails(int idx) throws Exception {
		JSONObject jsonObj = new JSONObject();
		try {

			Bucket bucket = BucketDao.selecetBucket(idx);
			JSONObject obj = new JSONObject();
			obj.put("categoryCode", bucket.getCategoryCode());
			obj.put("nickName", bucket.getNickName());
			obj.put("phone", bucket.getPhone());
			obj.put("content", bucket.getContent());
			obj.put("imageUrl", bucket.getImageUrl());
			obj.put("createDt", bucket.getDate());
			obj.put("idx", bucket.getIdx());

			jsonObj.put("bucketVO", obj);

			ArrayList<Comment> commentList = CommentDao.selecetComment(
					"SELECT NICKNAME, CONTENT, CREATE_DT, IDX , BUCKET_NO FROM COMMENT WHERE BUCKET_NO = " + idx + ";");

			JSONArray jsonArr = new JSONArray();
			for (int i = 0; i < commentList.size(); i++) {
				obj = new JSONObject();
				obj.put("nickName", commentList.get(i).getNickName());
				obj.put("content", commentList.get(i).getContent());
				obj.put("bucketNo", commentList.get(i).getBucketNo());
				obj.put("createDt", commentList.get(i).getDate());
				obj.put("idx", commentList.get(i).getIdx());
				jsonArr.add(obj);
			}
			jsonObj.put("CommentVOList", jsonArr);
		} catch (Exception e) {
			e.printStackTrace();

			jsonObj.clear();
			jsonObj.put(APIConstants.IS_VALID, false);
			jsonObj.put(APIConstants.INVALID_MSG, APIErrorCode.API_COMMON_ERROR.getErrorMsg());
			return jsonObj;
		}
		jsonObj.put(APIConstants.IS_VALID, true);
		return jsonObj;
	}

	/**
	 * 버킷 추가 API
	 * 
	 * @return JSONObject
	 * @throws Exception
	 */
	public static JSONObject insertBucket(Bucket bucket) throws Exception {
		JSONObject jsonObj = new JSONObject();
		try {

			boolean isResult = BucketDao.insertBucket(bucket);
			jsonObj.put("result", isResult);
			Bucket Bucket = BucketDao.selectBucket(bucket.getContent());
			jsonObj.put("idx", Bucket.getIdx());
		} catch (Exception e) {
			e.printStackTrace();

			jsonObj.clear();
			jsonObj.put(APIConstants.IS_VALID, false);
			jsonObj.put(APIConstants.INVALID_MSG, APIErrorCode.API_COMMON_ERROR.getErrorMsg());
			return jsonObj;
		}
		jsonObj.put(APIConstants.IS_VALID, true);
		return jsonObj;
	}

	/**
	 * 모바일단 사용자 추가 API
	 * 
	 * @return JSONObject
	 * @throws Exception
	 */
	public static JSONObject insertMobileUser(MobileUser user) throws Exception {
		JSONObject jsonObj = new JSONObject();
		try {
			String nickName = user.getUserNickName();
			if (nickName == null || nickName.equals("null") || nickName.equals("")) {
				jsonObj.clear();
				jsonObj.put(APIConstants.IS_VALID, false);
				jsonObj.put(APIConstants.INVALID_MSG, APIErrorCode.API_COMMON_ERROR.getErrorMsg());
				return jsonObj;
			}
			boolean isResult = MobileUserDao.insertUser(user);
			jsonObj.put("result", isResult);
		} catch (Exception e) {
			e.printStackTrace();

			jsonObj.clear();
			jsonObj.put(APIConstants.IS_VALID, false);
			jsonObj.put(APIConstants.INVALID_MSG, APIErrorCode.API_COMMON_ERROR.getErrorMsg());
			return jsonObj;
		}
		jsonObj.put(APIConstants.IS_VALID, true);
		return jsonObj;
	}

	/**
	 * 모바일단 이미지 업로드 API
	 * 
	 * @return JSONObject
	 * @throws Exception
	 */
	public static JSONObject uploadImageFile(Bucket bucket) throws Exception {
		JSONObject jsonObj = new JSONObject();
		try {

			boolean isResult = FileDao.updateBucketImage(bucket);
			jsonObj.put("result", isResult);
			jsonObj.put("imageUrl", bucket.getImageUrl());
		} catch (Exception e) {
			e.printStackTrace();

			jsonObj.clear();
			jsonObj.put(APIConstants.IS_VALID, false);
			jsonObj.put(APIConstants.INVALID_MSG, APIErrorCode.API_COMMON_ERROR.getErrorMsg());
			return jsonObj;
		}
		jsonObj.put(APIConstants.IS_VALID, true);
		return jsonObj;
	}

	/**
	 * 모바일단 이미지 다운로드 API
	 * 
	 * @return JSONObject
	 * @throws Exception
	 */
	public static File downloadImageFile(int bucketNo) throws Exception {
		return FileDao.downloadBucketImage(bucketNo);
	}

	/**
	 * 모바일단 DB 업로드 API
	 * 
	 * @return JSONObject
	 * @throws Exception
	 */
	public static JSONObject uploadDBFile(String nickname, String path, String date) throws Exception {
		JSONObject jsonObj = new JSONObject();
		try {

			boolean isResult = FileDao.updateDB(nickname, path, date);
			jsonObj.put("result", isResult);
		} catch (Exception e) {
			e.printStackTrace();

			jsonObj.clear();
			jsonObj.put(APIConstants.IS_VALID, false);
			jsonObj.put(APIConstants.INVALID_MSG, APIErrorCode.API_COMMON_ERROR.getErrorMsg());
			return jsonObj;
		}
		jsonObj.put(APIConstants.IS_VALID, true);
		return jsonObj;
	}

	/**
	 * 댓글 정보 반환
	 * 
	 * @return JSONObject
	 * @throws Exception
	 */
	public static JSONObject getCommentList(int idx) throws Exception {
		JSONObject jsonObj = new JSONObject();
		try {
			ArrayList<Comment> commentList = CommentDao.selecetComment(
					"SELECT NICKNAME, CONTENT, CREATE_DT, IDX, BUCKET_NO FROM COMMENT WHERE BUCKET_IDX =" + idx + ";");

			JSONArray jsonArr = new JSONArray();
			for (int i = 0; i < commentList.size(); i++) {
				JSONObject obj = new JSONObject();
				obj.put("comment", commentList.get(i).getContent());
				obj.put("date", commentList.get(i).getDate());
				obj.put("nickname", commentList.get(i).getNickName());
				jsonArr.add(obj);
			}
			jsonObj.put("commentVOList", jsonArr);

		} catch (Exception e) {
			e.printStackTrace();

			jsonObj.clear();
			jsonObj.put(APIConstants.IS_VALID, false);
			jsonObj.put(APIConstants.INVALID_MSG, APIErrorCode.API_COMMON_ERROR.getErrorMsg());
			return jsonObj;
		}
		jsonObj.put(APIConstants.IS_VALID, true);
		return jsonObj;
	}

	/**
	 * 버킷 댓글 추가 API
	 * 
	 * @return JSONObject
	 * @throws Exception
	 */
	public static JSONObject insertComment(Comment comment) throws Exception {
		JSONObject jsonObj = new JSONObject();
		try {

			boolean isResult = CommentDao.insertComment(comment);
			jsonObj.put("result", isResult);
		} catch (Exception e) {
			e.printStackTrace();

			jsonObj.clear();
			jsonObj.put(APIConstants.IS_VALID, false);
			jsonObj.put(APIConstants.INVALID_MSG, APIErrorCode.API_COMMON_ERROR.getErrorMsg());
			return jsonObj;
		}
		jsonObj.put(APIConstants.IS_VALID, true);
		return jsonObj;
	}

	/**
	 * 버킷 랭킹 반환 하는 메소드
	 * 
	 * @param pageNum
	 *            페이지 번호
	 * @return JSONObject
	 * @throws Exception
	 */
	public static JSONObject getBucketRankList(String sql, int pageNum, String strNickName) throws Exception {
		JSONObject jsonObj = new JSONObject();
		try {

			ArrayList<BucketRank> List = BucketRankDao.selecetBucketRank(sql);

			JSONArray jsonArr = new JSONArray();

			int startIndex = 0;	
			int maxIndex = 20;
			if (pageNum > 1) {
				startIndex = 20 * (pageNum - 1);
				if (List.size() - startIndex > 20) {
					maxIndex = startIndex + 20;
				} else {
					maxIndex = List.size();
				}
			}

			for (int i = startIndex; i < maxIndex; i++) {
				JSONObject obj = new JSONObject();
				obj.put("categoryCode", List.get(i).getCategoryCode());
				obj.put("content", List.get(i).getContent());
				obj.put("idx", List.get(i).getIdx());

				String subSql = "SELECT COMMENT FROM BUCKET_RANK_USER WHERE BUCKET_RANK_IDX =  " + List.get(i).getIdx()
						+ " AND NICKNAME = '" + strNickName + "'";
				int comment = BucketRankDao.selecetBucketRankUser(subSql);
				obj.put("bestCnt", List.get(i).getBestCnt());
				obj.put("goodCnt", List.get(i).getGoodCnt());
				obj.put("ssoCnt", List.get(i).getSoSoCnt());
				obj.put("comment", comment);

				jsonArr.add(obj);
			}

			jsonObj.put("bucketList", jsonArr);

		} catch (Exception e) {
			e.printStackTrace();

			jsonObj.clear();
			jsonObj.put(APIConstants.IS_VALID, false);
			jsonObj.put(APIConstants.INVALID_MSG, APIErrorCode.API_COMMON_ERROR.getErrorMsg());
			return jsonObj;
		}
		jsonObj.put(APIConstants.IS_VALID, true);
		return jsonObj;
	}

	/**
	 * 버킷 랭킹 반환 하는 메소드
	 * 
	 * @param pageNum
	 *            페이지 번호
	 * @return JSONObject
	 * @throws Exception
	 */
	public static JSONObject getBucketRankUserList(String sql, int pageNum) throws Exception {
		JSONObject jsonObj = new JSONObject();
		try {
			ArrayList<BucketRank> List = BucketRankDao.selecetBucketRank(sql);

			JSONArray jsonArr = new JSONArray();

			int startIndex = 0;
			int maxIndex = 20;
			if (pageNum > 1) {
				startIndex = 20 * (pageNum - 1);
				if (List.size() - startIndex > 20) {
					maxIndex = startIndex + 20;
				} else {
					maxIndex = List.size();
				}
			}

			for (int i = startIndex; i < maxIndex; i++) {
				JSONObject obj = new JSONObject();
				obj.put("categoryCode", List.get(i).getCategoryCode());
				obj.put("content", List.get(i).getContent());
				obj.put("idx", List.get(i).getIdx());
				obj.put("bestCnt", List.get(i).getBestCnt());
				obj.put("goodCnt", List.get(i).getGoodCnt());
				obj.put("ssoCnt", List.get(i).getSoSoCnt());
				jsonArr.add(obj);
			}
			jsonObj.put("bucketList", jsonArr);

		} catch (Exception e) {
			e.printStackTrace();

			jsonObj.clear();
			jsonObj.put(APIConstants.IS_VALID, false);
			jsonObj.put(APIConstants.INVALID_MSG, APIErrorCode.API_COMMON_ERROR.getErrorMsg());
			return jsonObj;
		}
		jsonObj.put(APIConstants.IS_VALID, true);
		return jsonObj;
	}

	/**
	 * 버킷 랭킹 추가 API
	 * 
	 * @return JSONObject
	 * @throws Exception
	 */
	public static JSONObject insertBucketRank(String strIdx, String strNickName, String strComment) throws Exception {
		JSONObject jsonObj = new JSONObject();
		try {

			boolean isResult = BucketRankDao.insertBucketRankUser(strIdx, strNickName, strComment);
			if (isResult) {
				isResult = BucketRankDao.insertBucketRank(strIdx, strComment);
			}
			jsonObj.put("result", isResult);

		} catch (Exception e) {
			e.printStackTrace();

			jsonObj.clear();
			jsonObj.put(APIConstants.IS_VALID, false);
			jsonObj.put(APIConstants.INVALID_MSG, APIErrorCode.API_COMMON_ERROR.getErrorMsg());
			return jsonObj;
		}
		jsonObj.put(APIConstants.IS_VALID, true);
		return jsonObj;
	}
	
	/**
	 * 모바일단 API 내용 오류 응답 반환
	 * 
	 * @return JSONObject
	 * @throws Exception
	 */
	public static JSONObject getJSONError() throws Exception {

		JSONObject jsonObj = new JSONObject();
		try {
			jsonObj.put(APIConstants.IS_VALID, false);
			jsonObj.put(APIConstants.INVALID_MSG, APIErrorCode.API_DATA_ERROR.getErrorMsg());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObj;
	}


}
