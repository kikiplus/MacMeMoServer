package utils;

import java.io.FileInputStream;
import java.io.*;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * XML �뙆�떛 �쑀�떥 �겢�옒�뒪
 * 
 * @author grapegirl
 */
public class XMLParser {

	/**
	 * �꽌踰� �솚寃쎌꽕�젙 �봽濡쒗띁�떚瑜� 媛��졇�삤湲� �쐞�븳 硫붿냼�뱶
	 * 
	 * @param keyName
	 * @return KeyValue
	 */
	public static String getXMLObject(String keyName) {
		Properties properties = new Properties();

		try {
			String configFile = "property.xml";
			FileInputStream  in = getFileInputStream(configFile);
			properties.loadFromXML(in);
			
			String value = properties.getProperty(keyName);
			System.out.println("getXMLObject key : " + keyName + " value : " + value);
			return value;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 吏덉쓽臾몄쓣 媛��졇�삤湲� �쐞�븳 硫붿냼�뱶
	 * 
	 * @param 吏덉쓽臾�
	 *            �씠由�
	 * @return �빐�떦 吏덉쓽臾�
	 */
	public static String getSqlFromXML(String sqlName) {
		Properties properties = new Properties();

		try {
			FileInputStream  in = getFileInputStream("sql.xml");
			properties.loadFromXML(in);

			return (String) properties.get(sqlName);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static FileInputStream getFileInputStream(String fileName) {
		FileInputStream in = null;
		URL url = XMLParser.class.getResource("");
		System.out.println("@@ path : " + url.getPath() );
		String parent = url.getPath();
		int lastIndex = parent.lastIndexOf("/WEB-INF/");
		String path =  parent.substring(0, lastIndex + 9) + fileName;  
		System.out.println("@@ path2 : "+ path);
		
		try {
			in = new FileInputStream(path);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return in;
	}
}
