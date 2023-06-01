package com.minglemingle.chat2mingle.report.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDetailVO {
    private Timestamp reportedAt;
    private String memberId; // 신고자 ID
    private String reporterNickname; // 신고자 닉네임
    private String reporteeNickname; // 신고당한 사람 닉네임
    private Integer messageId; // 메세지 ID
    private String messageContent; // 신고당한 메시지 내용
    private Timestamp messageSentAt;
    private int channel;
}
