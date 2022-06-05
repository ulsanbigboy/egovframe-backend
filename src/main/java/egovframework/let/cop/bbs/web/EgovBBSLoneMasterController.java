/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ 게시판 속성관리를 위한 컨트롤러  클래스
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.let.cop.bbs.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.let.cop.bbs.service.BoardMaster;
import egovframework.let.cop.bbs.service.BoardMasterVO;
import egovframework.let.cop.bbs.service.EgovBBSLoneMasterService;

import org.egovframe.rte.fdl.cmmn.exception.EgovBizException;
import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * <p>■게시판 속성관리를 위한 컨트롤러  클래스</p>
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
public class EgovBBSLoneMasterController {

	
	/**
	 * ■로그
	 * =================================
	 */
	private final Logger logger = LoggerFactory.getLogger(getClass());

	
	/**
	 * ■EgovBBSLoneMasterService
	 * =================================
	 */
    @Resource(name = "EgovBBSLoneMasterService")
    private EgovBBSLoneMasterService bbsLoneService;

	
	/**
	 * ■EgovCmmUseService
	 * =================================
	 */
    @Resource(name = "EgovCmmUseService")
    private EgovCmmUseService cmmUseService;

	
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
     * ■신규 게시판 마스터 등록을 위한 등록페이지로 이동한다.
	 * =================================
     * @param boardMasterVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/cop/bbs/addBoardMaster.do")
    public String addBoardMaster(@ModelAttribute("searchVO") BoardMasterVO boardMasterVO, ModelMap model) throws Exception {


		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");


    	if (!checkAuthority(model))
		 {
			return "cmm/uat/uia/EgovLoginUsr";	// server-side 권한 확인
		}

    	BoardMaster boardMaster = new BoardMaster();

		ComDefaultCodeVO vo = new ComDefaultCodeVO();

		vo.setCodeId("COM004");

		List<?> codeResult = cmmUseService.selectCmmCodeDetail(vo);

		model.addAttribute("typeList", codeResult);

		vo.setCodeId("COM009");

		codeResult = cmmUseService.selectCmmCodeDetail(vo);

		model.addAttribute("attrbList", codeResult);
		model.addAttribute("boardMaster", boardMaster);


		return "cop/bbs/EgovBBSLoneMstrRegist";
    }

    /**
     * ■신규 게시판 마스터 정보를 등록한다.
	 * =================================
     * @param boardMasterVO
     * @param boardMaster
     * @param status
     * @return
     * @throws Exception
     */
    @RequestMapping("/cop/bbs/insertBoardMaster.do")
    public String insertBoardMaster(@ModelAttribute("searchVO") BoardMasterVO boardMasterVO, @ModelAttribute("boardMaster") BoardMaster boardMaster,
	    BindingResult bindingResult, SessionStatus status, ModelMap model) throws Exception {


		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");


    	if (!checkAuthority(model))
		 {
			return "cmm/uat/uia/EgovLoginUsr";	// server-side 권한 확인
		}

		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();

		beanValidator.validate(boardMaster, bindingResult);
		if (bindingResult.hasErrors()) {

		    ComDefaultCodeVO vo = new ComDefaultCodeVO();

		    vo.setCodeId("COM004");

		    List<?> codeResult = cmmUseService.selectCmmCodeDetail(vo);

		    model.addAttribute("typeList", codeResult);

		    vo.setCodeId("COM009");

		    codeResult = cmmUseService.selectCmmCodeDetail(vo);

		    model.addAttribute("attrbList", codeResult);

		    return "cop/bbs/EgovBBSLoneMstrRegist";
		}

		if (isAuthenticated) {
		    boardMaster.setFrstRegisterId(user.getUniqId());
		    boardMaster.setUseAt("Y");
		    boardMaster.setTrgetId("SYSTEMDEFAULT_REGIST");

		    bbsLoneService.insertMaster(boardMaster);
		}

		return "forward:/cop/bbs/selectBoardMasterList.do";
    }

