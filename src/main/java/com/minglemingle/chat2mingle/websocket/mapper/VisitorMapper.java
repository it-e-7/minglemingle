package com.minglemingle.chat2mingle.websocket.mapper;

import com.minglemingle.chat2mingle.message.vo.MessageDTO;
import com.minglemingle.chat2mingle.websocket.vo.VisitorVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.lang.NonNull;

import java.util.List;

@Mapper
public interface VisitorMapper {
    int updateOneVisitor(@NonNull VisitorVO visitorVO);
    int selectAllVisitor(@NonNull Integer channel);
}
