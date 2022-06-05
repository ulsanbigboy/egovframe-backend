/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ 게시판의 이용정보를 관리하기 위한 모델 클래스
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.let.cop.com.service;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;




/**
 * <p>■게시판의 이용정보를 관리하기 위한 모델 클래스</p>
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
public class BoardUseInf implements Serializable {

	
	/**
	 * ■serialVersion UID
	 * =================================
	 */
	private static final long serialVersionUID = -8164785314697750055L;

	/**
	 * ■게시판 아이디
	 * =================================
	 */
    private String bbsId = "";

	/**
	 * ■대상시스템 아이디
	 * =================================
	 */
    private String trgetId = "";

	/**
	 * ■대상 구분 (커뮤니티, 동호회)
	 * =================================
	 */
    private String trgetType = "";

	/**
	 * ■최초 등록자 아이디
	 * =================================
	 */
    private String frstRegisterId = "";

	/**
	 * ■최초등록시점
	 * =================================
	 */
    private String frstRegisterPnttm = "";

	/**
	 * ■최종수정자 아이디
	 * =================================
	 */
    private String lastUpdusrId = "";

	/**
	 * ■최종수정시점
	 * =================================
	 */
    private String lastUpdusrPnttm = "";

	/**
	 * ■등록구분코드
	 * =================================
	 */
    private String registSeCode = "";

	/**
	 * ■사용여부
	 * =================================
	 */
    private String useAt = "";

    /**
     * ■bbsId attribute를 리턴한다.
	 * =================================
     * @return the bbsId
     */
    public String getBbsId() {
    	return bbsId;
    }

    /**
     * ■bbsId attribute 값을 설정한다.
	 * =================================
     * @param bbsId - the bbsId to set
     */
    public void setBbsId(String bbsId) {
    	this.bbsId = bbsId;
    }

    /**
     * ■trgetId attribute를 리턴한다.
	 * =================================
     * @return the trgetId
     */
    public String getTrgetId() {
    	return trgetId;
    }

    /**
     * ■trgetId attribute 값을 설정한다.
	 * =================================
     * @param trgetId - the trgetId to set
     */
    public void setTrgetId(String trgetId) {
	this.trgetId = trgetId;
    }

    /**
     * ■frstRegisterId attribute를 리턴한다.
	 * =================================
     * @return the frstRegisterId
     */
    public String getFrstRegisterId() {
    	return frstRegisterId;
    }

    /**
     * ■frstRegisterId attribute 값을 설정한다.
	 * =================================
     * @param frstRegisterId - the frstRegisterId to set
     */
    public void setFrstRegisterId(String frstRegisterId) {
    	this.frstRegisterId = frstRegisterId;
    }

    /**
     * ■frstRegisterPnttm attribute를 리턴한다.
	 * =================================
     * @return the frstRegisterPnttm
     */
    public String getFrstRegisterPnttm() {
    	return frstRegisterPnttm;
    }

    /**
     * ■frstRegisterPnttm attribute 값을 설정한다.
	 * =================================
     * @param frstRegisterPnttm - the frstRegisterPnttm to set
     */
    public void setFrstRegisterPnttm(String frstRegisterPnttm) {
    	this.frstRegisterPnttm = frstRegisterPnttm;
    }

    /**
     * ■lastUpdusrId attribute를 리턴한다.
	 * =================================
     * @return the lastUpdusrId
     */
    public String getLastUpdusrId() {
    	return lastUpdusrId;
    }

    /**
     * ■lastUpdusrId attribute 값을 설정한다.
	 * =================================
     * @param lastUpdusrId - the lastUpdusrId to set
     */
    public void setLastUpdusrId(String lastUpdusrId) {
	this.lastUpdusrId = lastUpdusrId;
    }

    /**
     * ■lastUpdusrPnttm attribute를 리턴한다.
	 * =================================
     * @return the lastUpdusrPnttm
     */
    public String getLastUpdusrPnttm() {
    	return lastUpdusrPnttm;
    }

    /**
     * ■lastUpdusrPnttm attribute 값을 설정한다.
	 * =================================
     * @param lastUpdusrPnttm - the lastUpdusrPnttm to set
     */
    public void setLastUpdusrPnttm(String lastUpdusrPnttm) {
    	this.lastUpdusrPnttm = lastUpdusrPnttm;
    }

    /**
     * ■registSeCode attribute를 리턴한다.
	 * =================================
     * @return the registSeCode
     */
    public String getRegistSeCode() {
    	return registSeCode;
    }

    /**
     * ■registSeCode attribute 값을 설정한다.
	 * =================================
     * @param registSeCode - the registSeCode to set
     */
    public void setRegistSeCode(String registSeCode) {
    	this.registSeCode = registSeCode;
    }

    /**
     * ■useAt attribute를 리턴한다.
	 * =================================
     * @return the useAt
     */
    public String getUseAt() {
    	return useAt;
    }

    /**
     * ■useAt attribute 값을 설정한다.
	 * =================================
     * @param useAt - the useAt to set
     */
    public void setUseAt(String useAt) {
    	this.useAt = useAt;
    }

    /**
     * ■trgetType attribute를 리턴한다.
	 * =================================
     * @return the trgetType
     */
    public String getTrgetType() {
        return trgetType;
    }

    /**
     * ■trgetType attribute 값을 설정한다.
	 * =================================
     * @param trgetType the trgetType to set
     */
    public void setTrgetType(String trgetType) {
        this.trgetType = trgetType;
    }

    /**
     * ■toString 메소드를 대치한다.
	 * =================================
     */
    public String toString() {
    	return ToStringBuilder.reflectionToString(this);
    }
}
