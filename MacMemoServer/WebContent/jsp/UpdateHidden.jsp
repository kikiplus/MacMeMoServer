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
	location.href = "/jsp/BucketList.jsp";
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메모가지 관리자</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		PrintUtil.printHeaderAndContents(request);
		String hidden = request.getParameter("hidden");
		String idx = request.getParameter("idx");

		if (hidden != null && idx != null) {
			System.out.println("update to bucket table for hiddenCode");
			boolean isResult = BucketDao.updateBucketHidden(hidden, Integer.valueOf(idx));
			if (isResult) {
				System.out.println("update to bucket table for hiddenCode");
			} else {
				System.out.println("update error to bucket table for hiddenCode");
			}
		} else {
			System.out.println("hiddenCode or idx in null");
		}
	%>
</body>
</html>