package com.board.model;

import lombok.Builder;
import lombok.Setter;

@Setter
@Builder
public class BoardDTO {
    private int num;
    private String writer;
    private String subject;
    private String email;
    private String content;
    private String ip;
    private int readcount;
    private int ref;
    private int re_step;
    private int re_level;
    private String passwd;
    private String reg_date;

    public int getNum() {
        return num;
    }

    public String getWriter() {
        return (writer == null) ? "" : writer;
    }

    public String getSubject() {
        return (subject == null) ? "" : subject;
    }

    public String getEmail() {
        return (email == null) ? "" : email;
    }

    public String getContent() {
        return (content == null) ? "" : content;
    }

    public String getIp() {
        return (ip == null) ? "" : ip;
    }

    public int getReadcount() {
        return readcount;
    }

    public int getRef() {
        return ref;
    }

    public int getRe_step() {
        return re_step;
    }

    public int getRe_level() {
        return re_level;
    }

    public String getPasswd() {
        return (passwd == null) ? "" : passwd;
    }

    public String getReg_date() {
        return (reg_date == null) ? "" : reg_date;
    }
}
