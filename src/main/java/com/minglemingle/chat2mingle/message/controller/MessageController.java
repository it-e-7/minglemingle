package com.minglemingle.chat2mingle.message.controller;

import com.minglemingle.chat2mingle.message.service.MessageService;
import com.minglemingle.chat2mingle.message.vo.MessageDTO;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping(value="/message", produces = "application/json")
    public MessageDTO getMessage(@NonNull MessageDTO messageDTO) {
        return messageService.getOneMessage(messageDTO);
    }

    @GetMapping(value="/messages")
    public List<MessageDTO> getMessages(@NonNull MessageDTO messageDTO) {
        return messageService.getMessageListAfterMessageId(messageDTO);
    }

}
