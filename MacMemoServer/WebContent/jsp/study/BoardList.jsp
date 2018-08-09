<%@page import="utils.XMLParser"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Board"%>
<%@page import="dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="javascript" charset="EUC-KR">
	var ua = window.navigator.userAgent;
	window.JAlertInterface.setMessage(ua);

	function pass(url) {
		location.href = url;
	}
	function passForm(url) {
		var f = document.board;
		f.action = url;
		f.submit();
	}

	function a() {
		window.JAlertInterface.setMessage("테스트입니다");
	}

	function b(url) {
		window.JLoadUrlInterface.loadHomePageURL("http://google.com");
	}

	function c() {
		window.JMenuInterface.setTitle("환경설정");
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리스트</title>
</head>
<body>
	<form name=board method=post>
		<table width="100%" cellpadding="0" cellspacing="0" border="0">
			<tr height="5">
				<td width="5"></td>
			</tr>
			<tr align="center">
				<td width="100">번호</td>
				<td width="379">제목</td>
				<td width="164">작성일</td>
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
			<%
				//게시판 목록 불러오기
				ArrayList<Board> boardList = (ArrayList<Board>) BoardDao.selecetBoard( "select TITLE, CONTENT, BOARD_DATE, IDX from BOARD;" );
				for ( int i = 0; i < boardList.size(); i++ ) {
			%>
			<tr align="center" height="30">
				<td width="100"><input name="idx" type="radio"
					value="<%=boardList.get( i ).getIdx()%>"> <%=i + 1%></td>
				<td width="379"><a
					href="javascript:passForm('/MemoServer/jsp/ModifyBoard.jsp')"><%=boardList.get( i ).getTitle()%></a></td>
				<td width="164"><%=boardList.get( i ).getDate()%></td>
			</tr>
			<%
				}
			%>
		</table>

		<table width="100%" cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td colspan="4" height="30"></td>
			</tr>
			<tr align="right">
				<td><input type=button value="홈"
					Onclick="javascript:pass('/MemoServer/')"> <input
					type=button value="등록"
					Onclick="javascript:pass('/MemoServer/jsp/insertBoard.jsp')">
					<input type=button value="수정"
					Onclick="javascript:passForm('/MemoServer/jsp/ModifyBoard.jsp')">
					<input type=button value="삭제"
					Onclick="javascript:passForm('/MemoServer/jsp/DeleteBoard.jsp')">
				</td>

			</tr>
			<tr align="right">
				<td><input type=button value="테스트버튼" Onclick="javascript:a()">
					<input type=button value="환경설정버튼" Onclick="javascript:b()">
				</td>
			</tr>
			<tr height="100">
				<td colspan="6"></td>
			</tr>
		</table>
	</form>
</body>
</html>
