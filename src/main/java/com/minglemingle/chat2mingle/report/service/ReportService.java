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
}
