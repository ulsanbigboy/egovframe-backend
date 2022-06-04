/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 :
 * 버       젼 : 0.0
 * 서브 시스템 :
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ 
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.com.cmm;


/**
 * <p>■</p>
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
public enum ResponseCode {


	/**
	 * ■
	 * =================================
	 */
	SUCCESS(200, "성공했습니다."),


	/**
	 * ■
	 * =================================
	 */
	AUTH_ERROR(403, "인가된 사용자가 아닙니다."),


	/**
	 * ■
	 * =================================
	 */
	DELETE_ERROR(700, "삭제 중 내부 오류가 발생했습니다."),


	/**
	 * ■
	 * =================================
	 */
	SAVE_ERROR(800, "저장시 내부 오류가 발생했습니다."),


	/**
	 * ■
	 * =================================
	 */
	INPUT_CHECK_ERROR(900, "입력값 무결성 오류 입니다.");

	
	/**
	 * ■응답코드
	 * =================================
	 */
	private int code;
	
	
	/**
	 * ■응답메시지
	 * =================================
	 */
	private String message;


	/**
	 * ■응답정보 설정
	 * =================================
	 * @param code
	 * @param message
	 */
	private ResponseCode(int code, String message) {
		this.code = code;
		this.message = message;
	}


	/**
	 * ■응답코드 반환
	 * =================================
	 */
	public int getCode() {
		return code;
	}


	/**
	 * ■응답메시지 반환
	 * =================================
	 */
	public String getMessage() {
		return message;
	}

	
}


