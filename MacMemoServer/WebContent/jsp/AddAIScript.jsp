<!DOCTYPE HTML>
<%@page import="vo.AIScript"%>
<%@page import="dao.AIDao"%>
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
		String content = request.getParameter("content");
		String categoryCode = request.getParameter("categoryCode");

		if (content == null || categoryCode == null) {
			System.out.println("categoryCode or  content is null");
		} else {
			System.out.println(content);
			System.out.println(categoryCode);

			AIScript script = new AIScript();
			script.setCategoryCode(Integer.valueOf(categoryCode));
			script.setContent(content);

			boolean isResult = AIDao.insertAIScript(script);
			if (isResult) {
				System.out.println("insert to ai_script table");
			} else {
				System.out.println("insert error to ai_script table");
			}
		}
	%>
</body>
</html>