<%@page import="utils.ErrorLogUtils"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="vo.Comment"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="vo.MobileUser"%>
<%@page import="api.MobileAPIController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String requestMethod = request.getMethod(); // POST전송인지 GET 전송인지 판별한다.
	System.out.println("@@ insertComment requestMethod => " + requestMethod + "\n");
	
	if (requestMethod.equals("POST")) {
		String nickName = request.getParameter("NICKNAME");
		String content = request.getParameter("CONTENT");
		String bucketNo = request.getParameter("BUCKET_NO");
		System.out.println("@@ insertComment nickName : " + nickName);
		System.out.println("@@ insertComment content : " + content);
		System.out.println("@@ insertComment bucketNo : " + bucketNo);

		if (bucketNo == null || nickName == null || content == null) {
			JSONObject jsonObj = MobileAPIController.getJSONError();
			out.print(jsonObj);
			System.out.println("## comment input data is null : " + jsonObj);
		} else {
			Comment comment = new Comment();
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String currentTime = sdf.format(calendar.getTime());
			comment.setDate(currentTime);
			comment.setNickName(nickName);
			comment.setContent(content);

			int no = Integer.valueOf(bucketNo);
			comment.setBucketNo(no);
			JSONObject jsonObj = MobileAPIController.insertComment(comment);
			out.print(jsonObj);
			System.out.println("@@ insertComment => " + jsonObj + "\n");
		}
	}else{
		System.out.println("@@ insertComment request no post\n");
	}

	
%>
