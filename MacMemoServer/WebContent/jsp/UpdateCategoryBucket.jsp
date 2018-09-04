<!DOCTYPE HTML>
<%@page import="vo.Bucket"%>
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
	location.href = "CategoryList.jsp";
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메모가지 관리자</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String categoryCode = request.getParameter("categoryCode");
		System.out.println("@@ categoryCode : " + categoryCode);
		
		String categoryName = request.getParameter("categoryName");
		System.out.println("@@ categoryName : " + categoryName);

		String idx = request.getParameter("idx");
		System.out.println("@@ idx : " + idx);
		Bucket bucket = new Bucket();
		bucket.setCategoryCode(Integer.valueOf(categoryCode));
		bucket.setCategoryName(categoryName);
		bucket.setIdx(Integer.valueOf(idx));

		boolean isResult = CategoryBucketDao.modifyCategoryBucket(bucket);
		if (isResult) {
			System.out.println("update to bucket table");
		} else {
			System.out.println("update error to bucket table");
		}
	%>
</body>
</html>