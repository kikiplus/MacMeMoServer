<!DOCTYPE HTML>
<%@page import="dao.VersionDao"%>
<%@page import="vo.Version"%>
<%@page import="dao.UpdateAppDao"%>
<%@page import="vo.UpdateApp"%>
<%@page import="vo.Board"%>
<%@page import="dao.BoardDao"%>
<html>
<head>
<script>
	location.href = "/jsp/VersionList.jsp";
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메모가지 관리자</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String versionCode = request.getParameter("versionCode");
		String versionName = request.getParameter("versionName");
		String forceYN = request.getParameter("forceYN");

		Version version = new Version();
		version.setVersionCode(Integer.valueOf(versionCode));
		version.setVersionName(versionName);
		version.setForceYN(forceYN);

		boolean isResult = VersionDao.modifyVersion(version);
		if (isResult) {
			System.out.println("update to version table");
		} else {
			System.out.println("update error to version table");
		}
	%>
</body>
</html>