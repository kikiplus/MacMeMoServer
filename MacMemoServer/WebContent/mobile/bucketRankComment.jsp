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
	System.out.println("@@ getBucketRacnkUpdate requestMethod => " + requestMethod + "\n");
	
	if (requestMethod.equals("POST")) {
		String strIdx = request.getParameter("idx");
		String strNickName = request.getParameter("nickname");
		String strComment = request.getParameter("comment");
		System.out.println("@@ getBucketRacnkUpdate strIdx : " + strIdx);
		System.out.println("@@ getBucketRacnkUpdate strNickName : " + strNickName);
		System.out.println("@@ getBucketRacnkUpdate strComment : " + strComment);
		
		if(strIdx != null && strNickName != null && strComment != null){
			JSONObject jsonObject = MobileAPIController.insertBucketRank(strIdx, strNickName, strComment);
			out.print(jsonObject);
			System.out.println("@@ getBucketRacnkUpdate => " + jsonObject + "\n");
		}else{
			System.out.println("## getBucketRacnkUpdate idx or nickname or comment is null");
		}
	}else{
		System.out.println("@@ getBucketRacnkUpdate request no post\n");
	}
	
%>
