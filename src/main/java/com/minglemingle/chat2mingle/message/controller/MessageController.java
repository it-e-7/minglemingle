package com.minglemingle.chat2mingle.message.controller;

import com.google.gson.Gson;
import com.minglemingle.chat2mingle.message.service.MessageService;
import com.minglemingle.chat2mingle.message.vo.MessageDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/message", produces="text/plain;charset=UTF-8")
public class MessageController {

    private final MessageService messageService;

    private final Gson gson;

    public MessageController(MessageService messageService, Gson gson) {
        this.messageService = messageService;
        this.gson = gson;
    }

    @GetMapping(value="")
    public ResponseEntity<String> getMessages(@NonNull MessageDTO messageDTO) {
        List<MessageDTO> result = messageService.getMessageListAfterMessageId(messageDTO);

        return ResponseEntity.ok().body(gson.toJson(result, ArrayList.class));
    }

//    @DeleteMapping(value="/message/{messageId}")
//    public int deleteMessage(@NonNull @PathVariable("messageId") int messageId){
//        MessageDTO messageDTO = new MessageDTO(messageId, null, 0, null, 0, null);
//        return messageService.(messageDTO);
//    }
//

}
