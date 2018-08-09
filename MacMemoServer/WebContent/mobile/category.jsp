<%@page import="utils.ErrorLogUtils"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="api.MobileAPIController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String requestMethod = request.getMethod(); // POST전송인지 GET 전송인지 판별한다.
	System.out.println("@@ getCategory requestMethod => " + requestMethod + "\n");
	
	JSONObject jsonObj = MobileAPIController.getCategory();
	out.print(jsonObj);
	System.out.println("@@ getCategory => " + jsonObj + "\n");
%>
