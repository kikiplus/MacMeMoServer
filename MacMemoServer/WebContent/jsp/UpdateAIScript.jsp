<!DOCTYPE HTML>
<%@page import="dao.AIDao"%>
<%@page import="vo.AIScript"%>
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
	location.href = "/jsp/AIScriptList.jsp";
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메모가지 관리자</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String categoryCode = request.getParameter("categoryCode");
		String idx = request.getParameter("idx");

		if (categoryCode == null || idx == null) {
			System.out.println("categoryCode or  idx is null");
		} else {
			AIScript script = new AIScript();
			script.setCategoryCode(Integer.valueOf(categoryCode));
			script.setIdx(Integer.valueOf(idx));

			boolean isResult = AIDao.updateAIScript(Integer.valueOf(categoryCode), Integer.valueOf(idx));
			if (isResult) {
				System.out.println("update to ai_script table");
			} else {
				System.out.println("update error to ai_script table");
			}
		}
	%>
</body>
</html>