package com.member.action;

import com.member.model.SMemberDAO;
import com.member.model.SMemberDAOImpl;
import com.member.model.SMemberDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member/join")
public class JoinAction extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("join.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        SMemberDAO dao = SMemberDAOImpl.getInstance();

        SMemberDTO md = SMemberDTO.builder()
                .name(req.getParameter("name"))
                .userid(req.getParameter("userid"))
                .pwd(req.getParameter("pwd"))
                .email(req.getParameter("email"))
                .phone(req.getParameter("phone"))
//                .admin(Integer.parseInt(req.getParameter("admin")))
                .build();

        dao.memberJoin(md);

        resp.sendRedirect("login");
    }
}
