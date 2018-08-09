<!DOCTYPE HTML>
<%@ page import="utils.XMLParser"%>
<%@ page import="dao.SessionDao"%>
<%@ page import="dao.UserDao"%>
<%@ page import="dao.VersionDao"%>
<%@ page import="vo.Version"%>
<%@ page import="dao.UpdateAppDao"%>
<%@ page import="vo.UpdateApp"%>
<%@ page import="vo.User" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> </title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");

		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");
		System.out.println(userID);
		System.out.println(userPassword);
		
		System.out.println("Server Version : " +application.getServerInfo());
		System.out.println("Servlet Version  : " + application.getMajorVersion() + "." + application.getMinorVersion());
		System.out.println("JSP Version : " + JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion());
		System.out.println(request.getContextPath());

		User user = new User();
		user.setUserID(userID);
		user.setUserPassword(userPassword);


		boolean isAdmin = UserDao.checkAdmin(user);
		System.out.println("select isAdmin : " + isAdmin);
		
		String userid = XMLParser.getXMLObject("SessionUserId");
		SessionDao.addSessionValue(request, userid, userID);
		SessionDao.printSessionValues(request);
		
		if (isAdmin) {
			boolean isResult = UserDao.checkUser(user);
			System.out.println("select isResult : " + isResult);
			if (isResult) {
				
				response.sendRedirect("/kikiMain.html");
			} else {
				response.sendRedirect("/index.html");

			}
		} else {
			response.sendRedirect("/guestMain.html");
		}
	%>
</body>
</html>
