<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="vo.Board"%>
<%@page import="dao.BoardDao"%>
<html>
<head>
<script language="javascript" charset="EUC-KR">
	location.href = "/MemoServer/jsp/list.jsp";
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ë±ë¡ íì´ì§</title>
</head>
<body>
	<%
		request.setCharacterEncoding( "UTF-8" );
		String title = request.getParameter( "title" );
		String content = request.getParameter( "content" );
		String sIDX = request.getParameter( "idx" );

		Board board = new Board();
		board.setTitle( title );
		board.setContent( content );
		board.setIdx( Integer.valueOf( sIDX ) );

		boolean isResult = BoardDao.modifyBoard( board );
		if ( isResult ) {
			System.out.println( "글 수정 성공" );
		} else {
			System.out.println( "글 수정 실패" );
		}
	%>
</body>
</html>