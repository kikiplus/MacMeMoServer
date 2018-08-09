<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
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
	System.out.println("@@ uploadDBFile requestMethod => " + requestMethod + "\n");
	
	if (requestMethod.equals("POST")) {
		String resultPath = null;
		String nickname = request.getHeader("nickname");
		String fileName = request.getHeader("filename");
		System.out.println("@@ uploadDBFile nickname : "+ nickname);
		System.out.println("@@ uploadDBFile fileName : "+ fileName);
		
		if (fileName == null) {
			out.println("uploadDBFile file is null");
		} else {
			String date = fileName.substring(0, fileName.length() - 3);
			if (nickname == null) {
				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
				String currentTime = sdf.format(calendar.getTime());
				nickname = "SYSTEM_" + currentTime;
			}
			System.out.println("@@ uploadDBFile nickname : " + nickname + ", fileName : " + fileName);

			String savePath = XMLParser.getXMLObject("DBfileUploadPath");
			resultPath = FileUpload.upload(request, savePath);
			JSONObject jsonObj = null;
			if (resultPath != null) {
				jsonObj = MobileAPIController.uploadDBFile(nickname, resultPath, date);
				out.print(jsonObj);
				System.out.println("@@ uploadDBFile OK => " + jsonObj + "\n");
			} else {
				System.out.println("## uploadDBFile Fail => " + jsonObj + "\n");
			}
		}
	}else{
		System.out.println("@@ uploadDBFile request no post\n");
	}
	
%>
