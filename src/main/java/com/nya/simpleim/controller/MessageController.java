package com.nya.simpleim.controller;

import com.nya.simpleim.pojo.ChatRoom;
import com.nya.simpleim.pojo.Message;
import com.nya.simpleim.repository.RoomMessageSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.nya.simpleim.repository.RoomMessageSession.roomMap;

@Slf4j
@RestController
public class MessageController {


    @PostMapping("/sendMessage")
    public int sendMessage(@RequestBody Message message){

        //log.info("============ message value"+message.toString());
        //Timestamp t1 = Timestamp.valueOf(message.getTime().toLocalDateTime());
        //message.setTime(t1);
        log.info("============ message value"+message.toString());

        /*
         * roomMap 来自 ...repository.RoomMessageSession.roomMap;
         * 是暂时使用的全局变量
         */
        ChatRoom room = roomMap.get(message.getRoomId());

        //if(!roomMap.containsKey(message.getRoomId())){
        if(room==null){
           return 0;
        }

        List<Message> list2 = room.getMessageList();
        list2.add(message);
        room.setMessageList(list2);
        roomMap.put(room.getId(),room);

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
