/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ 공통 >  로그 출력
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.com.cmm.util;


import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;


/**
 * <p>■공통 >  로그 출력</p>
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
public class LogUtil {
	
	/**
	 * ■함수 시작 로그 출력
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	public static void start (Logger logger, String msg, HttpServletRequest req) {
		logger.debug( "\n\n\n▼▼▼▼START : " + getLineInfo(3) + msg + "\n\n");
		if (req != null) {
			parameterPrint(logger, req);
		}
	}
	
	/**
	 * ■함수 종료 로그 출력
	 * =================================
	 * @param logger
	 * @param msg
	 */
	public static void end (Logger logger, String msg) {
		logger.debug( "\n\n\n▲▲▲▲E N D : " + getLineInfo(3) + msg + "\n\n");  
	}
	
	/**
	 * ■라인수취득
	 * =================================
	 * @param n
	 * @return
	 */
    private static String getLineInfo(int n)    {
    	StackTraceElement s = Thread.currentThread().getStackTrace()[n];
    	return String.format("(%s:%s) ", s.getFileName(), s.getLineNumber());
	}

    
    /**
	 * ■Parameter 정보 출력
	 * =================================
     * @param logger
     * @param param
     */
    @SuppressWarnings({ "rawtypes" })
	private static void parameterPrint (Logger logger, HttpServletRequest req) {
		
    	if (req == null) {
    		return;
    	}
		
    	logger.debug("■Parameter 정보");
		Enumeration eNames = req.getParameterNames();
		if (eNames.hasMoreElements()) {
			//String title = "Parameters";
			//Map entries = new TreeMap();
			while (eNames.hasMoreElements()) {
				String name = (String) eNames.nextElement();
				String[] values = req.getParameterValues(name);
				if (values.length > 0) {
					String value = values[0];
					for (int i = 1; i < values.length; i++) {
						value += "," + values[i];
					}
					//System.out.println(name+" : "+value);
			    	logger.debug("■ "+ String.format("%-40s", name) + ":" + String.format("%-40s", value));
				}
			}
		}		
		
    	logger.debug("■Attribute 정보");
    	Enumeration<String> attrNames = req.getAttributeNames(); 
    	while(attrNames.hasMoreElements()){
            String attrName = attrNames.nextElement();
            Object attrValue = req.getAttribute(attrName);
            System.out.println(attrName + " : " + attrValue);
    	}

//    	logger.debug("■Session 정보 : AttributeNames");
//    	HttpSession mySession = req.getSession();
//    	Enumeration<String> sessNames = mySession.getAttributeNames(); 
//    	while(sessNames.hasMoreElements()){
//            String attrName = sessNames.nextElement();
//            Object attrValue = mySession.getAttribute(attrName);
//	    	logger.debug("■ "+ String.format("%-40s", attrName) + ":" + String.format("%-40s", attrValue));
//    	}
//    	logger.debug("■Session 정보 : ValueNames");
//    	String[] values = mySession.getValueNames();
//    	for(int i=0; i<values.length; i++) {
//            Object attrValue = mySession.getValue(values[i]);
//	    	logger.debug("■ "+ String.format("%-40s", values[i]) + ":" + String.format("%-40s", attrValue));
//    	}
//
//    	logger.debug("■ getAttributeNames 정보");
//		Arrays.sort(req.getAttributeNames(), String.CASE_INSENSITIVE_ORDER);
//		List<String> list1 = Arrays.asList(param.getAttributeNames());
//	    for (String nameInfo : list1) {
//	    	logger.debug("■ "+ String.format("%-40s", nameInfo) + ":" + String.format("%-40s", param.getAttribute(nameInfo)));
//	    }
//
//    	logger.debug("■ getParamNames 정보");
//    	if (param == null) {
//    		return;
//    	}
//		Arrays.sort(param.getParamNames(), String.CASE_INSENSITIVE_ORDER);
//		List<String> list2 = Arrays.asList(param.getParamNames());
//	    for (String nameInfo : list2) {
//	    	logger.debug("■ "+ String.format("%-40s", nameInfo) + ":" + String.format("%-40s", req.getParamValueString(nameInfo)));
//	    } 
//
//    	logger.debug("■ getSysParamNames 정보");
//		Arrays.sort(param.getSysParamNames(), String.CASE_INSENSITIVE_ORDER);
//		List<String> list3 = Arrays.asList(param.getSysParamNames());
//	    for (String nameInfo : list3) {
//	    	logger.debug("■ "+ String.format("%-40s", nameInfo) + ":" + String.format("%-40s", req.getParamValueString(nameInfo)));
//	    }
//	    
//    	logger.debug("■ getRequestHeaderNames 정보");
//		Arrays.sort(param.getRequestHeaderNames(), String.CASE_INSENSITIVE_ORDER);
//		List<String> list4 = Arrays.asList(param.getRequestHeaderNames());
//	    for (String nameInfo : list4) {
//	    	logger.debug("■ "+ String.format("%-40s", nameInfo) + ":" + String.format("%-40s", req.getParamValueString(nameInfo)));
//	    }

	}

}
