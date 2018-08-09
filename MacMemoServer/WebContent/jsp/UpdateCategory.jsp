<!DOCTYPE HTML>
<%@page import="utils.PrintUtil"%>
<%@page import="dao.BucketDao"%>
<%@page import="dao.VersionDao"%>
<%@page import="vo.Version"%>
<%@page import="dao.UpdateAppDao"%>
<%@page import="vo.UpdateApp"%>
<%@page import="vo.Board"%>
<%@page import="dao.BoardDao"%>
<html>
<head>
<script>
	location.href = "/jsp/CategoryBucketList.jsp";
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메모가지 관리자 </title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		PrintUtil.printHeaderAndContents(request);
		String categoryCode = request.getParameter("categoryCode");
		String idx = request.getParameter("idx");
		if (categoryCode != null && idx != null) {
			boolean isResult = BucketDao.updateBucketCateogry(Integer.valueOf(categoryCode), Integer.valueOf(idx));
			if (isResult) {
				System.out.println("update to bucket table for cateogry");
			} else {
				System.out.println("update error to bucket table for cateogry");
			}
		} else {
			System.out.println("categoryCode or idx in null");
		}
	%>
</body>
</html>