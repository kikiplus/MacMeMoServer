<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>파일 업로드 폼</title>
</head>
<body>

	<form name="fileForm" method="POST"
		action="../mobile/uploadFile.jsp" enctype="multipart/form-data">
		<input type="text" name="idx" id="idx"> 
		<input type="file"
			name="uploadFile" id="uploadFile"> <input type="submit"
			value="전송">
	</form>
</body>
</html>
