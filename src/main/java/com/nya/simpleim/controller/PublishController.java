package com.nya.simpleim.controller;

import com.nya.simpleim.pojo.ChatRoom;
import com.nya.simpleim.pojo.Message;
import com.nya.simpleim.repository.RoomMessageSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PublishController {

    // 一次获取全部消息
    @GetMapping("/publishAll")
    public List<Message> publish(@RequestParam Long roomId){
        ChatRoom room = RoomMessageSession.roomMap.get(roomId);
        return room.getMessageList();
    }

    // 获取指定时间之后的消息
    @GetMapping("/publishSinceTime")
    public List<Message> publish(@RequestParam Long roomId, @RequestParam Timestamp time){
        ChatRoom room = RoomMessageSession.roomMap.get(roomId);
        return room.getMessageList().stream().
                filter(message -> message.getTime().after(time)).collect(Collectors.toList());
    }


}