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
package egovframework.com.cmm.service.impl;

import java.util.ArrayList;
import java.util.List;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.service.EgovUserDetailsService;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;


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
/**
 *
 * @author 공통서비스 개발팀 서준식
 * @since 2011. 8. 12.
 * @version 1.0
 * @see
 *
 * <pre>
 * 개정이력(Modification Information)
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2011. 8. 12.    서준식        최초생성
 *
 *  </pre>
 */
public class EgovTestUserDetailsServiceImpl extends EgovAbstractServiceImpl implements EgovUserDetailsService {

	
	/**
	 * ■함수 시작 로그 출력
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
	@Override
	public Object getAuthenticatedUser() {

		LoginVO loginVO = new LoginVO();
		loginVO.setId("TEST1");
		loginVO.setPassword("raHLBnHFcunwNzcDcfad4PhD11hHgXSUr7fc1Jk9uoQ=");
		loginVO.setUserSe("USR");
		loginVO.setEmail("egovframe@nia.or.kr");
		loginVO.setIhidNum("");
		loginVO.setName("더미사용자");
		loginVO.setOrgnztId("ORGNZT_0000000000000");
		loginVO.setUniqId("USRCNFRM_00000000000");
		return loginVO;

		// return
		// RequestContextHolder.getRequestAttributes().getAttribute("loginVO",
		// RequestAttributes.SCOPE_SESSION);

	}

	@Override
	public List<String> getAuthorities() {

		// 권한 설정을 리턴한다.

		List<String> listAuth = new ArrayList<String>();
		listAuth.add("IS_AUTHENTICATED_ANONYMOUSLY");
		listAuth.add("IS_AUTHENTICATED_FULLY");
		listAuth.add("IS_AUTHENTICATED_REMEMBERED");
		listAuth.add("ROLE_ADMIN");
		listAuth.add("ROLE_ANONYMOUS");
		listAuth.add("ROLE_RESTRICTED");
		listAuth.add("ROLE_USER");

		return listAuth;
	}

	@Override
	public Boolean isAuthenticated() {
		// 인증된 유저인지 확인한다.

		/*if (RequestContextHolder.getRequestAttributes() == null) {
			return false;
		} else {

			if (RequestContextHolder.getRequestAttributes().getAttribute(
					"loginVO", RequestAttributes.SCOPE_SESSION) == null) {
				return false;
			} else {
				return true;
			}
		}*/

		return true;
	}

}
