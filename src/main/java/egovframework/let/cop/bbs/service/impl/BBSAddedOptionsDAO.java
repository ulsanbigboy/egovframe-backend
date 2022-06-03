/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ 2단계 기능 추가 (댓글관리, 만족도조사) 관리를 위한 데이터 접근 클래스
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.let.cop.bbs.service.impl;

import egovframework.let.cop.bbs.service.BoardMaster;
import egovframework.let.cop.bbs.service.BoardMasterVO;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;

import org.springframework.stereotype.Repository;



/**
 * <p>■2단계 기능 추가 (댓글관리, 만족도조사) 관리를 위한 데이터 접근 클래스</p>
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
@Repository("BBSAddedOptionsDAO")
public class BBSAddedOptionsDAO extends EgovAbstractMapper {

	/**
	 * ■함수 시작 로그 출력
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
    /**
	 * ■신규 게시판 추가기능 정보를 등록한다.
	 * =================================
     * @param BoardMaster
     */
    public int insertAddedOptionsInf(BoardMaster boardMaster) throws Exception {
    	return (int)insert("BBSAddedOptionsDAO.insertAddedOptionsInf", boardMaster);
    }
    
    /**
	 * ■게시판 추가기능 정보 한 건을 상세조회 한다.
	 * =================================
     * @param BoardMasterVO
     */
    public BoardMasterVO selectAddedOptionsInf(BoardMaster vo) throws Exception {
    	return (BoardMasterVO)selectOne("BBSAddedOptionsDAO.selectAddedOptionsInf", vo);
    }
    
    /**
	 * ■게시판 추가기능 정보를 수정한다.
	 * =================================
     * @param BoardMaster
     */
    public void updateAddedOptionsInf(BoardMaster boardMaster) throws Exception {
    	update("BBSAddedOptionsDAO.updateAddedOptionsInf", boardMaster);
    }
    
}
