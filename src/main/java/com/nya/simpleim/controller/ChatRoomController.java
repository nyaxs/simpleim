package com.nya.simpleim.controller;

import com.nya.simpleim.pojo.ChatRoom;
import com.nya.simpleim.pojo.User;
import com.nya.simpleim.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChatRoomController {

    private final ChatRoomService roomService;

    public ChatRoomController(ChatRoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/enterRoom")
    public int enterRoom(@RequestBody User user){
        //获取登录状态，已登录则为 1，未登录为 0
        int userStatus = 1;
        if(userStatus == 0){
            return 0;
        }

        ChatRoom room = roomService.getRoomById(user.getId());
        room.getUserList().add(user);

        return 1;

    }

    @GetMapping("/quitRoom")
    public int quitRoom(@RequestBody User user){

        ChatRoom room = roomService.getRoomById(user.getRoomId());
        room.getUserList().remove(user);
        return 1;

    }




}
