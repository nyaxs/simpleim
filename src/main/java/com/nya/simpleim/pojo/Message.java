package com.nya.simpleim.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private Long id;
    private Long userId;
    private Long roomId;
    private String content;
    private Timestamp time;
}
