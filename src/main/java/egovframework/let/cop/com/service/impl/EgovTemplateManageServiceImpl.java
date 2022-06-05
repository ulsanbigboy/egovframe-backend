/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ 템플릿 정보관리를 위한 서비스 구현 클래스
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.let.cop.com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.cop.com.service.EgovTemplateManageService;
import egovframework.let.cop.com.service.TemplateInf;
import egovframework.let.cop.com.service.TemplateInfVO;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;


/**
 * <p>■템플릿 정보관리를 위한 서비스 구현 클래스</p>
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
@Service("EgovTemplateManageService")
public class EgovTemplateManageServiceImpl extends EgovAbstractServiceImpl implements EgovTemplateManageService {
	
	/**
	 * ■
	 * =================================
	 */
	@Resource(name = "TemplateManageDAO")
	private TemplateManageDAO tmplatDAO;
	
	/**
	 * ■
	 * =================================
	 */
	@Resource(name = "egovTmplatIdGnrService")
	private EgovIdGnrService idgenService;

	/**
	 * ■템플릿 정보를 삭제한다.
	 * =================================
	 * @see egovframework.let.cop.bbs.com.service.EgovTemplateManageService#deleteTemplateInf(egovframework.let.cop.bbs.com.service.TemplateInf)
	 */
	@Override
	public void deleteTemplateInf(TemplateInf tmplatInf) throws Exception {
		tmplatDAO.deleteTemplateInf(tmplatInf);
	}

	/**
	 * ■템플릿 정보를 등록한다.
	 * =================================
	 * @see egovframework.let.cop.bbs.com.service.EgovTemplateManageService#insertTemplateInf(egovframework.let.cop.bbs.com.service.TemplateInf)
	 */
	@Override
	public void insertTemplateInf(TemplateInf tmplatInf) throws Exception {

		tmplatInf.setTmplatId(idgenService.getNextStringId());

		tmplatDAO.insertTemplateInf(tmplatInf);
	}

	/**
	 * ■템플릿에 대한 상세정보를 조회한다.
	 * =================================
	 * @see egovframework.let.cop.bbs.com.service.EgovTemplateManageService#selectTemplateInf(egovframework.let.cop.bbs.com.service.TemplateInfVO)
	 */
	@Override
	public TemplateInfVO selectTemplateInf(TemplateInfVO tmplatInfVO) throws Exception {
		TemplateInfVO vo = new TemplateInfVO();
		vo = tmplatDAO.selectTemplateInf(tmplatInfVO);
		return vo;
	}

	/**
	 * ■템플릿에 대한 목록를 조회한다.
	 * =================================
	 * @see egovframework.let.cop.bbs.com.service.EgovTemplateManageService#selectTemplateInfs(egovframework.let.cop.bbs.com.service.TemplateInfVO)
	 */
	@Override
	public Map<String, Object> selectTemplateInfs(TemplateInfVO tmplatInfVO) throws Exception {
		List<TemplateInfVO> result = tmplatDAO.selectTemplateInfs(tmplatInfVO);
		int cnt = tmplatDAO.selectTemplateInfsCnt(tmplatInfVO);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("resultList", result);
		map.put("resultCnt", Integer.toString(cnt));

		return map;
	}

	/**
	 * ■템플릿에 대한 미리보기 정보를 조회한다.
	 * =================================
	 * @see egovframework.let.cop.bbs.com.service.EgovTemplateManageService#selectTemplatePreview(egovframework.let.cop.bbs.com.service.TemplateInfVO)
	 */
	@Override
	public TemplateInfVO selectTemplatePreview(TemplateInfVO tmplatInfVO) throws Exception {
		TemplateInfVO vo = new TemplateInfVO();

		vo = tmplatDAO.selectTemplatePreview(tmplatInfVO);

		return vo;
	}

	/**
	 * ■템플릿 정보를 수정한다.
	 * =================================
	 * @see egovframework.let.cop.bbs.com.service.EgovTemplateManageService#updateTemplateInf(egovframework.let.cop.bbs.com.service.TemplateInf)
	 */
	@Override
	public void updateTemplateInf(TemplateInf tmplatInf) throws Exception {
		tmplatDAO.updateTemplateInf(tmplatInf);
	}

	/**
	 * ■템플릿 구분에 따른 목록을 조회한다.
	 * =================================
	 * @see egovframework.let.cop.bbs.com.service.EgovTemplateManageService#selectAllTemplateInfs(egovframework.let.cop.bbs.com.service.TemplateInfVO)
	 */
	@Override
	public List<TemplateInfVO> selectTemplateInfsByCode(TemplateInfVO tmplatInfVO) throws Exception {
		return tmplatDAO.selectTemplateInfsByCode(tmplatInfVO);
	}
	
}


