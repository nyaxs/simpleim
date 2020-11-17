package com.nya.simpleim.repository;

import com.nya.simpleim.pojo.ChatRoom;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


//临时缓存，进一步开发应当使用 Redis 或 数据库 进行缓存或持久化。
@Repository
public class RoomMessageSession {

    public static ConcurrentHashMap<Long, ChatRoom> roomMap = new ConcurrentHashMap<>();

    public static void addRoom(Long id , ChatRoom room){
        roomMap.put(id,room);
    }

    public static ChatRoom getRoom(Long id){
        return roomMap.get(id);
    }

    public static void removeRoom(Long id){
        roomMap.remove(id);
    }

    public static List<ChatRoom> findAllRoom(){
        return new LinkedList<>(roomMap.values());
    }



}
