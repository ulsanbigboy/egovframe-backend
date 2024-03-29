/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ XXXXXXXXXX
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.com.cmm;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * <p>■XXXXXXXXXX</p>
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
public class ComDefaultCodeVO implements Serializable {


	/**
	 * ■serialVersion UID
	 * =================================
	 */
	private static final long serialVersionUID = -2020648489890016404L;


	/**
	 * ■코드 ID
	 * =================================
	 */
    private String codeId = "";


	/**
	 * ■상세코드
	 * =================================
	 */
    private String code = "";


	/**
	 * ■코드명
	 * =================================
	 */
    private String codeNm = "";


	/**
	 * ■코드설명
	 * =================================
	 */
    private String codeDc = "";


	/**
	 * ■특정테이블명 - 특정테이블에서 코드정보를추출시 사용
	 * =================================
	 */
    private String tableNm = "";


	/**
	 * ■상세 조건 여부
	 * =================================
	 */
    private String haveDetailCondition = "N";


	/**
	 * ■상세 조건
	 * =================================
	 */
    private String detailCondition = "";

    /**
     * ■codeId attribute를 리턴한다.
	 * =================================
     * @return the codeId
     */
    public String getCodeId() {
	return codeId;
    }

    /**
     * ■codeId attribute 값을 설정한다.
	 * =================================
     * @param codeId - the codeId to set
     */
    public void setCodeId(String codeId) {
	this.codeId = codeId;
    }

    /**
     * ■code attribute를 리턴한다.
	 * =================================
     * @return the code
     */
    public String getCode() {
    	return code;
    }

    /**
     * ■code attribute 값을 설정한다.
	 * =================================
     * @param code - the code to set
     */
    public void setCode(String code) {
    	this.code = code;
    }

    /**
     * ■codeNm attribute를 리턴한다.
	 * =================================
     * @return the codeNm
     */
    public String getCodeNm() {
    	return codeNm;
    }

    /**
     * ■codeNm attribute 값을 설정한다.
	 * =================================
     * @param codeNm - the codeNm to set
     */
    public void setCodeNm(String codeNm) {
    	this.codeNm = codeNm;
    }

    /**
     * ■codeDc attribute를 리턴한다.
	 * =================================
     * @return the codeDc
     */
    public String getCodeDc() {
    	return codeDc;
    }

    /**
     * ■codeDc attribute 값을 설정한다.
	 * =================================
     * @param codeDc - the codeDc to set
     */
    public void setCodeDc(String codeDc) {
    	this.codeDc = codeDc;
    }

    /**
     * ■tableNm attribute를 리턴한다.
	 * =================================
     * @return the tableNm
     */
    public String getTableNm() {
    	return tableNm;
    }

    /**
     * ■tableNm attribute 값을 설정한다.
	 * =================================
     * @param tableNm - the tableNm to set
     */
    public void setTableNm(String tableNm) {
    	this.tableNm = tableNm;
    }

    /**
     * ■haveDetailCondition attribute를 리턴한다.
	 * =================================
     * @return the haveDetailCondition
     */
    public String getHaveDetailCondition() {
    	return haveDetailCondition;
    }

    /**
     * ■haveDetailCondition attribute 값을 설정한다.
	 * =================================
     * @param haveDetailCondition - the haveDetailCondition to set
     */
    public void setHaveDetailCondition(String haveDetailCondition) {
    	this.haveDetailCondition = haveDetailCondition;
    }

    /**
     * ■detailCondition attribute를 리턴한다.
	 * =================================
     * @return the detailCondition
     */
    public String getDetailCondition() {
    	return detailCondition;
    }

    /**
     * ■detailCondition attribute 값을 설정한다.
	 * =================================
     * @param detailCondition - the detailCondition to set
     */
    public void setDetailCondition(String detailCondition) {
    	this.detailCondition = detailCondition;
    }

    /**
     * ■toString 메소드를 대치한다.
	 * =================================
     */
    public String toString() {
    	return ToStringBuilder.reflectionToString(this);
    }
    
}


