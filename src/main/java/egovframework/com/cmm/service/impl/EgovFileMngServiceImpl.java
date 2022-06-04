/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ 파일정보의 관리를 위한 구현 클래스
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.com.cmm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.FileVO;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;


/**
 * <p>■파일정보의 관리를 위한 구현 클래스</p>
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
@Service("EgovFileMngService")
public class EgovFileMngServiceImpl extends EgovAbstractServiceImpl implements EgovFileMngService {

	
	/**
	 * ■함수 시작 로그 출력
	 * =================================
	 */
    @Resource(name = "FileManageDAO")
    private FileManageDAO fileMngDAO;

	
	/**
	 * ■여러 개의 파일을 삭제한다.
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
    @Override
    public void deleteFileInfs(List<?> fvoList) throws Exception {
    	fileMngDAO.deleteFileInfs(fvoList);
    }


	
	/**
	 * ■하나의 파일에 대한 정보(속성 및 상세)를 등록한다.
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
    @Override
	public String insertFileInf(FileVO fvo) throws Exception {
    	String atchFileId = fvo.getAtchFileId();
    	fileMngDAO.insertFileInf(fvo);
    	return atchFileId;
    }


	
	/**
	 * ■여러 개의 파일에 대한 정보(속성 및 상세)를 등록한다.
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
    @Override
    public String insertFileInfs(List<?> fvoList) throws Exception {
    	String atchFileId = "";

    	if (fvoList.size() != 0) {
    		atchFileId = fileMngDAO.insertFileInfs(fvoList);
    	}
    	if("".equals(atchFileId)){
    		atchFileId = null;
    	}
    	return atchFileId;
    }


	
	/**
	 * ■파일에 대한 목록을 조회한다.
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
    @Override
	public List<FileVO> selectFileInfs(FileVO fvo) throws Exception {
    	return fileMngDAO.selectFileInfs(fvo);
    }


	
	/**
	 * ■여러 개의 파일에 대한 정보(속성 및 상세)를 수정한다.
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
    @Override
	public void updateFileInfs(List<?> fvoList) throws Exception {
    	//Delete & Insert
    	fileMngDAO.updateFileInfs(fvoList);
    }


	
	/**
	 * ■하나의 파일을 삭제한다.
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
    @Override
	public void deleteFileInf(FileVO fvo) throws Exception {
    	fileMngDAO.deleteFileInf(fvo);
    }


	
	/**
	 * ■파일에 대한 상세정보를 조회한다.
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
    @Override
	public FileVO selectFileInf(FileVO fvo) throws Exception {
    	return fileMngDAO.selectFileInf(fvo);
    }


	
	/**
	 * ■파일 구분자에 대한 최대값을 구한다.
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
    @Override
	public int getMaxFileSN(FileVO fvo) throws Exception {
    	return fileMngDAO.getMaxFileSN(fvo);
    }


	
	/**
	 * ■전체 파일을 삭제한다.
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
    @Override
	public void deleteAllFileInf(FileVO fvo) throws Exception {
    	fileMngDAO.deleteAllFileInf(fvo);
    }


	
	/**
	 * ■파일명 검색에 대한 목록을 조회한다.
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
    @Override
	public Map<String, Object> selectFileListByFileNm(FileVO fvo) throws Exception {
    	List<FileVO>  result = fileMngDAO.selectFileListByFileNm(fvo);
    	int cnt = fileMngDAO.selectFileListCntByFileNm(fvo);

    	Map<String, Object> map = new HashMap<String, Object>();

    	map.put("resultList", result);
    	map.put("resultCnt", Integer.toString(cnt));

    	return map;
    }


	
	/**
	 * ■이미지 파일에 대한 목록을 조회한다.
	 * =================================
	 * @param logger
	 * @param msg
	 * @param req
	 */
    @Override
	public List<FileVO> selectImageFileList(FileVO vo) throws Exception {
    	return fileMngDAO.selectImageFileList(vo);
    }
    
    
}


