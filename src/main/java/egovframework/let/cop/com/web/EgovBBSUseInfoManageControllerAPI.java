/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ 게시판의 이용정보를 관리하기 위한 컨트롤러 클래스
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.let.cop.com.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.exception.EgovBizException;
import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.ResponseCode;
import egovframework.com.cmm.service.ResultVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.let.cop.bbs.service.BoardMasterVO;
import egovframework.let.cop.bbs.service.EgovBBSAttributeManageService;
import egovframework.let.cop.com.service.BoardUseInf;
import egovframework.let.cop.com.service.BoardUseInfVO;
import egovframework.let.cop.com.service.EgovBBSUseInfoManageService;


/**
 * <p>■게시판의 이용정보를 관리하기 위한 컨트롤러 클래스</p>
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
public class EgovBBSUseInfoManageControllerAPI {

	/**
	 * ■로그
	 * =================================
	 */
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * ■EgovBBSUseInfoManageService
	 * =================================
	 */
	@Resource(name = "EgovBBSUseInfoManageService")
	private EgovBBSUseInfoManageService bbsUseService;
	
	/**
	 * ■EgovPropertyService
	 * =================================
	 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;
	
	/**
	 * ■EgovBBSAttributeManageService
	 * =================================
	 */
	@Resource(name = "EgovBBSAttributeManageService")
	private EgovBBSAttributeManageService bbsAttrbService;
	
	/**
	 * ■DefaultBeanValidator
	 * =================================
	 */
	@Autowired
	private DefaultBeanValidator beanValidator;
	
	/**
	 * ■EgovMessageSource
	 * =================================
	 */
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

	/**
	 * ■게시판 사용정보 목록을 조회한다.
	 * =================================
	 * @param bdUseVO
	 * @param sessionVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/cop/com/selectBBSUseInfsAPI.do")
	@ResponseBody
	public ResultVO selectBBSUseInfs(@RequestBody BoardUseInfVO bdUseVO) throws Exception {

		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");



		ResultVO resultVO = new ResultVO();
		Map<String, Object> resultMap = new HashMap<String, Object>();

		if (!EgovUserDetailsHelper.isAuthenticated()) {
			return handleAuthError(resultVO); // server-side 권한 확인
		}

		bdUseVO.setPageUnit(propertyService.getInt("pageUnit"));
		bdUseVO.setPageSize(propertyService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(bdUseVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(bdUseVO.getPageUnit());
		paginationInfo.setPageSize(bdUseVO.getPageSize());

		bdUseVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		bdUseVO.setLastIndex(paginationInfo.getLastRecordIndex());
		bdUseVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		Map<String, Object> map = bbsUseService.selectBBSUseInfs(bdUseVO);
		int totCnt = Integer.parseInt((String)map.get("resultCnt"));

		paginationInfo.setTotalRecordCount(totCnt);

		resultMap.put("resultList", map.get("resultList"));
		resultMap.put("resultCnt", map.get("resultCnt"));
		resultMap.put("paginationInfo", paginationInfo);

		resultVO.setResult(resultMap);
		resultVO.setResultCode(ResponseCode.SUCCESS.getCode());
		resultVO.setResultMessage(ResponseCode.SUCCESS.getMessage());

		return resultVO;
	}

	/**
	 * ■생성된 마스터 게시판을 조회한다.
	 * =================================
	 * @param boardMasterVO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/cop/com/selectNotUsedBdMstrList.do")
	@ResponseBody
	public ResultVO selectNotUsedBdMstrList( BoardMasterVO boardMasterVO) throws Exception {

		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");


		ResultVO resultVO = new ResultVO();

		boardMasterVO.setFirstIndex(0);
		Map<String, Object> resultMap = bbsAttrbService.selectNotUsedBdMstrList(boardMasterVO);

		resultVO.setResult(resultMap);
		resultVO.setResultCode(ResponseCode.SUCCESS.getCode());
		resultVO.setResultMessage(ResponseCode.SUCCESS.getMessage());

		return resultVO;
	}

	/**
	 * ■게시판 사용정보에 대한 상세정보를 조회한다.
	 * =================================
	 * @param bdUseVO
	 * @param sessionVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/cop/com/selectBBSUseInfAPI.do")
	@ResponseBody
	public ResultVO selectBBSUseInf( @RequestBody BoardUseInfVO bdUseVO) throws Exception {

		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");



		ResultVO resultVO = new ResultVO();
		Map<String, Object> resultMap = new HashMap<String, Object>();

		BoardUseInfVO vo = bbsUseService.selectBBSUseInf(bdUseVO);// bbsItrgetId

		if (!EgovUserDetailsHelper.isAuthenticated()) {
			return handleAuthError(resultVO); // server-side 권한 확인
		}

		// 시스템 사용 게시판의 경우 URL 표시
		if ("SYSTEM_DEFAULT_BOARD".equals(vo.getTrgetId())) {
			if (vo.getBbsTyCode().equals("BBST02")) { // 익명게시판
			} else {
				vo.setProvdUrl("/cop/bbs/selectBoardListAPI.do");//bbsId 값을 따로 넘겨줘야 함
			}
		}

		BoardMasterVO boardMasterVO = new BoardMasterVO();
		resultMap = bbsAttrbService.selectNotUsedBdMstrList(boardMasterVO);

		resultMap.put("bdUseVO", vo);

		resultVO.setResult(resultMap);
		resultVO.setResultCode(ResponseCode.SUCCESS.getCode());
		resultVO.setResultMessage(ResponseCode.SUCCESS.getMessage());

		return resultVO;
	}

	/**
	 * ■게시판 사용정보를 등록한다.
	 * =================================
	 * @param bdUseVO
	 * @param bdUseInf
	 * @param sessionVO
	 * @param status
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/cop/com/insertBBSUseInfAPI.do")
	@ResponseBody
	public ResultVO insertBBSUseInf( BoardUseInfVO bdUseVO, BindingResult bindingResult) throws Exception {


		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");


		ResultVO resultVO = new ResultVO();
		Map<String, Object> resultMap = new HashMap<String, Object>();

		if (!EgovUserDetailsHelper.isAuthenticated()) {
			return handleAuthError(resultVO); // server-side 권한 확인
		}

		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();

		beanValidator.validate(bdUseVO, bindingResult);

		if (bindingResult.hasErrors()) {
			resultVO.setResultCode(ResponseCode.INPUT_CHECK_ERROR.getCode());
			resultVO.setResultMessage(ResponseCode.INPUT_CHECK_ERROR.getMessage());
			return resultVO;
		}

		if ("CMMNTY".equals(bdUseVO.getTrgetType())) {
			bdUseVO.setRegistSeCode("REGC06");
		} else if ("CLUB".equals(bdUseVO.getTrgetType())) {
			bdUseVO.setRegistSeCode("REGC05");
		} else {
			bdUseVO.setRegistSeCode("REGC01");
		}

		bdUseVO.setUseAt("Y");
		bdUseVO.setFrstRegisterId(user.getUniqId());

		if (isAuthenticated) {
			bbsUseService.insertBBSUseInf(bdUseVO);

			resultVO.setResultCode(ResponseCode.SUCCESS.getCode());
			resultVO.setResultMessage(ResponseCode.SUCCESS.getMessage());
		}

		return resultVO;
	}

	/**
	 * ■게시판 사용정보를 수정한다.
	 * =================================
	 * @param bdUseVO
	 * @param bdUseInf
	 * @param sessionVO
	 * @param status
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/cop/com/updateBBSUseInfAPI.do")
	@ResponseBody
	public ResultVO updateBBSUseInf(BoardUseInfVO bdUseVO) throws Exception {

		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");



		ResultVO resultVO = new ResultVO();
		Map<String, Object> resultMap = new HashMap<String, Object>();

		if (!EgovUserDetailsHelper.isAuthenticated()) {
			return handleAuthError(resultVO); // server-side 권한 확인
		}

		Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();

		if (isAuthenticated) {
			bbsUseService.updateBBSUseInf(bdUseVO);

			resultVO.setResultCode(ResponseCode.SUCCESS.getCode());
			resultVO.setResultMessage(ResponseCode.SUCCESS.getMessage());
		}

		return resultVO;
	}

	/**
	 * ■게시판 사용 정보를 삭제한다.
	 * =================================
	 * @param bdUseVO
	 * @param bdUseInf
	 * @param sessionVO
	 * @param status
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/cop/com/deleteBBSUseInfAPI.do")
	public String deleteBBSUseInf(@ModelAttribute("searchVO") BoardUseInfVO bdUseVO, @ModelAttribute("bdUseInf") BoardUseInf bdUseInf, SessionStatus status, ModelMap model) throws Exception {

		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");



		if (!EgovUserDetailsHelper.isAuthenticated()) {
			return "cmm/uat/uia/EgovLoginUsr"; // server-side 권한 확인
		}

		Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();

		if (isAuthenticated) {
			bbsUseService.deleteBBSUseInf(bdUseInf);
		}

		return "forward:/cop/com/selectBBSUseInfsAPI.do";
	}

	/**
	 * ■게사판 사용정보 등록을 위한 등록페이지로 이동한다.
	 * =================================
	 * @param bdUseVO
	 * @param sessionVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/cop/com/addBBSUseInfAPI.do")
	public String addBBSUseInf(@ModelAttribute("searchVO") BoardUseInfVO bdUseVO, ModelMap model) throws Exception {

		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");



		if (!EgovUserDetailsHelper.isAuthenticated()) {
			return "cmm/uat/uia/EgovLoginUsr"; // server-side 권한 확인
		}

		return "cop/com/EgovBoardUseInfRegist";
	}

	/**
	 * ■커뮤니티, 동호회에 사용되는 게시판 사용정보에 대한 목록을 조회한다.
	 * =================================
	 * @param bdUseVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/cop/com/selectBBSUseInfsByTrgetAPI.do")
	public String selectBBSUseInfsByTrget(@ModelAttribute("searchVO") BoardUseInfVO bdUseVO, ModelMap model)
		throws Exception {

		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");



		if (!EgovUserDetailsHelper.isAuthenticated()) {
			return "cmm/uat/uia/EgovLoginUsr"; // server-side 권한 확인
		}

		bdUseVO.setPageUnit(propertyService.getInt("pageUnit"));
		bdUseVO.setPageSize(propertyService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(bdUseVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(bdUseVO.getPageUnit());
		paginationInfo.setPageSize(bdUseVO.getPageSize());

		bdUseVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		bdUseVO.setLastIndex(paginationInfo.getLastRecordIndex());
		bdUseVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		Map<String, Object> map = bbsUseService.selectBBSUseInfsByTrget(bdUseVO);
		int totCnt = Integer.parseInt((String)map.get("resultCnt"));

		paginationInfo.setTotalRecordCount(totCnt);

		model.addAttribute("resultList", map.get("resultList"));
		model.addAttribute("resultCnt", map.get("resultCnt"));
		model.addAttribute("trgetId", bdUseVO.getTrgetId());
		model.addAttribute("trgetType", bdUseVO.getTrgetType());
		model.addAttribute("paginationInfo", paginationInfo);

		return "cop/com/EgovBdUseInfListByTrget";
	}

	/**
	 * ■커뮤니티, 동호회에 사용되는 게시판 사용정보를 수정한다.
	 * =================================
	 * @param bdUseVO
	 * @param boardUseInf
	 * @param status
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/cop/com/updateBBSUseInfByTrgetAPI.do")
	public String updateBBSUseInfByTrget(@ModelAttribute("searchVO") BoardUseInfVO bdUseVO,
		@ModelAttribute("boardUseInf") BoardUseInf boardUseInf,
		@RequestParam Map<String, Object> commandMap, SessionStatus status, ModelMap model) throws Exception {

		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");



		if (!EgovUserDetailsHelper.isAuthenticated()) {
			return "cmm/uat/uia/EgovLoginUsr"; // server-side 권한 확인
		}

		String param_trgetId = (String)commandMap.get("param_trgetId");

		Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();

		if (isAuthenticated) {
			boardUseInf.setTrgetId(param_trgetId);
			bbsUseService.updateBBSUseInfByTrget(boardUseInf);
		}

		return "forward:/cop/com/selectBBSUseInfsByTrgetAPI.do";
	}

	/**
	 * ■커뮤니티, 동호회에 사용되는 게시판 사용정보를 등록한다.
	 * =================================
	 * @param bdUseVO
	 * @param boardUseInf
	 * @param status
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/cop/com/insertBBSUseInfByTrgetAPI.do")
	public String insertBBSUseInfByTrget(@ModelAttribute("searchVO") BoardUseInfVO bdUseVO,
		@ModelAttribute("boardUseInf") BoardUseInf boardUseInf,
		@RequestParam Map<String, Object> commandMap, SessionStatus status, ModelMap model) throws Exception {

		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");



		if (!EgovUserDetailsHelper.isAuthenticated()) {
			return "cmm/uat/uia/EgovLoginUsr"; // server-side 권한 확인
		}

		String paramTrgetId = (String)commandMap.get("param_trgetId");
		String bbsId = (String)commandMap.get("bbsId");

		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();

		if (isAuthenticated) {
			boardUseInf.setUseAt("Y");
			boardUseInf.setFrstRegisterId(user.getUniqId());
			boardUseInf.setRegistSeCode("REGC07");
			boardUseInf.setBbsId(bbsId);
			boardUseInf.setTrgetId(paramTrgetId);

			bbsUseService.insertBBSUseInf(boardUseInf);
		}

		return "forward:/cop/com/selectBBSUseInfsByTrgetAPI.do";
	}
	
	
	/**
	 * ■
	 * =================================
	 * @param boardMaster
	 */
	private ResultVO handleAuthError(ResultVO resultVO) {
		resultVO.setResultCode(ResponseCode.AUTH_ERROR.getCode());
		resultVO.setResultMessage(ResponseCode.AUTH_ERROR.getMessage());
		return resultVO;
	}

	/**
	 * ■운영자 권한을 확인한다.(로그인 여부를 확인한다.)
	 * =================================
	 * @param boardMaster
	 * @throws EgovBizException
	 */
	protected boolean checkAuthority() throws Exception {
		// 사용자권한 처리
		if (!EgovUserDetailsHelper.isAuthenticated()) {
			return false;
		} else {
			return true;
		}
	}

}

