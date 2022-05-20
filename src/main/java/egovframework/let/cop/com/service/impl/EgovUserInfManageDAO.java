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
package egovframework.let.cop.com.service.impl;

import java.util.List;

import egovframework.let.cop.com.service.UserInfVO;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;

import org.springframework.stereotype.Repository;

/**
 * 협업 활용 사용자 정보 조회를 위한 데이터 접근 클래스
 * @author 공통서비스개발팀 이삼섭
 * @since 2009.04.06
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.04.06  이삼섭          최초 생성
 *   2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성
 *
 * </pre>
 */
@Repository("EgovUserInfManageDAO")
public class EgovUserInfManageDAO extends EgovAbstractMapper {

    /**
     * 사용자 정보에 대한 목록을 조회한다.
     *
     * @param userVO
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<UserInfVO> selectUserList(UserInfVO userVO) throws Exception {
	return (List<UserInfVO>) list("EgovUserInfManageDAO.selectUserList", userVO);
    }

    /**
     * 사용자 정보에 대한 목록 전체 건수를 조회한다.
     *
     * @param userVO
     * @return
     * @throws Exception
     */
    public int selectUserListCnt(UserInfVO userVO) throws Exception {
	return (Integer)selectOne("EgovUserInfManageDAO.selectUserListCnt", userVO);
    }

    /**
     * 커뮤니티 사용자 목록을 조회한다.
     *
     * @param userVO
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<UserInfVO> selectCmmntyUserList(UserInfVO userVO) throws Exception {
	return (List<UserInfVO>) list("EgovUserInfManageDAO.selectCmmntyUserList", userVO);
    }

    /**
     * 커뮤니티 사용자 목록에 대한 전체 건수를 조회한다.
     *
     * @param userVO
     * @return
     * @throws Exception
     */
    public int selectCmmntyUserListCnt(UserInfVO userVO) throws Exception {
	return (Integer)selectOne("EgovUserInfManageDAO.selectCmmntyUserListCnt", userVO);
    }

    /**
     * 커뮤니티 관리자 목록을 조회한다.
     *
     * @param userVO
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<UserInfVO> selectCmmntyMngrList(UserInfVO userVO) throws Exception {
	return (List<UserInfVO>) list("EgovUserInfManageDAO.selectCmmntyMngrList", userVO);
    }

    /**
     * 커뮤니티 관리자 목록에 대한 전체 건수를 조회한다.
     *
     * @param userVO
     * @return
     * @throws Exception
     */
    public int selectCmmntyMngrListCnt(UserInfVO userVO) throws Exception {
	return (Integer)selectOne("EgovUserInfManageDAO.selectCmmntyMngrListCnt", userVO);
    }

    /**
     * 동호회 사용자 목록을 조회한다.
     *
     * @param userVO
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<UserInfVO> selectClubUserList(UserInfVO userVO) throws Exception {
	return (List<UserInfVO>) list("EgovUserInfManageDAO.selectClubUserList", userVO);
    }

    /**
     * 동호회 사용자 목록에 대한 전체 건수를 조회한다.
     *
     * @param userVO
     * @return
     * @throws Exception
     */
    public int selectClubUserListCnt(UserInfVO userVO) throws Exception {
	return (Integer)selectOne("EgovUserInfManageDAO.selectClubUserListCnt", userVO);
    }

    /**
     * 동호회 운영자 목록을 조회한다.
     *
     * @param userVO
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<UserInfVO> selectClubOprtrList(UserInfVO userVO) throws Exception {
	return (List<UserInfVO>) list("EgovUserInfManageDAO.selectClubOprtrList", userVO);
    }

    /**
     * 동호회 운영자 목록에 대한 전체 건수를 조회한다.
     *
     * @param userVO
     * @return
     * @throws Exception
     */
    public int selectClubOprtrListCnt(UserInfVO userVO) throws Exception {
	return (Integer)selectOne("EgovUserInfManageDAO.selectClubOprtrListCnt", userVO);
    }

    /**
     * 동호회에 대한 모든 사용자 목록을 조회한다.
     *
     * @param userVO
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<UserInfVO> selectAllClubUser(UserInfVO userVO) throws Exception {
	return (List<UserInfVO>) list("EgovUserInfManageDAO.selectAllClubUser", userVO);
    }

    /**
     * 커뮤니티에 대한 모든 사용자 목록을 조회한다.
     *
     * @param userVO
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<UserInfVO> selectAllCmmntyUser(UserInfVO userVO) throws Exception {
	return (List<UserInfVO>) list("EgovUserInfManageDAO.selectAllCmmntyUser", userVO);
    }
}
