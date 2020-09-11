package com.member.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SMemberDTO {
    private String name;
    private String userid;
    private String pwd;
    private String email;
    private String phone;
    private int admin;

    public String getName() {
        return (name == null) ? "" : name;
    }

    public String getUserid() {
        return (userid == null) ? "" : userid;
    }

    public String getPwd() {
        return (pwd == null) ? "" : pwd;
    }

    public String getEmail() {
        return (email == null) ? "" : email;
    }

    public String getPhone() {
        return (phone == null) ? "" : phone;
    }

    public int getAdmin() {
        return admin;
    }
}
