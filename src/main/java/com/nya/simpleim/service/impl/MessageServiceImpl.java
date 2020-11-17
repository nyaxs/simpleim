package com.nya.simpleim.service.impl;

import com.nya.simpleim.pojo.ChatRoom;
import com.nya.simpleim.pojo.Message;
import com.nya.simpleim.service.MessageService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Override
    public Message getMessageById(String id) {
        return null;
    }

    @Override
    public List<Message> getMessageSinceTimeInRoom(Timestamp timestamp, String roomId) {
        return null;
    }

    @Override
    public List<Message> getMessageByTimeInRoom(Timestamp gapTimestamp, String roomId) {
        return null;
    }

    @Override
    public List<Message> getMessageByUserId(String userId) {
        return null;
    }

    @Override
    public List<Message> getMessageByRoomId(String roomId) {
        return null;
    }

    @Override
    public int addMessageToList(Message message, ChatRoom room) {
        return 0;
    }

    @Override
    public int saveMessage(Message message) {
        return 0;
    }
}
