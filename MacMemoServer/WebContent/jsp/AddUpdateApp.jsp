<!DOCTYPE HTML>
<%@page import="dao.UpdateAppDao"%>
<%@page import="vo.UpdateApp"%>
<%@page import="vo.Board"%>
<%@page import="dao.BoardDao"%>
<html>
<head>
<script>
	location.href = "/jsp/UpdateAppList.jsp";
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메모가지 관리자 </title>
</head>
<body>
	<%
		request.setCharacterEncoding( "UTF-8" );
		String content = request.getParameter( "content" );
		System.out.println( content );

		UpdateApp update = new UpdateApp();
		update.setContent( content );

		boolean isResult = UpdateAppDao.insertUpdateApp(update);
		if ( isResult ) {
			System.out.println( "insert to update_app table" );
		} else {
			System.out.println( "insert error to update_app table" );
		}
	%>
</body>
</html>