<!DOCTYPE HTML>
<%@page import="dao.CategoryBucketDao"%>
<%@page import="vo.CategoryBucket"%>
<%@page import="dao.VersionDao"%>
<%@page import="vo.Version"%>
<%@page import="dao.UpdateAppDao"%>
<%@page import="vo.UpdateApp"%>
<%@page import="vo.Board"%>
<%@page import="dao.BoardDao"%>
<html>
<head>
<script>
	location.href = "/jsp/CategoryList.jsp";
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메모가지 관리자 </title>
</head>
<body>
	<%
		request.setCharacterEncoding( "UTF-8" );
		String categoryCode = request.getParameter( "categoryCode" );
		String categoryName = request.getParameter( "categoryName" );
		System.out.println( categoryCode );
		System.out.println( categoryName );

		CategoryBucket category = new CategoryBucket();
		category.setCategoryCode(Integer.valueOf(categoryCode));
		category.setCategoryName(categoryName);

		boolean isResult = CategoryBucketDao.insertCategoryBucket(category);
		if ( isResult ) {
			System.out.println( "insert to category_bucket table" );
		} else {
			System.out.println( "insert error to category_bucket table" );
		}
	%>
</body>
</html>