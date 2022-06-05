/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ 게시판 이용정보를 관리하기 위한 서비스 인터페이스 클래스
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.let.cop.com.service;

import java.util.Map;




/**
 * <p>■게시판 이용정보를 관리하기 위한 서비스 인터페이스 클래스</p>
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
public interface EgovBBSUseInfoManageService {

    /**
     * ■게시판 사용 정보를 삭제한다.
	 * =================================
     * @param bdUseInf
     * @throws Exception
     */
    public void deleteBBSUseInf(BoardUseInf bdUseInf) throws Exception;

    /**
     * ■커뮤니티에 사용되는 게시판 사용정보를 삭제한다.
	 * =================================
     * @param bdUseInf
     * @throws Exception
     */
    public void deleteBBSUseInfByCmmnty(BoardUseInfVO bdUseVO) throws Exception;

    /**
     * ■동호회에 사용되는 게시판 사용정보를 삭제한다.
	 * =================================
     * @param bdUseInf
     * @throws Exception
     */
    public void deleteBBSUseInfByClub(BoardUseInfVO bdUseVO) throws Exception;

    /**
     * ■커뮤니티에 사용되는 모든 게시판 사용정보를 삭제한다.
	 * =================================
     * @param bdUseInf
     * @throws Exception
     */
    public void deleteAllBBSUseInfByCmmnty(BoardUseInfVO bdUseVO) throws Exception;

    /**
     * ■동호회에 사용되는 모든 게시판 사용정보를 삭제한다.
	 * =================================
     * @param bdUseInf
     * @throws Exception
     */
    public void deleteAllBBSUseInfByClub(BoardUseInfVO bdUseVO) throws Exception;

    /**
     * ■게시판 사용정보를 등록한다.
	 * =================================
     * @param bdUseInf
     * @throws Exception
     */
    public void insertBBSUseInf(BoardUseInf bdUseInf) throws Exception;

    /**
     * ■게시판 사용정보 목록을 조회한다.
	 * =================================
     * @param bdUseVO
     * @return
     * @throws Exception
     */
    public Map<String, Object> selectBBSUseInfs(BoardUseInfVO bdUseVO) throws Exception;

    /**
     * ■게시판 사용정보를 수정한다.
	 * =================================
     * @param bdUseInf
     * @throws Exception
     */
    public void updateBBSUseInf(BoardUseInf bdUseInf) throws Exception;

    /**
     * ■게시판 사용정보에 대한 상세정보를 조회한다.
	 * =================================
     * @param bdUseVO
     * @return
     * @throws Exception
     */
    public BoardUseInfVO selectBBSUseInf(BoardUseInfVO bdUseVO) throws Exception;

    /**
     * ■게시판에 대한 사용정보를 삭제한다.
	 * =================================
     * @param bdUseInf
     * @throws Exception
     */
    public void deleteBBSUseInfByBoardId(BoardUseInf bdUseInf) throws Exception;

    /**
     * ■커뮤니티, 동호회에 사용되는 게시판 사용정보에 대한 목록을 조회한다.
	 * =================================
     * @param bdUseVO
     * @return
     * @throws Exception
     */
    public Map<String, Object> selectBBSUseInfsByTrget(BoardUseInfVO bdUseVO) throws Exception;

    /**
     * ■커뮤니티, 동호회에 사용되는 게시판 사용정보를 수정한다.
	 * =================================
     * @param bdUseInf
     * @throws Exception
     */
    public void updateBBSUseInfByTrget(BoardUseInf bdUseInf) throws Exception;

}


