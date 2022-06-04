/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ 공통서비스의 trace 처리 클래스
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.com.cmm;

import org.egovframe.rte.fdl.cmmn.trace.handler.TraceHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * <p>■공통서비스의 trace 처리 클래스</p>
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
public class EgovComTraceHandler implements TraceHandler {


	
	/**
	 * ■로그변수
	 * =================================
	 */
	private final Logger logger = LoggerFactory.getLogger(EgovComTraceHandler.class);

	
	/**
	 * ■발생된 메시지를 출력한다.
	 * =================================
	 * @param clazz
	 * @param message
	 */
    public void todo(Class<?> clazz, String message) {
    	//System.out.println("log ==> DefaultTraceHandler run...............");
    	logger.debug("[TRACE]CLASS::: {}", clazz.getName());
    	logger.debug("[TRACE]MESSAGE::: {}", message);
    	//이곳에서 후속처리로 필요한 액션을 취할 수 있다.
    }
    
}
