/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * �� Ű �� �� : 
 * ��       �� : 0.0
 * ���� �ý��� : 
 * ��       �� : 2022.05.01
 * �� �� ȯ �� : JDK1.7.0_79, RESIN-3.1.9
 * �� �� �� �� : �� ���� >  �α� ���
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ����Ű����
 */


/**
 * <p>����� >  �α� ���</p>
 * <p>COPYRIGHT: Copyright (c) 2003</p>
 * <p>COMPANY: (LTD)KYOBOBOOK</p>
 * <DL>
 *   <DT>ó����.<BR>
 *     <DD>.<BR>
 * <BR>
 *   <DT>��������.<BR>
 *     <DD>����ȯ�� : jdk8, resin 3.1<BR>
 * </DL>
 * <BR>
 *
 * @author   
 * @version  1.0
 * @since    1.0
 */
	
	/**
	 * ���Լ� ���� �α� ���
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
package egovframework.com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@Import({
	EgovConfigAppAspect.class,
	EgovConfigAppCommon.class,
	EgovConfigAppDatasource.class,
	EgovConfigAppIdGen.class,
	EgovConfigAppProperties.class,
	EgovConfigAppMapper.class,
	EgovConfigAppTransaction.class,
	EgovConfigAppValidator.class,
	EgovConfigAppWhitelist.class
})
@PropertySources({
	@PropertySource("classpath:/egovframework/egovProps/globals.properties")
}) //CAUTION: min JDK 8
public class EgovConfigApp {

}
