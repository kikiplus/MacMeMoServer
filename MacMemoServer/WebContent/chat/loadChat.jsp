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
	String nickname = request.getParameter("NICKNAME");
	String seq = request.getParameter("seq");
	
	Chat chat = new Chat();
	chat.setIdx(idx);
	chat.setNickName(nickname);

	JSONObject jsonObj = ChatAPIController.loadChat(chat, seq);
	out.print(jsonObj);
	System.out.println("@@ chat load : " + jsonObj);
%>
