/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ 인증여부 체크 인터셉터
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.com.cmm.interceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;



/**
 * <p>■인증여부 체크 인터셉터</p>
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
public class AuthenticInterceptor extends WebContentInterceptor {

	
	/**
	 * ■세션에 계정정보(LoginVO)가 있는지 여부로 인증 여부를 체크한다.
	 *   계정정보(LoginVO)가 없다면, 로그인 페이지로 이동한다.
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {

		LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();

		if (loginVO.getId() != null) {
			return true;
		} else {
//			ModelAndView modelAndView = new ModelAndView("redirect:/uat/uia/egovLoginUsr.do");
			ModelAndView modelAndView = new ModelAndView("redirect:http://localhost:3000/login");
			throw new ModelAndViewDefiningException(modelAndView);
		}
	}

}
