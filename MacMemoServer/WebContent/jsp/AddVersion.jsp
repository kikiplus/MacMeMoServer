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
	location.href = "VersionList.jsp";
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메모가지 관리자 </title>
</head>
<body>
	<%
		request.setCharacterEncoding( "UTF-8" );
		String versionCode = request.getParameter( "versionCode" );
		String versionName = request.getParameter( "versionName" );
		String forceYN = request.getParameter( "forceYN" );
		System.out.println( versionCode );
		System.out.println( versionName );
		System.out.println( forceYN );

		Version version = new Version();
		version.setVersionCode(Integer.valueOf(versionCode));
		version.setVersionName(versionName);
		version.setForceYN(forceYN);

		boolean isResult = VersionDao.insertVersion(version);
		if ( isResult ) {
			System.out.println( "insert to version table" );
		} else {
			System.out.println( "insert error to version table" );
		}
	%>
</body>
</html>