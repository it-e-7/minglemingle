package com.minglemingle.chat2mingle.report.service;

import com.minglemingle.chat2mingle.report.vo.ReportVO;

import java.util.List;

public interface ReportService {
    List<ReportVO> selectReportListByReportedDate(ReportVO reportVO);

    ReportVO selectReportDetailByMessageId(ReportVO reportVO);
}
