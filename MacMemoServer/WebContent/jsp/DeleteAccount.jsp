<!DOCTYPE HTML>
<%@page import="dao.SessionDao"%>
<%@page import="utils.XMLParser"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메모가지 관리자</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		
		String userid = XMLParser.getXMLObject("SessionUserId");
		String value = SessionDao.getSessionValue(request, userid);
		if (value != null) {
			SessionDao.removeSessionValue(request, userid);
			System.out.println("remove Session User id");

			response.sendRedirect("/index.html");
		} else {
			response.sendRedirect("/index.html");
		}
	%>
</body>
</html>