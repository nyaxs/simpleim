package com.nya.simpleim;

import com.nya.simpleim.pojo.ChatRoom;
import com.nya.simpleim.pojo.Message;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static com.nya.simpleim.repository.RoomMessageSession.roomMap;

@SpringBootTest
public class Test {
    @org.junit.jupiter.api.Test
    void test1(){
        Timestamp ts = Timestamp.valueOf(LocalDateTime.now());
        System.out.println(ts);

        ChatRoom room = new ChatRoom((long)2,null,null,(long)222,1,121);

        roomMap.put(room.getId(),room);
        //ConcurrentHashMap<Long, ChatRoom> roomMap,更新数据测试
        System.out.println(roomMap.get(room.getId()));
        //ChatRoom(id=2, messageList=null, userList=null, anchormanId=222, status=1, headCount=121)
        room.setHeadCount(88);
        System.out.println(roomMap.get(room.getId()));
        //ChatRoom(id=2, messageList=null, userList=null, anchormanId=222, status=1, headCount=88)

    }
    @org.junit.jupiter.api.Test
    void test2(){
        Long t1 = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();
        Timestamp time = new Timestamp(t1);
        System.out.println("==============="+t1);
        System.out.println("==============="+time);

    }
}
