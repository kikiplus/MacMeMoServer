<%@page import="dao.VersionDao"%>
<%@page import="dao.MobileUserDao"%>
<%@page import="vo.MobileUser"%>
<%@page import="dao.UpdateAppDao"%>
<%@page import="vo.UpdateApp"%>
<%@page import="utils.XMLParser"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="CheckSession.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메모가지 관리자</title>
</head>
<body class="homepage">
	<div class="inner">
		<b>사용자 PUSH 정보 페이지</b>
		<form name=board method=post>
			<div style="height: 1000px; overflow: auto; font-size:1.5em;" >
				<table width="100%" cellpadding="0" cellspacing="0" border="0">
					<tr height="5">
						<td width="5"></td>
					</tr>
					<tr align="center">
						<td width="40">nickname</td>
						<td width="300">Push</td>
					</tr>
					<tr height="20" align="center">
					</tr>
					<tr height="1" bgcolor="#D2D2D2">
						<td colspan="6"></td>
					</tr>
					<tr height="1" bgcolor="#82B5DF">
						<td colspan="9" width="752"></td>
					</tr>
					<%
						ArrayList<MobileUser> userList = (ArrayList<MobileUser>) MobileUserDao.selecetMobileUser();
						int nLastestVersion = 0;
						for (int i = 0; i < userList.size(); i++) {
					%>
					<tr align=left height="70" >
						<td width="40"><%=userList.get(i).getUserNickName()%></td>
						<td width="300"><%=userList.get(i).getGcmToken()%></td>
					</tr>

					<%
						}
					%>
				
				</table>
			</div>
			<table width="100%" cellpadding="0" cellspacing="0" border="0">
				<tr>
					<td colspan="4" height="30"></td>
				</tr>
				<tr align="center">
					<td><input type=button value="홈"
						Onclick="javascript:pass('../kikiMain.html')"></td>

				</tr>
				<tr height="100">
					<td colspan="6"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>

