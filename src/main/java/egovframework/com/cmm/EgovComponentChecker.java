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

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;




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
@Service("egovUtil")
public class EgovComponentChecker extends EgovAbstractServiceImpl implements ApplicationContextAware{


	/**
	 * ■
	 * =================================
	 */
	public static ApplicationContext context;


	/**
	 * ■
	 * =================================
	 * @param context
	 */
	@Override
	@SuppressWarnings("static-access")
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}


	/**
	 * ■Spring MVC에서 설정한 빈이 아닌 서비스 빈(컴포넌트)만을 검색할 수 있음
	 * =================================
	 * @param componentName
	 */
	public static boolean hasComponent(String componentName){
		try{
			Object component = context.getBean(componentName);
			if(component == null){
				return false;
			}else{
				return true;
			}
		}catch(NoSuchBeanDefinitionException ex){// 해당 컴포넌트를 찾을 수없을 경우 false반환
			return false;
		}
		
	}

}
