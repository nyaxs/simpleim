package com.nya.simpleim.controller;

import com.nya.simpleim.pojo.Message;
import com.nya.simpleim.repository.RoomMessageSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.nya.simpleim.repository.RoomMessageSession.roomMap;

@RestController
public class MessageController {


    @GetMapping("/sendMessage")
    public int sendMessage(@RequestBody Message message){

        /*
         * roomMap 来自 ...repository.RoomMessageSession.roomMap;
         * 是暂时使用的全局变量
         */
        if(!roomMap.containsKey(message.getRoomId())){
           return 0;
        }

        roomMap.get(message.getRoomId()).getMessageList().add(message);

        return 1;

    }

    public int sendMessageList(@RequestBody List<Message> messageList){

        Long roomId = messageList.get(0).getRoomId();
        /*
         * roomMap 来自 ...repository.RoomMessageSession.roomMap;
         * 是暂时使用的全局变量
         */

        if(!roomMap.containsKey(roomId)){
            return 0;
        }

        roomMap.get(roomId).getMessageList().addAll(messageList);

        return 1;

    }

}
