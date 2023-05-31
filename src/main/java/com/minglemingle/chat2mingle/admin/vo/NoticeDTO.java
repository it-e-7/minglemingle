package com.minglemingle.chat2mingle.admin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeDTO {
    private String content;
    private List<Integer> channels;
}
