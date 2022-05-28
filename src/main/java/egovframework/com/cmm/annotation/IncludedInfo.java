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
package egovframework.com.cmm.annotation;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
 * <p>■컴포넌트의 포함 정보 표현을 위한 annotation 클래스</p>
 *      기본적으로 Controller 클래스에 annotation을 부여하되, 
 *      하나의 Controller에 여러 개의 목록성 url mapping이 제공되는 경우에는
 *      메소드에 annotation을 부여한다. 
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
@Retention(RetentionPolicy.RUNTIME) 
public @interface IncludedInfo {

	
	/**
	 * ■컴포넌트의 한글 이름
	 * =================================
	 */
	String name() default ""; 

	
	/**
	 * ■컴포넌트의 목록정보조회를 위한 URL
	 * =================================
	 */
	String listUrl() default "";

	
	/**
	 * ■자동 생성되는 메뉴 목록에 표시되는 순서
	 * =================================
	 */
	int order() default 0; 

	
	/**
	 * ■컴포넌트의 Group ID(대분류 구분)
	 * =================================
	 */
	int gid() default 0; 
	
}