    /**
     * ■게시판 마스터 목록을 조회한다.
	 * =================================
     * @param boardMasterVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/cop/bbs/selectBoardMasterList.do")
    public String selectBoardMasterList(@ModelAttribute("searchVO") BoardMasterVO boardMasterVO, ModelMap model) throws Exception {

		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");


    	if (!checkAuthority(model))
		 {
			return "cmm/uat/uia/EgovLoginUsr";	// server-side 권한 확인
		}

    	boardMasterVO.setPageUnit(propertyService.getInt("pageUnit"));
		boardMasterVO.setPageSize(propertyService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(boardMasterVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(boardMasterVO.getPageUnit());
		paginationInfo.setPageSize(boardMasterVO.getPageSize());

		boardMasterVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		boardMasterVO.setLastIndex(paginationInfo.getLastRecordIndex());
		boardMasterVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		Map<String, Object> map = bbsLoneService.selectMasterList(boardMasterVO);
		int totCnt = Integer.parseInt((String)map.get("resultCnt"));

		paginationInfo.setTotalRecordCount(totCnt);

		model.addAttribute("resultList", map.get("resultList"));
		model.addAttribute("resultCnt", map.get("resultCnt"));
		model.addAttribute("paginationInfo", paginationInfo);

		return "cop/bbs/EgovBBSLoneMstrList";
    }

    /**
     * ■게시판 마스터 상세내용을 조회한다.
	 * =================================
     * @param boardMasterVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/cop/bbs/selectBoardMaster.do")
    public String selectBoardMaster(@ModelAttribute("searchVO") BoardMasterVO searchVO, ModelMap model) throws Exception {

		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");


    	if (!checkAuthority(model))
		 {
			return "cmm/uat/uia/EgovLoginUsr";	// server-side 권한 확인
		}

    	BoardMasterVO vo = bbsLoneService.selectMaster(searchVO);

		model.addAttribute("result", vo);

		model.addAttribute("provdUrl", "/cop/bbs/selectBoardList.do?bbsId=" + vo.getBbsId());

		return "cop/bbs/EgovBBSLoneMstrUpdt";
    }

    /**
     * ■게시판 마스터 정보를 수정한다.
	 * =================================
     * @param boardMasterVO
     * @param boardMaster
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/cop/bbs/updateBoardMaster.do")
    public String updateBoardMaster(@ModelAttribute("searchVO") BoardMasterVO boardMasterVO, @ModelAttribute("boardMaster") BoardMaster boardMaster,
	    BindingResult bindingResult, ModelMap model) throws Exception {

		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");



    	if (!checkAuthority(model))
		 {
			return "cmm/uat/uia/EgovLoginUsr";	// server-side 권한 확인
		}

		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();

		beanValidator.validate(boardMaster, bindingResult);
		if (bindingResult.hasErrors()) {
		    BoardMasterVO vo = bbsLoneService.selectMaster(boardMasterVO);

		    model.addAttribute("result", vo);

		    return "cop/bbs/EgovBBSLoneMstrUpdt";
		}

		if (isAuthenticated) {
		    boardMaster.setLastUpdusrId(user.getUniqId());
		    bbsLoneService.updateMaster(boardMaster);
		}

		return "forward:/cop/bbs/selectBoardMasterList.do";
    }

    /**
     * ■게시판 마스터 정보를 삭제한다.
	 * =================================
     * @param boardMasterVO
     * @param boardMaster
     * @param status
     * @return
     * @throws Exception
     */
    @RequestMapping("/cop/bbs/deleteBoardMaster.do")
    public String deleteBoardMaster(@ModelAttribute("searchVO") BoardMasterVO boardMasterVO, @ModelAttribute("boardMaster") BoardMaster boardMaster,
	    ModelMap model) throws Exception {

		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");



    	if (!checkAuthority(model))
		 {
			return "cmm/uat/uia/EgovLoginUsr";	// server-side 권한 확인
		}

		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();

		if (isAuthenticated) {
		    boardMaster.setLastUpdusrId(user.getUniqId());
		    bbsLoneService.deleteMaster(boardMaster);
		}
		// status.setComplete();
		return "forward:/cop/bbs/selectBoardMasterList.do";
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
