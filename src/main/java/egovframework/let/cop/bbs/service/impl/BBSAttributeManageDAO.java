/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ 공통 >  로그 출력
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */


/**
 * <p>■공통 >  로그 출력</p>
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
	
	/**
	 * ■함수 시작 로그 출력
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
package egovframework.let.cop.bbs.service.impl;
import java.util.List;

import egovframework.let.cop.bbs.service.BoardMaster;
import egovframework.let.cop.bbs.service.BoardMasterVO;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;

import org.springframework.stereotype.Repository;

/**
 * 게시판 속성정보 관리를 위한 데이터 접근 클래스
 * @author 공통 서비스 개발팀 이삼섭
 * @since 2009.03.12
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2009.03.12  이삼섭          최초 생성
 *  2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성
 *
 *  </pre>
 */
@Repository("BBSAttributeManageDAO")
public class BBSAttributeManageDAO extends EgovAbstractMapper {

    /**
     * 등록된 게시판 속성정보를 삭제한다.
     *
     * @param BoardMaster
     */
    public void deleteBBSMasterInf(BoardMaster boardMaster) throws Exception {
	update("BBSAttributeManageDAO.deleteBBSMasterInf", boardMaster);
    }

    /**
     * 신규 게시판 속성정보를 등록한다.
     *
     * @param BoardMaster
     */
    public int insertBBSMasterInf(BoardMaster boardMaster) throws Exception {
	return (int)insert("BBSAttributeManageDAO.insertBBSMasterInf", boardMaster);
    }

    /**
     * 게시판 속성정보 한 건을 상세조회 한다.
     *
     * @param BoardMasterVO
     */
    public BoardMasterVO selectBBSMasterInf(BoardMaster vo) throws Exception {
	return (BoardMasterVO)selectOne("BBSAttributeManageDAO.selectBBSMasterInf", vo);
    }

    /**
     * 게시판 속성정보 목록을 조회한다.
     *
     * @param BoardMasterVO
     */
    @SuppressWarnings("unchecked")
    public List<BoardMasterVO> selectBBSMasterInfs(BoardMasterVO vo) throws Exception {
	return (List<BoardMasterVO>) list("BBSAttributeManageDAO.selectBBSMasterInfs", vo);
    }

    /**
     * 게시판 속성정보 목록 숫자를 조회한다
     *
     * @param vo
     * @return
     * @throws Exception
     */
    public int selectBBSMasterInfsCnt(BoardMasterVO vo) throws Exception {
	return (Integer)selectOne("BBSAttributeManageDAO.selectBBSMasterInfsCnt", vo);
    }

    /**
     * 게시판 속성정보를 수정한다.
     *
     * @param BoardMaster
     */
    public void updateBBSMasterInf(BoardMaster boardMaster) throws Exception {
	update("BBSAttributeManageDAO.updateBBSMasterInf", boardMaster);
    }

    /**
     * 템플릿의 유효여부를 점검한다.
     *
     * @param BoardMasterVO
     */
    public boolean validateTemplate(BoardMasterVO vo) throws Exception {
	return true;
    }

    /**
     * 유효한 게시판 목록을 불러온다.
     *
     * @param vo
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<BoardMasterVO> selectAllBBSMasteInf(BoardMasterVO vo) throws Exception {
	// 커뮤니티, 동호회의 게시판이 나오지 않도록 LETTNBBSUSE 테이블과 Join 필요
	return (List<BoardMasterVO>) list("BBSAttributeManageDAO.selectAllBBSMaster", vo);
    }

    /**
     * 사용중인 게시판 속성정보 목록을 조회한다.
     *
     * @param BoardMasterVO
     */
    @SuppressWarnings("unchecked")
    public List<BoardMasterVO> selectBdMstrListByTrget(BoardMasterVO vo) throws Exception {
	return (List<BoardMasterVO>) list("BBSAttributeManageDAO.selectBdMstrListByTrget", vo);
    }

    /**
     * 사용중인 게시판 속성정보 목록 숫자를 조회한다
     *
     * @param vo
     * @return
     * @throws Exception
     */
    public int selectBdMstrListCntByTrget(BoardMasterVO vo) throws Exception {
	return (Integer)selectOne("BBSAttributeManageDAO.selectBdMstrListCntByTrget", vo);
    }

    /**
     * 커뮤니티, 동호회등 게시판 사용등록이 된 게시판 목록 전체를 불러온다.
     *
     * @param vo
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<BoardMasterVO> selectAllBdMstrByTrget(BoardMasterVO vo) throws Exception {
	return (List<BoardMasterVO>) list("BBSAttributeManageDAO.selectAllBdMstrByTrget", vo);
    }

    /**
     * 사용 중이지 않은 게시판 속성정보 목록을 조회한다.
     *
     * @param BoardMasterVO
     */
    @SuppressWarnings("unchecked")
    public List<BoardMasterVO> selectNotUsedBdMstrList(BoardMasterVO vo) throws Exception {
	return (List<BoardMasterVO>) list("BBSAttributeManageDAO.selectNotUsedBdMstrList", vo);
    }

    /**
     * 사용 중이지 않은 게시판 속성정보 목록 숫자를 조회한다
     *
     * @param vo
     * @return
     * @throws Exception
     */
	public int selectNotUsedBdMstrListCnt(BoardMasterVO vo) throws Exception {
	return (Integer)selectOne("BBSAttributeManageDAO.selectNotUsedBdMstrListCnt", vo);
    }
}
