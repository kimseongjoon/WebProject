package com.member.action;

import com.member.model.SMemberDAO;
import com.member.model.SMemberDAOImpl;
import com.member.model.SMemberDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member/update")
public class UpdateAction extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        SMemberDTO md = SMemberDTO.builder()
                .phone(req.getParameter("phone"))
                .name(req.getParameter("name"))
                .email(req.getParameter("email"))
                .admin(Integer.parseInt(req.getParameter("admin")))
                .pwd(req.getParameter("pwd"))
                .userid(req.getParameter("userid"))
                .build();

        SMemberDAO dao = SMemberDAOImpl.getInstance();
        dao.memberUpdate(md);

        resp.sendRedirect("login");
    }
}
