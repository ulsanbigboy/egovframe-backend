/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ 게시판 이용정보를 관리하기 위한 서비스 구현 클래스
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.let.cop.com.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import egovframework.let.cop.com.service.BoardUseInf;
import egovframework.let.cop.com.service.BoardUseInfVO;
import egovframework.let.cop.com.service.EgovBBSUseInfoManageService;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;



/**
 * <p>■게시판 이용정보를 관리하기 위한 서비스 구현 클래스</p>
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
@Service("EgovBBSUseInfoManageService")
public class EgovBBSUseInfoManageServiceImpl extends EgovAbstractServiceImpl implements EgovBBSUseInfoManageService {
	
	
	/**
	 * ■
	 * =================================
	 */
    @Resource(name = "BBSUseInfoManageDAO")
    private BBSUseInfoManageDAO bbsUseDAO;

    /**
     * ■게시판 사용 정보를 삭제한다.
	 * =================================
     * @see egovframework.let.cop.bbs.com.service.EgovBBSUseInfoManageService#deleteBBSUseInf(egovframework.let.cop.bbs.com.service.BoardUseInf)
     */
    public void deleteBBSUseInf(BoardUseInf bdUseInf) throws Exception {
    	bbsUseDAO.deleteBBSUseInf(bdUseInf);
    }

    /**
     * ■게시판 사용정보를 등록한다.
	 * =================================
     * @see egovframework.let.cop.bbs.com.service.EgovBBSUseInfoManageService#insertBBSUseInf(egovframework.let.cop.bbs.com.service.BoardUseInf)
     */
    public void insertBBSUseInf(BoardUseInf bdUseInf) throws Exception {
    	bbsUseDAO.insertBBSUseInf(bdUseInf);
    }

    /**
     * ■게시판 사용정보 목록을 조회한다.
	 * =================================
     * @see egovframework.let.cop.bbs.com.service.EgovBBSUseInfoManageService#selectBBSUseInfs(egovframework.let.cop.bbs.com.service.BoardUseInfVO)
     */
    public Map<String, Object> selectBBSUseInfs(BoardUseInfVO bdUseVO) throws Exception {

    	List<BoardUseInfVO> result = bbsUseDAO.selectBBSUseInfs(bdUseVO);
    	int cnt = bbsUseDAO.selectBBSUseInfsCnt(bdUseVO);
	
    	Map<String, Object> map = new HashMap<String, Object>();
	
    	map.put("resultList", result);
    	map.put("resultCnt", Integer.toString(cnt));

    	return map;
    }

    /**
     * ■게시판 사용정보를 수정한다.
	 * =================================
     * @see egovframework.let.cop.bbs.com.service.EgovBBSUseInfoManageService#updateBBSUseInf(egovframework.let.cop.bbs.com.service.BoardUseInf)
     */
    public void updateBBSUseInf(BoardUseInf bdUseInf) throws Exception {
    	bbsUseDAO.updateBBSUseInf(bdUseInf);
    }

    /**
     * ■게시판 사용정보에 대한 상세정보를 조회한다.
	 * =================================
     * @see egovframework.let.cop.bbs.com.service.EgovBBSUseInfoManageService#selectBBSUseInf(egovframework.let.cop.bbs.com.service.BoardUseInfVO)
     */
    public BoardUseInfVO selectBBSUseInf(BoardUseInfVO bdUseVO) throws Exception {
    	return bbsUseDAO.selectBBSUseInf(bdUseVO);
    }

    /**
     * ■동호회에 사용되는 게시판 사용정보를 삭제한다.
	 * =================================
     * @see egovframework.let.cop.com.service.EgovBBSUseInfoManageService#deleteBBSUseInfByClub(egovframework.let.cop.com.service.BoardUseInf)
     */
    public void deleteBBSUseInfByClub(BoardUseInfVO bdUseVO) throws Exception {
    	List<BoardUseInf> result = bbsUseDAO.selectBBSUseInfByClub(bdUseVO);
	
    	BoardUseInf bdUseInf = null;
    	Iterator<BoardUseInf> iter = result.iterator();
    	while (iter.hasNext()) {
    		bdUseInf = (BoardUseInf)iter.next();
	    
    		bdUseInf.setLastUpdusrId(bdUseVO.getLastUpdusrId());
    		//bdUseInf.setTrgetId(bdUseVO.getClbId());	// 사용자 ID를 넘겨야 함..
    		bdUseInf.setTrgetId(bdUseVO.getTrgetId());
	    
    		bbsUseDAO.deleteBBSUseInf(bdUseInf);
    	}
    }

    /**
     * ■커뮤니티에 사용되는 게시판 사용정보를 삭제한다.
	 * =================================
     * @see egovframework.let.cop.com.service.EgovBBSUseInfoManageService#deleteBBSUseInfByCmmnty(egovframework.let.cop.com.service.BoardUseInf)
     */
    public void deleteBBSUseInfByCmmnty(BoardUseInfVO bdUseVO) throws Exception {
    	List<BoardUseInf> result = bbsUseDAO.selectBBSUseInfByCmmnty(bdUseVO);
	
    	BoardUseInf bdUseInf = null;
    	Iterator<BoardUseInf> iter = result.iterator();
	
    	while (iter.hasNext()) {
    		bdUseInf = (BoardUseInf)iter.next();
	    
    		bdUseInf.setLastUpdusrId(bdUseVO.getLastUpdusrId());
    		//bdUseInf.setTrgetId(bdUseVO.getCmmntyId());	// 사용자 ID를 넘겨야 함..
    		bdUseInf.setTrgetId(bdUseVO.getTrgetId());
	    
    		bbsUseDAO.deleteBBSUseInf(bdUseInf);
    	}
    }

    /**
     * ■동호회에 사용되는 모든 게시판 사용정보를 삭제한다.
	 * =================================
     * @see egovframework.let.cop.com.service.EgovBBSUseInfoManageService#deleteAllBBSUseInfByClub(egovframework.let.cop.com.service.BoardUseInfVO)
     */
    public void deleteAllBBSUseInfByClub(BoardUseInfVO bdUseVO) throws Exception {
    	bbsUseDAO.deleteAllBBSUseInfByClub(bdUseVO);
    }

    /**
     * ■커뮤니티에 사용되는 모든 게시판 사용정보를 삭제한다.
	 * =================================
     * @see egovframework.let.cop.com.service.EgovBBSUseInfoManageService#deleteAllBBSUseInfByCmmnty(egovframework.let.cop.com.service.BoardUseInfVO)
     */
    public void deleteAllBBSUseInfByCmmnty(BoardUseInfVO bdUseVO) throws Exception {
    	bbsUseDAO.deleteAllBBSUseInfByCmmnty(bdUseVO);
    }

    /**
     * ■게시판에 대한 사용정보를 삭제한다.
	 * =================================
     * @see egovframework.let.cop.com.service.EgovBBSUseInfoManageService#deleteBBSUseInfByBoardId(egovframework.let.cop.com.service.BoardUseInf)
     */
    public void deleteBBSUseInfByBoardId(BoardUseInf bdUseInf) throws Exception {
    	bbsUseDAO.deleteBBSUseInfByBoardId(bdUseInf);
    }

    /**
     * ■커뮤니티, 동호회에 사용되는 게시판 사용정보에 대한 목록을 조회한다.
	 * =================================
     * @see egovframework.let.cop.com.service.EgovBBSUseInfoManageService#selectBBSUseInfsByTrget(egovframework.let.cop.com.service.BoardUseInfVO)
     */
    public Map<String, Object> selectBBSUseInfsByTrget(BoardUseInfVO bdUseVO) throws Exception {
    	List<BoardUseInfVO> result = bbsUseDAO.selectBBSUseInfsByTrget(bdUseVO);
    	int cnt = bbsUseDAO.selectBBSUseInfsCntByTrget(bdUseVO);
	
    	Map<String, Object> map = new HashMap<String, Object>();
	
    	map.put("resultList", result);
    	map.put("resultCnt", Integer.toString(cnt));

    	return map;
    }

    /**
     * ■커뮤니티, 동호회에 사용되는 게시판 사용정보를 수정한다.
	 * =================================
     */
    public void updateBBSUseInfByTrget(BoardUseInf bdUseInf) throws Exception {
    	bbsUseDAO.updateBBSUseInfByTrget(bdUseInf);
    }

    
}


