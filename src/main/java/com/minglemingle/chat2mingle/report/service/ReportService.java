package com.minglemingle.chat2mingle.report.service;

import com.minglemingle.chat2mingle.report.vo.ReportDetailVO;
import com.minglemingle.chat2mingle.report.vo.ReportStatisticVO;
import com.minglemingle.chat2mingle.report.vo.ReportVO;

import java.util.List;

public interface ReportService {
    List<ReportVO> selectReportListByReportedDate(ReportVO reportVO);

    ReportDetailVO selectReportDetailByMessageId(ReportVO reportVO);

    ReportStatisticVO selectReportStatisticByMessageId(ReportVO reportVO);

    boolean setReportStatusDone(ReportVO reportVO);
}
