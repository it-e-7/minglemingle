package com.minglemingle.chat2mingle.report.service;

import com.minglemingle.chat2mingle.report.vo.ReportDetailVO;
import com.minglemingle.chat2mingle.report.vo.ReportStatisticVO;
import com.minglemingle.chat2mingle.report.vo.ReportVO;

import java.util.List;

/**
 * 신고 서비스 인터페이스입니다.
 *
 */
public interface ReportService {
    /**
     * 신고 일자별 신고 목록을 조회합니다.
     * @author sangwon
     * @param reportVO 신고 정보
     * @return 신고 목록
     */
    List<ReportVO> selectReportListByReportedDate(ReportVO reportVO);

    /**
     * 메시지 ID로 신고 상세 정보를 조회합니다.
     * @author sangwon
     * @param reportVO 신고 정보
     * @return 신고 상세 정보
     */
    ReportDetailVO selectReportDetailByMessageId(ReportVO reportVO);

    /**
     * 메시지 ID로 신고 통계 정보를 조회합니다.
     * @author sangwon
     * @param reportVO 신고 정보
     * @return 신고 통계 정보
     */
    ReportStatisticVO selectReportStatisticByMessageId(ReportVO reportVO);

    /**
     * 신고 상태를 완료로 설정합니다.
     * @author sangwon
     * @param reportVO 신고 정보
     * @return 설정 성공 여부
     */
    boolean setReportStatusDone(ReportVO reportVO);

    /**
     * 새 보고서를 생성합니다.
     * @author sangwon
     * @param reportVO 생성할 보고서에 대한 정보가 포함된 ReportVO 객체
     * @return 보고서 생성 성공 여부를 나타내는 boolean 값. 보고서 생성에 성공하면 true를 반환하고, 그렇지 않으면 false를 반환합니다.
     */
    boolean createNewReport(ReportVO reportVO);
}
