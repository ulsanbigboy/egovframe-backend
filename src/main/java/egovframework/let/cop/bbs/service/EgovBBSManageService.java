/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ 게시물 관리를 위한 서비스 인터페이스  클래스
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.let.cop.bbs.service;

import java.util.Map;



/**
 * <p>■게시물 관리를 위한 서비스 인터페이스  클래스</p>
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
public interface EgovBBSManageService {

	/**
	 * ■게시물 한 건을 삭제 한다.
	 * =================================
	 * @param Board
	 * @exception Exception Exception
	 */
	public void deleteBoardArticle(Board Board) throws Exception;

	/**
	 * ■방명록 내용을 삭제 한다.
	 * =================================
	 * @param boardVO
	 * @exception Exception Exception
	 */
	public void deleteGuestList(BoardVO boardVO) throws Exception;

	/**
	 * ■방명록에 대한 패스워드를 조회 한다.
	 * =================================
	 * @return
	 * 
	 * @param Board
	 * @exception Exception Exception
	 */
	public String getPasswordInf(Board Board) throws Exception;

	/**
	 * ■게시판에 게시물 또는 답변 게시물을 등록 한다.
	 * =================================
	 * @param Board
	 * @exception Exception Exception
	 */
	public void insertBoardArticle(Board Board) throws Exception;

	/**
	 * ■게시물 대하여 상세 내용을 조회 한다.
	 * =================================
	 * @return
	 * 
	 * @param boardVO
	 * @exception Exception Exception
	 */
	public BoardVO selectBoardArticle(BoardVO boardVO) throws Exception;

	/**
	 * ■조건에 맞는 게시물 목록을 조회 한다.
	 * =================================
	 * @return
	 * 
	 * @param boardVO
	 * @param attrbFlag
	 * @exception Exception Exception
	 */
	public Map<String, Object> selectBoardArticles(BoardVO boardVO, String attrbFlag) throws Exception;

	/**
	 * ■방명록에 대한 목록을 조회 한다.
	 * =================================
	 * @return
	 * 
	 * @param boardVO
	 * @exception Exception Exception
	 */
	public Map<String, Object> selectGuestList(BoardVO boardVO) throws Exception;

	/**
	 * ■게시물 한 건의 내용을 수정 한다.
	 * =================================
	 * @param Board
	 * @exception Exception Exception
	 */
	public void updateBoardArticle(Board Board) throws Exception;

}


