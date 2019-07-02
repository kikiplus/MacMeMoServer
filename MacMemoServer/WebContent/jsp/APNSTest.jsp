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
	//페이지 이동
	function pass(url) {
		location.href = url;
	}
	// 입력 체크 함수
	function apnsInputCheck() {
		var form = document.apns;

		if (form.sendAll.checked) {
			form.submit();
		} else {
			if (!form.regId.value) {
				alert('보낼 RegId을 입력해주세요');
				form.regId.focus();
				return;
			}

			if (!form.certPassword.value) {
				alert('인증서 암를 입력해주세요');
				form.certPassword.focus();
				return;
			}
			
			
			if (!form.sendMessage.value) {
				alert('보낼 메시지를 입력해주세요');
				form.sendMessage.focus();
				return;
			}
			
			form.submit();

		}
	}
	// 전체 발송 함수
	function sendAllMsg() {
		var form = document.apns;
		if (!form.sendMessage.value) {
			alert('보낼 메시지를 입력해주세요');
			form.sendMessage.focus();
			return;
		}

		form.submit();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메모가지 관리자</title>
</head>
<body>
	<table width="70%" cellpadding="0" cellspacing="0" border="0">
		<form name=apns method=post action="sendAPNSMessage.jsp">
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
				<td>APNS Device Token</td>
				<td><input name="regId" type=edit value="" maxlength="300"></td>
			</tr>
			<tr height="10">
				<td>Certification Password</td>
				<td><input name="certPassword" type=edit value="" maxlength="100"></td>
			</tr>
			
			<tr height="10">
				<td>전체 발송</td>
				<td><input name="sendAll" type="checkbox" value="Y"
					OnClick="javascript:sendAllMsg()"></td>
			</tr>
			<tr height="10">
				<td>전송 메시지</td>
				<td><textarea name="sendMessage" cols="50" rows="13"></textarea></td>
			</tr>

			<tr height="10">
				<td><input type=button value="전송"
					OnClick="javascript:apnsInputCheck()"></td>

				<td><input type=button value="홈"
					Onclick="javascript:pass('/kikiMain.html')"></td>
			</tr>
		</form>
	</table>
</body>
</html>