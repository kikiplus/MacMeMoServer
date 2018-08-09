<%@page import="org.json.simple.JSONObject"%>
<%@page import="utils.ErrorLogUtils"%>
<%@page import="api.MobileAPIController"%>
<%@page import="dao.BoardDao"%>
<%@page import="vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String requestMethod = request.getMethod(); // POST전송인지 GET 전송인지 판별한다.
	System.out.println("@@ gcmProjectId requestMethod => " + requestMethod + "\n");
	
	if (requestMethod.equals("POST")) {
		JSONObject jsonObj = MobileAPIController.gcmProjectId();
		out.print(jsonObj);
		System.out.println("@@ gcmProjectId => " + jsonObj + "\n");
	}else{
		System.out.println("@@ gcmProjectId request no post\n");
	}
%>
