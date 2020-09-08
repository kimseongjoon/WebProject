package com.member.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SMemberDTO {
    private String name;
    private String userid;
    private String pwd;
    private String email;
    private String phone;
    private int admin;
}
