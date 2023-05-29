package com.minglemingle.chat2mingle.message.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageDTO {
    private Integer messageId;
    private String nickname;
    private Integer channel;
    private String content;
    private Integer messageType;
    private Timestamp sentAt;
}
