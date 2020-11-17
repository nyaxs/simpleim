package com.nya.simpleim;

import com.nya.simpleim.pojo.ChatRoom;
import com.nya.simpleim.pojo.Message;
import com.nya.simpleim.pojo.User;
import com.nya.simpleim.repository.RoomMessageSession;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.nya.simpleim.repository.RoomMessageSession.roomMap;

@SpringBootTest
class SimpleimApplicationTests {

    @Test
    void contextLoads() {

        User user1;

        ChatRoom room1 = new ChatRoom();
        room1.setAnchormanId((long)101);
        room1.setId((long)1);

        roomMap.put((long)1,room1);

        Timestamp t1 = Timestamp.valueOf(LocalDateTime.now());
        System.out.println(t1);

        Timestamp t2 = Timestamp.valueOf(LocalDateTime.now().plusSeconds(1));

        Timestamp t3 = Timestamp.valueOf(LocalDateTime.now().plusSeconds(2));

        Message m1 = new Message((long)1,(long)1,(long)1,"1111111111",t1);
        Message m2 = new Message((long)2,(long)1,(long)1,"2222222222",t2);
        Message m3 = new Message((long)3,(long)1,(long)1,"3333333333",t3);

        List<Message> messageList = Arrays.asList(m1,m2,m3);
        List<Long> mIdList = messageList.stream()
                                        .map(Message::getId).collect(Collectors.toList());

        user1 = new User((long)1,"韭菜",mIdList,(long)1);

        room1.setUserList(Arrays.asList(user1));
        room1.setMessageList(messageList);

        List <Message> messageList2 = room1.getMessageList().stream().
                filter(message -> message.getTime().after(t1)).collect(Collectors.toList());
        messageList2.forEach(System.out::println);
    }

}
