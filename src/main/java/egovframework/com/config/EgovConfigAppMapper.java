/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ Mapper 설정
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.com.config;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.support.lob.DefaultLobHandler;



/**
 * <p>■Mapper 설정</p>
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
@PropertySources({
	@PropertySource("classpath:/egovframework/egovProps/globals.properties")
})
public class EgovConfigAppMapper {


	/**
	 * ■XXXXXXXXXX
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	@Autowired
	DataSource dataSource;


	/**
	 * ■XXXXXXXXXX
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
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
	@PostConstruct
	void init() {
		dbType = env.getProperty("Globals.DbType");
	}


	/**
	 * ■XXXXXXXXXX
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	@Bean
	@Lazy
	public DefaultLobHandler lobHandler() {
		return new DefaultLobHandler();
	}


	/**
	 * ■XXXXXXXXXX
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	@Bean(name = {"sqlSession", "egov.sqlSession"})
	public SqlSessionFactoryBean sqlSession() {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);

		PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();

		sqlSessionFactoryBean.setConfigLocation(
			pathMatchingResourcePatternResolver
				.getResource("classpath:/egovframework/mapper/config/mapper-config.xml"));

		try {
			sqlSessionFactoryBean.setMapperLocations(
				pathMatchingResourcePatternResolver
					.getResources("classpath:/egovframework/mapper/let/**/*_" + dbType + ".xml"));
		} catch (IOException e) {
			// TODO Exception 처리 필요
		}

		return sqlSessionFactoryBean;
	}


	/**
	 * ■XXXXXXXXXX
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	@Bean
	public SqlSessionTemplate egovSqlSessionTemplate(@Qualifier("sqlSession") SqlSessionFactory sqlSession) {
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSession);
		return sqlSessionTemplate;
	}
	
}

