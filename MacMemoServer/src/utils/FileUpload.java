package utils;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/***
 * @Class Name : FileUpload
 * @Description : 파일 업로더 클래스
 * @since 2015. 8. 4.
 * @author grapegirl
 * @version 1.0
 */
public class FileUpload {

	/**
	 * @Method : upload
	 * @Description :Post 방식으로 전송
	 * @return 파일명
	 */
	public static String upload(HttpServletRequest request, String savePath) {
		// 5Mbyte 제한
		int maxSize = 1024 * 1024 * 5;
		// 업로드 파일명
		String uploadFile = "";

		try {
			MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, "UTF-8",
					new DefaultFileRenamePolicy());
			// 파일업로드
			uploadFile = multi.getFilesystemName("uploadFile");

			File oldFile = new File(savePath + "\\" + uploadFile);

			// System.out.println("파일경로 :" + oldFile.getPath());
			// System.out.println("파일명 :" + uploadFile);
			return uploadFile;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
