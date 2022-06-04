/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ 파일 조회, 삭제, 다운로드 처리를 위한 컨트롤러 클래스
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.com.cmm.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.FileVO;
import egovframework.com.cmm.service.ResultVO;


/**
 * <p>■파일 조회, 삭제, 다운로드 처리를 위한 컨트롤러 클래스</p>
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
public class EgovFileMngAPIController {


	/**
	 * ■로그
	 * =================================
	 */
	private final Logger logger = LoggerFactory.getLogger(getClass());


	/**
	 * ■함수 시작 로그 출력
	 * =================================
	 */
    @Resource(name = "EgovFileMngService")
    private EgovFileMngService fileService;


    /**
	 * ■첨부파일에 대한 삭제를 처리한다.
	 * =================================
     * @param fileVO
     * @param returnUrl
     * @param sessionVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/cmm/fms/deleteFileInfsAPI.do")
    public @ResponseBody ResultVO deleteFileInf(@ModelAttribute("searchVO") FileVO fileVO, ModelMap model) throws Exception {

		egovframework.com.cmm.util.LogUtil.start(logger, "첨부파일에 대한 삭제를 처리", null);

    	ResultVO resultVO = new ResultVO();

		//Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
    	Boolean isAuthenticated = true;

		if (isAuthenticated) {
		    fileService.deleteFileInf(fileVO);
		}

		//--------------------------------------------
		// contextRoot가 있는 경우 제외 시켜야 함
		//--------------------------------------------
		////return "forward:/cmm/fms/selectFileInfs.do";
		//return "forward:" + returnUrl;

		resultVO.setResultCode(200);
		resultVO.setResultMessage("삭제 성공");
		egovframework.com.cmm.util.LogUtil.end(logger, "첨부파일에 대한 삭제를 처리");
		return resultVO;
    }
    
}
