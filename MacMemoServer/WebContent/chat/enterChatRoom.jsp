<%@page import="vo.Chat"%>
<%@page import="api.ChatAPIController"%>
<%@page import="utils.ErrorLogUtils"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="api.MobileAPIController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String idx = request.getParameter("idx");
	String nickName = request.getParameter("NICKNAME");
	String phone = request.getParameter("PHONE");
	String createDate = request.getParameter("CREATE_DT");
	
	Chat chat = new Chat();
	chat.setNickName(nickName);
	chat.setPhone(phone);
	chat.setIdx(idx);

	JSONObject jsonObj = ChatAPIController.enterChatRoom(chat);
	out.print(jsonObj);
	System.out.println("@@ chatEnter : " + jsonObj);
%>
