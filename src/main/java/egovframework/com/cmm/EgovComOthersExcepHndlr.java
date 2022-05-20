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
package egovframework.com.cmm;

import org.egovframe.rte.fdl.cmmn.exception.handler.ExceptionHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EgovComOthersExcepHndlr implements ExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(EgovComOthersExcepHndlr.class);

    public void occur(Exception exception, String packageName) {
    	//log.debug(" EgovServiceExceptionHandler run...............");
    	LOGGER.error(packageName, exception);
    }
}
