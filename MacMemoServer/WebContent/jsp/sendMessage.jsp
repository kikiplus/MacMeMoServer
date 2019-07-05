<!DOCTYPE HTML>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.MobileUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="push.GcmManager"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메모가지 관리자</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String sendAll = request.getParameter("sendAll");
		if (sendAll != null && sendAll.equals("Y")) {
			// 전체 발송
			ArrayList<String> tokenList = MobileUserDao.selecetAllMobileUserToken();
			String content = request.getParameter("sendMessage");
			System.out.println("@@ GCM 모든 사용자에게 메시지 전송 준비");
			for (int i = 0; i < tokenList.size(); i++) {
				boolean isResult = GcmManager.sendMessage(tokenList.get(i), content);
				System.out.println("@@ GCM 전송 완료 : " + i + "번재");
				if (isResult) {
					out.println("<script>alert('" + "GCM 전송완료" + "');</script>");
				} else {
					out.println("<script>alert('" + "GCM 전송실패" + "');</script>");

				}
			}
			System.out.println("@@ GCM 모든 사용자에게 메시지 전송 완료 ");
			response.sendRedirect("/jsp/GcmTest.jsp");
		} else {
			String registrationId = request.getParameter("regId");
			String content = request.getParameter("sendMessage");

			System.out.println("@@ sendAll : " + sendAll);
			System.out.println("@@ REG_ID : " + registrationId);
			System.out.println("@@ MSG : " + content);

			if (registrationId == null || content == null) {
				out.println("<script>alert('" + "GCM 전송실패" + "');</script>");
				response.sendRedirect("/jsp/GcmTest.jsp");
				return;
			}

			boolean isResult = GcmManager.sendMessage(registrationId, content);
			if (isResult) {
				System.out.println("@@ GCM 전송 완료");
				out.println("<script>alert('" + "GCM 전송완료" + "');</script>");
				response.sendRedirect("GcmTest.jsp");
			} else {
				out.println("<script>alert('" + "GCM 전송실패" + "');</script>");
				response.sendRedirect("GcmTest.jsp");
			}
		}
	%>
</body>
</html>