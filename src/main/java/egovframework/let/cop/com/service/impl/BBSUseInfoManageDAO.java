/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ 게시판 이용정보를 관리하기 위한 데이터 접근 클래스
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.let.cop.com.service.impl;

import java.util.List;

import egovframework.let.cop.com.service.BoardUseInf;
import egovframework.let.cop.com.service.BoardUseInfVO;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;

import org.springframework.stereotype.Repository;


/**
 * <p>■게시판 이용정보를 관리하기 위한 데이터 접근 클래스</p>
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
@Repository("BBSUseInfoManageDAO")
public class BBSUseInfoManageDAO extends EgovAbstractMapper {

	
	/**
	 * ■함수 시작 로그 출력
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
    /**
     * ■게시판 사용 정보를 삭제한다.
	 * =================================
     * @param bdUseInf
     * @throws Exception
     */
    public void deleteBBSUseInf(BoardUseInf bdUseInf) throws Exception {
    	update("BBSUseInfoManageDAO.deleteBBSUseInf", bdUseInf);
    }

    /**
     * ■커뮤니티에 사용되는 게시판 사용정보 목록을 조회한다.
	 * =================================
     * @param bdUseInf
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<BoardUseInf> selectBBSUseInfByCmmnty(BoardUseInfVO bdUseVO) throws Exception {
    	return (List<BoardUseInf>) list("BBSUseInfoManageDAO.selectBBSUseInfByCmmnty", bdUseVO);
    }

    /**
     * ■동호회에 사용되는 게시판 사용정보 목록을 조회한다.
	 * =================================
     * @param bdUseInf
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<BoardUseInf> selectBBSUseInfByClub(BoardUseInfVO bdUseVO) throws Exception {
    	return (List<BoardUseInf>) list("BBSUseInfoManageDAO.selectBBSUseInfByClub", bdUseVO);
    }

    /**
     * ■커뮤니티에 사용되는 모든 게시판 사용정보를 삭제한다.
	 * =================================
     * @param bdUseInf
     * @throws Exception
     */
    public void deleteAllBBSUseInfByCmmnty(BoardUseInfVO bdUseVO) throws Exception {
    	update("BBSUseInfoManageDAO.deleteAllBBSUseInfByCmmnty", bdUseVO);
    }

    /**
     * ■동호회에 사용되는 모든 게시판 사용정보를 삭제한다.
	 * =================================
     * @param bdUseInf
     * @throws Exception
     */
    public void deleteAllBBSUseInfByClub(BoardUseInfVO bdUseVO) throws Exception {
    	update("BBSUseInfoManageDAO.deleteAllBBSUseInfByClub", bdUseVO);
    }

    /**
     * ■게시판 사용정보를 등록한다.
	 * =================================
     * @param bdUseInf
     * @throws Exception
     */
    public void insertBBSUseInf(BoardUseInf bdUseInf) throws Exception {
    	insert("BBSUseInfoManageDAO.insertBBSUseInf", bdUseInf);
    }

    /**
     * ■게시판 사용정보 목록을 조회한다.
	 * =================================
     * @param bdUseVO
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<BoardUseInfVO> selectBBSUseInfs(BoardUseInfVO bdUseVO) throws Exception {
    	return (List<BoardUseInfVO>) list("BBSUseInfoManageDAO.selectBBSUseInfs", bdUseVO);
    }

    /**
     *■
	 * =================================
     * @param bdUseVO
     * @return
     * @throws Exception
     */
    public int selectBBSUseInfsCnt(BoardUseInfVO bdUseVO) throws Exception {
    	return (Integer)selectOne("BBSUseInfoManageDAO.selectBBSUseInfsCnt", bdUseVO);
    }

    /**
     * ■게시판 사용정보에 대한 상세정보를 조회한다.
	 * =================================
     * @param bdUseVO
     * @return
     * @throws Exception
     */
    public BoardUseInfVO selectBBSUseInf(BoardUseInfVO bdUseVO) throws Exception {
    	return (BoardUseInfVO)selectOne("BBSUseInfoManageDAO.selectBBSUseInf", bdUseVO);
    }

    /**
     * ■게시판 사용정보를 수정한다.
	 * =================================
     * @param bdUseInf
     * @throws Exception
     */
    public void updateBBSUseInf(BoardUseInf bdUseInf) throws Exception {
    	update("BBSUseInfoManageDAO.updateBBSUseInf", bdUseInf);
    }

    /**
     * ■게시판에 대한 사용정보를 삭제한다.
	 * =================================
     * @param bdUseInf
     * @throws Exception
     */
    public void deleteBBSUseInfByBoardId(BoardUseInf bdUseInf) throws Exception {
    	update("BBSUseInfoManageDAO.deleteBBSUseInfByBoardId", bdUseInf);
    }

    /**
     * ■커뮤니티, 동호회에 사용되는 게시판 사용정보에 대한 목록을 조회한다.
	 * =================================
     * @param bdUseVO
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<BoardUseInfVO> selectBBSUseInfsByTrget(BoardUseInfVO bdUseVO) throws Exception {
    	return (List<BoardUseInfVO>) list("BBSUseInfoManageDAO.selectBBSUseInfsByTrget", bdUseVO);
    }

    /**
     * ■커뮤니티, 동호회에 사용되는 게시판 사용정보에 대한 전체 건수를 조회한다.
	 * =================================
     * @param bdUseVO
     * @return
     * @throws Exception
     */
    public int selectBBSUseInfsCntByTrget(BoardUseInfVO bdUseVO) throws Exception {
    	return (Integer)selectOne("BBSUseInfoManageDAO.selectBBSUseInfsCntByTrget", bdUseVO);
    }

    /**
     * ■커뮤니티, 동호회에 사용되는 게시판 사용정보를 수정한다.
	 * =================================
     * @param bdUseInf
     * @throws Exception
     */
    public void updateBBSUseInfByTrget(BoardUseInf bdUseInf) throws Exception {
    	update("BBSUseInfoManageDAO.updateBBSUseInfByTrget", bdUseInf);
    }
    
}
