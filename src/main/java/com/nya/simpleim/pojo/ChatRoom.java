package com.nya.simpleim.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoom {
    private Long id;
    private List<Message> messageList;
    private List<User> userList;
    // 主播 Id, anchorman:主播
    private Long anchormanId;
}
