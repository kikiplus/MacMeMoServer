<!DOCTYPE HTML>
<%@page import="dao.UpdateAppDao"%>
<%@page import="vo.UpdateApp"%>
<%@page import="vo.Board"%>
<%@page import="dao.BoardDao"%>
<html>
<head>
<script language="javascript" charset="EUC-KR">
	location.href = "/jsp/UpdateAppList.jsp";
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메모가지 관리자 </title>
</head>
<body>
	<%
		request.setCharacterEncoding( "UTF-8" );
		String versionCode = request.getParameter( "versionCode" );
		String content = request.getParameter( "content" );

		UpdateApp board = new UpdateApp();
		board.setVersionCode(Integer.valueOf(versionCode));
		board.setContent( content );

		boolean isResult = UpdateAppDao.modifyUpdateApp(board);
		if ( isResult ) {
			System.out.println( "update to update_app table" );
		} else {
			System.out.println( "update error to update_app table" );
		}
	%>
</body>
</html>