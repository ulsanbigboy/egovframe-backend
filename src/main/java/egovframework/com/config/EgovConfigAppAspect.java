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
package egovframework.com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.util.AntPathMatcher;

import egovframework.com.cmm.EgovComExcepHndlr;
import egovframework.com.cmm.EgovComOthersExcepHndlr;
import egovframework.com.cmm.interceptor.AopExceptionTransfer;
import org.egovframe.rte.fdl.cmmn.aspect.ExceptionTransfer;
import org.egovframe.rte.fdl.cmmn.exception.handler.ExceptionHandler;
import org.egovframe.rte.fdl.cmmn.exception.manager.DefaultExceptionHandleManager;
import org.egovframe.rte.fdl.cmmn.exception.manager.ExceptionHandlerService;


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
/**
 * @ClassName : EgovConfigAppAspect.java
 * @Description : Aspect 설정
 *
 * @author : 윤주호
 * @since  : 2021. 7. 20
 * @version : 1.0
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일              수정자               수정내용
 *  -------------  ------------   ---------------------
 *   2021. 7. 20    윤주호               최초 생성
 * </pre>
 *
 */
@Configuration
@EnableAspectJAutoProxy
public class EgovConfigAppAspect {

	@Autowired
	AntPathMatcher antPathMatcher;

	@Bean
	public EgovComExcepHndlr egovHandler() {
		EgovComExcepHndlr egovComExcepHndlr = new EgovComExcepHndlr();
		return egovComExcepHndlr;
	}

	@Bean
	public EgovComOthersExcepHndlr otherHandler() {
		EgovComOthersExcepHndlr egovComOthersExcepHndlr = new EgovComOthersExcepHndlr();
		return egovComOthersExcepHndlr;
	}

	
	/**
	 * ■함수 시작 로그 출력
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	@Bean
	public DefaultExceptionHandleManager defaultExceptionHandleManager(ExceptionHandler egovHandler) {
		DefaultExceptionHandleManager defaultExceptionHandleManager = new DefaultExceptionHandleManager();
		defaultExceptionHandleManager.setReqExpMatcher(antPathMatcher);
		defaultExceptionHandleManager.setPatterns(new String[] {"**service.impl.*"});
		defaultExceptionHandleManager.setHandlers(new ExceptionHandler[] {egovHandler});
		return defaultExceptionHandleManager;
	}
	
	/**
	 * ■함수 시작 로그 출력
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	@Bean
	public DefaultExceptionHandleManager otherExceptionHandleManager() {
		DefaultExceptionHandleManager defaultExceptionHandleManager = new DefaultExceptionHandleManager();
		defaultExceptionHandleManager.setReqExpMatcher(antPathMatcher);
		defaultExceptionHandleManager.setPatterns(new String[] {"**service.impl.*"});
		defaultExceptionHandleManager.setHandlers(new ExceptionHandler[] {otherHandler()});
		return defaultExceptionHandleManager;
	}
	
	/**
	 * ■함수 시작 로그 출력
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	/**
	 * @return
	 * Exception 발생시 후처리를 위해 표준프레임워크 실행환경의 ExceptionTransfer를 활용하도록  설정
	 */
	@Bean
	public ExceptionTransfer exceptionTransfer(
		@Qualifier("defaultExceptionHandleManager") DefaultExceptionHandleManager defaultExceptionHandleManager,
		@Qualifier("otherExceptionHandleManager") DefaultExceptionHandleManager otherExceptionHandleManager) {
		ExceptionTransfer exceptionTransfer = new ExceptionTransfer();
		exceptionTransfer.setExceptionHandlerService(new ExceptionHandlerService[] {
			defaultExceptionHandleManager, otherExceptionHandleManager
		});
		return exceptionTransfer;
	}
	
	/**
	 * ■함수 시작 로그 출력
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	@Bean
	public AopExceptionTransfer aopExceptionTransfer(ExceptionTransfer exceptionTransfer) {
		AopExceptionTransfer aopExceptionTransfer = new AopExceptionTransfer();
		aopExceptionTransfer.setExceptionTransfer(exceptionTransfer);
		return aopExceptionTransfer;
	}

}
