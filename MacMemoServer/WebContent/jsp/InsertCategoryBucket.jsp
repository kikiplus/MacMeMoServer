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
	// 입력 체크 함수
	function boardInputCheck() {
		var form = document.board;
		if (!form.categoryCode.value) {
			form.categoryCode.focus();
			return;
		}
		if (!form.categoryName.value) {
			form.categoryName.focus();
			return;
		}

		form.submit();
	}
</script>
<title>메모가지 관리자</title>
</head>
<body>
	<b>카테고리 등록 페이지</b>
	<table width="70%" cellpadding="0" cellspacing="0" border="0">
		<form name=board method=post
			action="AddCategoryBucket.jsp">
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
				<td width=100>카테고리코드</td>
				<td><input name="categoryCode" type=edit value=""
					maxlength="200"></td>
			</tr>
			<tr height="50">
				<td width=100>카테고리명</td>
				<td><input name="categoryName" type=edit value=""
					maxlength="300"></td>
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