package com.nya.simpleim.service;

import com.nya.simpleim.pojo.ChatRoom;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ChatRoomService {

    public int createRoom();

    public int destroyRoom();

    public List<ChatRoom> getRoomList();

    public ChatRoom getRoomById(Long id);



}
