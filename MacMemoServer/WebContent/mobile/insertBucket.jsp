<%@page import="utils.ErrorLogUtils"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="vo.Bucket"%>
<%@page import="api.MobileAPIController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String requestMethod = request.getMethod(); // POST전송인지 GET 전송인지 판별한다.
	System.out.println("@@ insertBucket requestMethod => " + requestMethod + "\n");
	if (requestMethod.equals("POST")) {
		String categoryCode = request.getParameter("CATEGORY_CODE");
		String nickName = request.getParameter("NICKNAME");
		String content = request.getParameter("CONTENT");
		String imageUrl = request.getParameter("IMAGE_URL");
		String createDate = request.getParameter("CREATE_DT");

		Bucket bucket = new Bucket();
		if(categoryCode == null){
			categoryCode = "9";
		}
		bucket.setCategoryCode(Integer.valueOf(categoryCode));
		bucket.setNickName(nickName);
		bucket.setContent(content);
		bucket.setImageUrl(imageUrl);
		bucket.setHidden("N");

		if (createDate == null) {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			createDate = sdf.format(calendar.getTime());
		}
		bucket.setDate(createDate);

		JSONObject jsonObj = MobileAPIController.insertBucket(bucket);
		out.print(jsonObj);
		System.out.println("@@ insertBucket => " + jsonObj + "\n");
		
	}else{
		System.out.println("@@ insertBucket request no post\n");
	}
	
%>
