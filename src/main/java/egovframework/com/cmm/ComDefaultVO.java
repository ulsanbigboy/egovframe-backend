/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ ComDefaultVO class
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.com.cmm;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;



/**
 * <p>■XXXXXXXXXX</p>
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
public class ComDefaultVO implements Serializable {

	
	/**
	 * ■
	 * =================================
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ■검색조건
	 * =================================
	 */
    private String searchCondition = "";

	/**
	 * ■검색Keyword
	 * =================================
	 */
    private String searchKeyword = "";

	/**
	 * ■검색사용여부
	 * =================================
	 */
    private String searchUseYn = "";

	/**
	 * ■현재페이지
	 * =================================
	 */
    private int pageIndex = 1;

	/**
	 * ■페이지갯수
	 * =================================
	 */
    private int pageUnit = 10;

	/**
	 * ■페이지사이즈
	 * =================================
	 */
    private int pageSize = 10;

	/**
	 * ■firstIndex
	 * =================================
	 */
    private int firstIndex = 1;

	/**
	 * ■lastIndex
	 * =================================
	 */
    private int lastIndex = 1;

	/**
	 * ■recordCountPerPage
	 * =================================
	 */
    private int recordCountPerPage = 10;

	/**
	 * ■검색KeywordFrom
	 * =================================
	 */
    private String searchKeywordFrom = "";

	/**
	 * ■검색KeywordTo 
	 * =================================
	 */
    private String searchKeywordTo = "";


    /**
	 * ■
	 * =================================
	 * @return String
	 */
	public int getFirstIndex() {
		return firstIndex;
	}


    /**
	 * ■
	 * =================================
	 * @return String
	 */
	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}


    /**
	 * ■
	 * =================================
	 * @return String
	 */
	public int getLastIndex() {
		return lastIndex;
	}


    /**
	 * ■
	 * =================================
	 * @return String
	 */
	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}


    /**
	 * ■
	 * =================================
	 * @return String
	 */
	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}


    /**
	 * ■
	 * =================================
	 * @return String
	 */
	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}


    /**
	 * ■
	 * =================================
	 * @return String
	 */
	public String getSearchCondition() {
        return searchCondition;
    }


    /**
	 * ■
	 * =================================
	 * @return String
	 */
    public void setSearchCondition(String searchCondition) {
        this.searchCondition = searchCondition;
    }


    /**
	 * ■
	 * =================================
	 * @return String
	 */
    public String getSearchKeyword() {
        return searchKeyword;
    }


    /**
	 * ■
	 * =================================
	 * @return String
	 */
    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }


    /**
	 * ■
	 * =================================
	 * @return String
	 */
    public String getSearchUseYn() {
        return searchUseYn;
    }


    /**
	 * ■
	 * =================================
	 * @return String
	 */
    public void setSearchUseYn(String searchUseYn) {
        this.searchUseYn = searchUseYn;
    }


    /**
	 * ■
	 * =================================
	 * @return String
	 */
    public int getPageIndex() {
        return pageIndex;
    }


    /**
	 * ■
	 * =================================
	 * @return String
	 */
    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }


    /**
	 * ■
	 * =================================
	 * @return String
	 */
    public int getPageUnit() {
        return pageUnit;
    }


    /**
	 * ■
	 * =================================
	 * @return String
	 */
    public void setPageUnit(int pageUnit) {
        this.pageUnit = pageUnit;
    }


    /**
	 * ■
	 * =================================
	 * @return String
	 */
    public int getPageSize() {
        return pageSize;
    }


    /**
	 * ■
	 * =================================
	 * @return String
	 */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    /**
	 * ■
	 * =================================
	 * @return String
	 */
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }


    /**
	 * ■searchKeywordFrom attribute를 리턴한다.
	 * =================================
	 * @return String
	 */
	public String getSearchKeywordFrom() {
		return searchKeywordFrom;
	}

	/**
	 * ■searchKeywordFrom attribute 값을 설정한다.
	 * =================================
	 * @param searchKeywordFrom String
	 */
	public void setSearchKeywordFrom(String searchKeywordFrom) {
		this.searchKeywordFrom = searchKeywordFrom;
	}

	/**
	 * ■searchKeywordTo attribute를 리턴한다.
	 * =================================
	 * @return String
	 */
	public String getSearchKeywordTo() {
		return searchKeywordTo;
	}


	
	/**
	 * ■searchKeywordTo attribute 값을 설정한다.
	 * =================================
	 * @param searchKeywordTo String
	 */
	public void setSearchKeywordTo(String searchKeywordTo) {
		this.searchKeywordTo = searchKeywordTo;
	}


}


