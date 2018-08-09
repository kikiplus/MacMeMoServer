<%@page import="utils.ErrorLogUtils"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.util.Enumeration"%>
<%@page import="vo.Bucket"%>
<%@page import="api.MobileAPIController"%>
<%@page import="utils.XMLParser"%>
<%@page import="utils.FileUpload"%>
<%
	request.setCharacterEncoding("UTF-8");

	String requestMethod = request.getMethod(); // POST전송인지 GET 전송인지 판별한다.
	System.out.println("@@ uploadFile requestMethod => " + requestMethod + "\n");
	
	if (requestMethod.equals("POST")) {
		String resultPath = null;
		String idx = request.getHeader("idx");
		String fileName = request.getHeader("filename");
		System.out.println("@@ uploadFile idx : "+ idx);
		System.out.println("@@ uploadFile fileName : "+ fileName);
		
		if (idx == null || fileName == null) {
			System.out.println("@@ uploadFile image file idx : " + idx + ", fileName : " + fileName);
			out.println("image parameter Error");
		} else {
			Bucket bucket = new Bucket();
			bucket.setIdx(Integer.valueOf(idx)); // 웹서버 컨테이너 경로 String
			String savePath = XMLParser.getXMLObject("fileUploadPath");
			resultPath = FileUpload.upload(request, savePath);
			JSONObject jsonObj = null;
			if (resultPath == null) {
				out.println("image parameter Error");
				System.out.println("## uploadFile Fail => " + jsonObj + "\n");
			} else {
				bucket.setImageUrl(resultPath);
				jsonObj = MobileAPIController.uploadImageFile(bucket);
				out.print(jsonObj);
				System.out.println("@@ uploadFile OK => " + jsonObj + "\n");
			}
		}
	}else{
		System.out.println("@@ uploadFile request no post\n");
	}

%>
