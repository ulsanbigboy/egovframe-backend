/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ 세션 VO 클래스
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.com.cmm;

import java.io.Serializable;



/**
 * <p>■세션 VO 클래스</p>
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
public class SessionVO implements Serializable {

	
	/**
	 * ■함수 시작 로그 출력
	 * =================================
	 */
	private static final long serialVersionUID = -2848741427493626376L;
	
	/**
	 * ■아이디
	 * =================================
	 */
	private String sUserId;
	
	/**
	 * ■이름
	 * =================================
	 */
	private String sUserNm;
	
	/**
	 * ■이메일
	 * =================================
	 */
	private String sEmail;
	
	/**
	 * ■사용자구분
	 * =================================
	 */
	private String sUserSe;
	
	/**
	 * ■조직(부서)ID
	 * =================================
	 */
	private String orgnztId;
	
	/**
	 * ■고유아이디
	 * =================================
	 */
	private String uniqId;
	
	/**
	 * ■sUserId attribute 를 리턴한다.
	 * =================================
	 * @return String
	 */
	public String getSUserId() {
		return sUserId;
	}
	
	/**
	 * ■sUserId attribute 값을 설정한다.
	 * =================================
	 * @param sUserId String
	 */
	public void setSUserId(String userId) {
		sUserId = userId;
	}
	
	/**
	 * ■sUserNm attribute 를 리턴한다.
	 * =================================
	 * @return String
	 */
	public String getSUserNm() {
		return sUserNm;
	}
	
	/**
	 * ■sUserNm attribute 값을 설정한다.
	 * =================================
	 * @param sUserNm String
	 */
	public void setSUserNm(String userNm) {
		sUserNm = userNm;
	}
	
	/**
	 * ■sEmail attribute 를 리턴한다.
	 * =================================
	 * @return String
	 */
	public String getSEmail() {
		return sEmail;
	}
	
	/**
	 * ■sEmail attribute 값을 설정한다.
	 * =================================
	 * @param sEmail String
	 */
	public void setSEmail(String email) {
		sEmail = email;
	}
	
	/**
	 * ■sUserSe attribute 를 리턴한다.
	 * =================================
	 * @return String
	 */
	public String getSUserSe() {
		return sUserSe;
	}
	
	/**
	 * ■sUserSe attribute 값을 설정한다.
	 * =================================
	 * @param sUserSe String
	 */
	public void setSUserSe(String userSe) {
		sUserSe = userSe;
	}
	
	/**
	 * ■orgnztId attribute 를 리턴한다.
	 * =================================
	 * @return String
	 */
	public String getOrgnztId() {
		return orgnztId;
	}
	
	/**
	 * ■orgnztId attribute 값을 설정한다.
	 * =================================
	 * @param orgnztId String
	 */
	public void setOrgnztId(String orgnztId) {
		this.orgnztId = orgnztId;
	}
	
	/**
	 * ■uniqId attribute 를 리턴한다.
	 * =================================
	 * @return String
	 */
	public String getUniqId() {
		return uniqId;
	}
	
	/**
	 * ■uniqId attribute 값을 설정한다.
	 * =================================
	 * @param uniqId String
	 */
	public void setUniqId(String uniqId) {
		this.uniqId = uniqId;
	}
	
}
