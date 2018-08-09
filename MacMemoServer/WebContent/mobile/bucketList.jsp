<%@page import="api.SqlController"%>
<%@page import="utils.ErrorLogUtils"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="api.MobileAPIController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	int categoryCode = request.getParameter("idx") != null ? Integer.valueOf(request.getParameter("idx")) : 1;
	String requestMethod = request.getMethod(); // POST전송인지 GET 전송인지 판별한다.
	System.out.println("@@ getBucketList requestMethod => " + requestMethod + "\n");
	
	if (requestMethod.equals("POST")) {
		System.out.println("@@ getBucketList categotCode : " + categoryCode);
		String sql = SqlController.getBucketList(categoryCode);
		JSONObject jsonObject = MobileAPIController.getBucketList(sql);
		out.print(jsonObject);
		System.out.println("@@ getBucketList => " + jsonObject + "\n");
	}else{
		System.out.println("@@ getBucketList request no post\n");
	}
%>
