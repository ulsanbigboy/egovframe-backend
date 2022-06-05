/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ 휴일에 관한 서비스 인터페이스 클래스를 정의한다
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.let.sym.cal.service;

import java.util.List;



/**
 * <p>■휴일에 관한 서비스 인터페이스 클래스를 정의한다</p>
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
public interface EgovCalRestdeManageService {

	/**
	 * ■일반달력 팝업 정보를 조회한다.
	 * =================================
	 * @param restde
	 * @return List(일반달력 팝업 날짜정보)
	 * @throws Exception
	 */
	List<?> selectNormalRestdePopup(Restde restde)	throws Exception;

	/**
	 * ■행정달력 팝업 정보를 조회한다.
	 * =================================
	 * @param restde
	 * @return List(행정달력 팝업 날짜정보)
	 * @throws Exception
	 */
	List<?> selectAdministRestdePopup(Restde restde)	throws Exception;

	/**
	 * ■일반달력 일간 정보를 조회한다.
	 * =================================
	 * @param restde
	 * @return List(일반달력 일간 날짜정보)
	 * @throws Exception
	 */
	List<?> selectNormalDayCal(Restde restde)	throws Exception;

	/**
	 * ■일반달력 일간 휴일을 조회한다.
	 * =================================
	 * @param restde
	 * @return List(일반달력 일간 휴일정보)
	 * @throws Exception
	 */
	List<?> selectNormalDayRestde(Restde restde)	throws Exception;

	/**
	 * ■일반달력 월간 휴일을 조회한다.
	 * =================================
	 * @param restde
	 * @return List(일반달력 월간 휴일정보)
	 * @throws Exception
	 */
	List<?> selectNormalMonthRestde(Restde restde)	throws Exception;

	/**
	 * ■행정달력 일간 정보를 조회한다.
	 * =================================
	 * @param restde
	 * @return List(행정달력 일간 날짜정보)
	 * @throws Exception
	 */
	List<?> selectAdministDayCal(Restde restde)	throws Exception;

	/**
	 * ■행정달력 일간 휴일을 조회한다.
	 * =================================
	 * @param restde
	 * @return List(행정달력 일간 휴일정보)
	 * @throws Exception
	 */
	List<?> selectAdministDayRestde(Restde restde)	throws Exception;

	/**
	 * ■행정달력 월간 휴일을 조회한다.
	 * =================================
	 * @param restde
	 * @return List(행정달력 월간 휴일정보)
	 * @throws Exception
	 */
	List<?> selectAdministMonthRestde(Restde restde)	throws Exception;

	/**
	 * ■휴일을 삭제한다.
	 * =================================
	 * @param restde
	 * @throws Exception
	 */
	void deleteRestde(Restde restde) throws Exception;

	/**
	 * ■휴일을 등록한다.
	 * =================================
	 * @param restde
	 * @throws Exception
	 */
	void insertRestde(Restde restde) throws Exception;

	/**
	 * ■휴일 상세항목을 조회한다.
	 * =================================
	 * @param restde
	 * @return Restde(휴일)
	 * @throws Exception
	 */
	Restde selectRestdeDetail(Restde restde) throws Exception;

	/**
	 * ■휴일 목록을 조회한다.
	 * =================================
	 * @param searchVO
	 * @return List(휴일 목록)
	 * @throws Exception
	 */
	List<?> selectRestdeList(RestdeVO searchVO) throws Exception;

    /**
     * ■휴일 총 갯수를 조회한다.
	 * =================================
     * @param searchVO
     * @return int(휴일 총 갯수)
     */
    int selectRestdeListTotCnt(RestdeVO searchVO) throws Exception;

	/**
	 * ■휴일을 수정한다.
	 * =================================
	 * @param restde
	 * @throws Exception
	 */
	void updateRestde(Restde restde) throws Exception;

}
