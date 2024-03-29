/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ 협업 기능에서 사용자 정보를 관리하기 위한 서비스 인터페이스 클래스
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.let.cop.com.service;

import java.util.List;
import java.util.Map;


/**
 * <p>■협업 기능에서 사용자 정보를 관리하기 위한 서비스 인터페이스 클래스</p>
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
public interface EgovUserInfManageService {

	
	/**
	 * ■함수 시작 로그 출력
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	/**
	 * ■사용자 정보에 대한 목록을 조회한다.
	 * =================================
     * @param userVO
     * @return
     * @throws Exception
     */
    public Map<String, Object> selectUserList(UserInfVO userVO) throws Exception;

    /**
	 * ■커뮤니티 사용자 목록을 조회한다.
	 * =================================
     * @param userVO
     * @return
     * @throws Exception
     */
    public Map<String, Object> selectCmmntyUserList(UserInfVO userVO) throws Exception;

    /**
	 * ■커뮤니티 관리자 목록을 조회한다.
	 * =================================
     * @param userVO
     * @return
     * @throws Exception
     */
    public Map<String, Object> selectCmmntyMngrList(UserInfVO userVO) throws Exception;

    /**
	 * ■동호회 사용자 목록을 조회한다.
	 * =================================
     * @param userVO
     * @return
     * @throws Exception
     */
    public Map<String, Object> selectClubUserList(UserInfVO userVO) throws Exception;

    /**
	 * ■동호회 운영자 목록을 조회한다.
	 * =================================
     * @param userVO
     * @return
     * @throws Exception
     */
    public Map<String, Object> selectClubOprtrList(UserInfVO userVO) throws Exception;

    /**
	 * ■동호회에 대한 모든 사용자 목록을 조회한다.
	 * =================================
     * @param userVO
     * @return
     * @throws Exception
     */
    public List<UserInfVO> selectAllClubUser(UserInfVO userVO) throws Exception;

    /**
	 * ■커뮤니티에 대한 모든 사용자 목록을 조회한다.
	 * =================================
     * @param userVO
     * @return
     * @throws Exception
     */
    public List<UserInfVO> selectAllCmmntyUser(UserInfVO userVO) throws Exception;
    
    
}



