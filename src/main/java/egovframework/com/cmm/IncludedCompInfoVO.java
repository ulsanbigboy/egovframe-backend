/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ IncludedInfo annotation을 바탕으로 화면에 표시할 정보를 구성하기 위한 VO 클래스
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.com.cmm;


/**
 * <p>■IncludedInfo annotation을 바탕으로 화면에 표시할 정보를 구성하기 위한 VO 클래스</p>
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
public class IncludedCompInfoVO {


	/**
	 * ■ XXXXXXXXXX
	 * =================================
	 */
	private String name;


	/**
	 * ■ XXXXXXXXXX
	 * =================================
	 */
	private String listUrl;


	/**
	 * ■ XXXXXXXXXX
	 * =================================
	 */
	private int order;


	/**
	 * ■ XXXXXXXXXX
	 * =================================
	 */
	private int gid;
	
	/**
	 * ■ XXXXXXXXXX
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * ■ XXXXXXXXXX
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * ■ XXXXXXXXXX
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	public String getListUrl() {
		return listUrl;
	}
	
	/**
	 * ■ XXXXXXXXXX
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	public void setListUrl(String listUrl) {
		this.listUrl = listUrl;
	}
	
	/**
	 * ■ XXXXXXXXXX
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	public int getOrder() {
		return order;
	}
	
	/**
	 * ■ XXXXXXXXXX
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	public void setOrder(int order) {
		this.order = order;
	}
	
	/**
	 * ■ XXXXXXXXXX
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	public int getGid() {
		return gid;
	}
	
	/**
	 * ■ XXXXXXXXXX
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	public void setGid(int gid) {
		this.gid = gid;
	}
	
}
