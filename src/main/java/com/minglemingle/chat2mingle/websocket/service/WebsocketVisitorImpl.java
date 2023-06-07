package com.minglemingle.chat2mingle.websocket.service;
import com.minglemingle.chat2mingle.aspect.annotation.DebugLog;
import com.minglemingle.chat2mingle.aspect.transaction.annotation.Transactional;
import com.minglemingle.chat2mingle.websocket.mapper.VisitorMapper;
import com.minglemingle.chat2mingle.websocket.vo.VisitorVO;
import org.springframework.stereotype.Service;

@Service
public class WebsocketVisitorImpl implements WebSocketVisitor {

    public WebsocketVisitorImpl(VisitorMapper mapper) {
        this.mapper = mapper;
    }

    private VisitorMapper mapper;

    @Override
    @DebugLog
    public void updateVisitor(Integer channel, String nickname) {
        VisitorVO visitorVO = new VisitorVO();
        visitorVO.setChannel(channel);
        visitorVO.setNickname(nickname);
        System.out.println(visitorVO);
        try {
            int result = mapper.updateOneVisitor(visitorVO);
            if (result == 1){
                //업데이트 성공
            }
            else {
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}