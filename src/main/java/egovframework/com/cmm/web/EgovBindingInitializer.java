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
package egovframework.com.cmm.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;

public class EgovBindingInitializer implements WebBindingInitializer {

	@Override
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
	}

}
