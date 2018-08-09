<%@page import="api.SqlController"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="utils.ErrorLogUtils"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="api.MobileAPIController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String requestMethod = request.getMethod(); // POST전송인지 GET 전송인지 판별한다.
	System.out.println("@@ getBucketRankList requestMethod => " + requestMethod + "\n");
	
	if (requestMethod.equals("POST")) {
		int pageNm = request.getParameter("page") != null ? Integer.valueOf(request.getParameter("page")) : 1;
		String strNickName = request.getParameter("nickname");
		System.out.println("@@ getBucketRankList strNickName : " + strNickName);
		if (strNickName == null) {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			String currentTime = sdf.format(calendar.getTime());
			strNickName = "SYSTEM_" + currentTime;
		}

		String sql = SqlController.getBucketRankList();
		JSONObject jsonObject = MobileAPIController.getBucketRankList(sql, pageNm, strNickName);
		out.print(jsonObject);
		System.out.println("@@ getBucketRankList => " + jsonObject + "\n");
	}else{
		System.out.println("@@ getBucketRankList request no post\n");
	}
%>
