<%@page import="dao.CategoryBucketDao"%>
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
		String idx = request.getParameter("idx");
		if (idx == null) {
			System.out.println("글 삭제 번호 없음");
			out.println("글 삭제 번호 없음");
			return;
		}
		System.out.println("idx : " + idx);

		boolean isResult = CategoryBucketDao.deleteCategoryBucket(Integer.valueOf(idx));

		if (isResult) {
			System.out.println("글 삭제 성공");

			response.sendRedirect("/jsp/CategoryList.jsp");
		} else {
			System.out.println("글 삭제 실패");
		}
	%>
</body>
</html>