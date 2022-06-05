/********+*********+*********+*********+*********+*********+*********+*********
 * All Rights Reserved,  (C)2016, CO., LTD.
 *
 * 패 키 지 명 : 
 * 버       젼 : 0.0
 * 서브 시스템 : 
 * 일       자 : 2022.05.01
 * 개 발 환 경 : JDK1.7.0_79, RESIN-3.1.9
 * 주 요 내 용 : ■ 공휴일에 관한 요청을 받아 서비스 클래스로 요청을 전달하고 서비스클래스에서 처리한 결과를 웹 화면으로 전달을 위한 Controller를 정의한다
 ********+*********+*********+*********+*********+*********+*********+*********/

/*
 * ■패키지명
 */
package egovframework.let.sym.cal.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.map.ListOrderedMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.let.sym.cal.service.Restde;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * <p>■공휴일에 관한 요청을 받아 서비스 클래스로 요청을 전달하고 서비스클래스에서 처리한 결과를 웹 화면으로 전달을 위한 Controller를 정의한다</p>
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
@Controller
public class EgovCalRestdeManageController {

	
	/**
	 * ■로그
	 * =================================
	 */
	private final Logger logger = LoggerFactory.getLogger(getClass());

	
	/**
	 * ■EgovPropertyService
	 * =================================
	 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	
	/**
	 * ■일반달력 팝업 메인창을 호출한다.
	 * =================================
	 * @param model
	 * @return "/cmm/sym/cal/EgovNormalCalPopup"
	 * @throws Exception
	 */
	@RequestMapping(value = "/sym/cmm/EgovNormalCalPopup.do")
	public String callNormalCalPopup(ModelMap model) throws Exception {

		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");
		return "/cmm/sym/cal/EgovNormalCalPopup";
	}

	
	/**
	 * ■일반달력 팝업 정보를 조회한다.
	 * =================================
	 * @param restde
	 * @param model
	 * @return "/cmm/sym/cal/EgovNormalCalendar"
	 * @throws Exception
	 */
	@RequestMapping(value = "/sym/cmm/EgovselectNormalCalendar.do")
	public String selectNormalRestdePopup(Restde restde, ModelMap model) throws Exception {

		egovframework.com.cmm.util.LogUtil.start(logger, "START", null);
		egovframework.com.cmm.util.LogUtil.end(logger, "E N D");



		Calendar cal = Calendar.getInstance();

		if (restde.getYear() == null || restde.getYear().equals("")) {
			restde.setYear(Integer.toString(cal.get(Calendar.YEAR)));
		}
		if (restde.getMonth() == null || restde.getMonth().equals("")) {
			restde.setMonth(Integer.toString(cal.get(Calendar.MONTH) + 1));
		}
		int iYear = Integer.parseInt(restde.getYear());
		int iMonth = Integer.parseInt(restde.getMonth());

		if (iMonth < 1) {
			iYear--;
			iMonth = 12;
		}
		if (iMonth > 12) {
			iYear++;
			iMonth = 1;
		}
		if (iYear < 1) {
			iYear = 1;
			iMonth = 1;
		}
		if (iYear > 9999) {
			iYear = 9999;
			iMonth = 12;
		}

		/* DB를 사용할 경우 처리
		restde.setYear(Integer.toString(iYear));
		restde.setMonth(Integer.toString(iMonth));

		cal.set(iYear,iMonth-1,1);

		restde.setStartWeekMonth(cal.get(Calendar.DAY_OF_WEEK));
		restde.setLastDayMonth(cal.getActualMaximum(Calendar.DATE));

		List CalInfoList = restdeManageService.selectNormalRestdePopup(restde);
		*/

		cal.set(iYear, iMonth - 1, 1);

		int firstWeek = cal.get(Calendar.DAY_OF_WEEK);
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		int week = cal.get(Calendar.DAY_OF_WEEK);

		String year = Integer.toString(iYear);
		String month = Integer.toString(iMonth);
		//String day    = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));

		restde.setStartWeekMonth(firstWeek);
		restde.setLastDayMonth(lastDay);
		restde.setYear(year);
		restde.setMonth(month);

		List<ListOrderedMap> CalInfoList = new ArrayList<ListOrderedMap>();
		String tmpDay = "";

		/**
		 * 계산... START
		 */
		for (int i = 0; i < 42; i++) {
			ListOrderedMap map = new ListOrderedMap();
			int cc = i + 1;
			int dd = cc - firstWeek + 1;

			if (dd > 0 && dd <= lastDay) {
				tmpDay = Integer.toString(dd);
			} else {
				tmpDay = "";
			}

			map.put("year", year);
			map.put("month", month);
			map.put("day", tmpDay);
			map.put("cellNum", cc);
			map.put("weeks", (cc - 1) / 7 + 1);
			map.put("week", (week - 1) % 7 + 1);
			map.put("restAt", ((week - 1) % 7 + 1 == 1) ? "Y" : "N");

			if (dd > 0 && dd <= lastDay) {
				week++;
			}
			CalInfoList.add(map);

		}
		/**
		 * 계산... END
		 */

		model.addAttribute("resultList", CalInfoList);
		return "/cmm/sym/cal/EgovNormalCalendar";
	}

}

