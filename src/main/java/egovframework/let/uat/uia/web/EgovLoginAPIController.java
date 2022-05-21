/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ 일반 로그인을 처리하는 컨트롤러 클래스
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.let.uat.uia.web;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.egovframe.rte.fdl.cmmn.trace.LeaveaTrace;
import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.ResponseCode;
import egovframework.com.cmm.service.ResultVO;
import egovframework.let.uat.uia.service.EgovLoginService;



/**
 * <p>■일반 로그인을 처리하는 컨트롤러 클래스</p>
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
@Controller
public class EgovLoginAPIController {

	
	/**
	 * ■로그
	 * =================================
	 */
	private final Logger logger = LoggerFactory.getLogger(EgovLoginAPIController.class);

	
	/**
	 * ■
	 * =================================
	 */
	/** EgovLoginService */
	@Resource(name = "loginService")
	private EgovLoginService loginService;

	
	/**
	 * ■
	 * =================================
	 */
	/** EgovMessageSource */
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

	
	/**
	 * ■
	 * =================================
	 */
	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	
	/**
	 * ■
	 * =================================
	 */
	/** TRACE */
	@Resource(name = "leaveaTrace")
	LeaveaTrace leaveaTrace;

	
	/**
	 * ■일반 로그인을 처리한다
	 * =================================
	 * @param     vo        - 아이디, 비밀번호가 담긴 LoginVO
	 * @param     request   - 세션처리를 위한 HttpServletRequest
	 * @return    result    - 로그인결과(세션정보)
	 * @exception Exception
	 */
//	@Consumes({"text/html;charset=UTF-8","application/json;charset=UTF-8"})
	@RequestMapping(value = "/uat/uia/actionLoginAPI.do", consumes = {MediaType.APPLICATION_JSON_VALUE , MediaType.TEXT_HTML_VALUE})
	public @ResponseBody HashMap<String, Object> actionLogin(@RequestBody LoginVO loginVO, HttpServletRequest request) throws Exception {

		egovframework.com.cmm.util.LogUtil.start(logger, "START", request);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");
		
		HashMap<String,Object> resultMap = new HashMap<String,Object>();

		// 1. 일반 로그인 처리
		LoginVO loginResultVO = loginService.actionLogin(loginVO);

		boolean loginPolicyYn = true;

		if (loginResultVO != null && loginResultVO.getId() != null && !loginResultVO.getId().equals("")
			&& loginPolicyYn) {

			request.getSession().setAttribute("LoginVO", loginResultVO);
			resultMap.put("resultVO", loginResultVO);
			resultMap.put("resultCode", "200");
			resultMap.put("resultMessage", "성공 !!!");
		} else {
			resultMap.put("resultVO", loginResultVO);
			resultMap.put("resultCode", "300");
			resultMap.put("resultMessage", egovMessageSource.getMessage("fail.common.login"));
		}

		return resultMap;

	}

	
	/**
	 * ■
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	@RequestMapping(value = "/uat/uia/actionLoginJWT.do")
	public @ResponseBody HashMap<String, Object> actionLoginJWT(@RequestBody LoginVO loginVO, HttpServletRequest request, ModelMap model) throws Exception {

		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");


		// 1. 일반 로그인 처리
		LoginVO resultVO = loginService.actionLogin(loginVO);

		boolean loginPolicyYn = true;
		HashMap<String, Object> resultMap = new HashMap<String, Object>();

		if (resultVO != null && resultVO.getId() != null && !resultVO.getId().equals("") && loginPolicyYn) {

			request.getSession().setAttribute("LoginVO", resultVO);
			resultMap.put("resultVO", resultVO);
			resultMap.put("resultCode", "0");
			resultMap.put("resultMessage", "성공 !!!");
		} else {
			resultMap.put("resultVO", resultVO);
			resultMap.put("resultCode", "100");
			resultMap.put("resultMessage", egovMessageSource.getMessage("fail.common.login"));
		}
		return resultMap;
	}

	
	/**
	 * ■로그아웃
	 * =================================
	 * @return    request
	 * @exception Exception
	 */
	@RequestMapping(value = "/uat/uia/actionLogoutAPI.do")
	public @ResponseBody ResultVO actionLogoutJSON(HttpServletRequest request) throws Exception {

		egovframework.com.cmm.util.LogUtil.start(logger, "■로그아웃", null);
		ResultVO resultVO = new ResultVO();
		RequestContextHolder.getRequestAttributes().removeAttribute("LoginVO", RequestAttributes.SCOPE_SESSION);
		resultVO.setResultCode(ResponseCode.SUCCESS.getCode());
		resultVO.setResultMessage(ResponseCode.SUCCESS.getMessage());
		egovframework.com.cmm.util.LogUtil.end(logger, "■로그아웃");
		return resultVO;
	}

}


