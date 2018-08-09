<%@page import="dao.BoardDao"%>
<%@page import="vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter( "name" );
		String title = request.getParameter( "title" );
		String content = request.getParameter( "content" );

		System.out.println( "name :" + name );
		System.out.println( "content :" + content );
		System.out.println( "title :" + title );
		
		if ( name != null ) {
			System.out.println( "login.jsp 호출됨" );
		} else {
			out.print( "에러" );
			return;
		}
		
		Board board = new Board();
		board.setTitle( title );
		board.setContent( content );
		
		boolean isResult = BoardDao.insertBoard( board );
		if(isResult){
			System.out.println( "완료" );
			out.print( "성공 ");
		}else{
			out.print( "실패 ");
		}
	%>

</body>
</html>