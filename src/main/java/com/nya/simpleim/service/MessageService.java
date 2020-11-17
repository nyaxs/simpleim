package com.nya.simpleim.service;

import com.nya.simpleim.pojo.ChatRoom;
import com.nya.simpleim.pojo.Message;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

public interface MessageService {


    public Message getMessageById(String id);

    public List<Message> getMessageSinceTimeInRoom(Timestamp timestamp,String roomId);

    public List<Message> getMessageByTimeInRoom(Timestamp gapTimestamp,String roomId);

    public List<Message> getMessageByUserId(String userId);

    public List<Message> getMessageByRoomId(String roomId);

    public int addMessageToList(Message message, ChatRoom room);

    public int saveMessage(Message message);

}
