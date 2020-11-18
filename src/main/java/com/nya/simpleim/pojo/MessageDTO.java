package com.nya.simpleim.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {
        private Long userId;
        private Long roomId;
        private String content;
        private Long time;
}
