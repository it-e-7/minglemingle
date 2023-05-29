package com.minglemingle.chat2mingle.message.service;

import com.minglemingle.chat2mingle.message.vo.MessageDTO;
import org.springframework.lang.NonNull;

import java.sql.SQLException;
import java.util.List;

public interface MessageService {

    /**
     * 주어진 MessageDTO를 사용하여 메시지를 특정 채널에 브로드캐스트합니다.
     *
     * @author Daniel Choi
     *
     * @param messageDTO 브로드캐스트할 메시지의 정보를 포함하는 {@link MessageDTO} 객체
     * @throws NullPointerException MessageDTO가 null일 경우
     */

    void broadcast(@NonNull MessageDTO messageDTO);
    void broadcast(@NonNull String messageString);

    /**
     * 주어진 MessageDTO를 사용하여 단일 메시지를 조회합니다.
     *
     * @author Daniel Choi
     * @param messageDTO 조회할 메시지의 정보를 포함하는 {@link MessageDTO} 객체
     * @return 조회된 단일 메시지의 정보를 포함하는 {@link MessageDTO} 객체. 메시지가 없는 경우 null을 반환할 수 있습니다.
     * @throws NullPointerException MessageDTO가 null일 경우
     */
    MessageDTO getOneMessage(@NonNull MessageDTO messageDTO);


    /**
     * 주어진 messageId을 사용하여 메시지 목록을 조회합니다.
     *
     * @author Daniel Choi
     *
     * @param messageDTO 조회를 시작할 messageId를 담고 있는 객체. null인 경우 처음부터 조회합니다.
     *               한 번에 최대 5건을 반환합니다. (개발용)
     * @return 조회된 메시지 목록을 담고 있는 {@link MessageDTO}의 {@link List} 객체. 메시지가 없는 경우 빈 리스트를 반환할 수 있습니다.
     */
    List<MessageDTO> getMessageListAfterMessageId(@NonNull MessageDTO messageDTO);


    /**
     * 주어진 MessageDTO를 사용하여 단일 메시지를 삽입합니다.
     *
     * @author : Daniel Choi
     *
     * @param messageDTO 삽입할 메시지의 정보를 포함하는 {@link MessageDTO} 객체
     * @return 삽입된 메시지의 ID. 삽입에 실패한 경우 -1을 반환합니다.
     * @throws NullPointerException MessageDTO가 null일 경우
     */
    Integer insertOneMessage(@NonNull MessageDTO messageDTO) throws SQLException;
    Integer insertOneMessage(@NonNull String messageString) throws SQLException;

    /**
     * 주어진 MessageDTO를 사용하여 단일 메시지를 삭제합니다.
     * WebSocket Session에 접속되어있는 사용자들의 메시지도 삭제합니다.
     *
     * @author : Daniel Choi
     *
     * @param messageDTO 삭제할 메시지의 정보를 포함하는 {@link MessageDTO} 객체
     * @return 삭제된 메시지의 ID. 삭제에 실패한 경우 -1을 반환합니다.
     * @throws NullPointerException MessageDTO가 null일 경우
     */
    Integer deleteMessageSent(@NonNull MessageDTO messageDTO);

}
