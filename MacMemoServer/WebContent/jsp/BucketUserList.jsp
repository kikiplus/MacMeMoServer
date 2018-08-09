<%@page import="java.util.HashMap"%>
<%@page import="dao.BucketDao"%>
<%@page import="vo.Bucket"%>
<%@page import="dao.VersionDao"%>
<%@page import="vo.Version"%>
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
	<b>사용자별 버킷 목록 페이지</b>
	<table width="100%" cellpadding="0" cellspacing="0" border="0">
		<tr height="5">
			<td width="5"></td>
		</tr>
		<tr align="center">
			<td width="100">닉네임</td>
			<td width="100">공유수</td>

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
			String sql = XMLParser.getSqlFromXML("selectBucket");
			ArrayList<Bucket> bucketList = (ArrayList<Bucket>) BucketDao.selecetBucketCategory(sql);
			HashMap<String, Integer> userList = new HashMap<String, Integer>();
			ArrayList<String> userNameList = new ArrayList<String>();
			for (int i = 0; i < bucketList.size(); i++) {
				Bucket bucket = bucketList.get(i);
				if (!userList.containsKey(bucket.getNickName())) {
					userList.put(bucket.getNickName(), 1);
					userNameList.add(bucket.getNickName());
				} else {
					Integer count = userList.get(bucket.getNickName());
					count++;
					userList.put(bucket.getNickName(), count);
				}
			}

			System.out.println("@@ userList size : " + userList.size());
			for (int i = 0; i < userNameList.size(); i++) {
				String userNickName = userNameList.get(i);
		%>
		<tr align="center" height="30">
			<td width="100"><%=userNickName%></td>
			<td width="379"><%=userList.get(userNickName)%></td>
		</tr>
		<%
			}
		%>
	</table>

	<table width="100%" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td colspan="4" height="30"></td>
		</tr>
		
		<%
			if (value.equals("guest")) {
		%>
		<tr align="center">
			<td><input type=button value="홈"
					Onclick="javascript:pass('/guestMain.html')"> 
				</td>
			</tr>
		<%
		   }else{
		%>
		<tr align="center">
			<td><input type=button value="홈"
				Onclick="javascript:pass('/kikiMain.html')"></td>
		</tr>
		<%
			}
		%>
		<tr height="100">
			<td colspan="6"></td>
		</tr>
	</table>
</body>
</html>
