package com.nya.simpleim.controller;

import com.nya.simpleim.pojo.ChatRoom;
import com.nya.simpleim.pojo.Message;
import com.nya.simpleim.pojo.User;
import com.nya.simpleim.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.nya.simpleim.repository.RoomMessageSession.roomMap;

@RestController
public class ChatRoomController {

    private final ChatRoomService roomService;

    public ChatRoomController(ChatRoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/enterRoom")
    public int enterRoom(@RequestBody User user) {
        //获取登录状态，已登录则为 1，未登录为 0
        int userStatus = 1;
        if (userStatus == 0) {
            return 0;
        }

        ChatRoom room = roomService.getRoomById(user.getId());
        room.getUserList().add(user);

        return 1;

    }

    @GetMapping("/quitRoom")
    public int quitRoom(@RequestBody User user) {

        ChatRoom room = roomService.getRoomById(user.getRoomId());
        room.getUserList().remove(user);
        return 1;

    }

    /*
        测试数据
    */

    @GetMapping("/test")
    public List<Message> test() {

        User user1;

        ChatRoom room1 = new ChatRoom();
        room1.setAnchormanId((long)101);
        room1.setId((long)1);


        Timestamp t1 = Timestamp.valueOf(LocalDateTime.now());
        System.out.println(t1);

        Timestamp t2 = Timestamp.valueOf(LocalDateTime.now().plusSeconds(1));

        Timestamp t3 = Timestamp.valueOf(LocalDateTime.now().plusSeconds(2));

        Message m1 = new Message((long)1,(long)1,(long)1,"1111111111",t1);
        Message m2 = new Message((long)2,(long)1,(long)1,"2222222222",t2);
        Message m3 = new Message((long)3,(long)1,(long)1,"3333333333",t3);

        List<Message> messageList = new ArrayList<>();
        messageList.add(m1);
        messageList.add(m2);
        messageList.add(m3);
        List<Long> mIdList = messageList.stream()
                .map(Message::getId).collect(Collectors.toList());

        user1 = new User((long)1,"韭菜",mIdList,(long)1);

        room1.setUserList(Arrays.asList(user1));
        room1.setMessageList(messageList);

        roomMap.put((long)1,room1);

        List <Message> messageList2 = room1.getMessageList().stream().
                filter(message -> message.getTime().after(t1)).collect(Collectors.toList());
        messageList2.forEach(System.out::println);

        return messageList2;
    }

    @GetMapping("/getRoomInfo")
    public ChatRoom getRoomInfo(@RequestParam Long id){
        return roomMap.get(id);
    }

}
