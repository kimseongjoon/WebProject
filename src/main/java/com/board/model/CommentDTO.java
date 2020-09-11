package com.board.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentDTO {
    private long cNum;
    private String userId;
    private String msg;
    private String bNum;
    private String regdate;
}

