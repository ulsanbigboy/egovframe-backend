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
package egovframework.let.sym.cal.service;

import java.io.Serializable;

/**
 * 휴일 모델 클래스
 * @author 공통서비스 개발팀 이중호
 * @since 2009.04.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.04.01  이중호          최초 생성
 *
 * </pre>
 */
public class Restde implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * 휴일번호
	 */
    private int    restdeNo       = 0;
    
    /*
     * 휴일일자
     */
    private String restdeDe       = "";
    
    /*
     * 휴일명
     */
    private String restdeNm       = "";
    
    /*
     * 휴일설명
     */
    private String restdeDc       = "";
    
    /*
     * 휴일구분
     */
    private String restdeSe       = "";
    
    /*
     * 휴일구분코드
     */
    private String restdeSeCode   = "";
    
    /*
     * 최초등록자ID
     */
    private String frstRegisterId = "";
    
    /*
     * 최종수정자ID
     */
    private String lastUpdusrId   = "";

    /*
     * 년
     */
    private String year           = "";
    
    /*
     * 월
     */
    private String month          = "";
    
    /*
     * 일
     */
    private String day            = "";
    
    /*
     * 휴일여부
     */
    private String restdeAt       = "";

    /*
     * 달력셀
     */
	private int    cellNum        = 0;
	
	/*
	 * 월별 주순위
	 */
    private int    weeks          = 0;
    
    /*
     * 월 주수
     */
    private int maxWeeks = 0;
    
    /*
     * 요일
     */
    private int    week           = 0;
    
    /*
     * 시작요일 
     */
    private int    startWeekMonth = 0;
    
    /*
     * 마지막 일자
     */
    private int    lastDayMonth   = 0;

	/**
	 * restdeNo attribute 를 리턴한다.
	 * @return int
	 */
	public int getRestdeNo() {
		return restdeNo;
	}

	/**
	 * restdeNo attribute 값을 설정한다.
	 * @param restdeNo int
	 */
	public void setRestdeNo(int restdeNo) {
		this.restdeNo = restdeNo;
	}

	/**
	 * restdeDe attribute 를 리턴한다.
	 * @return String
	 */
	public String getRestdeDe() {
		return restdeDe;
	}

	/**
	 * restdeDe attribute 값을 설정한다.
	 * @param restdeDe String
	 */
	public void setRestdeDe(String restdeDe) {
		this.restdeDe = restdeDe;
	}

	/**
	 * restdeNm attribute 를 리턴한다.
	 * @return String
	 */
	public String getRestdeNm() {
		return restdeNm;
	}

	/**
	 * restdeNm attribute 값을 설정한다.
	 * @param restdeNm String
	 */
	public void setRestdeNm(String restdeNm) {
		this.restdeNm = restdeNm;
	}

	/**
	 * restdeDc attribute 를 리턴한다.
	 * @return String
	 */
	public String getRestdeDc() {
		return restdeDc;
	}

	/**
	 * restdeDc attribute 값을 설정한다.
	 * @param restdeDc String
	 */
	public void setRestdeDc(String restdeDc) {
		this.restdeDc = restdeDc;
	}

	/**
	 * restdeSe attribute 를 리턴한다.
	 * @return String
	 */
	public String getRestdeSe() {
		return restdeSe;
	}

	/**
	 * restdeSe attribute 값을 설정한다.
	 * @param restdeSe String
	 */
	public void setRestdeSe(String restdeSe) {
		this.restdeSe = restdeSe;
	}

	/**
	 * restdeSeCode attribute 를 리턴한다.
	 * @return String
	 */
	public String getRestdeSeCode() {
		return restdeSeCode;
	}

	/**
	 * restdeSeCode attribute 값을 설정한다.
	 * @param restdeSeCode String
	 */
	public void setRestdeSeCode(String restdeSeCode) {
		this.restdeSeCode = restdeSeCode;
	}

	/**
	 * frstRegisterId attribute 를 리턴한다.
	 * @return String
	 */
	public String getFrstRegisterId() {
		return frstRegisterId;
	}

	/**
	 * frstRegisterId attribute 값을 설정한다.
	 * @param frstRegisterId String
	 */
	public void setFrstRegisterId(String frstRegisterId) {
		this.frstRegisterId = frstRegisterId;
	}

	/**
	 * lastUpdusrId attribute 를 리턴한다.
	 * @return String
	 */
	public String getLastUpdusrId() {
		return lastUpdusrId;
	}

	/**
	 * lastUpdusrId attribute 값을 설정한다.
	 * @param lastUpdusrId String
	 */
	public void setLastUpdusrId(String lastUpdusrId) {
		this.lastUpdusrId = lastUpdusrId;
	}

	/**
	 * year attribute 를 리턴한다.
	 * @return String
	 */
	public String getYear() {
		return year;
	}

	/**
	 * year attribute 값을 설정한다.
	 * @param year String
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * month attribute 를 리턴한다.
	 * @return String
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * month attribute 값을 설정한다.
	 * @param month String
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * day attribute 를 리턴한다.
	 * @return String
	 */
	public String getDay() {
		return day;
	}

	/**
	 * day attribute 값을 설정한다.
	 * @param day String
	 */
	public void setDay(String day) {
		this.day = day;
	}

	/**
	 * restdeAt attribute 를 리턴한다.
	 * @return String
	 */
	public String getRestdeAt() {
		return restdeAt;
	}

	/**
	 * restdeAt attribute 값을 설정한다.
	 * @param restdeAt String
	 */
	public void setRestdeAt(String restdeAt) {
		this.restdeAt = restdeAt;
	}

	/**
	 * cellNum attribute 를 리턴한다.
	 * @return int
	 */
	public int getCellNum() {
		return cellNum;
	}

	/**
	 * cellNum attribute 값을 설정한다.
	 * @param cellNum int
	 */
	public void setCellNum(int cellNum) {
		this.cellNum = cellNum;
	}

	/**
	 * weeks attribute 를 리턴한다.
	 * @return int
	 */
	public int getWeeks() {
		return weeks;
	}

	/**
	 * weeks attribute 값을 설정한다.
	 * @param weeks int
	 */
	public void setWeeks(int weeks) {
		this.weeks = weeks;
	}

	/**
	 * maxWeeks attribute 를 리턴한다.
	 * @return int
	 */
	public int getMaxWeeks() {
		return maxWeeks;
	}

	/**
	 * maxWeeks attribute 값을 설정한다.
	 * @param maxWeeks int
	 */
	public void setMaxWeeks(int maxWeeks) {
		this.maxWeeks = maxWeeks;
	}

	/**
	 * week attribute 를 리턴한다.
	 * @return int
	 */
	public int getWeek() {
		return week;
	}

	/**
	 * week attribute 값을 설정한다.
	 * @param week int
	 */
	public void setWeek(int week) {
		this.week = week;
	}

	/**
	 * startWeekMonth attribute 를 리턴한다.
	 * @return int
	 */
	public int getStartWeekMonth() {
		return startWeekMonth;
	}

	/**
	 * startWeekMonth attribute 값을 설정한다.
	 * @param startWeekMonth int
	 */
	public void setStartWeekMonth(int startWeekMonth) {
		this.startWeekMonth = startWeekMonth;
	}

	/**
	 * lastDayMonth attribute 를 리턴한다.
	 * @return int
	 */
	public int getLastDayMonth() {
		return lastDayMonth;
	}

	/**
	 * lastDayMonth attribute 값을 설정한다.
	 * @param lastDayMonth int
	 */
	public void setLastDayMonth(int lastDayMonth) {
		this.lastDayMonth = lastDayMonth;
	}

    
}
