<%@page import="org.json.simple.JSONObject"%>
<%@page import="utils.ErrorLogUtils"%>
<%@page import="api.MobileAPIController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String requestMethod = request.getMethod(); // POST전송인지 GET 전송인지 판별한다.
	System.out.println("@@ getBucketInfo requestMethod => " + requestMethod + "\n");
	if (requestMethod.equals("POST")) {
		String idx = request.getParameter("idx");
		System.out.println("@@ getBucketInfo idx : " + idx);
		JSONObject jsonObject = MobileAPIController.getBucketDetails(Integer.valueOf(idx));
		out.print(jsonObject);
		System.out.println("@@ getBucketInfo => " + jsonObject + "\n");
	}else{
		System.out.println("@@ getBucketInfo request no post\n");
	}
	
%>
