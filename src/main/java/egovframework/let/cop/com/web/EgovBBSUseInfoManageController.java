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

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.let.cop.com.service.BoardUseInf;
import egovframework.let.cop.com.service.BoardUseInfVO;
import egovframework.let.cop.com.service.EgovBBSUseInfoManageService;

import org.egovframe.rte.fdl.cmmn.exception.EgovBizException;
import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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
public class EgovBBSUseInfoManageController {

	
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
	 * ■DefaultBeanValidator
	 * =================================
	 */
    @Autowired
    private DefaultBeanValidator beanValidator;

	
	/**
	 * ■EgovMessageSource
	 * =================================
	 */
    @Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;

    
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
    @RequestMapping("/cop/com/deleteBBSUseInf.do")
    public String deleteBBSUseInf(@ModelAttribute("searchVO") BoardUseInfVO bdUseVO, @ModelAttribute("bdUseInf") BoardUseInf bdUseInf,
	    SessionStatus status, ModelMap model) throws Exception {

		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");



    	if (!checkAuthority(model))
		 {
			return "cmm/uat/uia/EgovLoginUsr";	// server-side 권한 확인
		}

		Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();

		if (isAuthenticated) {
		    bbsUseService.deleteBBSUseInf(bdUseInf);
		}

		return "forward:/cop/com/selectBBSUseInfs.do";
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
    @RequestMapping("/cop/com/addBBSUseInf.do")
    public String addBBSUseInf(@ModelAttribute("searchVO") BoardUseInfVO bdUseVO, ModelMap model) throws Exception {

		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");



    	if (!checkAuthority(model))
		 {
			return "cmm/uat/uia/EgovLoginUsr";	// server-side 권한 확인
		}

    	return "cop/com/EgovBoardUseInfRegist";
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
    @RequestMapping("/cop/com/insertBBSUseInf.do")
    public String insertBBSUseInf(@ModelAttribute("searchVO") BoardUseInfVO bdUseVO, @ModelAttribute("boardUseInf") BoardUseInf boardUseInf,
	    BindingResult bindingResult, @RequestParam Map<String, Object> commandMap, ModelMap model) throws Exception {

		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");



    	if (!checkAuthority(model))
		 {
			return "cmm/uat/uia/EgovLoginUsr";	// server-side 권한 확인
		}

	    LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
	    Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();

		beanValidator.validate(boardUseInf, bindingResult);

		if (bindingResult.hasErrors()) {
		    return "cop/com/EgovBoardUseInfRegist";
		}

		String trgetType = (String)commandMap.get("param_trgetType");
		String registSeCode = "";

		// CMMNTY 06/CLUB 05/SYSTEM(REGC01)
		if ("CMMNTY".equals(trgetType)) {
		    registSeCode = "REGC06";
		} else if ("CLUB".equals(trgetType)) {
		    registSeCode = "REGC05";
		} else {
		    registSeCode = "REGC01";
		}

		boardUseInf.setUseAt("Y");
		boardUseInf.setFrstRegisterId(user.getUniqId());
		boardUseInf.setRegistSeCode(registSeCode);

		if (isAuthenticated) {
		    bbsUseService.insertBBSUseInf(boardUseInf);
		}

		return "forward:/cop/com/selectBBSUseInfs.do";
    }

    /**
     * ■게시판 사용정보 목록을 조회한다.
	 * =================================
     * @param bdUseVO
     * @param sessionVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/cop/com/selectBBSUseInfs.do")
    public String selectBBSUseInfs(@ModelAttribute("searchVO") BoardUseInfVO bdUseVO, ModelMap model) throws Exception {

		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");



    	if (!checkAuthority(model))
		 {
			return "cmm/uat/uia/EgovLoginUsr";	// server-side 권한 확인
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

		model.addAttribute("resultList", map.get("resultList"));
		model.addAttribute("resultCnt", map.get("resultCnt"));
		model.addAttribute("paginationInfo", paginationInfo);

		return "cop/com/EgovBoardUseInfList";
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
    @RequestMapping("/cop/com/updateBBSUseInf.do")
    public String updateBBSUseInf(@ModelAttribute("searchVO") BoardUseInfVO bdUseVO, @ModelAttribute("boardUseInf") BoardUseInf boardUseInf,
	    HttpServletRequest request, ModelMap model) throws Exception {

		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");



    	if (!checkAuthority(model))
		 {
			return "cmm/uat/uia/EgovLoginUsr";	// server-side 권한 확인
		}

    	Boolean isAuthenticated = (LoginVO)request.getSession().getAttribute("LoginVO") == null ? false:true;

		if (isAuthenticated) {
		    bbsUseService.updateBBSUseInf(boardUseInf);
		}

		return "forward:/cop/com/selectBBSUseInfs.do";
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
    @RequestMapping("/cop/com/selectBBSUseInf.do")
    public String selectBBSUseInf(@ModelAttribute("searchVO") BoardUseInfVO bdUseVO, ModelMap model) throws Exception {

		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");


	BoardUseInfVO vo = bbsUseService.selectBBSUseInf(bdUseVO);

	    if (!checkAuthority(model))
		 {
			return "cmm/uat/uia/EgovLoginUsr";	// server-side 권한 확인
		}

		// 시스템 사용 게시판의 경우 URL 표시
		if ("SYSTEM_DEFAULT_BOARD".equals(vo.getTrgetId())) {
		    if (vo.getBbsTyCode().equals("BBST02")) {	// 익명게시판
		    	vo.setProvdUrl("/cop/bbs/anonymous/selectBoardList.do?bbsId=" + vo.getBbsId());
		    } else {
		    	vo.setProvdUrl("/cop/bbs/selectBoardList.do?bbsId=" + vo.getBbsId());
		    }
		}

		model.addAttribute("bdUseVO", vo);
		return "cop/com/EgovBoardUseInfInqire";
    }

    /**
     * ■커뮤니티, 동호회에 사용되는 게시판 사용정보에 대한 목록을 조회한다.
	 * =================================
     * @param bdUseVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/cop/com/selectBBSUseInfsByTrget.do")
    public String selectBBSUseInfsByTrget(@ModelAttribute("searchVO") BoardUseInfVO bdUseVO, ModelMap model) throws Exception {

		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");



    	if (!checkAuthority(model))
		 {
			return "cmm/uat/uia/EgovLoginUsr";	// server-side 권한 확인
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
    @RequestMapping("/cop/com/updateBBSUseInfByTrget.do")
    public String updateBBSUseInfByTrget(@ModelAttribute("searchVO") BoardUseInfVO bdUseVO, @ModelAttribute("boardUseInf") BoardUseInf boardUseInf,
    		@RequestParam Map<String, Object> commandMap, SessionStatus status, ModelMap model) throws Exception {

		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");



    	if (!checkAuthority(model))
		 {
			return "cmm/uat/uia/EgovLoginUsr";	// server-side 권한 확인
		}

		String param_trgetId = (String)commandMap.get("param_trgetId");

		Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();

		if (isAuthenticated) {
		    boardUseInf.setTrgetId(param_trgetId);
		    bbsUseService.updateBBSUseInfByTrget(boardUseInf);
		}

		return "forward:/cop/com/selectBBSUseInfsByTrget.do";
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
    @RequestMapping("/cop/com/insertBBSUseInfByTrget.do")
    public String insertBBSUseInfByTrget(@ModelAttribute("searchVO") BoardUseInfVO bdUseVO, @ModelAttribute("boardUseInf") BoardUseInf boardUseInf,
    		@RequestParam Map<String, Object> commandMap, SessionStatus status, ModelMap model) throws Exception {

		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");



    	if (!checkAuthority(model))
		 {
			return "cmm/uat/uia/EgovLoginUsr";	// server-side 권한 확인
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

		return "forward:/cop/com/selectBBSUseInfsByTrget.do";
    }

    /**
     * ■운영자 권한을 확인한다.(로그인 여부를 확인한다.)
	 * =================================
     * @param boardMaster
     * @throws EgovBizException
     */
    protected boolean checkAuthority(ModelMap model) throws Exception {
    	// 사용자권한 처리
    	if(!EgovUserDetailsHelper.isAuthenticated()) {
    		model.addAttribute("message", egovMessageSource.getMessage("fail.common.login"));
        	return false;
    	}else{
    		return true;
    	}
    }
    
}


