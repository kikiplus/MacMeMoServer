package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Calendar;

/***
 * @author grapegirl
 * @version 1.0
 * @Class Name : ErrorLogUtils.java
 * @Description : Error Log 파일 생성 클래스
 * @since 2016.05.02
 */
public class ErrorLogUtils {
	private static final String ERROR_FILE = XMLParser.getXMLObject("fileErrorLogPath");

	/**
	 * 로그 파일 생성
	 *
	 * @param error
	 */
	public static void saveFileEror(String error) {
		String fileName = DateUtil.currentDate() + ".txt";
		File file = new File(ERROR_FILE, fileName);
		FileWriter fw;
		try {
			// 파일이 존재하지 않으면
			if (!file.exists()) {
				// 파일 생성
				file.createNewFile();
				fw = new FileWriter(file.getPath());
			} else {
				// 기존 파일에 추가하기
				fw = new FileWriter(file.getPath(), true);
			}

			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Error Invoke Date : " + getCurrentTime());
			bw.write("\n");
			bw.write(error);
			bw.write("\n");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 로그 파일 생성 시점 반환
	 *
	 * @return 로그 파일 생성 시간
	 */
	private static String getCurrentTime() {
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		int misecond = calendar.get(Calendar.MILLISECOND);

		String time = hour + ":" + minute + ":" + second + ":" + misecond;
		return time;
	}

	public static class UncaughtExceptionHandlerApplication implements Thread.UncaughtExceptionHandler {
		@Override
		public void uncaughtException(Thread thread, Throwable ex) {

			// 예외상황이 발행 되는 경우 작업
			String error = getStackTrace(ex);

			saveFileEror(error);

			// 현재 프로세스 종료
			System.exit(10);

		}
	}

	/**
	 * 메시지로 변환
	 *
	 * @param th
	 * @return
	 */
	private static String getStackTrace(Throwable th) {

		final Writer result = new StringWriter();
		final PrintWriter printWriter = new PrintWriter(result);

		Throwable cause = th;
		while (cause != null) {
			cause.printStackTrace(printWriter);
			cause = cause.getCause();
		}
		final String stacktraceAsString = result.toString();
		printWriter.close();

		return stacktraceAsString;
	}
}
