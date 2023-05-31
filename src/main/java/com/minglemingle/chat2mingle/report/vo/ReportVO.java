package com.minglemingle.chat2mingle.report.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportVO {
    private Timestamp reportedAt;
    private String memberId;
    private Integer messageId;
    private String reporterNickname; // 신고자 ID
    private String reporteeNickname; // 신고당한 사람 닉네임
    private String messageContent; // 신고당한 메시지 내용
}
