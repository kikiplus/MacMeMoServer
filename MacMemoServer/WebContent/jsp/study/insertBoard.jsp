<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="javascript">
	// 입력 체크 함수
	function boardInputCheck() {
		var form = document.board;

		if (!form.title.value) {
			form.title.focus();
			return;
		}

		if (!form.content.value) {
			form.content.focus();
			return;
		}

		form.submit();
	}
	
	//첨부하기
	function attach(){
		window.JFileAttachInterface.sendFile();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>등록 페이지</title>
</head>
<body>
	<table width="70%" cellpadding="0" cellspacing="0" border="0">
		<form name=board method=post
			action="/MemoServer/jsp/AddBoard.jsp">
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
				<td><input name="title" type=edit value="" maxlength="100"></td>
			</tr>
			<tr height="10">
				<td>내용</td>
				<td><textarea name="content" cols="50" rows="13"></textarea></td>
			</tr>
			<tr height="10">
				<td>첨부파일</td>
				<td><input type=button value="첨부파일"
					OnClick="javascript:attach()"></td>
			</tr>

			<tr height="10">
				<td width="10"></td>
			</tr>

			<tr height="10">
				<td><input type=button value="등록"
					OnClick="javascript:boardInputCheck()"></td>
				<td><input type=button value="취소"
					OnClick="javascript:history.back(-1)"></td>
			</tr>
		</form>
	</table>
</body>
</html>