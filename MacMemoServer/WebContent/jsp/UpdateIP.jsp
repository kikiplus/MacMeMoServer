<!DOCTYPE HTML>
<%@page import="dao.ServerDao"%>
<%@page import="vo.IP"%>
<%@page import="dao.VersionDao"%>
<%@page import="vo.Version"%>
<%@page import="dao.UpdateAppDao"%>
<%@page import="vo.UpdateApp"%>
<%@page import="vo.Board"%>
<%@page import="dao.BoardDao"%>
<html>
<head>
<script>
	location.href = "/jsp/ServerList.jsp";
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메모가지 관리자</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String versionCode = request.getParameter("versionCode");
		String versionName = request.getParameter("versionName");

		IP ip = new IP();
		ip.setVersionCode(Integer.valueOf(versionCode));
		ip.setVersionName(versionName);

		boolean isResult = ServerDao.modifyIP(ip);
		if (isResult) {
			System.out.println("update to ip table");
		} else {
			System.out.println("update error to ip table");
		}
	%>
</body>
</html>