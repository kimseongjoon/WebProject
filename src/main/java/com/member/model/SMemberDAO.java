package com.member.model;

import com.member.model.SMemberDTO;

import java.util.ArrayList;

public interface SMemberDAO {
    // 추가
    void memberJoin(SMemberDTO memberDTO);

    // 전체보기
    ArrayList<SMemberDTO> getMember();

    // 수정
    int memberUpdate(SMemberDTO memberDTO);

    // 상세보기
    SMemberDTO findById(String userid);

    // 삭제
    void memberDelete(String userid);

    // 회원수
    int memberCount();

    // 아이디 중복확인
    String memberIdCheck(String userid);

    // 로그인 확인
    SMemberDTO memberLoginCheck(String userid, String pwd);
}
