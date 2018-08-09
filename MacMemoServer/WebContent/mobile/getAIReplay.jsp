<%@page import="utils.ErrorLogUtils"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="ai.AIController"%>
<%@page import="api.MobileAPIController"%>
<%@page import="dao.BoardDao"%>
<%@page import="vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String requestMethod = request.getMethod(); // POST전송인지 GET 전송인지 판별한다.
	System.out.println("@@ getAIResponse requestMethod => " + requestMethod + "\n");
	
	if (requestMethod.equals("POST")) {
		String strNickName = request.getParameter("nickname");
		System.out.println("@@ getAIResponse strNickName : " + strNickName);
		JSONObject jsonObj = AIController.getResponse(strNickName);
		out.print(jsonObj);
		System.out.println("@@ getAIResponse => " + jsonObj + "\n");
	}else{
		System.out.println("@@ getAIResponse request no post\n");
	}
%>
