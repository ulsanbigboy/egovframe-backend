/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ 일정관리를 처리하는 서비스인터페이스 클래스
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.let.cop.smt.sim.service;

import java.util.List;
import java.util.Map;

import egovframework.com.cmm.ComDefaultVO;


/**
 * <p>■일정관리를 처리하는 서비스인터페이스 클래스</p>
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
public interface EgovIndvdlSchdulManageService {

	/**
	 * ■일정를(을) 삭제한다.
	 * =================================
	 * @param indvdlSchdulManageVO    - 일정 정보 담김 VO
	 * @exception Exception Exception
	 */
	public void deleteIndvdlSchdulManage(IndvdlSchdulManageVO indvdlSchdulManageVO) throws Exception;

	/**
	 * ■일정를(을) 등록한다.
	 * =================================
	 *
	 * @param indvdlSchdulManageVO    - 일정 정보 담김 VO
	 * @exception Exception Exception
	 */
	public void insertIndvdlSchdulManage(IndvdlSchdulManageVO indvdlSchdulManageVO) throws Exception;

	/**
	 * ■일정를(을) 상세조회 한다.
	 * =================================
	 * @return List
	 *
	 * @param indvdlSchdulManageVO    - 일정 정보 담김 VO
	 * @exception Exception Exception
	 */
	public IndvdlSchdulManageVO selectIndvdlSchdulManageDetail(IndvdlSchdulManageVO indvdlSchdulManageVO) throws Exception;

	/**
	 * ■일정 목록을 VO(model)형식으로 조회한다.
	 * =================================
	 * @return List
	 *
	 * @param indvdlSchdulManageVO    - 조회할 정보가 담긴 VO
	 * @exception Exception Exception
	 */
	public IndvdlSchdulManageVO selectIndvdlSchdulManageDetailVO(IndvdlSchdulManageVO indvdlSchdulManageVO) throws Exception;

	/**
	 * ■일정 목록을 조회한다.
	 * =================================
	 * @return List
	 *
	 * @param searchVO    - 조회할 정보가 담긴 VO
	 * @exception Exception Exception
	 */
	public List<?> selectIndvdlSchdulManageList(ComDefaultVO searchVO) throws Exception;

	/**
	 * ■일정를(을) 목록 전체 건수를(을) 조회한다.
	 * =================================
	 * @return int
	 *
	 * @param searchVO    - 조회할 정보가 담긴 VO
	 * @exception Exception Exception
	 */
	public int selectIndvdlSchdulManageListCnt(ComDefaultVO searchVO) throws Exception;

	/**
	 * ■메인페이지/일정관리조회
	 * =================================
	 * @return List
	 *
	 * @param map    - 조회할 정보가 담긴 map
	 * @exception Exception Exception
	 */
	public List<?> selectIndvdlSchdulManageMainList(Map<?, ?> map) throws Exception;

	/**
	 * ■일정 목록을 Map(map)형식으로 조회한다.
	 * =================================
	 * @param Map(map) - 조회할 정보가 담긴 Map
	 * @return List
	 *
	 * @param map
	 * @exception Exception Exception
	 */
	public List<?> selectIndvdlSchdulManageRetrieve(Map<?, ?> map) throws Exception;

	/**
	 * ■일정를(을) 수정한다.
	 * =================================
	 * @param indvdlSchdulManageVO    - 일정 정보 담김 VO
	 * @exception Exception Exception
	 */
	public void updateIndvdlSchdulManage(IndvdlSchdulManageVO indvdlSchdulManageVO) throws Exception;
	
}


