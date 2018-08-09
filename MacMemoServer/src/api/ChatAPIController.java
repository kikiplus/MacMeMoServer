package api;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dao.ChatDao;
import vo.Chat;

/**
 * Chat API 콘트롤러 클래스
 * 
 * @since 2015.12.19
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public class ChatAPIController {

	/**
	 * 채팅방 입장
	 * 
	 * @return JSONObject
	 * @throws Exception
	 */
	public static JSONObject enterChatRoom(Chat chat) throws Exception {
		JSONObject jsonObj = new JSONObject();
		try {
			boolean isResult = ChatDao.enterChat(chat);
			jsonObj.put(APIConstants.IS_VALID, isResult);

		} catch (Exception e) {
			e.printStackTrace();

			jsonObj.clear();
			jsonObj.put(APIConstants.IS_VALID, false);
			jsonObj.put(APIConstants.INVALID_MSG, APIErrorCode.CHAT_ERROR.getErrorMsg());
			return jsonObj;
		}

		return jsonObj;
	}

	/**
	 * 채팅방 퇴장
	 * 
	 * @return JSONObject
	 * @throws Exception
	 */
	public static JSONObject leaveChatRoom(Chat chat) throws Exception {
		JSONObject jsonObj = new JSONObject();
		try {

			boolean isResult = ChatDao.leaveChat(chat);
			jsonObj.put(APIConstants.IS_VALID, isResult);

		} catch (Exception e) {
			e.printStackTrace();

			jsonObj.clear();
			jsonObj.put(APIConstants.IS_VALID, false);
			jsonObj.put(APIConstants.INVALID_MSG, APIErrorCode.CHAT_ERROR.getErrorMsg());
			return jsonObj;
		}
		return jsonObj;
	}

	/**
	 * 채팅방 입력
	 * 
	 * @return JSONObject
	 * @throws Exception
	 */
	public static JSONObject sendChatRoom(Chat chat) throws Exception {
		JSONObject jsonObj = new JSONObject();
		try {

			boolean isResult = ChatDao.sendChat(chat);
			jsonObj.put(APIConstants.IS_VALID, isResult);
		} catch (Exception e) {
			e.printStackTrace();

			jsonObj.clear();
			jsonObj.put(APIConstants.IS_VALID, false);
			jsonObj.put(APIConstants.INVALID_MSG, APIErrorCode.CHAT_ERROR.getErrorMsg());
			return jsonObj;
		}
		return jsonObj;
	}

	/**
	 * 채팅방 내용 조회
	 * 
	 * @return JSONObject
	 * @throws Exception
	 */
	public static JSONObject loadChat(Chat chat, String seq) throws Exception {
		JSONObject jsonObj = new JSONObject();
		try {
			String sql = null;
			if (seq != null && seq.length() > 0) {
				sql = "SELECT NICKNAME, CREATE_DT, CONTENT, IDX FROM CHAT WHERE CHAT_IDX = '" + chat.getIdx()
						+ "' AND IDX > " + seq + ";";
			} else {
				sql = "SELECT NICKNAME, CREATE_DT, CONTENT, IDX FROM CHAT WHERE CHAT_IDX = '" + chat.getIdx() + "';";
			}
			System.out.println("@@ sql : " + sql);
			ArrayList<Chat> chatList = ChatDao.selectChat(sql);

			JSONArray jsonArr = new JSONArray();
			for (int i = 0; i < chatList.size(); i++) {
				JSONObject obj = new JSONObject();
				obj.put("nickname", chatList.get(i).getNickName());
				obj.put("date", chatList.get(i).getDate());
				obj.put("content", chatList.get(i).getContent());
				obj.put("seq", chatList.get(i).getSeq());
				jsonArr.add(obj);
			}
			jsonObj.put("chatVOList", jsonArr);
		} catch (Exception e) {
			e.printStackTrace();

			jsonObj.clear();
			jsonObj.put(APIConstants.IS_VALID, false);
			jsonObj.put(APIConstants.INVALID_MSG, APIErrorCode.CHAT_ERROR.getErrorMsg());
			return jsonObj;
		}
		jsonObj.put(APIConstants.IS_VALID, true);
		return jsonObj;
	}
}
