/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ Properties 설정
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.com.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.egovframe.rte.fdl.property.impl.EgovPropertyServiceImpl;



/**
 * <p>■Properties 설정</p>
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
public class EgovConfigAppProperties {
	
	
	
	/**
	 * ■XXXXXXXXXX
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	
	@Bean(destroyMethod = "destroy")
	public EgovPropertyServiceImpl propertiesService() {
		EgovPropertyServiceImpl egovPropertyServiceImpl = new EgovPropertyServiceImpl();

		Map<String, String> properties = new HashMap<String, String>();
		properties.put("pageUnit", "10");
		properties.put("pageSize", "10");
		properties.put("posblAtchFileSize", "5242880");
		properties.put("Globals.fileStorePath", "/user/file/sht/");
		properties.put("Globals.addedOptions", "false");

		egovPropertyServiceImpl.setProperties(properties);
		return egovPropertyServiceImpl;
	}
}
