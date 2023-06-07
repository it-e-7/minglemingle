package com.minglemingle.chat2mingle.websocket.service;
import com.minglemingle.chat2mingle.aspect.transaction.annotation.Transactional;
import com.minglemingle.chat2mingle.websocket.mapper.VisitorMapper;
import com.minglemingle.chat2mingle.websocket.vo.VisitorVO;
import org.springframework.stereotype.Service;

@Service
public class WebsocketVisitorServiceImpl implements WebSocketVisitorService {

    private final VisitorMapper visitorMapper;

    public WebsocketVisitorServiceImpl(VisitorMapper visitorMapper) {
        this.visitorMapper = visitorMapper;
    }

    @Override
    @Transactional
    public int updateVisitor(Integer channel, String nickname) {
        VisitorVO visitorVO = new VisitorVO();
        visitorVO.setChannel(channel);
        visitorVO.setNickname(nickname);
        return visitorMapper.updateOneVisitor(visitorVO);
    }

    @Override
    public int selectAllVisitor(Integer channel) {
        try{
            return visitorMapper.selectAllVisitor(channel);
        }
        catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}