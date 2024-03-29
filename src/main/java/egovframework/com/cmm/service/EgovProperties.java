/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ properties값들을 파일로부터 읽어와   Globals클래스의 정적변수로 로드시켜주는 클래스로
 *                  문자열 정보 기준으로 사용할 전역변수를 시스템 재시작으로 반영할 수 있도록 한다.
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.com.cmm.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




/**
 * <p>■properties값들을 파일로부터 읽어와   Globals클래스의 정적변수로 로드시켜주는 클래스로</p>
 *      문자열 정보 기준으로 사용할 전역변수를 시스템 재시작으로 반영할 수 있도록 한다.
 * <p>COPYRIGHT: Copyright (c) 2003</p>
 * <p>COMPANY: (LTD)KYOBOBOOK</p>
 * <DL>
 *   <DT>처리순.<BR>
 *     <DD>.<BR>
 * <BR>
 *   <DT>전제조건.<BR>
 *     <DD>개발환경 : jdk8, resin 3.1<BR>
 * </DL>
 * <BR>
 *
 * @author   
 * @version  1.0
 * @since    1.0
 */
public class EgovProperties {

	
	/**
	 * ■
	 * =================================
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(EgovProperties.class);

	
	/**
	 * ■프로퍼티값 로드시 에러발생하면 반환되는 에러문자열
	 * =================================
	 */
	public static final String ERR_CODE = " EXCEPTION OCCURRED";

	
	/**
	 * ■프로퍼티값 로드시 에러발생하면 반환되는 에러문자열
	 * =================================
	 */
	public static final String ERR_CODE_FNFE = " EXCEPTION(FNFE) OCCURRED";

	
	/**
	 * ■프로퍼티값 로드시 에러발생하면 반환되는 에러문자열
	 * =================================
	 */
	public static final String ERR_CODE_IOE = " EXCEPTION(IOE) OCCURRED";

	
	/**
	 * ■파일구분자
	 * =================================
	 */
	static final char FILE_SEPARATOR = File.separatorChar;


	
	/**
	 * ■프로퍼티 파일의 물리적 위치
	 * =================================
	 */
	/*public static final String GLOBALS_PROPERTIES_FILE
	= System.getProperty("user.home") + System.getProperty("file.separator") + "egovProps"
	+ System.getProperty("file.separator") + "globals.properties";*/


	
	/**
	 * ■
	 * =================================
	 */
	public static final String RELATIVE_PATH_PREFIX = EgovProperties.class.getResource("").getPath()
		+ System.getProperty("file.separator") + ".." + System.getProperty("file.separator")
		+ ".." + System.getProperty("file.separator") + ".." + System.getProperty("file.separator");


	
	/**
	 * ■
	 * =================================
	 */
	public static final String GLOBALS_PROPERTIES_FILE = RELATIVE_PATH_PREFIX + "egovProps"
		+ System.getProperty("file.separator") + "globals.properties";


