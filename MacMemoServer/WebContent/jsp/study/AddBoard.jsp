<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="vo.Board"%>
<%@page import="dao.BoardDao"%>
<html>
<head>
<script language="javascript" charset="EUC-KR">
	location.href = "/MemoServer/jsp/list.jsp";
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>등록 페이지</title>
</head>
<body>
	<%
		request.setCharacterEncoding( "UTF-8" );
		String title = request.getParameter( "title" );
		String content = request.getParameter( "content" );
		System.out.println( title );
		System.out.println( content );

		Board board = new Board();
		board.setTitle( title );
		board.setContent( content );

		boolean isResult = BoardDao.insertBoard( board );
		if ( isResult ) {
			System.out.println( "글 등록 성공" );
		} else {
			System.out.println( "글 등록 실패" );
		}
	%>
</body>
</html>