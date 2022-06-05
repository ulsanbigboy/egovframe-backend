/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ 템플릿 메인 페이지 컨트롤러 클래스(Sample 소스)
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.let.main.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.let.cop.bbs.service.BoardVO;
import egovframework.let.cop.bbs.service.EgovBBSManageService;

import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * <p>■템플릿 메인 페이지 컨트롤러 클래스(Sample 소스)</p>
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
@Controller@SessionAttributes(types = ComDefaultVO.class)
public class EgovMainController {

	
	/**
	 * ■로그
	 * =================================
	 */
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	
	/**
	 * ■EgovBBSManageService
	 * =================================
	 */
	@Resource(name = "EgovBBSManageService")
    private EgovBBSManageService bbsMngService;

	
	/**
	 * ■메인 페이지에서 각 업무 화면으로 연계하는 기능을 제공한다.
	 * =================================
	 * @param request
	 * @param commandMap
	 * @exception Exception Exception
	 */
	@RequestMapping(value = "/cmm/forwardPage.do")
	public String forwardPageWithMenuNo(HttpServletRequest request, @RequestParam Map<String, Object> commandMap) throws Exception{
		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");
		return "";
	}

	/**
	 * ■템플릿 메인 페이지 조회
	 * =================================
	 * @return 메인페이지 정보 Map [key : 항목명]
	 * @param request
	 * @param model
	 * @exception Exception Exception
	 */
	@RequestMapping(value = "/cmm/main/mainPage.do")
	public String getMgtMainPage(HttpServletRequest request, ModelMap model) throws Exception{

		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");

		// 공지사항 메인 컨텐츠 조회 시작 ---------------------------------
		BoardVO boardVO = new BoardVO();
		boardVO.setPageUnit(5);
		boardVO.setPageSize(10);
		boardVO.setBbsId("BBSMSTR_AAAAAAAAAAAA");

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(boardVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(boardVO.getPageUnit());
		paginationInfo.setPageSize(boardVO.getPageSize());

		boardVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		boardVO.setLastIndex(paginationInfo.getLastRecordIndex());
		boardVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		Map<String, Object> map = bbsMngService.selectBoardArticles(boardVO, "BBSA02");
		model.addAttribute("notiList", map.get("resultList"));

		boardVO.setBbsId("BBSMSTR_BBBBBBBBBBBB");
		map = bbsMngService.selectBoardArticles(boardVO, "BBSA02");
		model.addAttribute("galList", map.get("resultList"));

		// 공지사항 메인컨텐츠 조회 끝 -----------------------------------

		return "main/EgovMainView";
	}

}