	/**
	 * ■인자로 주어진 문자열을 Key값으로 하는 상대경로 프로퍼티 값을 절대경로로 반환한다(Globals.java 전용)
	 * =================================
	 * @param keyName String
	 * @return String

	public static String getPathProperty(String keyName){
		String value = ERR_CODE;
		value="99";
		debug(GLOBALS_PROPERTIES_FILE + " : " + keyName);
		FileInputStream fis = null;
		try{
			Properties props = new Properties();
			fis  = new FileInputStream(GLOBALS_PROPERTIES_FILE);
			props.load(new java.io.BufferedInputStream(fis));
			value = props.getProperty(keyName).trim();
			value = RELATIVE_PATH_PREFIX + "egovProps" + System.getProperty("file.separator") + value;
		}catch(FileNotFoundException fne){
			debug(fne);
		}catch(IOException ioe){
			debug(ioe);
		}catch(Exception e){
			debug(e);
		}finally{
			try {
				if (fis != null) fis.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
		return value;
	}
	*/



	
	/**
	 * ■인자로 주어진 문자열을 Key값으로 하는 프로퍼티 값을 반환한다(Globals.java 전용)
	 * =================================
	 * @param keyName String
	 * @return String
	 */
	public static String getProperty(String keyName) {
		String value = ERR_CODE;
		value = "99";
		debug(GLOBALS_PROPERTIES_FILE + " : " + keyName);
		FileInputStream fis = null;
		try {
			Properties props = new Properties();
			fis = new FileInputStream(GLOBALS_PROPERTIES_FILE);
			props.load(new java.io.BufferedInputStream(fis));
			value = props.getProperty(keyName).trim();
		} catch (FileNotFoundException fne) {
			debug(fne);
		} catch (IOException ioe) {
			debug(ioe);
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException ioe) {
				debug(ioe);
			}

		}
		return value;
	}

	
	/**
	 * ■주어진 파일에서 인자로 주어진 문자열을 Key값으로 하는 프로퍼티 상대 경로값을 절대 경로값으로 반환한다
	 * =================================
	 * @param fileName String
	 * @param key String
	 * @return String

	public static String getPathProperty(String fileName, String key){
		FileInputStream fis = null;
		try{
			java.util.Properties props = new java.util.Properties();
			fis  = new FileInputStream(fileName);
			props.load(new java.io.BufferedInputStream(fis));
			fis.close();

			String value = props.getProperty(key);
			value = RELATIVE_PATH_PREFIX + "egovProps" + System.getProperty("file.separator") + value;
			return value;
		}catch(java.io.FileNotFoundException fne){
			return ERR_CODE_FNFE;
		}catch(java.io.IOException ioe){
			return ERR_CODE_IOE;
		}finally{
			try {
				if (fis != null) fis.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	*/


	
	/**
	 * ■주어진 파일에서 인자로 주어진 문자열을 Key값으로 하는 프로퍼티 값을 반환한다
	 * =================================
	 * @param fileName String
	 * @param key String
	 * @return String

	public static String getProperty(String fileName, String key){
		FileInputStream fis = null;
		try{
			java.util.Properties props = new java.util.Properties();
			fis  = new FileInputStream(fileName);
			props.load(new java.io.BufferedInputStream(fis));
			fis.close();

			String value = props.getProperty(key);
			return value;
		}catch(java.io.FileNotFoundException fne){
			return ERR_CODE_FNFE;
		}catch(java.io.IOException ioe){
			return ERR_CODE_IOE;
		}finally{
			try {
				if (fis != null) fis.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	*/


	
	/**
	 * ■주어진 프로파일의 내용을 파싱하여 (key-value) 형태의 구조체 배열을 반환한다.
	 * =================================
	 * @param property String
	 * @return ArrayList
	 */
	@SuppressWarnings("unused")
	public static ArrayList<Map<String, String>> loadPropertyFile(String property) {

		// key - value 형태로 된 배열 결과
		ArrayList<Map<String, String>> keyList = new ArrayList<Map<String, String>>();

		String src = property.replace('\\', FILE_SEPARATOR).replace('/', FILE_SEPARATOR);
		FileInputStream fis = null;
		try {

			File srcFile = new File(src);
			if (srcFile.exists()) {

				java.util.Properties props = new java.util.Properties();
				fis = new FileInputStream(src);
				props.load(new java.io.BufferedInputStream(fis));
				fis.close();

				int i = 0;
				Enumeration<?> plist = props.propertyNames();
				if (plist != null) {
					while (plist.hasMoreElements()) {
						Map<String, String> map = new HashMap<String, String>();
						String key = (String)plist.nextElement();
						map.put(key, props.getProperty(key));
						keyList.add(map);
					}
				}
			}
		} catch (FileNotFoundException ex) {
			debug("FileNotFoundException:" + ex);
		} catch (IOException ex) {
			debug("IOException:" + ex);
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException ioe) {
				debug(ioe);
			}
		}

		return keyList;
	}


	
	/**
	 * ■시스템 로그를 출력한다.
	 * =================================
	 * @param obj Object
	 */
	private static void debug(Object obj) {
		if (obj instanceof java.lang.Exception) {
			LOGGER.debug("IGNORED: {}", ((Exception)obj).getMessage());
		}
	}
	
	
}

