package com.nya.simpleim.service.impl;

import com.nya.simpleim.pojo.ChatRoom;
import com.nya.simpleim.service.ChatRoomService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ChatRoomServiceImpl implements ChatRoomService {

    @Override
    public int createRoom() {
        return 0;
    }

    @Override
    public int destroyRoom() {
        return 0;
    }

    @Override
    public List<ChatRoom> getRoomList() {
        return null;
    }

    @Override
    public ChatRoom getRoomById(Long id) {
        return null;
    }

}
