<%@ page import="utils.XMLParser"%>
<%@ page import="dao.SessionDao"%>
<%@ page import="api.MobileAPIController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	System.out.println("CheckSession.jsp onload");
	String userid = XMLParser.getXMLObject("SessionUserId");
	String value = SessionDao.getSessionValue(request, userid);
	
	if (value == null) {
		System.out.println("로그인 계정이 없습니다. 다시 로그인 해주세요.");
		response.sendRedirect("/index.html");
	} else {
		System.out.println("로그인 계정 있음 : " + value);
	}
%>
