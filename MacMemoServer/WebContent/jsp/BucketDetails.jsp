<%@page import="java.util.ArrayList"%>
<%@page import="dao.CommentDao"%>
<%@page import="vo.Comment"%>
<%@page import="dao.BucketDao"%>
<%@page import="vo.Bucket"%>
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
	function pass(url) {
		location.href = url;
	}
	function passForm(url) {
		var f = document.board;
		f.action = url;
		f.submit();
	}
</script>
<title>메모가지 관리자 </title>
</head>
<body>
	<b>버킷 상세 내용 페이지</b>
	<%
		request.setCharacterEncoding("UTF-8");

		String idx = request.getParameter("idx");
		if (idx == null) {
			System.out.println("글 수정 번호 없음" + idx);
			out.println("글 수정 번호 없음");
			return;
		}
		System.out.println("idx : " + idx);
		int reqIdx = Integer.valueOf(idx);

		Bucket bucket = BucketDao.selecetBucket(reqIdx);
	%>
	<table width="70%" cellpadding="0" cellspacing="0" border="0">
		<form name=board method=post
			action="//jsp/UpdateCateogry.jsp">
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
			<tr height="50">
				<td>닉네임</td>
				<td><input name="nickname" type=edit
					value="<%=bucket.getNickName()%>" maxlength="100"></td>
			</tr>
			<tr height="50">
				<td>내용</td>
				<td><input name="content" type=edit
					value="<%=bucket.getContent()%>" maxlength="100"></td>
			</tr>

			<tr height="50">
				<td>이미지</td>
				<td><input name="imageUrl" type=edit
					value="<%=bucket.getImageUrl()%>" maxlength="100"></td>
			</tr>

			<tr height="50">
				<td>완료 날짜</td>
				<td><input name="date" type=edit value="<%=bucket.getDate()%>"
					maxlength="100"></td>
			</tr>

			<tr height="50">
				<td>분류 코드</td>
				<td><input name="categoryCode" type=edit
					value="<%=bucket.getCategoryCode()%>"></td>
				<td><input name="idx" type=hidden value="<%=bucket.getIdx()%>"></td>
			</tr>

			<tr height="30">
				<td colspan="2"><B><댓글 단 사람들></B></td>
			</tr>

			<tr height="5">
				<td width="5"></td>
			</tr>
			<tr align="center">
				<td width="100">닉네임</td>
				<td width="379">댓글 내용</td>
				<td width="100">날짜</td>
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
				String sql = "select NICKNAME, CONTENT, CREATE_DT,  IDX, BUCKET_NO from COMMENT WHERE BUCKET_NO =" + idx
						+ ";";
				//System.out.println("sql : " + sql);
				ArrayList<Comment> commentList = (ArrayList<Comment>) CommentDao.selecetComment(sql);
				for (int i = 0; i < commentList.size(); i++) {
			%>
			<tr align="center" height="30">
				<td width="100"><%=commentList.get(i).getNickName()%></td>
				<td width="379"><%=commentList.get(i).getContent()%></td>
				<td width="100"><%=commentList.get(i).getDate()%></td>
			</tr>
			<%
				}
			%>

			<tr height="200" align="center">
				<td colspan="3"><input type=button value="목록"
					Onclick="javascript:history.back(-1)"></td>
			</tr>
		</form>
	</table>

</body>
</html>
