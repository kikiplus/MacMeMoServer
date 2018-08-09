<%@page import="utils.ErrorLogUtils"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.io.OutputStream"%>
<%@page import="api.MobileAPIController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String requestMethod = request.getMethod(); // POST전송인지 GET 전송인지 판별한다.
	System.out.println("@@ getVersion requestMethod => " + requestMethod + "\n");
	
	if (requestMethod.equals("POST")) {
		String currentVersion = request.getParameter("version");
		System.out.println("@@ getVersion userVersion : " + currentVersion);
		JSONObject jsonObj = null;
		if (currentVersion != null) {
			jsonObj = MobileAPIController.getVersion(currentVersion);
		} else {
			jsonObj = MobileAPIController.getVersion();
		}
		out.print(jsonObj);
		System.out.println("@@ getVersion => " + jsonObj + "\n");
	}else{
		System.out.println("@@ getVersion request no post\n");
	}

%>
