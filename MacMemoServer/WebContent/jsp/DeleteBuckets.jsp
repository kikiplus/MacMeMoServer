<%@page import="dao.VersionDao"%>
<%@page import="dao.UpdateAppDao"%>
<%@page import="dao.BoardDao"%>
<%@page import="vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메모가지 관리자 </title>
</head>
<body>
	<%
		boolean isResult   = BoardDao.deleteHiddenBoard();

		if (isResult) {
			System.out.println("숨김 글 삭제 성공");

			response.sendRedirect("BucketList.jsp");
		} else {
			System.out.println("숨김 글 삭제 실패");
		}
	%>
</body>
</html>