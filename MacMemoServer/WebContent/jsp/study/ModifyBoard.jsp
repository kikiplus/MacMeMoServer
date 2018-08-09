<%@page import="java.util.ArrayList"%>
<%@page import="org.w3c.dom.Document"%>
<%@page import="dao.BoardDao"%>
<%@page import="vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="javascript">
	function boardInputCheck() {
		var f = document.board;
		if (!f.title.value) {
			alert("제목을 적어주세요");
			form.title.focus();
			return;
		}
		if (!f.content.value) {
			alert("내용을 적어주세요");
			form.content.focus();
			return;
		}

		f.action = "/MemoServer/jsp/UpdateBoard.jsp";
		f.submit();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수정 페이지</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String idx = request.getParameter( "idx" );
		if ( idx == null ) {
			System.out.println( "글 수정 번호 없음" );
			out.println( "글 수정 번호 없음" );
			return;
		}
		System.out.println( "idx : " + idx );

		ArrayList<Board> BoardList = BoardDao.selecetBoard( "SELECT * FROM BOARD WHERE IDX = " + idx + ";" );

		if ( BoardList.size() == 1 ) {
			System.out.println( "글 수정 데이타 조회" );
			System.out.println( BoardList.get( 0 ).getTitle() );
			System.out.println( BoardList.get( 0 ).getContent() );
			System.out.println( BoardList.get( 0 ).getIdx() );
			System.out.println( BoardList.get( 0 ).getDate() );
		} else {
			System.out.println( "글 수정 데이타 불러오기 실패" );
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
				<td>제목</td>
				<td><input name="title" type=edit
					value="<%=BoardList.get( 0 ).getTitle()%>" maxlength="100">
					<input name="idx" type="hidden" value=<%=idx%>></td>
			</tr>
			<tr height="10">
				<td>내용</td>
				<td><textarea name="content" cols="50" rows="13"><%=BoardList.get( 0 ).getContent()%>
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