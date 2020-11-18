package com.nya.simpleim.service.impl;

import com.nya.simpleim.pojo.ChatRoom;
import com.nya.simpleim.pojo.User;
import com.nya.simpleim.service.ChatRoomService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.nya.simpleim.repository.RoomMessageSession.roomMap;

@Service

public class ChatRoomServiceImpl implements ChatRoomService {

    @Override
    public ChatRoom createRoom(User user) {
        ChatRoom room = new ChatRoom();
        //直播间 Id 与用户 id 相同
        room.setId(user.getId());
        room.setAnchormanId(user.getId());
        List<User> userList = new ArrayList<>();
        userList.add(user);
        room.setUserList(userList);
        //添加到缓存中
        roomMap.put(room.getId(),room);

        return room;
    }

    @Override
    public int openRoom(Long roomId) {
        roomMap.get(roomId).setStatus(1);
        return 1;
    }

    @Override
    public int closeRoom(Long roomId) {
        roomMap.get(roomId).setStatus(0);
        return 0;
    }

    @Override
    public int destroyRoom() {
        return 0;
    }

    @Override
    public int enterRoom(Long roomId) {
        int headCount = roomMap.get(roomId).getHeadCount();
        roomMap.get(roomId).setHeadCount(headCount+1);
        return headCount+1;
    }

    @Override
    public int quitRoom(Long roomId) {
        int headCount = roomMap.get(roomId).getHeadCount();
        roomMap.get(roomId).setHeadCount(headCount-1);
        return headCount-1;
    }

    @Override
    public List<ChatRoom> getRoomList() {
        return new ArrayList<>(roomMap.values());
    }

    @Override
    public ChatRoom getRoomById(Long id) {
        return roomMap.get(id);
    }

}
