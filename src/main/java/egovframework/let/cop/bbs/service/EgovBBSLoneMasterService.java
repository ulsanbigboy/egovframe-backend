/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ 게시판 속성관리를 위한 서비스 인터페이스 클래스
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.let.cop.bbs.service;

import java.util.Map;


/**
 * <p>■게시판 속성관리를 위한 서비스 인터페이스 클래스</p>
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
public interface EgovBBSLoneMasterService {


	/**
	 * ■등록된 게시판 속성정보를 삭제한다.
	 * =================================
	 * @param BoardMaster
	 * @param boardMaster
	 * @exception Exception Exception
	 */
	public void deleteMaster(BoardMaster boardMaster) throws Exception;

	/**
	 * ■신규 게시판 속성정보를 생성한다.
	 * =================================
	 * @param BoardMaster
	 * @param boardMaster
	 * @exception Exception Exception
	 */
	public String insertMaster(BoardMaster boardMaster) throws Exception;

	/**
	 * ■게시판 속성정보 한 건을 상세조회한다.
	 * =================================
	 * @param BoardMasterVO
	 * @param searchVO
	 * @exception Exception Exception
	 */
	public BoardMasterVO selectMaster(BoardMaster searchVO) throws Exception;

	/**
	 * ■게시판 속성 정보의 목록을 조회 한다.
	 * =================================
	 * @param BoardMasterVO
	 * @param searchVO
	 * @exception Exception Exception
	 */
	public Map<String, Object> selectMasterList(BoardMasterVO searchVO) throws Exception;

	/**
	 * ■게시판 속성정보를 수정한다.
	 * =================================
	 * @param BoardMaster
	 * @param boardMaster
	 * @exception Exception Exception
	 */
	public void updateMaster(BoardMaster boardMaster) throws Exception;

}


