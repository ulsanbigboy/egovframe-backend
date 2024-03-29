/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ 템플릿 정보관리를 위한 데이터 접근 클래스
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.let.cop.com.service.impl;
import java.util.List;

import egovframework.let.cop.com.service.TemplateInf;
import egovframework.let.cop.com.service.TemplateInfVO;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;

import org.springframework.stereotype.Repository;


/**
 * <p>■템플릿 정보관리를 위한 데이터 접근 클래스</p>
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
@Repository("TemplateManageDAO")
public class TemplateManageDAO extends EgovAbstractMapper {

	
    /**
     * ■템플릿 정보를 삭제한다.
	 * =================================
     * @param tmplatInf
     * @throws Exception
     */
    public void deleteTemplateInf(TemplateInf tmplatInf) throws Exception {
    	update("TemplateManageDAO.deleteTemplateInf", tmplatInf);
    }

    /**
     * ■템플릿 정보를 등록한다.
	 * =================================
     * @param tmplatInf
     * @throws Exception
     */
    public void insertTemplateInf(TemplateInf tmplatInf) throws Exception {
    	insert("TemplateManageDAO.insertTemplateInf", tmplatInf);
    }

    /**
     * ■템플릿 정보를 수정한다.
	 * =================================
     * @param tmplatInf
     * @throws Exception
     */
    public void updateTemplateInf(TemplateInf tmplatInf) throws Exception {
    	update("TemplateManageDAO.updateTemplateInf", tmplatInf);
    }

    /**
     * ■템플릿에 대한 목록를 조회한다.
	 * =================================
     * @param tmplatInfVO
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<TemplateInfVO> selectTemplateInfs(TemplateInfVO tmplatInfVO) throws Exception {
    	return (List<TemplateInfVO>) list("TemplateManageDAO.selectTemplateInfs", tmplatInfVO);
    }

    /**
     * ■템플릿에 대한 목록 전체 건수를 조회한다.
	 * =================================
     * @param tmplatInfVO
     * @return
     * @throws Exception
     */
    public int selectTemplateInfsCnt(TemplateInfVO tmplatInfVO) throws Exception {
    	return (Integer)selectOne("TemplateManageDAO.selectTemplateInfsCnt", tmplatInfVO);
    }

    /**
     * ■템플릿에 대한 상세정보를 조회한다.
	 * =================================
     * @param tmplatInfVO
     * @return
     * @throws Exception
     */
    public TemplateInfVO selectTemplateInf(TemplateInfVO tmplatInfVO) throws Exception {
    	return (TemplateInfVO)selectOne("TemplateManageDAO.selectTemplateInf", tmplatInfVO);

    }

    /**
     * ■템플릿에 대한 미리보기 정보를 조회한다.
	 * =================================
     * @param tmplatInfVO
     * @return
     * @throws Exception
     */
    public TemplateInfVO selectTemplatePreview(TemplateInfVO tmplatInfVO) throws Exception {
    	return null;
    }

    /**
     * ■템플릿 구분에 따른 목록을 조회한다.
	 * =================================
     * @param tmplatInfVO
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<TemplateInfVO> selectTemplateInfsByCode(TemplateInfVO tmplatInfVO) throws Exception {
    	return (List<TemplateInfVO>) list("TemplateManageDAO.selectTemplateInfsByCode", tmplatInfVO);
    }

}


