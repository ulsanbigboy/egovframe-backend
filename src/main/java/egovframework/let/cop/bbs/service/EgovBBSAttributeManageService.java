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
package egovframework.let.cop.bbs.service;

import java.util.List;
import java.util.Map;

/**
 * 게시판 속성관리를 위한 서비스 인터페이스 클래스
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
public interface EgovBBSAttributeManageService {

	/**
	 * 등록된 게시판 속성정보를 삭제한다.
	 * @param BoardMaster
	 * 
	 * @param boardMaster
	 * @exception Exception Exception
	 */
	public void deleteBBSMasterInf(BoardMaster boardMaster)
	  throws Exception;

	/**
	 * 신규 게시판 속성정보를 생성한다.
	 * @param BoardMaster
	 * 
	 * @param boardMaster
	 * @exception Exception Exception
	 */
	public String insertBBSMastetInf(BoardMaster boardMaster)
	  throws Exception;

	/**
	 * 유효한 게시판 마스터 정보를 호출한다.
	 * @param searchVO
	 * @return
	 * 
	 * @param vo
	 * @exception Exception Exception
	 */
	public List<BoardMasterVO> selectAllBBSMasteInf(BoardMasterVO vo)
	  throws Exception;

	/**
	 * 커뮤니티, 동호회에서 사용중인 게시판 속성 정보의 목록을 전체조회 한다.
	 * @return
	 * 
	 * @param vo
	 * @exception Exception Exception
	 */
	public List<BoardMasterVO> selectAllBdMstrByTrget(BoardMasterVO vo)
	  throws Exception;

	/**
	 * 게시판 속성정보 한 건을 상세조회한다.
	 * @param BoardMasterVO
	 * 
	 * @param searchVO
	 * @exception Exception Exception
	 */
	public BoardMasterVO selectBBSMasterInf(BoardMaster searchVO)
	  throws Exception;

	/**
	 * 게시판 속성 정보의 목록을 조회 한다.
	 * @param BoardMasterVO
	 * 
	 * @param searchVO
	 * @exception Exception Exception
	 */
	public Map<String, Object> selectBBSMasterInfs(BoardMasterVO searchVO)
	  throws Exception;

	/**
	 * 사용중인 게시판 속성 정보의 목록을 조회 한다.
	 * @param BoardMasterVO
	 * 
	 * @param vo
	 * @exception Exception Exception
	 */
	public Map<String, Object> selectBdMstrListByTrget(BoardMasterVO vo)
	  throws Exception;

	/**
	 * 사용중이지 않은 게시판 속성 정보의 목록을 조회 한다.
	 * @return
	 * 
	 * @param vo
	 * @exception Exception Exception
	 */
	public Map<String, Object> selectNotUsedBdMstrList(BoardMasterVO vo)
	  throws Exception;

	/**
	 * 게시판 속성정보를 수정한다.
	 * @param BoardMaster
	 * 
	 * @param boardMaster
	 * @exception Exception Exception
	 */
	public void updateBBSMasterInf(BoardMaster boardMaster)
	  throws Exception;

	/**
	 * 템플릿의 유효여부를 점검한다.
	 * @param BoardMasterVO
	 * 
	 * @param searchVO
	 * @exception Exception Exception
	 */
	public void validateTemplate(BoardMasterVO searchVO)
	  throws Exception;

}