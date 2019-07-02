<!DOCTYPE HTML>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.MobileUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="gcm.ApnsManager"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메모가지 관리자</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String sendAll = request.getParameter("sendAll");
		String certPass = request.getParameter("certPassword");
		
		if (sendAll != null && sendAll.equals("Y")) {
			// 전체 발송
			System.out.println("@@ APNS 모든 사용자에게 메시지 전송 예 ");
			response.sendRedirect("/jsp/APNSTest.jsp");
		} else {
			String registrationId = request.getParameter("regId");
			String content = request.getParameter("sendMessage");
			

			System.out.println("@@ sendAll : " + sendAll);
			System.out.println("@@ REG_ID : " + registrationId);
			System.out.println("@@ MSG : " + content);
			System.out.println("@@ certPass : " + certPass);

			if (registrationId == null || content == null) {
				out.println("<script>alert('" + "APNS 전송실패" + "');</script>");
				response.sendRedirect("/jsp/APNSTest.jsp");
				return;
			}

			boolean isResult = ApnsManager.sendAPNSMessage(1, registrationId, content, 1, "",  certPass);
			if (isResult) {
				System.out.println("@@ APNS 전송 완료");
				out.println("<script>alert('" + "APNS 전송완료" + "');</script>");
				response.sendRedirect("APNSTest.jsp");
			} else {
				out.println("<script>alert('" + "APNS 전송실패" + "');</script>");
				//response.sendRedirect("APNSTest.jsp");
			}
		}
	%>
</body>
</html>