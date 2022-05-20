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

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.com.cmm.service.EgovProperties;

public class EgovWebServletContextListener implements ServletContextListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(EgovWebServletContextListener.class);

	public EgovWebServletContextListener() {
		setEgovProfileSetting();
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		if (System.getProperty("spring.profiles.active") == null) {
			setEgovProfileSetting();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		if (System.getProperty("spring.profiles.active") != null) {
			System.clearProperty("spring.profiles.active");
		}
	}

	public void setEgovProfileSetting() {
		try {
			LOGGER.debug("===========================Start EgovServletContextLoad START ===========");
			System.setProperty("spring.profiles.active",
					EgovProperties.getProperty("Globals.DbType") + "," + EgovProperties.getProperty("Globals.Auth"));
			LOGGER.debug("Setting spring.profiles.active>" + System.getProperty("spring.profiles.active"));
			LOGGER.debug("===========================END   EgovServletContextLoad END ===========");
		} catch (IllegalArgumentException e) {
			LOGGER.error("[IllegalArgumentException] Try/Catch...usingParameters Runing : " + e.getMessage());
		} catch (Exception e) {
			LOGGER.error("[" + e.getClass() + "] search fail : " + e.getMessage());
		}
	}
}
