/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ 공통코드등 전체 업무에서 공용해서 사용해야 하는 서비스를 정의하기위한 서비스 구현 클래스
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.com.cmm.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.EgovCmmUseService;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


/**
 * <p>■공통코드등 전체 업무에서 공용해서 사용해야 하는 서비스를 정의하기위한 서비스 구현 클래스</p>
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
@Service("EgovCmmUseService")
public class EgovCmmUseServiceImpl extends EgovAbstractServiceImpl implements EgovCmmUseService {

	
	/**
	 * ■
	 * =================================
	 */
	@Resource(name = "cmmUseDAO")
	private CmmUseDAO cmmUseDAO;

	
	/**
	 * ■공통코드를 조회한다.
	 * =================================
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CmmnDetailCode> selectCmmCodeDetail(ComDefaultCodeVO vo) throws Exception {
		return cmmUseDAO.selectCmmCodeDetail(vo);
	}

	
	/**
	 * ■ComDefaultCodeVO의 리스트를 받아서 여러개의 코드 리스트를 맵에 담아서 리턴한다.
	 * =================================
	 * @param voList
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, List<CmmnDetailCode>> selectCmmCodeDetails(List<?> voList) throws Exception {
		ComDefaultCodeVO vo;
		Map<String, List<CmmnDetailCode>> map = new HashMap<String, List<CmmnDetailCode>>();

		Iterator<?> iter = voList.iterator();
		while (iter.hasNext()) {
			vo = (ComDefaultCodeVO) iter.next();
			map.put(vo.getCodeId(), cmmUseDAO.selectCmmCodeDetail(vo));
		}

		return map;
	}

	
	/**
	 * ■조직정보를 코드형태로 리턴한다.
	 * =================================
	 * @param 조회조건정보 vo
	 * @return 조직정보 List
	 * @throws Exception
	 */
	@Override
	public List<CmmnDetailCode> selectOgrnztIdDetail(ComDefaultCodeVO vo) throws Exception {
		return cmmUseDAO.selectOgrnztIdDetail(vo);
	}

	
	/**
	 * ■그룹정보를 코드형태로 리턴한다.
	 * =================================
	 * @param 조회조건정보 vo
	 * @return 그룹정보 List
	 * @throws Exception
	 */
	@Override
	public List<CmmnDetailCode> selectGroupIdDetail(ComDefaultCodeVO vo) throws Exception {
		return cmmUseDAO.selectGroupIdDetail(vo);
	}
	
}

