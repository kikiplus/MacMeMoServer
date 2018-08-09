<%@page import="utils.ErrorLogUtils"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="api.MobileAPIController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String requestMethod = request.getMethod(); // POST전송인지 GET 전송인지 판별한다.
	System.out.println("@@ getCommentList requestMethod => " + requestMethod + "\n");
	
	if (requestMethod.equals("POST")) {
		String idx = request.getParameter("idx");
		System.out.println("@@ getCommentList idx : " + idx);
		if(idx != null){
			JSONObject jsonObj = MobileAPIController.getBucketDetails(Integer.valueOf(idx));
			out.print(jsonObj);
			System.out.println("@@ getCommentList => " + jsonObj + "\n");	
		}else{
			System.out.println("## getCommentList idx is null");
		}
	}else{
		System.out.println("@@ getCommentList request no post\n");
	}
	
%>
