/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ DataSource 설정
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.com.config;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;


/**
 * <p>■DataSource 설정</p>
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
public class EgovConfigAppDatasource {

	
	/**
	 * ■@Value 을 어노테이션을 이용하는 방법
	 * =================================
	 */
	//	@Value("${Globals.DbType}")
	//	private String dbType;
	//
	//	@Value("${Globals.DriverClassName}")
	//	private String className;
	//
	//	@Value("${Globals.Url}")
	//	private String url;
	//
	//	@Value("${Globals.UserName}")
	//	private String userName;
	//
	//	@Value("${Globals.Password}")
	//	private String password;



	
	/**
	 * ■Environment 의존성 주입하여 사용하는 방법
	 * =================================
	 */
	@Autowired
	Environment env;


	
	/**
	 * ■XXXXXXXXXX
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	private String dbType;

	
	/**
	 * ■XXXXXXXXXX
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	private String className;

	
	/**
	 * ■XXXXXXXXXX
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	private String url;

	
	/**
	 * ■XXXXXXXXXX
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	private String userName;

	
	/**
	 * ■XXXXXXXXXX
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	private String password;

	
	/**
	 * ■XXXXXXXXXX
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	@PostConstruct
	void init() {
		dbType = env.getProperty("Globals.DbType");
		//Exception 처리 필요
		className = env.getProperty("Globals." + dbType + ".DriverClassName");
		url = env.getProperty("Globals." + dbType + ".Url");
		userName = env.getProperty("Globals." + dbType + ".UserName");
		password = env.getProperty("Globals." + dbType + ".Password");
	}

	
	/**
	 * ■XXXXXXXXXX
	 * =================================
	 * @return [dataSource 설정] HSQL 설정
	 */
	private DataSource dataSourceHSQL() {
		return new EmbeddedDatabaseBuilder()
			.setType(EmbeddedDatabaseType.HSQL)
			.setScriptEncoding("UTF8")
			.addScript("classpath:/db/shtdb.sql")
			//			.addScript("classpath:/otherpath/other.sql")
			.build();
	}

	
	/**
	 * ■XXXXXXXXXX
	 * =================================
	 * @return [dataSource 설정] basicDataSource 설정
	 */
	private DataSource basicDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(className);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(userName);
		basicDataSource.setPassword(password);
		return basicDataSource;
	}

	
	/**
	 * ■XXXXXXXXXX
	 * =================================
	 * @return [DataSource 설정]
	 */
	@Bean(name = {"dataSource", "egov.dataSource", "egovDataSource"})
	public DataSource dataSource() {
		if ("hsql".equals(dbType)) {
			return dataSourceHSQL();
		} else {
			return basicDataSource();
		}
	}
	
}
