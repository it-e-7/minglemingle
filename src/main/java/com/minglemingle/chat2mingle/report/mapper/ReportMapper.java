package com.minglemingle.chat2mingle.report.mapper;

import com.minglemingle.chat2mingle.report.vo.ReportDetailVO;
import com.minglemingle.chat2mingle.report.vo.ReportStatisticVO;
import com.minglemingle.chat2mingle.report.vo.ReportVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReportMapper {
    List<ReportVO> selectReportListByReportedDate(ReportVO reportVO);
    ReportDetailVO selectReportDetailByMessageId(ReportVO reportVO);
    boolean updateReportStatusByMessageId(ReportVO reportVO);
    ReportStatisticVO selectReportStatisticByMessageId(ReportVO reportVO);
}
