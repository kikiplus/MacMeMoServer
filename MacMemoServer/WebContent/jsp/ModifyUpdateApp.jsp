<%@page import="vo.UpdateApp"%>
<%@page import="dao.UpdateAppDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.w3c.dom.Document"%>
<%@page import="dao.BoardDao"%>
<%@page import="vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	function boardInputCheck() {
		var f = document.board;
		if (!f.versionCode.value) {
			alert("버전코드를 적어주세요");
			form.title.focus();
			return;
		}
		if (!f.content.value) {
			alert("내용을 적어주세요");
			form.content.focus();
			return;
		}

		f.action = "UpdateApp.jsp";
		f.submit();
	}
</script>
<title>메모가지 관리자 </title>
</head>
<body>
<b>업데이트 내역 수정 페이지</b>
	<%
		request.setCharacterEncoding("UTF-8");
		String idx = request.getParameter("idx");
		if (idx == null) {
			System.out.println("글 수정 번호 없음");
			out.println("글 수정 번호 없음");
			return;
		}
		System.out.println("idx : " + idx);

		ArrayList<UpdateApp> BoardList = UpdateAppDao
				.selecetUpdateApp("SELECT * FROM UPDATE_APP WHERE version_code = " + idx + ";");

		if (BoardList.size() == 1) {
			System.out.println("글 수정 데이타 조회");
			System.out.println(BoardList.get(0).getVersionCode());
			System.out.println(BoardList.get(0).getContent());
		} else {
			System.out.println("글 수정 데이타 불러오기 실패");
		}
	%>
	<table width="70%" cellpadding="0" cellspacing="0" border="0">
		<form name=board method=post>
			<tr height="5">
				<td width="5"></td>
			</tr>
			<tr height="20" align="center">
			</tr>
			<tr height="1" bgcolor="#D2D2D2">
				<td colspan="6"></td>
			</tr>
			<tr height="1" bgcolor="#82B5DF">
				<td colspan="6" width="752"></td>
			</tr>
			<tr height="10">
				<td colspan="6"></td>
			</tr>
			<tr height="10">
				<td width=70>No</td>
				<td><input name="versionCode" type=edit
					value="<%=BoardList.get(0).getVersionCode()%>" maxlength="100">
					<input name="idx" type="hidden" value=<%=idx%>></td>
			</tr>
			<tr height="10">
				<td width=70>Contents</td>
				<td><textarea name="content" cols="50" rows="13"><%=BoardList.get(0).getContent()%>
				</textarea></td>
			</tr>

			<tr height="10">
				<td width="10"></td>
			</tr>

			<tr height="10">
				<td><input type=button value="수정"
					Onclick="javascript:boardInputCheck()"></td>
				<td><input type=button value="취소"
					Onclick="javascript:history.back(-1)"></td>
			</tr>
		</form>
	</table>
</body>
</html>