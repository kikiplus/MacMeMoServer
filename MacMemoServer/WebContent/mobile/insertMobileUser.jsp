<%@page import="utils.ErrorLogUtils"%>
<%@page import="dao.TodayCntDao"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="vo.MobileUser"%>
<%@page import="api.MobileAPIController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String requestMethod = request.getMethod(); // POST전송인지 GET 전송인지 판별한다.
	System.out.println("@@ insertMobileUser requestMethod => " + requestMethod + "\n");
	
	if (requestMethod.equals("POST")) {
		String os = request.getParameter("OS");
		String nickName = request.getParameter("NICKNAME");
		String versionName = request.getParameter("VERSION_NAME");
		String market = request.getParameter("MARKET");
		String lang = request.getParameter("LANG");
		String county = request.getParameter("COUNTY");
		String token = request.getParameter("GCM_TOKEN");
		String osVersion = request.getParameter("OS_VERSION");
		String telGbn = request.getParameter("TEL_GBN");

		MobileUser user = new MobileUser();
		user.setOS(os);
		user.setUserNickName(nickName);
		user.setVersionName(versionName);
		user.setMarket(market);
		user.setLanuage(lang);
		user.setCountry(county);
		user.setOsVersion(osVersion);
		user.setGcmToken(token);
		user.setTelGbn(telGbn);
		System.out.println("@@ insertMobileUser user : "+ user.toString());
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(calendar.getTime());

		user.setLastDt(currentTime);
		user.setGcmToken(token);

		JSONObject jsonObj = MobileAPIController.insertMobileUser(user);

		out.print(jsonObj);
		System.out.println("@@ insertMobileUser => " + jsonObj + "\n");

		boolean isResult = TodayCntDao.insertUserLogin();
		if (!isResult) {
			System.out.println("## insertMobileUser 사용자 Today 방문 조회수 추가  실패");
		}
	}else{
		System.out.println("@@ insertMobileUser request no post\n");
	}
	
%>
