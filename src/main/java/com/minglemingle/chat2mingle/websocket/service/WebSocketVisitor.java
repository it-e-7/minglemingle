package com.minglemingle.chat2mingle.websocket.service;

import com.minglemingle.chat2mingle.member.vo.MemberVO;
import org.springframework.stereotype.Service;

public interface WebSocketVisitor {
    public void updateVisitor(Integer channel,String nickname);
}