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

import java.util.List;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import egovframework.com.cmm.interceptor.AuthenticInterceptor;
import egovframework.com.cmm.interceptor.CustomAuthenticInterceptor;



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
@ComponentScan(basePackages = "egovframework", excludeFilters = {
	@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Service.class),
	@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Repository.class),
	@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class)
})
public class EgovConfigWebDispatcherServlet implements WebMvcConfigurer {

	
	/**
	 * ■
	 * =================================
	 */
	final static String RESOLVER_DEFAULT_ERROR_VIEW = "cmm/error/egovError";
	
	/**
	 * ■
	 * =================================
	 */
	final static int URL_BASED_VIEW_RESOLVER_ORDER = 1;
	
	/**
	 * ■
	 * =================================
	 */
	final static String URL_BASED_VIEW_RESOLVER_PREFIX = "/WEB-INF/jsp/";
	
	/**
	 * ■
	 * =================================
	 */
	final static String URL_BASED_VIEW_RESOLVER_SUFFIX = ".jsp";

	//private final String[] CORS_ORIGIN_SERVER_URLS = {"http://127.0.0.1:3000", "http://localhost:3000"};

	
	/**
	 * ■
	 * =================================
	 * @param registry
	 */
	// =====================================================================
	// RequestMappingHandlerMapping 설정
	// =====================================================================
	// -------------------------------------------------------------
	// RequestMappingHandlerMapping 설정 - Interceptor 추가
	// -------------------------------------------------------------
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthenticInterceptor())
			.addPathPatterns(
//				"/cop/com/*.do",
//				"/cop/bbs/*Master*.do",
				"/uat/uia/*.do")
			.excludePathPatterns(
				"/uat/uia/actionLogin.do",
				"/uat/uia/actionLoginAPI.do",
				"/uat/uia/egovLoginUsr.do",
				"/uat/uia/egovLoginUsrAPI.do",
				"/uat/uia/actionLogoutAPI.do"
				);
		registry.addInterceptor(new CustomAuthenticInterceptor())
			.addPathPatterns(
				"/**/*.do")
			.excludePathPatterns(
				"/uat/uia/**");
	}

	
	/**
	 * ■
	 * =================================
	 * @param registry
	 */
	// -------------------------------------------------------------
	// RequestMappingHandlerMapping 설정 View Controller 추가
	// -------------------------------------------------------------
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/cmmn/validator.do")
			.setViewName("cmmn/validator");
		registry.addViewController("/").setViewName("forward:/index.jsp");
	}

	
	/**
	 * ■
	 * =================================
	 * @param exceptionResolvers
	 */
	// -------------------------------------------------------------
	// HandlerExceptionResolver 설정
	// -------------------------------------------------------------
	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();

		simpleMappingExceptionResolver.setDefaultErrorView(RESOLVER_DEFAULT_ERROR_VIEW);

		Properties mappings = new Properties();
		mappings.setProperty("org.springframework.dao.DataAccessException", "cmm/error/dataAccessFailure");
		mappings.setProperty("org.springframework.transaction.TransactionException", "cmm/error/transactionFailure");
		mappings.setProperty("org.egovframe.rte.fdl.cmmn.exception.EgovBizException", "cmm/error/egovError");
		mappings.setProperty("org.springframework.security.AccessDeniedException", "cmm/error/accessDenied");

		simpleMappingExceptionResolver.setExceptionMappings(mappings);

		exceptionResolvers.add(simpleMappingExceptionResolver);
	}

	
	/**
	 * ■
	 * =================================
	 */
	// -------------------------------------------------------------
	// View Resolver 설정
	// -------------------------------------------------------------
	@Bean
	public UrlBasedViewResolver urlBasedViewResolver() {
		UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
		urlBasedViewResolver.setOrder(URL_BASED_VIEW_RESOLVER_ORDER);
		urlBasedViewResolver.setViewClass(JstlView.class);
		urlBasedViewResolver.setPrefix(URL_BASED_VIEW_RESOLVER_PREFIX);
		urlBasedViewResolver.setSuffix(URL_BASED_VIEW_RESOLVER_SUFFIX);
		return urlBasedViewResolver;
	}

	
	/**
	 * ■
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	// -------------------------------------------------------------
	// CORS 설정 추가
	// -------------------------------------------------------------
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("*.do").allowedOrigins(CORS_ORIGIN_SERVER_URLS);
//	}

}
