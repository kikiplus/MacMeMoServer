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
	<b>버킷 목록 페이지</b>
	<form name=board method=post action="/jsp/BucketDetails.jsp">
		<table width="100%" cellpadding="0" cellspacing="0" border="0">
			<tr height="5">
				<td width="5"></td>
			</tr>
			<tr align="center">
				<td width="100">idx</td>
				<td width="100">닉네임</td>
				<td width="100">카데고리</td>
				<td width="100">숨김여부</td>
				<td width="379">버킷 내용</td>
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
				for (int i = 0; i < bucketList.size(); i++) {
			%>
			<tr align="center" height="30">
				<td width="100"><input name="idx" type="radio"
					value="<%=bucketList.get(i).getIdx()%>"> <%=bucketList.get(i).getIdx()%></td>
				<td width="100"><%=bucketList.get(i).getNickName()%></td>
				<td width="100"><%=bucketList.get(i).getCategoryName()%></td>
				<td width="100"><%=bucketList.get(i).getIsHidden()%></td>
				<td width="379"><%=bucketList.get(i).getContent()%></td>
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
				<td><select style="width: 300px;" id="hiddenCode" name="hidden">
						<option value="Y">숨김</option>
						<option value="N">숨김해제</option>
				</select></td>
				<td><input type=button value="업데이트"
					Onclick="javascript:passForm('/jsp/UpdateHidden.jsp')">
					<input type=button value="상세"
					Onclick="javascript:passForm('/jsp/BucketDetails.jsp')">
				</td>
			</tr>
		<%
			}
		%>
		<tr height="100">
			<td colspan="6"></td>
		</tr>
	</table>
	</form>
</body>
</html>
