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
package egovframework.com.cmm;

import java.io.IOException;
import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;

import org.egovframe.rte.psl.orm.ibatis.support.AbstractLobTypeHandler;


/**
 * <p>■iBATIS TypeHandler implementation for Strings that get mapped to CLOBs.</p>
 * Retrieves the LobHandler to use from SqlMapClientFactoryBean at config time.
 *
 * <p>Particularly useful for storing Strings with more than 4000 characters in an
 * Oracle database (only possible via CLOBs), in combination with OracleLobHandler.
 *
 * <p>Can also be defined in generic iBATIS mappings, as DefaultLobCreator will
 * work with most JDBC-compliant database drivers. In this case, the field type
 * does not have to be BLOB: For databases like MySQL and MS SQL Server, any
 * large enough binary type will work.
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
@SuppressWarnings("deprecation")
public class AltibaseClobStringTypeHandler extends AbstractLobTypeHandler {

	
	/**
	 * ■로그변수
	 * =================================
	 */
	private Logger logger = LoggerFactory.getLogger(getClass());


	
	/**
	 * ■Constructor used by iBATIS: fetches config-time LobHandler from SqlMapClientFactoryBean.
	 * =================================
	 * @see org.springframework.orm.ibatis.SqlMapClientFactoryBean#getConfigTimeLobHandler
	 */
	public AltibaseClobStringTypeHandler() {
		super();
	}


	
	/**
	 * ■Constructor used for testing: takes an explicit LobHandler.
	 * =================================
	 * @param lobHandler
	 * @param msg
	 * @param req
	 */
	/**
	 * 
	 */
	protected AltibaseClobStringTypeHandler(LobHandler lobHandler) {
		super(lobHandler);
	}


	
	/**
	 * ■
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	@Override
	protected void setParameterInternal( PreparedStatement ps, int index, Object value, String jdbcType, LobCreator lobCreator) throws SQLException {
		lobCreator.setClobAsString(ps, index, (String) value);
	}

	
	/**
	 * ■
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	@Override
	protected Object getResultInternal(ResultSet rs, int index, LobHandler lobHandler) throws SQLException {

		StringBuffer read_data = new StringBuffer("");
	    int read_length;

		char [] buf = new char[1024];

		Reader rd =  lobHandler.getClobAsCharacterStream(rs, index);
	    try {
			while( (read_length=rd.read(buf))  != -1) {
				read_data.append(buf, 0, read_length);
			}
	    } catch (IOException ie) {
	    	logger.debug("ie: {}", ie);//SQLException sqle = new SQLException(ie.getMessage());
	    	//throw sqle;
    	// 2011.10.10 보안점검 후속조치
	    } finally {
		    if (rd != null) {
			try {
			    rd.close();
			} catch (IOException ignore) {
				logger.debug("IGNORE: {}", ignore.getMessage());
			}
		    }
		}

	    return read_data.toString();

		//return lobHandler.getClobAsString(rs, index);
	}

	
	/**
	 * ■
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	@Override
	public Object valueOf(String s) {
		return s;
	}

}
