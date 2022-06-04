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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springmodules.validation.commons.DefaultBeanValidator;
import org.springmodules.validation.commons.DefaultValidatorFactory;



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
public class EgovConfigAppValidator {

	
	/**
	 * ■
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	@Bean
	public DefaultBeanValidator beanValidator() {
		DefaultBeanValidator defaultBeanValidator = new DefaultBeanValidator();
		defaultBeanValidator.setValidatorFactory(validatorFactory());
		return defaultBeanValidator;

	}

	
	/**
	 * ■
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	/** validation config location 설정
	 * @return
	 */
	@Bean
	public DefaultValidatorFactory validatorFactory() {
		DefaultValidatorFactory defaultValidatorFactory = new DefaultValidatorFactory();

		defaultValidatorFactory.setValidationConfigLocations(getValidationConfigLocations());

		return defaultValidatorFactory;
	}

	
	/**
	 * ■
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	private Resource[] getValidationConfigLocations() {

		PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();

		List<Resource> validationConfigLocations = new ArrayList<Resource>();

		Resource[] validationRulesConfigLocations = new Resource[] {
			pathMatchingResourcePatternResolver
				.getResource("classpath:/egovframework/validator/validator-rules-let.xml")
		};

		Resource[] validationFormSetLocations = new Resource[] {};
		try {
			validationFormSetLocations = pathMatchingResourcePatternResolver
				.getResources("classpath:/egovframework/validator/let/**/*.xml");
		} catch (IOException e) {
			// TODO Exception 처리 필요
		}

		validationConfigLocations.addAll(Arrays.asList(validationRulesConfigLocations));
		validationConfigLocations.addAll(Arrays.asList(validationFormSetLocations));

		return validationConfigLocations.toArray(new Resource[validationConfigLocations.size()]);
	}
}
