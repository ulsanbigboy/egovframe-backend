/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ 공통코드등 전체 업무에서 공용해서 사용해야 하는 서비스를 정의하기위한 데이터 접근 클래스
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.com.cmm.service.impl;

import java.util.List;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;

import org.springframework.stereotype.Repository;


/**
 * <p>■공통코드등 전체 업무에서 공용해서 사용해야 하는 서비스를 정의하기위한 데이터 접근 클래스</p>
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
@Repository("cmmUseDAO")
public class CmmUseDAO extends EgovComAbstractDAO {


	/**
	 * ■주어진 조건에 따른 공통코드를 불러온다.
	 * =================================
     * @param vo
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "deprecation" })
	public List<CmmnDetailCode> selectCmmCodeDetail(ComDefaultCodeVO vo) throws Exception {
    	return (List<CmmnDetailCode>) list("CmmUseDAO.selectCmmCodeDetail", vo);
    }

    /**
	 * ■공통코드로 사용할 조직정보를 를 불러온다.
	 * =================================
     * @param vo
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<CmmnDetailCode> selectOgrnztIdDetail(ComDefaultCodeVO vo) throws Exception {
    	return (List<CmmnDetailCode>) list("CmmUseDAO.selectOgrnztIdDetail", vo);
    }

    /**
	 * ■공통코드로 사용할그룹정보를 를 불러온다.
	 * =================================
     * @param vo
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<CmmnDetailCode> selectGroupIdDetail(ComDefaultCodeVO vo) throws Exception {
    	return (List<CmmnDetailCode>) list("CmmUseDAO.selectGroupIdDetail", vo);
    }
    
}
