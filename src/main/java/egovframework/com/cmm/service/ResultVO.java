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
package egovframework.com.cmm.service;

import java.util.HashMap;
import java.util.Map;

public class ResultVO {

	private int resultCode = 0;
	private String resultMessage = "OK";
	private Map<String, Object> result = new HashMap<String, Object>();

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public void putResult(String key, Object value) {
		result.put(key, value);
	}

	public Object getResult(String key) {
		return this.result.get(key);
	}


}
