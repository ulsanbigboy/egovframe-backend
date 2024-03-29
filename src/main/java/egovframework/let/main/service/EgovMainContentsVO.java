/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■  템플릿 메인화면 작업 List 항목 VO(Sample 소스)
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.let.main.service;

import java.io.Serializable;



/**
 * <p>■ 템플릿 메인화면 작업 List 항목 VO(Sample 소스)</p>
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
public class EgovMainContentsVO implements Serializable {

	/**
	 * ■serialVersionUID
	 * =================================
	 */
	private static final long serialVersionUID = -2202175699511921484L;
	
	/**
	 * ■작업항목 이름
	 * =================================
	 */
	private String workItemName;
	
	/**
	 * ■To-Do List 항목 별 업무화면 URL
	 * =================================
	 */
	private String workItemURL;

	/**
	 * ■getItemCount 항목 개수 getter
	 * =================================
	 * @return
	 */
	public int getItemCount(){
		return 0;
	}

	/**
	 * ■getWorkItemName To-Do List 항목 명 getter
	 * =================================
	 * @return To-Do List 항목 명
	 */
	public String getWorkItemName(){
		return workItemName;
	}

	/**
	 * ■getWorkItemURL 업무화면 URL getter
	 * =================================
	 * @return 업무화면 URL
	 */
	public String getWorkItemURL(){
		return workItemURL;
	}
	
}

