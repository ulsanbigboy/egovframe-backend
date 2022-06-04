/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ 파일정보의 관리를 위한 서비스 인터페이스
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.com.cmm.service;

import java.util.List;
import java.util.Map;


/**
 * <p>■파일정보의 관리를 위한 서비스 인터페이스</p>
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
public interface EgovFileMngService {

	
    /**
	 * ■파일에 대한 목록을 조회한다.
	 * =================================
     * @param fvo
     * @return
     * @throws Exception
     */
    public List<FileVO> selectFileInfs(FileVO fvo) throws Exception;

    
    /**
	 * ■하나의 파일에 대한 정보(속성 및 상세)를 등록한다.
	 * =================================
     * @param fvo
     * @throws Exception
     */
    public String insertFileInf(FileVO fvo) throws Exception;

    
    /**
	 * ■여러 개의 파일에 대한 정보(속성 및 상세)를 등록한다.
	 * =================================
     * @param fvoList
     * @throws Exception
     */
    public String insertFileInfs(List<?> fvoList) throws Exception;

    
    /**
	 * ■여러 개의 파일에 대한 정보(속성 및 상세)를 수정한다.
	 * =================================
     * @param fvoList
     * @throws Exception
     */
    public void updateFileInfs(List<?> fvoList) throws Exception;

    
    /**
	 * ■여러 개의 파일을 삭제한다.
	 * =================================
     * @param fvoList
     * @throws Exception
     */
    public void deleteFileInfs(List<?> fvoList) throws Exception;

    
    /**
	 * ■하나의 파일을 삭제한다.
     *
     * @param fvo
     * @throws Exception
     */
    public void deleteFileInf(FileVO fvo) throws Exception;

    
    /**
	 * ■파일에 대한 상세정보를 조회한다.
	 * =================================
     * @param fvo
     * @return
     * @throws Exception
     */
    public FileVO selectFileInf(FileVO fvo) throws Exception;

    
    /**
	 * ■파일 구분자에 대한 최대값을 구한다.
	 * =================================
     * @param fvo
     * @return
     * @throws Exception
     */
    public int getMaxFileSN(FileVO fvo) throws Exception;

    
    /**
	 * ■전체 파일을 삭제한다.
	 * =================================
     * @param fvo
     * @throws Exception
     */
    public void deleteAllFileInf(FileVO fvo) throws Exception;

    
    /**
	 * ■파일명 검색에 대한 목록을 조회한다.
     *
     * @param fvo
     * @return
     * @throws Exception
     */
    public Map<String, Object> selectFileListByFileNm(FileVO fvo) throws Exception;

    
    /**
	 * ■이미지 파일에 대한 목록을 조회한다.
	 * =================================
     * @param vo
     * @return
     * @throws Exception
     */
    public List<FileVO> selectImageFileList(FileVO vo) throws Exception;
    
    
}
