package com.nya.simpleim.service;

import com.nya.simpleim.pojo.ChatRoom;
import com.nya.simpleim.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ChatRoomService {

    public ChatRoom createRoom(User user,Long roomId);

    public int openRoom(Long roomId);

    public int closeRoom(Long roomId);

    public int destroyRoom();

    public int enterRoom(Long roomId);

    public int quitRoom(Long roomId);

    public List<ChatRoom> getRoomList();

    public ChatRoom getRoomById(Long id);



}
