/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ 실행환경의 파일업로드 처리를 위한 기능 클래스
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.com.cmm.web;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.fileupload.FileItem;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;



/**
 * <p>■실행환경의 파일업로드 처리를 위한 기능 클래스</p>
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
public class EgovMultipartResolver extends CommonsMultipartResolver {
	
	/**
	 * ■생성자
	 * =================================
	 */
	public EgovMultipartResolver() {}


	/**
	 * ■첨부파일 처리를 위한 multipart resolver를 생성한다.
	 * =================================
	 * @param servletContext
	 */
	public EgovMultipartResolver(ServletContext servletContext) {
		super(servletContext);
	}

	/**
	 * ■multipart에 대한 parsing을 처리한다.
	 * =================================
	 * @param fileItems
	 * @param encoding
	 */
	@SuppressWarnings("rawtypes")
	@Override
	protected MultipartParsingResult parseFileItems(List fileItems, String encoding) {

		//스프링 3.0변경으로 수정한 부분
		MultiValueMap<String, MultipartFile> multipartFiles = new LinkedMultiValueMap<String, MultipartFile>();
		Map<String, String[]> multipartParameters = new HashMap<String, String[]>();
		Map<String, String> mpParamContentTypes = new HashMap<String, String>();

		// Extract multipart files and multipart parameters.
		for (Iterator<?> it = fileItems.iterator(); it.hasNext();) {
			FileItem fileItem = (FileItem)it.next();


			if (fileItem.isFormField()) {

				String value = null;
				if (encoding != null) {
					try {
						value = fileItem.getString(encoding);
					} catch (UnsupportedEncodingException ex) {
						if (logger.isWarnEnabled()) {
							logger.warn("Could not decode multipart item '" + fileItem.getFieldName()
								+ "' with encoding '" + encoding
								+ "': using platform default");
						}
						value = fileItem.getString();
					}
				} else {
					value = fileItem.getString();
				}
				String[] curParam = multipartParameters.get(fileItem.getFieldName());
				if (curParam == null) {
					// simple form field
					multipartParameters.put(fileItem.getFieldName(), new String[] {value});
				} else {
					// array of simple form fields
					String[] newParam = StringUtils.addStringToArray(curParam, value);
					multipartParameters.put(fileItem.getFieldName(), newParam);
				}

				//contentType 입력
				mpParamContentTypes.put(fileItem.getFieldName(), fileItem.getContentType());
			} else {

				if (fileItem.getSize() > 0) {
					// multipart file field
					CommonsMultipartFile file = new CommonsMultipartFile(fileItem);

					//스프링 3.0 업그레이드 API변경으로인한 수정
					List<MultipartFile> fileList = new ArrayList<MultipartFile>();
					fileList.add(file);

					if (multipartFiles.put(fileItem.getName(), fileList) != null) { // CHANGED!!
						throw new MultipartException("Multiple files for field name [" + file.getName()
							+ "] found - not supported by MultipartResolver");
					}
					if (logger.isDebugEnabled()) {
						logger.debug("Found multipart file [" + file.getName() + "] of size " + file.getSize()
							+ " bytes with original filename ["
							+ file.getOriginalFilename() + "], stored " + file.getStorageDescription());
					}
				}

			}
		}

		return new MultipartParsingResult(multipartFiles, multipartParameters, mpParamContentTypes);
	}
	
}
