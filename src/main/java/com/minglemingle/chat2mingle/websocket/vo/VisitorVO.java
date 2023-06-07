package com.minglemingle.chat2mingle.websocket.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitorVO {
    private String nickname;
    private Integer channel;
}