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
package egovframework.com.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



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
@Configuration
public class EgovConfigAppWhitelist {

	
	/**
	 * ■함수 시작 로그 출력
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	@Bean
	public List<String> egovPageLinkWhitelist() {
		List<String> whiteList = new ArrayList<String>();
		whiteList.add("main/inc/EgovIncHeader");
		whiteList.add("main/inc/EgovIncTopnav");
		whiteList.add("main/inc/EgovIncLeftmenu");
		whiteList.add("main/inc/EgovIncFooter");
		whiteList.add("main/sample_menu/Intro");
		whiteList.add("main/sample_menu/EgovDownloadDetail");
		whiteList.add("main/sample_menu/EgovDownloadModify");
		whiteList.add("main/sample_menu/EgovQADetail");
		whiteList.add("main/sample_menu/EgovAboutSite");
		whiteList.add("main/sample_menu/EgovHistory");
		whiteList.add("main/sample_menu/EgovOrganization");
		whiteList.add("main/sample_menu/EgovLocation");
		whiteList.add("main/sample_menu/EgovProductInfo");
		whiteList.add("main/sample_menu/EgovServiceInfo");
		whiteList.add("main/sample_menu/EgovDownload");
		whiteList.add("main/sample_menu/EgovQA");
		whiteList.add("main/sample_menu/EgovService");
		return whiteList;
	}
	
}

