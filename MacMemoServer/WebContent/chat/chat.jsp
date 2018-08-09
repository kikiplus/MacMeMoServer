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
	System.out.println("@@ chat idx : " + idx);
	String nickName = request.getParameter("NICKNAME");
	System.out.println("@@ chat nickName : " + nickName);
	String content = request.getParameter("CONTENT");
	System.out.println("@@ chat content : " + content);
	String createDate = request.getParameter("CREATE_DT");
	System.out.println("@@ chat createDate : " + createDate);
	
	if (idx == null || nickName == null || content == null || createDate == null) {
		System.out.println("## chat input data is null ");
	}else{
		Chat chat = new Chat();
		chat.setNickName(nickName);
		chat.setIdx(idx);
		chat.setContent(content);
		chat.setDate(createDate);

		JSONObject jsonObj = ChatAPIController.sendChatRoom(chat);
		out.print(jsonObj);
		System.out.println("@@ chat send : " + jsonObj);
	}
	
%>
