package com.minglemingle.chat2mingle.message.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {
    private Long messageId;
    private String nickname;
    private List<Integer> channels;
    private String content;
    private int messageType;
    private Timestamp sentAt;
}
