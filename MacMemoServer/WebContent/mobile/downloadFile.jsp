<%@page import="utils.ErrorLogUtils"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.File"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.util.Enumeration"%>
<%@page import="vo.Bucket"%>
<%@page import="api.MobileAPIController"%>
<%@page import="utils.XMLParser"%>
<%@page import="utils.FileUpload"%>
<%
	request.setCharacterEncoding("UTF-8");

	String resultPath = null;
	String idx = request.getParameter("idx");
	System.out.println("@@ downloadFile idx : " + idx);
	if (idx == null) {
		out.println("image download parameter Error");
		System.out.println("## downloadFile idx Fail \n");
	} else {
		File file = MobileAPIController.downloadImageFile(Integer.valueOf(idx));
		if (file != null) {
			String dFileName = file.getName();
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition",
					"attachment; filename=" + URLEncoder.encode(dFileName, "utf-8") + ";");
			byte bytestream[] = new byte[1024];
			out.clear();
			if (file.isFile() && file.length() > 0) {
				java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
				int i;
				while ((i = fileInputStream.read()) != -1) {
					out.write(i);
				}
				fileInputStream.close();
				System.out.println("@@ downloadFile OK => " + file.getPath() + "\n");
			} else {
				out.println("image file Error");
				System.out.println("## downloadFile file Fail \n");
			}
		}
	}
%>
