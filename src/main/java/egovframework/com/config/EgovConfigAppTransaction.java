/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ Transaction 설정
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.com.config;

import java.util.Collections;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;



/**
 * <p>■Transaction 설정</p>
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
public class EgovConfigAppTransaction {

	
	/**
	 * ■XXXXXXXXXX
	 * =================================
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
	@Bean
	public DataSourceTransactionManager txManager() {
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		dataSourceTransactionManager.setDataSource(dataSource);
		return dataSourceTransactionManager;
	}


	
	/**
	 * ■TransactionAdvice 설정
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	@Bean
	public TransactionInterceptor txAdvice(DataSourceTransactionManager txManager) {
		TransactionInterceptor txAdvice = new TransactionInterceptor();
		txAdvice.setTransactionManager(txManager);
		txAdvice.setTransactionAttributeSource(getNameMatchTransactionAttributeSource());
		return txAdvice;
	}

	
	/**
	 * ■XXXXXXXXXX
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	private NameMatchTransactionAttributeSource getNameMatchTransactionAttributeSource() {
		NameMatchTransactionAttributeSource txAttributeSource = new NameMatchTransactionAttributeSource();
		txAttributeSource.setNameMap(getRuleBasedTxAttributeMap());
		return txAttributeSource;
	}

	
	/**
	 * ■XXXXXXXXXX
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	private HashMap<String, TransactionAttribute> getRuleBasedTxAttributeMap() {
		HashMap<String, TransactionAttribute> txMethods = new HashMap<String, TransactionAttribute>();

		RuleBasedTransactionAttribute txAttribute = new RuleBasedTransactionAttribute();
		txAttribute.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		txAttribute.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
		txMethods.put("*", txAttribute);

		return txMethods;
	}

	
	/**
	 * ■TransactionAdvisor 설정
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	@Bean
	public Advisor txAdvisor(DataSourceTransactionManager txManager) {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression(
			"execution(* egovframework.let..impl.*Impl.*(..)) or execution(* egovframework.com..*Impl.*(..))");
		return new DefaultPointcutAdvisor(pointcut, txAdvice(txManager));
	}
	
}
