package com.minglemingle.chat2mingle.report.service;

import com.minglemingle.chat2mingle.report.mapper.ReportMapper;
import com.minglemingle.chat2mingle.report.vo.ReportDetailVO;
import com.minglemingle.chat2mingle.report.vo.ReportStatisticVO;
import com.minglemingle.chat2mingle.report.vo.ReportVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportMapper reportMapper;

    public ReportServiceImpl(ReportMapper reportMapper) {
        this.reportMapper = reportMapper;
    }

    @Override
    public List<ReportVO> selectReportListByReportedDate(ReportVO reportVO) {
        return reportMapper.selectReportListByReportedDate(reportVO);
    }

    @Override
    public ReportDetailVO selectReportDetailByMessageId(ReportVO reportVO) {
        return reportMapper.selectReportDetailByMessageId(reportVO);
    }

    @Override
    public ReportStatisticVO selectReportStatisticByMessageId(ReportVO reportVO) {
        return reportMapper.selectReportStatisticByMessageId(reportVO);
    }

    @Override
    public boolean setReportStatusDone(ReportVO reportVO) {
        return reportMapper.updateReportStatusByMessageId(reportVO);
    }

    @Override
    public boolean createNewReport(ReportVO reportVO) {
        return reportMapper.insertNewReport(reportVO);
    }


}
