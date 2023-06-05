package com.minglemingle.chat2mingle.report.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportStatisticVO {
    private int reportCount;
    private Timestamp lastReportedAt;
}
