<%@page import="dao.AIDao"%>
<%@page import="vo.AIScript"%>
<%@page import="dao.CategoryAIDao"%>
<%@page import="vo.CategoryAI"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="CheckSession.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="" />
<meta name="keywords" content="" />
<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
<script src="js/jquery.min.js"></script>
<script src="js/jquery.dropotron.min.js"></script>
<script src="js/jquery.scrolly.min.js"></script>
<script src="js/jquery.onvisible.min.js"></script>
<script src="js/skel.min.js"></script>
<script src="js/skel-layers.min.js"></script>
<script src="js/init.js"></script>
<link rel="stylesheet" href="/css/style.css" />
<link rel="stylesheet" href="/css/style.css" />
<link rel="stylesheet" href="/css/style-desktop.css" />
<link rel="stylesheet" href="/css/style-noscript.css" />
<script>
	function pass(url) {
		location.href = url;
	}
	function passForm(url) {
		var f = document.board;
		f.action = url;
		f.submit();
	}
</script>
<title>메모가지 관리자</title>
</head>
<body>
	<b>AI 드림이 목록 페이지</b>
	<form name=board method=post>
		<table width="50%" cellpadding="0" cellspacing="0" border="0">
			<tr height="5">
				<td width="5"></td>
			</tr>
			<tr align="center">
				<td width="100">카테고리 코드</td>
				<td width="379">카테고리명</td>
			</tr>
			<tr height="20" align="center">
			</tr>
			<tr height="1" bgcolor="#D2D2D2">
				<td colspan="6"></td>
			</tr>
			<tr height="1" bgcolor="#82B5DF">
				<td colspan="6" width="752"></td>
			</tr>
			<%
				//게시판 목록 불러오기
				ArrayList<CategoryAI> aiList = (ArrayList<CategoryAI>) CategoryAIDao.selectCategoryAI();
				for (int i = 0; i < aiList.size(); i++) {
			%>
			<tr align="center" height="30">
				<td width="100"><%=aiList.get(i).getCategoryCode()%></td>
				<td width="379"><%=aiList.get(i).getCategoryName()%></td>
			</tr>
			<%
				}
			%>
		</table>

		<div style="height: 500px; overflow: auto;">
			<table cellpadding="0" cellspacing="0" border="0">
				<tr height="5">
					<td width="5"></td>
				</tr>
				<tr align="center">
					<td width="100">idx</td>
					<td width="100">카데고리</td>
					<td width="379">스크립트 내용</td>
				</tr>
				<tr height="20" align="center">
				</tr>
				<tr height="1" bgcolor="#D2D2D2">
					<td colspan="6"></td>
				</tr>
				<tr height="1" bgcolor="#82B5DF">
					<td colspan="6" width="752"></td>
				</tr>
				<%
					//AI스크리브 목록 불러오기
					ArrayList<AIScript> scriptlist = (ArrayList<AIScript>) AIDao.selecetAIScriptList();
					for (int i = 0; i < scriptlist.size(); i++) {
				%>
				<tr align="center" height="30">
					<td width="100"><input name="idx" type="radio"
						value="<%=scriptlist.get(i).getIdx()%>"> <%=scriptlist.get(i).getIdx()%></td>
					<td width="100"><%=scriptlist.get(i).getCategoryCode()%></td>
					<td width="379"><%=scriptlist.get(i).getContent()%></td>
				</tr>
				<%
					}
				%>
			</table>
		</div>


		<table width="100%" cellpadding="0" cellspacing="0" border="0">

			<tr height="150" align="center">
				<td>분류</td>
				<td><select style="width: 300px;" id="categoryCode"
					name="categoryCode">
						<option value="1">GREETING_MORNING</option>
						<option value="2">GREETING_AFTERNOON</option>
						<option value="3">GREETING_NIGHT</option>
						<option value="4">INTEREST</option>
						<option value="5">PROMOTION</option>
						<option value="6">CHEER</option>
				</select></td>
				<td><input name="categoryCode" type=button value="업데이트"
					Onclick="javascript:passForm('/jsp/UpdateAIScript.jsp')">
				</td>
			</tr>
			<tr height="100" align="center">
				<td>내용</td>
				<td><input style="width: 300px;" name="content" type=edit></td>
				<td><input type=button value="등록"
					Onclick="javascript:passForm('/jsp/AddAIScript.jsp')">
				</td>
			</tr>

			<tr height="100" align="center">
				<td colspan="3"><input type=button value="홈"
					Onclick="javascript:pass('/kikiMain.html')"> <input
					type=button value="삭제"
					Onclick="javascript:passForm('/jsp/DeleteAIScript.jsp')">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>

